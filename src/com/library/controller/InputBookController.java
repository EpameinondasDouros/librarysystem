package com.library.controller;

import com.library.model.Book;
import com.library.model.Genre;
import com.library.utils.BookManager;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class InputBookController {

    @FXML private TextField titleField;
    @FXML private TextField authorField;
    @FXML private TextField publisherField;
    @FXML private TextField isbnField;
    @FXML private TextField publishYearField;
    @FXML private TextField categoryField;
    @FXML private TextField numberOfCopiesField;
    @FXML private Label detailsLabel;
    @FXML private TextField genreField;
   
    @FXML
    protected void submitBookDetails() {

        Genre fantasy = new Genre("Fantasy", "A genre of speculative fiction set in a fictional universe, often inspired by real world myth and folklore.");
        // Create a new Book object from the input fields
        Book book = new Book(
                titleField.getText(),
                authorField.getText(),
                publisherField.getText(),
                isbnField.getText(),
                Integer.parseInt(publishYearField.getText()),
                Integer.parseInt(numberOfCopiesField.getText()),
                fantasy
        );

        BookManager.getInstance().addBook(book);

        // Display the book details
        detailsLabel.setText(book.toString());
    }
}
