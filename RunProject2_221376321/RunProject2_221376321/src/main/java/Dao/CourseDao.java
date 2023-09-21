/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Connection.DBConnection;
import Domain.UniversityDomain;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author M.Masood Lamera
 */
public class CourseDao {

    private Connection con;
    private PreparedStatement stmt;
    int ok;

    public CourseDao() {
        try {
            this.con = DBConnection.derbyConnection();

        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, "Error: cannot connect : " + sql.getMessage());
        }
    }
        
    public UniversityDomain save(UniversityDomain dao) {
        
        String sql = "INSERT INTO UniversityCourseChoice(SubmissionID,ID,University,Course) VALUES('%s','%s','%s','%s')";

        try {
            sql = String.format(sql, dao.getSubID(),dao.getId(), dao.getUniversity(), dao.getCourse());
            stmt = this.con.prepareStatement(sql);
            ok = stmt.executeUpdate();
            if (ok > 0) {
                return dao;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: Cannot save1" + ex.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
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
            sql = String.format(sql, dao.getName(),dao.getEmail(), dao.getSchool(), dao.getNickname(), dao.getEmergConName(), dao.getEmergConNum());
            stmt = this.con.prepareStatement(sql);
            ok = stmt.executeUpdate();
            if (ok > 0) {
                return dao;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: Cannot save2: " + ex.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception exc) {
                JOptionPane.showMessageDialog(null, "error closing");
            }
        }
        return null;
    }
}
