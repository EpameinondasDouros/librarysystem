package com.library.controller;

import java.util.List;

import com.library.model.Book;
import com.library.model.Genre;
import com.library.utils.BookManager;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
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
    @FXML private ComboBox<Genre> genreComboBox;
   
    @FXML
    public void initialize() {
        // Populate the ComboBox with genres
        List<Genre> genresList = BookManager.getInstance().getGenres();
        genreComboBox.setItems(FXCollections.observableArrayList(genresList));

        // Optional: Make the ComboBox display a string property of Genre, if Genre is not a String
        genreComboBox.setCellFactory(lv -> new ListCell<Genre>() {
            @Override
            protected void updateItem(Genre item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? null : item.getName());
            }
        });
        genreComboBox.setButtonCell(new ListCell<Genre>() {
            @Override
            protected void updateItem(Genre item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getName());
                }
            }
        });
    }

    @FXML
    protected void submitBookDetails() {

        // Genre fantasy = new Genre("Fantasy", "A genre of speculative fiction set in a fictional universe, often inspired by real world myth and folklore.");
        // Create a new Book object from the input fields

        // List <Genre> genresList = BookManager.getInstance().getGenres();
        Genre selectedGenre = genreComboBox.getValue();

        
        Book book = new Book(
                titleField.getText(),
                authorField.getText(),
                publisherField.getText(),
                isbnField.getText(),
                Integer.parseInt(publishYearField.getText()),
                Integer.parseInt(numberOfCopiesField.getText()),
                selectedGenre
        );

        BookManager.getInstance().addBook(book);

        // Display the book details
        detailsLabel.setText(book.toString());
    }
}
