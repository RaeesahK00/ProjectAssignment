/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.cput.projectassignment1;

/**
 *
 * @author M.Masood Lamera
 */
public class UniversityDomain {

    private int subID;
    private String id;
    private String university;
    private String course;
    private String name ;
    private String email;
    private String school;
    private String nickname;
    private String emergConName;
    private String emergConNum;

    public UniversityDomain() {
    }

    public UniversityDomain(String name, String email, String school, String nickname, String emergConName, String emergConNum) {
        this.name = name;
        this.email = email;
        this.school = school;
        this.nickname = nickname;
        this.emergConName = emergConName;
        this.emergConNum = emergConNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public UniversityDomain(int subID, String id, String university, String course) {
        this.subID = subID;
        this.id = id;
        this.university = university;
        this.course = course;
    }

    public int getSubID() {
        return subID;
    }

    public void setSubID(int subID) {
        this.subID = subID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "UniversityDomain{" + "subID=" + subID + ", id=" + id + ", university=" + university + ", course=" + course + ", name=" + name + ", email=" + email + ", school=" + school + ", nickname=" + nickname + ", emergConName=" + emergConName + ", emergConNum=" + emergConNum + '}';
    }

}
