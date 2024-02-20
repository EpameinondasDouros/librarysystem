package com.library.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.util.List;
import java.util.stream.Collectors;

import com.library.model.*;
import com.library.utils.BookManager;

public class SearchController {
    @FXML
    private TextField searchField;
    @FXML
    private ListView<String> resultsListView;

    
    // private List<Book> allBooks;
    private List<Book> allBooks = BookManager.getInstance().getBooks(); // Assume this is populated with all available books

    @FXML
    protected void performSearch() {
        String searchTerm = searchField.getText().toLowerCase();
        System.out.println("Search Term Entered: " + searchTerm); // Print the search term for verification

        resultsListView.getItems().clear(); 
        
        for (Book book : allBooks) {
            System.out.println("Searched Book: " + book.getTitle().toLowerCase());
            if (book.getTitle().toLowerCase().contains(searchTerm)) {
                
                resultsListView.getItems().add(book.getTitle());
            }
        }
    }
    // Method to initialize or set 'allBooks' with actual book data
    public void setAllBooks(List<Book> books) {
        this.allBooks = books;
    }
}
