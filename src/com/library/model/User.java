package com.library.model;
import java.io.Serializable;

public class User implements Serializable{
    private static final long serialVersionUID = 12345L;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String idnumber;
     // Consider encryption for real applications
    private String email;
    private boolean admin;

    
    // Constructor
    public User(String username, String password, String email, boolean admin, String firstname, String lastname, String idnumber){
        this.username = username;
        this.password = password;
        this.email = email;
        this.admin = admin;
        this.lastname=lastname;
        this.firstname=firstname;
        this.idnumber=idnumber;
    }
    
    // Getters and Setters
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
        // In real applications, consider hashing the password before storing it
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstname;
    }
    public String getidNumber() {
        return idnumber;
    }
    public String getLastName() {
        return lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getStatus() {
        return admin;
    }




    
    // Additional methods can be added to support user behaviors, like changing a password, validating email, etc.
}
