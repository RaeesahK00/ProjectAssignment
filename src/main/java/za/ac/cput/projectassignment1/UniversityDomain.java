/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.cput.projectassignment1;

import java.io.Serializable;

/**
 *
 * @author M.Masood Lamera
 */
public class UniversityDomain implements Serializable {

    private int subID;
    private int id;
    private String university;
    private String course;
    private String fName;
    private String lName;
    private String mail;
    private String emergConName;
    private String emergConNum;
    private String facultyID;

    public UniversityDomain() {
    }

    public UniversityDomain(String name, String surname, String mail, String emergConName, String emergConNum) {
        this.fName = name;
        this.lName = surname;
        this.mail = mail;

        this.emergConName = emergConName;
        this.emergConNum = emergConNum;
    }

    public UniversityDomain(int subID, int id, String university, String course, String facultyID) {
        this.subID = subID;
        this.id = id;
        this.university = university;
        this.course = course;
        this.facultyID = facultyID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getEmergConName() {
        return emergConName;
    }

    public void setEmergConName(String emergConName) {
        this.emergConName = emergConName;
    }

    public String getEmergConNum() {
        return emergConNum;
    }

    public void setEmergConNum(String emergConNum) {
        this.emergConNum = emergConNum;
    }

    public int getSubID() {
        return subID;
    }

    public void setSubID(int subID) {
        this.subID = subID;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String toString2() {
        return fName + " " + lName + " " + mail + " " + emergConName + " " + emergConNum;

    }

    public String getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(String facultyID) {
        this.facultyID = facultyID;
    }

    @Override
    public String toString() {
        return "UniversityDomain{" + "subID=" + subID + ", university=" + university + ", course=" + course + ", name=" + fName + ", email=" + lName + ", school=" + mail + ", emergConName=" + emergConName + ", emergConNum=" + emergConNum + '}';
    }

}
