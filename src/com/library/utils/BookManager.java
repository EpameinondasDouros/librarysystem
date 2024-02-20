package com.library.utils;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.library.model.Book;
import com.library.model.Genre;
import com.library.model.Loan;
import com.library.model.Review;
import com.library.model.SessionManager;
import com.library.model.User;

public class BookManager {
    private static BookManager instance;
    private List<Book> books;
    private List<Genre> genres;
    private List<Loan> loans;
    private List<User> users;
    private User currentUser;

    private List<Review> reviews = new ArrayList<>();

    // Private constructor to prevent instantiation
    BookManager() {
        books = new ArrayList<>();
        // Load existing books from a serialized file at initialization
        books = DataUtil.loadBooks("books.ser");
        if (books == null) {
            books = new ArrayList<>();
        }
        genres = DataUtil.loadGenres("genres.ser");
        if (genres == null) {
            genres = new ArrayList<>();
        }
        loans = DataUtil.loadLoans("loans.ser");
        if (loans == null) {
            loans = new ArrayList<>();
        }
        users=DataUtil.loadUsers("users.ser");
        if (users == null) {
            users = new ArrayList<>();
        }
    }

    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null; // Return null if the user was not found
    }

    public Book getBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null; // Return null if the user was not found
    }

    // Public method to get the singleton instance
    public static synchronized BookManager getInstance() {
        if (instance == null) {
            instance = new BookManager();
        }
        return instance;
    }

    // Method to add a book to the list
    public void addBook(Book book) {
        if (book != null) {
            books.add(book);
            DataUtil.saveBooks(books, "books.ser");
        }
    }

    public void deleteBook(Book book) {
        if (book != null && books.contains(book)) {
            books.remove(book);
            // Save the updated list to the file
            DataUtil.saveBooks(books, "books.ser");
        }
    }

    // Method to get the list of books
    public List<Book> getBooks() {
        return books;
    }

    // Method to add a genre
    public void addGenre(Genre genre) {
        if (!genres.contains(genre)) {
            genres.add(genre);
        }
    }

    // Method to delete a genre and all associated books
    public void deleteGenreAndBooks(String genreName) {
        // Remove the genre from the genres list
        genres.removeIf(genre -> genre.getName().equals(genreName));

        // Remove all books associated with this genre
        books.removeIf(book -> book.getGenre().getName().equals(genreName));
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public List<Loan> getLoans() {
        return loans;
    }


    public void loanBook(Book book) {
        // Book selectedBook = book;
        if (book != null) {
            try {
                book.loanBook(); // Reduce the number of copies
                loans.add(new Loan(currentUser, book, LocalDate.now())); // Create a new loan
                // Optionally, refresh the list view to show the updated number of copies
            } catch (IllegalStateException ex) {
                System.out.println("Cannot loan this book: " + ex.getMessage());
                // Handle the case where no copies are available, e.g., show an error message
            }
        }
    }

    public void loanDelete(Loan loan){
        loans.remove(loan);

    }

    // Method to add a comment and rating together
    public void addReview(String comment, int rating,User user,Book book) {
        reviews.add(new Review(comment, rating,SessionManager.getInstance().getCurrentUser(),book));
    }

    // Method to get all reviews of the book
    public List<Review> getReviews(Book targetBook) {
            // Filter reviews for the specified book
            return reviews.stream()
                        .filter(review -> review.getBook().equals(targetBook))
                        .collect(Collectors.toList());
        }

    public double calculateAverageRating() {
        return reviews.stream()
                      .mapToInt(Review::getRating) // Convert Review objects to int stream of ratings
                      .average()                   // Calculate the average of the stream
                      .orElse(0);                  // Return 0 if the stream is empty
    }

    

}
