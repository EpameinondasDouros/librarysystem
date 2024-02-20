package com.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainPageController {

    @FXML
    protected void searchBooks() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/SearchingPage.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Search Books");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    protected void openBookInsertionPage(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/InputBook.fxml"));
            Parent bookInsertionPage = loader.load();
            
            // Create a new stage for the book insertion page
            Stage newStage = new Stage();
            newStage.setTitle("Add New Book");
            newStage.setScene(new Scene(bookInsertionPage));
                        
            // Show the new stage
            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void openGenreInsertionPage(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/InputGenre.fxml"));
            Parent genreInsertionPage = loader.load();
            
            // Create a new stage for the book insertion page
            Stage newStage = new Stage();
            newStage.setTitle("Add New Genre");
            newStage.setScene(new Scene(genreInsertionPage));
                        
            // Show the new stage
            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    protected void showAllBooks() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/ShowBooksPage.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("All Books");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void showAllGenres() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/ShowGenres.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("All Genres");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void showAllLoans() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/ShowLoans.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("All Loans");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
