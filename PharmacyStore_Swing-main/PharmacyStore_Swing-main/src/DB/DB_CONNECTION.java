package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_CONNECTION {

     public Connection Con;
    public Statement Stmt;
    public PreparedStatement Pstmt;
    public ResultSet Rst;

    public DB_CONNECTION() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
         
     
            Con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "");
            System.out.println("Connected to database.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return Con;
    }

    public void closeConnection() {
        if (Con != null) {
            try {
                Con.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}
