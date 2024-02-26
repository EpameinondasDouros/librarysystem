package com.library.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.library.model.*;
import com.library.utils.BookManager;

public class SearchController {
    @FXML
    private TextField titleField;
    @FXML
    private TextField authorField;
    @FXML
    private TextField yearField;
    @FXML
    private ListView<String> resultsListView;

    private ListView<Book> booksListView;
    // private List<Book> allBooks;
    private List<Book> allBooks = BookManager.getInstance().getBooks(); // Assume this is populated with all available books
   @FXML
    public void finalize() {
        booksListView.setCellFactory(param -> new ListCell<Book>() {
            private final HBox content = new HBox();
            private final Label text = new Label();
            private final Button deleteButton = new Button("Delete");
            private final Button detailsButton = new Button("Details");
            private final Button loanButton = new Button("Loan");
            
            {
                content.setSpacing(10);
                content.getChildren().addAll(text, deleteButton,detailsButton,loanButton);

                // deleteButton.setOnAction(event -> {
                //     Book book = getItem();
                //     if (book != null) {
                //         getListView().getItems().remove(book);
                //         deleteBook(book); // Ensure this method removes the book from the data model and updates persistence
                //     }
                // });
                detailsButton.setOnAction(event -> {
                    Book book = getItem();
                    if (book != null) {
                        showBookDetails(book); // Implement this method to show book details
                    }
                });

                // loanButton.setOnAction(event -> {
                //     Book book = getItem();
                //     if (book != null) {
                //         loanBook(book); 
                //     }
                // });

            }
        
            @Override
            protected void updateItem(Book book, boolean empty) {
                super.updateItem(book, empty);
        
                if (empty || book == null) {
                    setGraphic(null);
                } else {
                    text.setText(book.getTitle() + " - " + book.getAuthor());
                    setGraphic(content);
                }
            }
        });
        

        // List<Book> books = BookManager.getInstance().getBooks();
        
    }
    @FXML
    protected void performSearch() {          
    
            resultsListView.getItems().clear(); 
            
            String titleInput = titleField.getText().toLowerCase();
            String authorInput = authorField.getText().toLowerCase();
            String yearInput = yearField.getText();
    
            System.out.println("Search Term Entered: " + titleInput + authorInput + yearInput); // Print the search term for verification
    
            // Fetch all books - assuming BookManager has a method getAllBooks() returning List<Book>
            List<Book> allBooks = BookManager.getInstance().getBooks();
        
        for (Book book : allBooks) {
            System.out.println("Searched Book: " + book.getTitle().toLowerCase());
            if (
                book.getTitle().toLowerCase().contains(titleInput) 
                &&
                
                book.getAuthor().toLowerCase().contains(authorInput) 
                // &&

                // book.getPublishYear().contains(authorInput)                
                
                ) {

                    booksListView.getItems().add(book);
                
                // resultsListView.getItems().add("Ttile "+book.getTitle()+ " Author : " +book.getAuthor());
            }
        }     

        

        // finalize();
    }
    // Method to initialize or set 'allBooks' with actual book data
    public void setAllBooks(List<Book> books) {
        this.allBooks = books;
    }

    @FXML
    private void showBookDetails(Book book) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/BookDetails.fxml")); // Adjust path as needed
            Parent root = loader.load();
            
            BookDetailsController controller = loader.getController();
            controller.initData(book); // Assume initData is a method in your BookDetailsController
            
            Stage stage = new Stage();
            stage.setTitle("Book Details");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
