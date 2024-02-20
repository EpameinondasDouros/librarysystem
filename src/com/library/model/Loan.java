package com.library.model;

import java.io.Serializable;
import java.time.LocalDate;
import com.library.model.*;

public class Loan implements Serializable{
    private static final long serialVersionUID = 123L;
    private User user;
    private Book book;
    private LocalDate loanDate;

    public Loan(User user, Book book, LocalDate loanDate) {
        this.user = user;
        this.book = book;
        this.loanDate = loanDate;
    }

    // Getters
    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }
    // Additional functionality like returning a book could also be implemented here
}
