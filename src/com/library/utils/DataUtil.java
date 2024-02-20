package com.library.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.List;

import com.library.model.*;

public class DataUtil {

    // Method to serialize and save a list of books to a .ser file
    public static void saveBooks(List<Book> bookList, String filename) {
        if (!filename.endsWith(".ser")) {
            filename += ".ser";
        }
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(bookList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to load and deserialize a list of books from a .ser file
    public static List<Book> loadBooks(String filename) {
        if (!filename.endsWith(".ser")) {
            filename += ".ser";
        }
        List<Book> bookList = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            Object data = in.readObject();
            if (data instanceof List<?>) {
                bookList = (List<Book>) data; // The cast generates a warning
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Error");
        }
        return bookList;
    }
    
    public static void saveGenres(List<Genre> genreList, String filename) {
        if (!filename.endsWith(".ser")) {
            filename += ".ser";
        }
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(genreList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Genre> loadGenres(String filename) {
        if (!filename.endsWith(".ser")) {
            filename += ".ser";
        }
        List<Genre> genreList = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            Object data = in.readObject();
            if (data instanceof List<?>) {
                genreList = (List<Genre>) data; // This unchecked cast warning is normal
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Error loading genres");
        }
        return genreList;
    }

    public static void saveLoans(List<Loan> loanList, String filename) {
        if (!filename.endsWith(".ser")) {
            filename += ".ser";
        }
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(loanList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Loan> loadLoans(String filename) {
        if (!filename.endsWith(".ser")) {
            filename += ".ser";
        }
        List<Loan> loanList = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            Object data = in.readObject();
            if (data instanceof List<?>) {
                loanList = (List<Loan>) data; // This unchecked cast warning is normal but should be safe if the file contains Loans
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Error loading loans");
        }
        return loanList;
    }

    public static void saveUsers(List<User> userList, String filename) {
        if (!filename.endsWith(".ser")) {
            filename += ".ser";
        }
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(userList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<User> loadUsers(String filename) {
        if (!filename.endsWith(".ser")) {
            filename += ".ser";
        }
        List<User> userList = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            Object data = in.readObject();
            if (data instanceof List<?>) {
                userList = (List<User>) data; // This unchecked cast warning is normal but should be safe if the file contains Loans
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Error loading loans");
        }
        return userList;
    }
}
