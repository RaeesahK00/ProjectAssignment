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
    private String identity;
    private String university;
    private String courses;
    private String fName;
    private String lName;
    private String mail;
    private String emergConName;
    private String emergConNum;
    private String facultyId;

    public UniversityDomain() {
    }

    public UniversityDomain(int subID, String id, String university, String course, String facultyID) {
        this.subID = subID;
        this.identity = id;
        this.university = university;
        this.courses = course;
        this.facultyId = facultyID;
    }

    public UniversityDomain(String name, String surname, String mail, String emergConName, String emergConNum) {
        this.fName = name;
        this.lName = surname;
        this.mail = mail;

        this.emergConName = emergConName;
        this.emergConNum = emergConNum;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
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

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public String toString2() {
        return fName + " " + lName + " " + mail + " " + emergConName + " " + emergConNum;

    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    @Override
     public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        UniversityDomain other = (UniversityDomain) obj;

        // Compare attributes for equality
        return subID == other.subID && identity.equals(other.identity)
                && university.equals(other.university) && courses.equals(other.courses)
                && facultyId.equals(other.facultyId);
    }

}
