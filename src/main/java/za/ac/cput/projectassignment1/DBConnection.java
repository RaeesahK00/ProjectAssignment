
package za.ac.cput.projectassignment1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Desktop
 */
public class DBConnection {
     public static Connection derbyConnection() throws SQLException {
        String url = "";
        String username = "administrator";
        String password = "admin";

        Connection con = DriverManager.getConnection(url, username, password);
        return con;
    }
}
