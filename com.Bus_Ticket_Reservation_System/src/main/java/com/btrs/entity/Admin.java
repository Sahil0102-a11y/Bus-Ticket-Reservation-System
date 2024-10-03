package com.btrs.entity;

import javax.persistence.*;

@Entity
@Table(name = "admins")
public class Admin extends BaseEntity {
    
    //private String username;
    //private String email;
    private String password;

    @Column(unique = true, nullable = false)
    private String username; // Added username field

    public Admin() {}

    public Admin(String username, String password) {
        //this.name = name;
        //this.email = email;
        this.password = password;
        this.username = username; // Initialize username
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public String getUsername() { // Added getter for username
//        return username;
//    }
//
//    public void setUsername(String username) { // Added setter for username
//        this.username = username;
//    }

    @Override
    public String toString() {
        return super.toString() + " Admin [Username=" + username + "]";
    }
}
