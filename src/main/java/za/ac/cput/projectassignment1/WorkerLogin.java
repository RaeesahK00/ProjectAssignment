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
public class WorkerLogin implements Serializable{
    private String id;
    private String username;
    private String password;

    public WorkerLogin() {
    }

    public WorkerLogin(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "WorkerLogin{" + "id=" + id + ", username=" + username + ", password=" + password + '}';
    }
    
    
}
