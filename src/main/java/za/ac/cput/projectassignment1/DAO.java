
package za.ac.cput.projectassignment1;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Desktop
 */
public class DAO {
    Connection con;

    public DAO() {
        try {
            con = DBConnection.derbyConnection();
        } catch (SQLException ex) {
            System.out.println("SQLException");
        }
    }
    
    
    
}
