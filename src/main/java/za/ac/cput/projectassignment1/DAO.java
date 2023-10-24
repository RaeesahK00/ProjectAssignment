package za.ac.cput.projectassignment1;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
    private static final String SELECT_USER_ID = "SELECT ID FROM STUD_LOGIN_INFO WHERE USERNAME = ? AND PASSWORD = ?";

    public String getUserId(String username, String password) {
        try {
            PreparedStatement statement = this.con.prepareStatement(SELECT_USER_ID);

            statement.setString(1, username);
            statement.setString(2, password);

            try ( ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("ID");
                } else {
                    
                    return null; 
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null; 
        }
    }
    
     private static final String SELECT_Faculty_ID = "SELECT FACULTY_ID FROM FACULTY_TABLE WHERE FACULTY_NAME = ?";

    public String getfacId(String name) {
        try {
            PreparedStatement statement = this.con.prepareStatement(SELECT_Faculty_ID);

            statement.setString(1, name);
            

            try ( ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("FACULTY_ID");
                } else {
                    
                    return null; 
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null; 
        }
    }

    public boolean authenticateID(String id) {

        String query = "SELECT * FROM STUD_LOGIN_INFO WHERE ID=?";
        try {
            PreparedStatement statement = this.con.prepareStatement(query);
            statement.setString(1, id);

            try ( ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return true;
                } else {
                    return false;
                }

            }
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
            return false;
        }
    }

    public boolean authenticateUsername(String username) {

        String query = "SELECT * FROM STUD_LOGIN_INFO WHERE USERNAME=?";
        try {
            PreparedStatement statement = this.con.prepareStatement(query);
            statement.setString(1, username);

            try ( ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return true;
                } else {
                    return false;
                }

            }
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
            return false;
        }
    }

    public void enrollStudent(String id, String name, String surname, String email, String username, String password) throws SQLException {
        String query = "INSERT INTO STUD_LOGIN_INFO(ID,NAME,SURNAME,EMAIL,USERNAME,PASSWORD) VALUES (?, ?, ? , ? , ?,?)";

        PreparedStatement statement = this.con.prepareStatement(query);

        statement.setString(1, id);
        statement.setString(2, name);
        statement.setString(3, surname);
        statement.setString(4, email);
        statement.setString(5, username);
        statement.setString(6, password);

        statement.executeUpdate();
    }

    public void saveUserProfile(String id, String name, String surname) throws SQLException {
        String query = "INSERT INTO USER_TABLE(USER_ID,USER_NAME,USER_SURNAME) VALUES (?, ?, ? )";

        PreparedStatement statement = this.con.prepareStatement(query);

        statement.setString(1, id);
        statement.setString(2, name);
        statement.setString(3, surname);

        statement.executeUpdate();
    }

//    public static boolean checkUser(String username) {
//        try {
//            Connection connection = DriverManager.getConnection(CommonConstrants.DB_URL,
//                    CommonConstrants.DB_USERNAME, CommonConstrants.DB_PASSWORD);
//
//            PreparedStatement checkUsersExists = connection.prepareStatement(
//                    "SELECT * FROM" + CommonConstrants.DB_USERSIGNUP_TABLE_NAME
//                    + " WHERE USERNAME = ?"
//            );
//
//            checkUsersExists.setString(1, username);
//
//            ResultSet resultSet = checkUsersExists.executeQuery();
//
//            //check to see if the result set is empty
//            //if it is empty it means that there was no data row that contains the username
//            //(i.e = user does not exist
//            if (!resultSet.isBeforeFirst()) {
//                return false;
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return true;
//    }
    public boolean authenticateUser(String username, String password) {

        String query = "SELECT * FROM STUD_LOGIN_INFO WHERE USERNAME=? AND PASSWORD=?";
        try {
            PreparedStatement statement = this.con.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            try ( ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return true;
                } else {
                    return false;
                }

            }
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
            return false;
        }
    }
    //----------------------------------------------------------------------- Masoods methods


//    public String getFacultyId(String name) throws SQLException {
//    String id = null; // Initialize id to null
//    
//    String query = "SELECT FACULTY_ID FROM FACULTY_TABLE WHERE FACULTY_NAME = ?";
//    PreparedStatement statement = this.con.prepareStatement(query);
//    statement.setString(1, name);
//    ResultSet result = statement.executeQuery();
//    
//    if (result.next()) {
//        id = result.getString("FACULTY_ID"); // Set id if a match is found
//    }
//    
//    // Close the resources (e.g., statement and result) here
//    
//    return id; // Return id, which might be null or a valid value
//}
//   public String getFacultyId(String name) {
//    String id = null;
//    String query = "SELECT FACULTY_ID FROM FACULTY_TABLE WHERE FACULTY_NAME = ?";
//    
//    try (Connection connection = this.con;
//         PreparedStatement statement = connection.prepareStatement(query)) {
//        statement.setString(1, name);
//        try (ResultSet result = statement.executeQuery()) {
//            if (result.next()) {
//                id = result.getString("FACULTY_ID");
//            }
//        }
//    } catch (SQLException e) {
//        // Log or handle the exception here
//        e.printStackTrace();
//    }
//    
//    return id;
//} 
//    public List<UniversityDomain> getFaculty() throws SQLException {
//    String query = "SELECT FACULTY_ID FROM FACULTY_TABLE WHERE FACULTY_NAME = ?";
//    
//    List<UniversityDomain> students = new ArrayList<>();
//
//    PreparedStatement statement = this.con.prepareStatement(query);
//
//    ResultSet results = statement.executeQuery();
//
//    while (results.next()) {
//        String studentId = results.getString("FACULTY_ID");
//
//        UniversityDomain ws = new UniversityDomain();
//        ws.setFacultyID(studentId);
//        students.add(ws);
//    }
//    results.close();
//    statement.close();
//    
//    return students;
//}
//    
    public UniversityDomain save(UniversityDomain dao) {
WorkerLogin wl  = new WorkerLogin();
        String sql = "INSERT INTO UniversityCourseChoice(SubmissionID,ID,University,Course,faculty_id) VALUES('%s','%s','%s','%s')";

        try {
            sql = String.format(sql, dao.getSubID(),wl.getId(),  dao.getUniversity(), dao.getCourse());
            pstmt = this.con.prepareStatement(sql);
            ok = pstmt.executeUpdate();
            if (ok > 0) {
                return dao;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: Please ensure everything is correct");
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception exc) {
                JOptionPane.showMessageDialog(null, "There has been an error closing the program.");
            }
        }
        return null;
    }

    public ArrayList<UniversityDomain> getUserProfileInfo(String User_ID) throws SQLException {
        ArrayList<UniversityDomain> userInfo = new ArrayList<>();

        String query = "SELECT USER_NAME, USER_SURNAME, USER_EMAIL, USER_EMERGENCY_CON_NAME, USER_EMERGENCY_CON_NUM FROM USER_TABLE WHERE USER_ID = ?";

        PreparedStatement statement = this.con.prepareStatement(query);
        statement.setString(1, User_ID);

        ResultSet result = statement.executeQuery();

        while (result.next()) {
            String name = result.getString("USER_NAME");
            String surname = result.getString("USER_SURNAME");
            String email = result.getString("USER_EMAIL");
            String emergName = result.getString("USER_EMERGENCY_CON_NAME");
            String emergNum = result.getString("USER_EMERGENCY_CON_NUM");

            userInfo.add(new UniversityDomain(name, surname, email, emergName, emergNum));
        }
        return userInfo;
    }

    public UniversityDomain updateUserInfo(UniversityDomain dao) {
        String sql = "UPDATE User_Table SET User_name=?, USER_SURNAME = ?,  User_email=?, User_emergency_Con_Name=?, User_Emergency_Con_Num=? WHERE User_ID = ?";

        try {
            pstmt = this.con.prepareStatement(sql);
            pstmt.setString(1, dao.getfName());
            pstmt.setString(2, dao.getlName());
            pstmt.setString(3, dao.getMail());
            pstmt.setString(4, dao.getEmergConName());
            pstmt.setString(5, dao.getEmergConNum());
            pstmt.setString(6, "9907015149088");//id where to read the ID from to make dem edits

            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                return dao;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: Cannot save your update");
            ex.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception exc) {
                JOptionPane.showMessageDialog(null, "There has been an error closing the program.");
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

    public void save(String faculty) throws SQLException {
        String query = "INSERT INTO UNIVERSITYCOURSECHOICE(FACULTY_ID) VALUES (?,)";

        PreparedStatement statement = this.con.prepareStatement(query);

        statement.setString(1, faculty);

        statement.executeUpdate();
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
        String query = "INSERT INTO Stud_Guardian_Info (ID, LEAGAL_GUARDIAN, NAME,SURNAME, EMAIL, NATIONALITY, ADDRESS, PROVINCE, POSTAL_CODE, PHONE_NUMBER) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
        String query = "INSERT INTO Stud_School_Info (Stud_ID, School, Year_Completed, Grade11, Grade12, Subject1, Percent1, Subject2, Percent2, Subject3, Percent3, Subject4, Percent4, Subject5, Percent5, Subject6, Percent6, Subject7, Percent7  ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,? ,? ,?)";
        PreparedStatement statement = con.prepareStatement(query);

        statement.setString(1, student.getId());
        statement.setString(2, student.getSchool());
        statement.setString(3, student.getYear());
        statement.setBoolean(4, student.isGrade11());
        statement.setBoolean(5, student.isGrade12());
        statement.setString(6, student.getSubject1());
        statement.setString(7, student.getPercent1());
        statement.setString(8, student.getSubject2());
        statement.setString(9, student.getPercent2());
        statement.setString(10, student.getSubject3());
        statement.setString(11, student.getPercent3());
        statement.setString(12, student.getSubject4());
        statement.setString(13, student.getPercent4());
        statement.setString(14, student.getSubject5());
        statement.setString(15, student.getPercent5());
        statement.setString(16, student.getSubject6());
        statement.setString(17, student.getPercent6());
        statement.setString(18, student.getSubject7());
        statement.setString(19, student.getPercent7());

        statement.executeUpdate();
        return student;
    }

    //----------------------------------------------------------------------- Beurins methods
    public void apsScore(String id, String apsScore) throws SQLException {
        String query = "INSERT INTO APS_TABLE(STUDENT_ID,STUDENT_APSCORE) VALUES ( ?, ? )";

        PreparedStatement statement = this.con.prepareStatement(query);

        statement.setString(1, id);
        statement.setString(2, apsScore);
        statement.executeUpdate();
    }

}
