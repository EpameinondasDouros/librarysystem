package com.library.controller;

import com.library.model.User;
import com.library.utils.BookManager;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class SignupController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private TextField emailField;
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField idNumberField;
    
    @FXML private Label signupStatusLabel;

    @FXML
    protected void handleSignup() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String email = emailField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String idNumber = idNumberField.getText();

        
        // Simple validation (extend this according to your requirements)
        if(username.isEmpty() || 
        password.isEmpty() || 
        email.isEmpty() || 
        firstName.isEmpty() || 
        lastName.isEmpty() || 
        idNumber.isEmpty() 
        ) {
            signupStatusLabel.setText("Please fill in all fields.");
            return;
        }

        BookManager.getInstance().addUser(username, password, email, false, firstName, lastName, idNumber);

        // Handle the signup logic here
        // For example, check if the username already exists, validate the email format, etc.
        
        // If signup is successful
        // signupStatusLabel.setText("Signup successful.");
        
        // If there's an error during signup (like username already exists)
        // signupStatusLabel.setText("Signup error: <specific error>");
    }
}
