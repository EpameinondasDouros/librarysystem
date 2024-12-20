package com.library.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
// import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

import com.library.model.Book;
import com.library.model.Review;
import com.library.model.SessionManager;
import com.library.utils.BookManager;

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

    @FXML private ListView<String> reviewsListView;
    @FXML private ComboBox<Integer> ratingComboBox;

    private ObservableList<Review> commentsObservableList = FXCollections.observableArrayList();


    // Add more @FXML annotations for other book details as needed
    private Book currentBook; 

    //     public void initialize() {
    //     // Initialize the rating ComboBox with values 1 through 5
    //     // ratingComboBox.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5));
    // }

    public void initData(Book book) {

        // List<Review> bookSpecificReviews = BookManager.getInstance().getReviews(currentBook);
        // ObservableList<Review> viewableReviews = FXCollections.observableArrayList(bookSpecificReviews);
        // commentsListView.setText(BookManager.getInstance().getReviews(currentBook).toString());

        this.currentBook = book;
        titleField.setText(book.getTitle());
        authorField.setText(book.getAuthor());
        publisherField.setText(book.getPublisher());
        isbnField.setText(book.getIsbn());
        publishYearField.setText(String.valueOf(book.getPublishYear())); // Assuming publishYear is an int
        numberOfCopiesField.setText(String.valueOf(book.getNumberOfCopies()));
        categoryField.setText(String.valueOf(book.getGenre()));
        
        // commentField.setText(String.valueOf(book.getComments()));
        
        // commentsObservableList.setAll(BookManager.getInstance().getReviews(currentBook)); // Assuming getComments returns List<String>
        // commentsListView.setItems(BookManager.getInstance().getReviews(currentBook).toString().toList);
        List<Review> reviews = BookManager.getInstance().getReviews(book);

        for (Review review : reviews) {
            System.out.println(review);
        }

        reviewsListView.getItems().clear(); // Clear existing items if necessary
        for (Review review : reviews) {
            reviewsListView.getItems().add(review.toString());
        }
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

    // @FXML
    // private void submitReview() {
    //     String comment = commentField.getText();
    //     Integer rating = ratingComboBox.getValue();

    //     if (comment.isEmpty() || rating == null) {
    //         // Handle the case where either comment or rating is not provided
    //         System.out.println("Both comment and rating are required.");
    //         return;
    //     }

    //     // Assuming addReview method exists and properly updates the book with a new review
    //     BookManager.getInstance().addReview(comment, rating,SessionManager.getInstance().getCurrentUser(), currentBook); // currentUser needs to be defined based on your user management logic
    //     List<Review> reviews=BookManager.getInstance().getAllReviews();
    //     // Optionally, update the UI to reflect the new review
    //     // For example, refresh the list of reviews and update the average rating label
    //     averageRatingLabel.setText(String.format("Average Rating: %.2f", BookManager.getInstance().calculateAverageRating(currentBook,reviews)));

    //     currentBook.setRating(BookManager.getInstance().calculateAverageRating(currentBook,reviews),-1);

    //     // Clear the input fields after submission
    //     commentField.clear();
    //     ratingComboBox.getSelectionModel().clearSelection();
    //     // updateCommentsListView(currentBook);
    // }



}

