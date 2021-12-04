package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.security.*;
import java.math.*;


public class UsuarioDAO {

    public boolean checkLogin(String login, String senha) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {
            senha = hashMd5(senha);
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE email_usuario = ? and senha_usuario = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {
                check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return check;

    }
    
    private String hashMd5(String texto){
        try{
       MessageDigest m=MessageDigest.getInstance("MD5");
       m.update(texto.getBytes(),0,texto.length());
       return new BigInteger(1,m.digest()).toString(16);
       }catch(NoSuchAlgorithmException e){
           throw new RuntimeException(e);
       }
    }

}
