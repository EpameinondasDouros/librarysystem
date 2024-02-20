package com.library.controller;

import com.library.model.Genre;
import com.library.utils.BookManager;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class InputGenreController {

    @FXML private TextField nameField;
    @FXML private TextField descriptionField;
   
    @FXML
    protected void submitGenreDetails() {

        // Genre fantasy = new Genre("Fantasy", "A genre of speculative fiction set in a fictional universe, often inspired by real world myth and folklore.");
        // Create a new Book object from the input fields
        Genre genre = new Genre(
                nameField.getText(),
                descriptionField.getText()
        );

        BookManager.getInstance().addGenre(genre);
        

    }
}
