package com.library.model;

import java.io.Serializable;

public class Review implements Serializable{
    private static final long serialVersionUID = 1236969L;
    private String comment;
    private int rating;
    private User user;
    private Book book;
    private int numOfReviews;

    // Constructor
    public Review(String comment, int rating, User user, Book book) {
        this.comment = comment;
        this.rating = rating;
        this.user = user;
        this.book = book;
    }

    // Getters
    public String getComment() {
        return comment;
    }

    public int getRating() {
        return rating;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    // Optionally, if you want to allow modifications
    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    // toString method to represent the review as a String
    @Override
    public String toString() {
        return "Review by " + user.getUsername() + " for " + book.getTitle() + ": Rating=" + rating + ", Comment='" + comment + "'";
    }
}

