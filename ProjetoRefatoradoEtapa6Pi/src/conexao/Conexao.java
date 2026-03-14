/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Juliano
 */
public class Conexao {

    Connection conn;
    PreparedStatement stmt;
    ResultSet rs;

    private static final String url = "jdbc:mysql://localhost:3306/projetoIntegradorDB";
    private static final String user = "root";
    private static final String password = "99228688";

    public static Connection conectar() {
        try {
            //Carregar o Driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Estabelecer a Conexão
            return DriverManager.getConnection(url,user,password);
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro de conexão. " + e.getMessage());
            return null;
        }

    }

    public void desconectar() {
        try {
            conn.close();
        } catch (SQLException e) {
        }
    }    
}
