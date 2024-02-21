package com.library.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

import java.util.List;

import com.library.model.Book;
import com.library.utils.BookManager;

import javafx.collections.FXCollections;

public class TopBooksController {

    @FXML
    private ListView<Book> booksListView;

    private BookManager bookManager;

    @FXML
    public void initialize() {
        bookManager = BookManager.getInstance(); 
        updateBooksList();
    }

    private void updateBooksList() {
        // Fetch the top 5 rated books
        List<Book> topRatedBooks = bookManager.getTopRatedBooks();
        
        // Set these books to the ListView
        booksListView.setItems(FXCollections.observableArrayList(topRatedBooks));
        
        // Optional: Customize how books are displayed if necessary
        booksListView.setCellFactory(listView -> new ListCell<Book>() {
            @Override
            protected void updateItem(Book book, boolean empty) {
                super.updateItem(book, empty);
                if (empty || book == null) {
                    setText(null);
                } else {
                    setText(book.toString()); //+ " - Rating: " + book.getRating());
                }
            }
        });
    }

}


