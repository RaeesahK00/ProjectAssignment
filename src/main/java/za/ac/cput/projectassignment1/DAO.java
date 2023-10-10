package za.ac.cput.projectassignment1;

import Domain.UniversityDomain;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Desktop
 */
public class DAO {

    private Connection con;
    private PreparedStatement pstmt;
    int ok;

    public DAO() {
        try {
            con = DBConnection.derbyConnection();
        } catch (SQLException ex) {
            System.out.println("SQLException");
        }
    }
    //----------------------------------------------------------------------- Lindas methods

    public static boolean checkUser(String username) {
        try {
            Connection connection = DriverManager.getConnection(CommonConstrants.DB_URL,
                    CommonConstrants.DB_USERNAME, CommonConstrants.DB_PASSWORD);

            PreparedStatement checkUsersExists = connection.prepareStatement(
                    "SELECT * FROM" + CommonConstrants.DB_USERSIGNUP_TABLE_NAME
                    + " WHERE USERNAME = ?"
            );

            checkUsersExists.setString(1, username);

            ResultSet resultSet = checkUsersExists.executeQuery();

            //check to see if the result set is empty
            //if it is empty it means that there was no data row that contains the username
            //(i.e = user does not exist
            if (!resultSet.isBeforeFirst()) {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    
    //----------------------------------------------------------------------- Masoods methods

    public UniversityDomain save(UniversityDomain dao) {

        String sql = "INSERT INTO UniversityCourseChoice(SubmissionID,ID,University,Course) VALUES('%s','%s','%s','%s')";

        try {
            sql = String.format(sql, dao.getSubID(), dao.getId(), dao.getUniversity(), dao.getCourse());
            pstmt = this.con.prepareStatement(sql);
            ok = pstmt.executeUpdate();
            if (ok > 0) {
                return dao;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: Cannot save1" + ex.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception exc) {
                JOptionPane.showMessageDialog(null, "error closing");
            }
        }
        return null;
    }

    public UniversityDomain updateUserInfo(UniversityDomain dao) {

        String sql = "INSERT INTO UserInformation(name,email,school,nickname,emergCon,Emerg_Con_Num) VALUES('%s','%s','%s','%s','%s','%s')";

        try {
            sql = String.format(sql, dao.getName(), dao.getEmail(), dao.getSchool(), dao.getNickname(), dao.getEmergConName(), dao.getEmergConNum());
            pstmt = this.con.prepareStatement(sql);
            ok = pstmt.executeUpdate();
            if (ok > 0) {
                return dao;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: Cannot save2: " + ex.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception exc) {
                JOptionPane.showMessageDialog(null, "error closing");
            }
        }
        return null;
    }
//----------------------------------------------------------------------- Ronalds methods
    public Study_choice getSavedStudyChoices() {
        String sql = "SELECT study_choice1, study_choice2 FROM Study_choice";
        Study_choice study_choice = null;

        try {
            pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String choice1 = rs.getString("study_choice1");
                String choice2 = rs.getString("study_choice2");
                study_choice = new Study_choice(choice1, choice2);
            }
        } catch (SQLException sqlException) {
            // Handle SQL exception appropriately
        } finally {
            // ...
        }

        return study_choice;
    }

    public Study_choice save(Study_choice study_choice) throws SQLException {
        int ok;
        String sql = "INSERT INTO Study_choice (study_choice1, study_choice2) VALUES(?, ?)";

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, study_choice.getStudy_choice1());
            pstmt.setString(2, study_choice.getStudy_choice2());

            ok = pstmt.executeUpdate();

            if (ok > 0) {
                con.commit();
                return study_choice;
            } else {
                return null;
            }
        } catch (SQLException sqlException) {
            con.rollback(); // Rollback the transaction
            // Handle SQL exception appropriately
        } finally {
            // ...
        }
        return null;
    }
    
    //----------------------------------------------------------------------- Beurins methods
    
    
    
    //----------------------------------------------------------------------- Raeesahs methods

}
