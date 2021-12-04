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
import model.bean.Projeto;


public class ProjetoDAO {

    public void create(Projeto p) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO `projeto`(`id_projeto`, `nome_projeto`, `descricao_projeto`, `usuario_proprietario`) VALUES (NULL,?,?,?)");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescricao());
            stmt.setInt(3, p.getUsuarioDono());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Projeto> read() {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Projeto> Projetos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM projeto");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Projeto projeto = new Projeto();

                projeto.setId(rs.getInt("id_projeto"));
                projeto.setDescricao(rs.getString("descricao_projeto"));
                projeto.setNome(rs.getString("nome_projeto"));
                projeto.setUsuarioDono(rs.getInt("usuario_proprietario"));
                Projetos.add(projeto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return Projetos;

    }
    public List<Projeto> readForDesc(String desc) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Projeto> projetos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM projeto WHERE descricao_projeto LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Projeto projeto = new Projeto();

                projeto.setId(rs.getInt("id_projeto"));
                projeto.setDescricao(rs.getString("descricao_projeto"));
                projeto.setNome(rs.getString("nome_projeto"));
                projeto.setUsuarioDono(rs.getInt("usuario_proprietario"));
                projetos.add(projeto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return projetos;

    }

    public void update(Projeto p) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE projeto SET descricao_projeto = ? ,nome_projeto = ?,usuario_proprietario = ? WHERE id_projeto = ?");
            stmt.setString(1, p.getDescricao());
            stmt.setString(2, p.getNome());
            stmt.setInt(3, p.getUsuarioDono());
            stmt.setInt(4, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    public void delete(Projeto p) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM projeto WHERE id_projeto = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

}
