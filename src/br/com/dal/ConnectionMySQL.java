package br.com.dal;

import java.sql.Connection;
import java.sql.*;

public class ConnectionMySQL {

    public static Connection conectar() {
        Connection conexao;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/aulas_ifba";
        String user = "root";
        String password = "123456";

        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return null;
        }

    }

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement pst){
            closeConnection(con);
            
            try {
            if(pst != null){
               pst.close();
            }
        } catch (Exception e) {
                System.out.println(e);
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement pst, ResultSet rset){
        closeConnection(con, pst);
        
        try {
            if(rset != null){
                rset.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
