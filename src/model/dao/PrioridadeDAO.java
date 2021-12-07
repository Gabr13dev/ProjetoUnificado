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
import model.bean.Prioridade;
/**
 *
 * @author Gabriel
 */
public class PrioridadeDAO {
    
    public List<Prioridade> read() {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Prioridade> prioridadeList = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM prioridade");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Prioridade prioridade = new Prioridade();

                prioridade.setId(rs.getInt("id_prioridade"));
                prioridade.setNome(rs.getString("nome_prioridade"));
                prioridadeList.add(prioridade);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PrioridadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return prioridadeList;
    }
    
}
