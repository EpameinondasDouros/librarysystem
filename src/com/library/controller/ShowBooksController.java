package com.library.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.IOException;

import com.library.model.Book;
import com.library.utils.DataUtil;
import com.library.utils.BookManager;

import java.util.List;

public class ShowBooksController {
    @FXML
    private ListView<String> bookListView; // Display book titles or any property

    @FXML
    private ListView<Book> booksListView;


    @FXML
    private HBox topBar;


    @FXML
    public void initialize() {
        booksListView.setCellFactory(param -> new ListCell<Book>() {
            private final HBox content = new HBox();
            private final Label text = new Label();
            private final Button deleteButton = new Button("Delete");
            private final Button detailsButton = new Button("Details");
            private final Button loanButton = new Button("Loan");
            
            {
                content.setSpacing(10);
                content.getChildren().addAll(text, deleteButton,detailsButton,loanButton);

                deleteButton.setOnAction(event -> {
                    Book book = getItem();
                    if (book != null) {
                        getListView().getItems().remove(book);
                        deleteBook(book); // Ensure this method removes the book from the data model and updates persistence
                    }
                });
                detailsButton.setOnAction(event -> {
                    Book book = getItem();
                    if (book != null) {
                        showBookDetails(book); // Implement this method to show book details
                    }
                });

                loanButton.setOnAction(event -> {
                    Book book = getItem();
                    if (book != null) {
                        loanBook(book); 
                    }
                });

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
        

        List<Book> books = BookManager.getInstance().getBooks();
        booksListView.getItems().addAll(books);
    }





    @FXML
    private void deleteBook(Book book) {
    if (book != null) {
        BookManager.getInstance().deleteBook(book);
        DataUtil.saveBooks(BookManager.getInstance().getBooks(), "books.ser"); // Update the serialized file
        }
    }

    @FXML
    private void loanBook(Book book) {
    if (book != null) {
        BookManager.getInstance().loanBook(book);
        // DataUtil.saveBooks(BookManager.getInstance().getBooks(), "books.ser"); // Update the serialized file
        }
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
