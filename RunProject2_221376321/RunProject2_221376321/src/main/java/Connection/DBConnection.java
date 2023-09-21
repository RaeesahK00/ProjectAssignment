/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author M.Masood Lamera
 */
public class DBConnection {
    public static Connection derbyConnection() throws SQLException{
        String url = "jdbc:derby://localhost:1527/UniversityChoice";
        String user = "administrator";
        String password= "admin";
        Connection connection= DriverManager.getConnection(url,user,password);
        return connection;
    }
}
