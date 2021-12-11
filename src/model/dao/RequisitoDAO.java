/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Requisito;

/**
 *
 * @author Gabriel
 */
public class RequisitoDAO {
    
    public List<Requisito> getListByProjeto(int id){
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Requisito> Requisitos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM requisito WHERE id_projeto_requisito = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Requisito requisito = new Requisito();

                requisito.setIdRequisito(rs.getInt("id_requisito"));
                requisito.setNome(rs.getString("nome_requisito"));
                requisito.setDescricao(rs.getString("descricao_requisito"));
                requisito.setDatacriacao(rs.getDate("datacriacao_requisito"));
                requisito.setAutor(rs.getInt("autor_requisito"));
                requisito.setUsuario_ultimamodificacao(rs.getInt("usuario_ultimamodificacao_requisito"));
                requisito.setData_ultimamodificacao(rs.getDate("data_ultimamodificacao_requisito"));
                requisito.setId_prioridade(rs.getInt("id_prioridade_requisito"));
                requisito.setEsforco_horas(rs.getInt("esforco_horas_requisito"));
                requisito.setComplexidade(rs.getInt("complexidade_requisito"));
                requisito.setId_projeto(rs.getInt("id_projeto_requisito"));
                        
                Requisitos.add(requisito);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RequisitoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return Requisitos;

    }
}
