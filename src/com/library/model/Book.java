package com.library.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable{
    private static final long serialVersionUID = 1234512345L;
    private String title;
    private String author;
    private String publisher;
    private String isbn;
    private int publishYear;
    private int numberOfCopies;
    private Genre genre;    
    private double rating = 0.0;
    private int ratingCount = 0;
    private List<String> comments = new ArrayList<>();
    private List<Review> reviews = new ArrayList<>();

    // Constructor
    public Book(String title, String author, String publisher, String isbn, 
                int publishYear, int numberOfCopies, Genre genre) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.publishYear = publishYear;
        this.numberOfCopies = numberOfCopies;
        this.rating = 0;
        this.genre = genre; // Initial rating is set to 0
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    // Additional methods to manipulate the book's data can be added here
    // For example, a method to update the book's rating
    public void updateRating(int newRating) {
        this.rating = newRating;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void loanBook() {
        if (this.numberOfCopies > 0) {
            this.numberOfCopies -= 1;
        } else {
            throw new IllegalStateException("No copies left to loan.");
        }
    }

    public void addComment(String comment) {
        comments.add(comment);
    }

    // Method to add a rating
    public void addRating(int newRating) {
        double totalRating = this.rating * this.ratingCount;
        totalRating += newRating;
        this.ratingCount++;
        this.rating = totalRating / this.ratingCount;
    }

    // Getters for comments and rating
    public List<String> getComments() {
        return comments;
    }

    public double calculateAverageRating() {
        return reviews.stream()
                      .mapToInt(Review::getRating) // Convert Review objects to int stream of ratings
                      .average()                   // Calculate the average of the stream
                      .orElse(0);                  // Return 0 if the stream is empty
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }
    



    @Override
    public String toString() {
    return "Title: " + title +
           "\nAuthor: " + author +
           "\nPublisher: " + publisher +
           "\nISBN: " + isbn +
           "\nPublish Year: " + publishYear +
           "\nNumber of Copies: " + numberOfCopies +
           "\nRating: " + rating;
}



    // ... Any other necessary methods

}
