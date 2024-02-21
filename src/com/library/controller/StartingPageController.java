package com.library.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartingPageController {

    @FXML
    protected void handleLogin() {
        System.out.println("Login button clicked");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/Login.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Login");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void handleSignUp() {
        System.out.println("Sign Up button clicked");
        // Here, you would navigate to the Sign Up page
    }

    @FXML
    protected void handleSeeBestBooks() {
        System.out.println("See the 5 Best Rated Books button clicked");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/TopBooks.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Top Books");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
