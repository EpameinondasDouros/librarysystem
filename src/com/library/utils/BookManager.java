package com.library.utils;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Comparator;
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

    private List<Review> reviews;

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
        reviews=DataUtil.loadReviews("reviews.ser");
        if (reviews == null) {
            users = new ArrayList<>();
        }
    }

    public void addUser(String username, String password, String email, boolean admin, String firstname, String lastname, String idnumber) {
        // Check if the user already exists based on username, email, or idnumber
        // boolean userExists = users.stream()
        //                           .anyMatch(user -> user.getUsername().equals(username) ||
        //                                             user.getEmail().equals(email) ||
        //                                             user.getidNumber().equals(idnumber));

        // if (!userExists) {
            User newUser = new User(username, password, email, admin, firstname, lastname, idnumber);
            users.add(newUser);
            System.out.println("User added successfully.");

            DataUtil.saveUsers(users, "users.ser");
        // } else {
        //     System.out.println("A user with the same username, email, or ID number already exists.");
        // }
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

    public List<User> getUsers() {
        return users;
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

        loans.removeIf(loan -> loan.getBook().getGenre().getName().equals(genreName));
    }

    public List<Genre> getGenres() {
        if (this.genres == null) {
            return new ArrayList<>(); // Return an empty list instead of null
        }
        return new ArrayList<>(this.genres);
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
        System.out.println(comment);
        System.out.println(rating);
        System.out.println(user.toString());
        System.out.println(book.toString());
        
        Review newReview=new Review(comment, rating,SessionManager.getInstance().getCurrentUser(),book);
        reviews.add(newReview);
        DataUtil.saveReviews(reviews, "reviews.ser");
    }

    // Method to get all reviews of the book
    public List<Review> getReviews(Book targetBook) {
        // System.out.println("BOOOOOOOOOOOOOOOOk review found: ");
        List<Review> filteredReviews = new ArrayList<>();
        for (Review review : reviews) {
            // System.out.println(review.getBook().getTitle().toString() + "    =========           "+ targetBook.getTitle().toString());
            if (review.getBook().getTitle().toString().equalsIgnoreCase(targetBook.getTitle().toString()) ) {
                // System.out.println("Matching review14555555555555555555555555555555sdggggggggggggggggggggggggg found: " + review); // Debug statement
                filteredReviews.add(review);
            }
        }
        return filteredReviews;
    }
    public List<Review> getAllReviews() {
        // Filter reviews for the specified book
        return reviews;
    }

    public double calculateAverageRating(Book targetBook, List<Review> reviews) {
        
        // Filter reviews for the target book and calculate the average rating
        double averageRating = reviews.stream()
                        .filter(review -> review.getBook().equals(targetBook))
                        .mapToInt(Review::getRating)
                        .average()
                        .orElse(0); // Return 0 if there are no reviews for the book
        
        long reviewCount = reviews.stream()
                        .filter(review -> review.getBook().equals(targetBook))
                        .count();

        targetBook.setRating(averageRating,(int)reviewCount);
                        
        return averageRating;
        }

    public Genre getGenreByName(String name, List<Genre> genresList) {
        return genresList.stream()
                         .filter(genre -> genre.getName().equals(name))
                         .findFirst()
                         .orElse(null); // Return null if no match is found
    }
        

    // Method to find and return the top 5 rated books
    public List<Book> getTopRatedBooks() {
        return books.stream()
                .sorted(Comparator.comparingDouble(Book::getRating).reversed()) // Sort books by rating in descending order
                .limit(5) // Limit to top 5
                .collect(Collectors.toList()); // Collect the result into a list
    }
    

}
