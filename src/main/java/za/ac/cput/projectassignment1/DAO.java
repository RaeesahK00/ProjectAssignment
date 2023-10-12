package za.ac.cput.projectassignment1;

import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            sql = String.format(sql, dao.getName(), dao.getEmail(), dao.getSchool(), dao.getEmergConName(), dao.getEmergConNum());
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

    public Integer submission() {
        int lastValue = 0;
        
        
        try {
            //        String sql = "SELECT SubmissionID FROM UniversityCourseGui";
            String sql = "SELECT SubmissionID FROM UniversityCourseChoice WHERE SubmissionID = (SELECT MAX(SubmissionID) FROM UniversityCourseChoice)";
            pstmt = con.prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                // Retrieve the last value of the specified column
                lastValue = resultSet.getInt("SubmissionID");
            } else {
                System.out.println("No data found in the table.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lastValue;

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

    //----------------------------------------------------------------------- Raeesahs methods
    public Student addStudentToDB(Student student) throws IOException, SQLException {
        String query = "INSERT INTO Student_Info (Stud_ID, First_Name, Surname, Id, Passport, Email, Nationality, Date_Of_Birth, Home_Language, Address, Postal_Code, Province, Phone_Number, Male, Female, CertifiedID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = con.prepareStatement(query);

        statement.setString(1, student.getId());
        statement.setString(2, student.getFirstName());
        statement.setString(3, student.getSurname());
        statement.setBoolean(4, student.isIdSA());
        statement.setBoolean(5, student.isPassport());
        statement.setString(6, student.getEmail());
        statement.setString(7, student.getNationality());
        statement.setString(8, student.getDateOfBirth());
        statement.setString(9, student.getLanguage());
        statement.setString(10, student.getAddress());
        statement.setString(11, student.getPostalCode());
        statement.setString(12, student.getProvince());
        statement.setString(13, student.getNumber());
        statement.setBoolean(14, student.isMale());
        statement.setBoolean(15, student.isFemale());
        statement.setString(16, student.getSubmittedId());
        statement.executeUpdate();
        return student;
    }

    public Student addGaurdianToDB(Student student) throws IOException, SQLException {
        String query = "INSERT INTO Student_Gardian_Info (ID, LEGAL_GARDIAN, NAME,SURNAME, EMAIL, NATIONALITY, ADDRESS, PROVINCE, POSTAL_CODE, PHONE_NUMBER) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = con.prepareStatement(query);

        statement.setString(1, student.getGardianId());
        statement.setString(2, student.getGardian());
        statement.setString(3, student.getGardianName());
        statement.setString(4, student.getGardianSurname());
        statement.setString(5, student.getGardianEmail());
        statement.setString(6, student.getGardianNationality());
        statement.setString(7, student.getGardianAddress());
        statement.setString(8, student.getGardianProvince());
        statement.setString(9, student.getGardianPostalCode());
        statement.setString(10, student.getGardianNumber());

        statement.executeUpdate();
        return student;
    }

    public Student addStudSchoolToDB(Student student) throws IOException, SQLException {
        String query = "INSERT INTO Student_School_Info (Stud_ID, School, Year_Completed, Grade11, Grade12, Subject1, Percent1, Subject2, Percent2, Subject3, Percent3, Subject4, Percent4, Subject5, Percent5, Subject6, Percent6, Subject7, Percent7  ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,? ,? ,?)";
        PreparedStatement statement = con.prepareStatement(query);

        statement.setString(1, student.getId());
        statement.setString(2, student.getSchool());
        statement.setInt(3, student.getYear());
        statement.setBoolean(4, student.isGrade11());
        statement.setBoolean(5, student.isGrade12());
        statement.setString(6, student.getSubject1());
        statement.setInt(7, student.getPercent1());
        statement.setString(8, student.getSubject2());
        statement.setInt(9, student.getPercent2());
        statement.setString(10, student.getSubject3());
        statement.setInt(11, student.getPercent3());
        statement.setString(12, student.getSubject4());
        statement.setInt(13, student.getPercent4());
        statement.setString(14, student.getSubject5());
        statement.setInt(15, student.getPercent5());
        statement.setString(16, student.getSubject6());
        statement.setInt(17, student.getPercent6());
        statement.setString(18, student.getSubject7());
        statement.setInt(19, student.getPercent7());

        statement.executeUpdate();
        return student;
    }

    //----------------------------------------------------------------------- Beurins methods
}
