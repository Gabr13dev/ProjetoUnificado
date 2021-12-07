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
import model.bean.Complexidade;

/**
 *
 * @author Gabriel
 */
public class ComplexidadeDAO {
    
    public List<Complexidade> read() {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Complexidade> complexidadeList = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM complexidade");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Complexidade complex = new Complexidade();

                complex.setId(rs.getInt("id_complexidade"));
                complex.setNome(rs.getString("nome_complexidade"));
                complexidadeList.add(complex);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ComplexidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return complexidadeList;
    }
}
