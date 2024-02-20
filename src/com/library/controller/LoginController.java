package com.library.controller;

import java.io.IOException;
import java.util.List;
import javafx.scene.Node;

import com.library.model.Book;
import com.library.model.SessionManager;
import com.library.model.User;
import com.library.utils.BookManager;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField usernameField;
    private Button loginButton;
    @FXML
    private TextField passwordField;
    
    // Dummydata for demonstration. In a real application, use a database or other secure storage.
    // private String validUsername;
    // private String validPassword;

     // Assume this is populated with all available books

    
    @FXML
    protected void performLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        System.out.println("Password"+password);
        System.out.println("Username: " + username);
        final User user = BookManager.getInstance().getUserByUsername(username);

        if (user==null){
            System.out.println("Login failed");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText(null); // You can have a header text, or set it to null
            alert.setContentText("Wrong username");
            alert.showAndWait();

        }
        
        if (user.getPassword().equals(password)) {
            System.out.println("Login successful");
            System.out.println("Username: " + username);
            try {
            SessionManager.getInstance().setCurrentUser(user);
            // Replace "/path/to/MainPage.fxml" with the actual path to your MainPage.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/MainPage.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setTitle("Main Page");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception (e.g., log the error or show an error message)
        }


            
            // Proceed to the next part of your application
        } else {
            System.out.println("Login failed");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText(null); // You can have a header text, or set it to null
            alert.setContentText("Wrong password");
            alert.showAndWait();
            // Show login failed message
        }
    }
}
