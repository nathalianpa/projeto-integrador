/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.petfeliz.pi3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernanda.nunes
 */
public class Conexao {
  
    
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public static Connection getConexao() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/petfeliz?useSSL=false";
        String user = "root";
        String pass = "";
        return DriverManager.getConnection(url, user, pass);
}
}