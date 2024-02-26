
package com.library.utils;

import java.util.ArrayList;
import java.util.List;

import com.library.model.Book;
import com.library.model.Genre;
import com.library.model.Loan;
import com.library.model.Review;
import com.library.model.User;

import javafx.beans.binding.ListBinding;

public class CreateData {

    public static void main(String[] args) {

        BookManager Manager = new BookManager();


        List<Genre> genres = new ArrayList<>();

            Genre fantasy = new Genre("Fantasy", "A genre of speculative fiction set in a fictional universe, often inspired by real world myth and folklore.");
            Genre scienceFiction = new Genre("Science Fiction", "Science fiction deals with imaginative and futuristic concepts.");
            Genre mystery = new Genre("Mystery", "Mystery involves solving some sort of crime or puzzling scenario.");
            Genre romance = new Genre("Romance", "Romance focuses on love and relationships between people.");
            genres.add(fantasy);
            genres.add(scienceFiction);
            genres.add(mystery);
            genres.add(romance);

        List<Book> books = new ArrayList<>();
        
            Book theGreatGatsby=new Book("The Great Gatsby", "F. Scott Fitzgerald", "Charles Scribner's Sons", "9780743273565", 1925, 2, fantasy);
            books.add(theGreatGatsby);
            Book prideAndPrejudice = new Book("Pride and Prejudice", "Jane Austen", "T. Egerton", "9780141439518", 1813, 3, romance);
            books.add(prideAndPrejudice);
            Book dune = new Book("Dune", "Frank Herbert", "Chilton Books", "9780441172719", 1965, 4, scienceFiction);
            books.add(dune);
            Book malteseFalcon = new Book("The Maltese Falcon", "Dashiell Hammett", "Alfred A. Knopf", "9780679722649", 1930, 2, mystery);
            books.add(malteseFalcon);
            Book catcherInTheRye = new Book("The Catcher in the Rye", "J.D. Salinger", "Little, Brown and Company", "9780316769488", 1951, 2, scienceFiction);
            books.add(catcherInTheRye);
            Book the1984 = new Book("1984", "George Orwell", "Secker & Warburg", "9780451524935", 1949, 5,scienceFiction);
            books.add(the1984);
            Book theHobbit = new Book("The Hobbit", "J.R.R. Tolkien", "George Allen & Unwin", "9780345339683", 1937, 4, fantasy);
            books.add(theHobbit);   
            Book harryPotterSorcerersStone = new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Bloomsbury Publishing", "9780747532743", 1997, 5, fantasy);
            books.add(harryPotterSorcerersStone);
            Book lordOfTheFlies = new Book("Lord of the Flies", "William Golding", "Faber and Faber", "9780571191475", 1954, 4, scienceFiction);
            books.add(lordOfTheFlies);
            Book theHungerGames = new Book("The Hunger Games", "Suzanne Collins", "Scholastic Corporation", "9780439023481", 2008, 4, scienceFiction);
            books.add(theHungerGames);
            Book theCatcherInTheRye = new Book("The Catcher in the Rye", "J.D. Salinger", "Little, Brown and Company", "9780316769488", 1951, 4, scienceFiction);
            books.add(theCatcherInTheRye);
            Book crimeAndPunishment = new Book("Crime and Punishment", "Fyodor Dostoevsky", "The Russian Messenger", "9780140449136", 1866, 5, scienceFiction);
            books.add(crimeAndPunishment);
            Book theMartian = new Book("The Martian", "Andy Weir", "Crown Publishing Group", "9780553418026", 2011, 4, scienceFiction);
            books.add(theMartian);
            Book aTaleOfTwoCities = new Book("A Tale of Two Cities", "Charles Dickens", "Chapman & Hall", "9781853260391", 1859, 5, scienceFiction);
            books.add(aTaleOfTwoCities);
            Book theRoad = new Book("The Road", "Cormac McCarthy", "Alfred A. Knopf", "9780307265432", 2006, 4, scienceFiction);
            books.add(theRoad);
            Book theChroniclesOfNarnia = new Book("The Lion, the Witch and the Wardrobe", "C.S. Lewis", "Geoffrey Bles", "9780006716873", 1950, 4, fantasy);
            books.add(theChroniclesOfNarnia);
            Book endersGame = new Book("Ender's Game", "Orson Scott Card", "Tor Books", "9780812550702", 1985, 4, scienceFiction);
            books.add(endersGame);
            Book theFellowshipOfTheRing = new Book("The Fellowship of the Ring", "J.R.R. Tolkien", "George Allen & Unwin", "9780618346257", 1954, 5, fantasy);
            books.add(theFellowshipOfTheRing);
            Book theGirlWithTheDragonTattoo = new Book("The Girl with the Dragon Tattoo", "Stieg Larsson", "Norstedts Förlag", "9780307269751", 2005, 4, mystery);
            books.add(theGirlWithTheDragonTattoo);


        
        List<User> users = new ArrayList<>();
        
        User medialab = new User("medialab", "medialab", "medialab@gmail.com", true, "Media", "Lab", "22431");
        User epadouros = new User("epadouros", "ntua2024", "epa@gmail.com", true, "Epa", "Douros", "asdfa");
        User johnsmith = new User("johnsmith", "jsmith123", "john.smith@example.com", false, "John", "Smith", "323r2");
        User maryjones = new User("maryjones", "mary1234", "mary.jones@example.com", false, "Mary", "Jones", "23fwd");
        User davidbrown = new User("davidbrown", "dbrown567", "david.brown@example.com", false, "David", "Brown", "5wesrg23");
        User sarahwilson = new User("sarahwilson", "sarah987", "sarah.wilson@example.com", false, "Sarah", "Wilson", "6423wf");
        User michaelclark = new User("michaelclark", "mikec321", "michael.clark@example.com", false, "Michael", "Clark", "q2434");
        User jenniferlee = new User("jenniferlee", "jlee456", "jennifer.lee@example.com", false, "Jennifer", "Lee", "81234rfwe");
        User robertnguyen = new User("robertnguyen", "rob123", "robert.nguyen@example.com", false, "Robert", "Nguyen", "9234wf");
        User emilywang = new User("emilywang", "emily789", "emily.wang@example.com", false, "Emily", "Wang", "104a352fas");
        User christopherlopez = new User("christopherlopez", "chrisl555", "christopher.lopez@example.com", false, "Christopher", "Lopez", "fa22r3");
        User amandasmith = new User("amandasmith", "amanda12", "amanda.smith@example.com", false, "Amanda", "Smith", "1f4w2f2");
        

            users.add(medialab);
            users.add(epadouros);
            users.add(johnsmith);
            users.add(maryjones);
            users.add(davidbrown);
            users.add(sarahwilson);
            users.add(michaelclark);
            users.add(jenniferlee);
            users.add(robertnguyen);
            users.add(emilywang);
            users.add(christopherlopez);
            users.add(amandasmith);
            

        List<Loan> loans = new ArrayList<>();

        loans.add(new Loan(medialab, theMartian,null ));
        loans.add(new Loan(epadouros, theGirlWithTheDragonTattoo,null ));
        loans.add(new Loan(medialab, theFellowshipOfTheRing,null ));
        loans.add(new Loan(epadouros, theFellowshipOfTheRing,null ));
        loans.add(new Loan(medialab, theMartian,null ));
        loans.add(new Loan(epadouros, aTaleOfTwoCities,null ));
        loans.add(new Loan(medialab, aTaleOfTwoCities,null ));
        
        

        List<Review> reviews = new ArrayList<>();

        reviews.add(new Review("Arxiko", 4, amandasmith, theGirlWithTheDragonTattoo));
        // Adding more dummy reviews
        reviews.add(new Review("Captivating story!", 5, sarahwilson, harryPotterSorcerersStone));
        reviews.add(new Review("Enjoyed every page.", 4, michaelclark, theHobbit));
        reviews.add(new Review("A classic masterpiece.", 5, jenniferlee, prideAndPrejudice));
        reviews.add(new Review("Thrilling plot twists.", 4, davidbrown, theHungerGames));
        reviews.add(new Review("Fascinating world-building.", 5, epadouros, dune));
        reviews.add(new Review("Compelling characters.", 4, maryjones, theGreatGatsby));
        reviews.add(new Review("Couldn't put it down!", 5, johnsmith, theMartian));
        reviews.add(new Review("Timeless classic.", 5, sarahwilson, aTaleOfTwoCities));
        reviews.add(new Review("Suspenseful and gripping.", 4, michaelclark, malteseFalcon));
        reviews.add(new Review("Thought-provoking.", 4, jenniferlee, the1984));
        // Adding more dummy reviews
        reviews.add(new Review("Riveting from start to finish.", 5, davidbrown, harryPotterSorcerersStone));
        reviews.add(new Review("An epic adventure!", 5, epadouros, theHobbit));
        reviews.add(new Review("Beautifully written.", 4, johnsmith, prideAndPrejudice));
        reviews.add(new Review("Page-turner!", 4, maryjones, theMartian));
        reviews.add(new Review("Compelling narrative.", 5, sarahwilson, theGreatGatsby));
        reviews.add(new Review("A must-read.", 5, michaelclark, aTaleOfTwoCities));
        reviews.add(new Review("Intriguing mystery.", 4, jenniferlee, malteseFalcon));
        reviews.add(new Review("Immersive world-building.", 5, davidbrown, theHungerGames));
        reviews.add(new Review("Heartwarming story.", 4, epadouros, dune));
        reviews.add(new Review("Masterfully crafted.", 5, johnsmith, catcherInTheRye));
        // Adding more dummy reviews
        reviews.add(new Review("Couldn't stop reading!", 5, maryjones, harryPotterSorcerersStone));
        reviews.add(new Review("A timeless classic.", 5, sarahwilson, theGreatGatsby));
        reviews.add(new Review("Engrossing storyline.", 4, michaelclark, dune));
        reviews.add(new Review("Suspenseful and gripping.", 4, jenniferlee, theHungerGames));
        reviews.add(new Review("Brilliantly written.", 5, epadouros, aTaleOfTwoCities));
        reviews.add(new Review("Kept me on the edge of my seat.", 4, johnsmith, malteseFalcon));
        reviews.add(new Review("Thought-provoking.", 5, davidbrown, the1984));
        reviews.add(new Review("A must-read for fantasy fans!", 5, maryjones, theHobbit));
        reviews.add(new Review("Captivating characters.", 4, sarahwilson, theMartian));
        reviews.add(new Review("Spellbinding tale.", 5, michaelclark, catcherInTheRye));


        for(Book book : books) {
            double ratings=BookManager.getInstance().calculateAverageRating(book,reviews);
            System.out.println(ratings + book.toString());
        }
        // Add more books as needed

        // Now serialize the list to a file
        DataUtil.saveBooks(books, "books.ser"); // Assuming BookDataUtil is implemented as previously discussed
        DataUtil.saveGenres(genres, "genres.ser"); // Assuming BookDataUtil is implemented as previously discussed
        DataUtil.saveLoans(loans, "loans.ser"); // Assuming BookDataUtil is implemented as previously discussed
        DataUtil.saveUsers(users, "users.ser"); // Assuming BookDataUtil is implemented as previously discussed
        DataUtil.saveReviews(reviews, "reviews.ser"); // Assuming BookDataUtil is implemented as previously discussed
    }

    


}