package com.library.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
// import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import com.library.model.Book;

public class BookDetailsController {

    @FXML private TextField titleField;
    @FXML private TextField authorField;
    @FXML private TextField publisherField;
    @FXML private TextField isbnField;
    @FXML private TextField publishYearField;
    @FXML private TextField categoryField;
    @FXML private TextField numberOfCopiesField;
    @FXML private TextField commentField;
    @FXML private Label averageRatingLabel;

    @FXML private ListView<String> commentsListView;
    @FXML private ComboBox<Integer> ratingComboBox;

    private ObservableList<String> commentsObservableList = FXCollections.observableArrayList();


    // Add more @FXML annotations for other book details as needed
    private Book currentBook; 

        public void initialize() {
        // Initialize the rating ComboBox with values 1 through 5
        ratingComboBox.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5));
    }

    public void initData(Book book) {
        this.currentBook = book;
        titleField.setText(book.getTitle());
        authorField.setText(book.getAuthor());
        publisherField.setText(book.getPublisher());
        isbnField.setText(book.getIsbn());
        publishYearField.setText(String.valueOf(book.getPublishYear())); // Assuming publishYear is an int
        numberOfCopiesField.setText(String.valueOf(book.getNumberOfCopies()));
        commentField.setText(String.valueOf(book.getComments()));
        averageRatingLabel.setText(String.valueOf(book.getRating()));
        categoryField.setText(String.valueOf(book.getGenre())); // Assuming numberOfCopies is an int
        // Set other details as necessary
        commentsObservableList.setAll(book.getComments()); // Assuming getComments returns List<String>
        commentsListView.setItems(commentsObservableList);

        // Assuming getRating returns a double or similar
        averageRatingLabel.setText(String.format("Average Rating: %.2f", book.getRating()));
    }
    

    // Called when the "Save" button is pressed
    @FXML
    private void saveBookDetails() {
        try {
            // Here, update the currentBook object with new details
            currentBook.setTitle(titleField.getText());
            currentBook.setAuthor(authorField.getText());
            currentBook.setPublisher(publisherField.getText());
            currentBook.setIsbn(isbnField.getText());
            currentBook.setPublishYear(Integer.parseInt(publishYearField.getText()));
            currentBook.setNumberOfCopies(Integer.parseInt(numberOfCopiesField.getText()));                     
            // Add logic to persist these changes, such as updating a database or a data file
        } catch (NumberFormatException e) {
            // Handle potential format errors, e.g., for publishYearField and numberOfCopiesField
            System.err.println("Error updating book details: " + e.getMessage());
            // Optionally, show an error message to the user
        }
    }

    @FXML
    private void submitComment() {
        String comment = commentField.getText();
        if (!comment.isEmpty()) {
            currentBook.addComment(comment);
            commentsObservableList.add(comment); // Update the ListView
            commentField.clear(); // Clear the input field
        }
    }

    @FXML
    private void submitRating() {
        Integer rating = ratingComboBox.getValue();
        if (rating != null) {
            currentBook.addRating(rating);
            averageRatingLabel.setText(String.format("Average Rating: %.2f", currentBook.getRating())); // Update the average rating
        }
    }



}
