package com.library.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import com.library.model.Genre;
import com.library.model.Review;
import com.library.utils.BookManager;
import com.library.utils.DataUtil;

import java.util.List;

public class ShowReviewsController {
    @FXML
    private ListView<String> reviewListView; // Display book titles or any property

    @FXML
    private ListView<Review> reviewsListView;


    @FXML
    private HBox topBar;


    @FXML
    public void initialize() {
        reviewsListView.setCellFactory(param -> new ListCell<Review>() {
            private final HBox content = new HBox();
            private final Label text = new Label();
            private final Button deleteButton = new Button("Delete");
            private final Button detailsButton = new Button("Details");
            
            {
                content.setSpacing(10);
                content.getChildren().addAll(text, deleteButton,detailsButton);

                // deleteButton.setOnAction(event -> {
                //     Loan loan = getItem();
                //     if (loan != null) {
                //         getListView().getItems().remove(loan);
                //         deleteLoan(loan); // Ensure this method removes the book from the data model and updates persistence
                //     }
                // });
                // detailsButton.setOnAction(event -> {
                //     Genre genre = getItem();
                //     if (genre != null) {
                //         showGenreDetails(genre); // Implement this method to show genre details
                //     }
                // });

            }
        
            @Override
            protected void updateItem(Review review, boolean empty) {
                super.updateItem(review, empty);
        
                if (empty || review == null) {
                    setGraphic(null);
                } else {
                    text.setText(review.toString() + " - " + review.getUser());
                    setGraphic(content);
                }
            }
        });
        

        List<Review> reviews = BookManager.getInstance().getAllReviews();
        reviewsListView.getItems().addAll(reviews);
    }





    // @FXML
    // private void deleteGenre(Genre genre) {
    // if (genre != null) {
    //     BookManager.getInstance().deleteGenreAndBooks(genre.getName());
    //     DataUtil.saveGenres(BookManager.getInstance().getGenres(), "genres.ser"); // Update the serialized file
    //     }
    // }

    // @FXML
    // private void showGenreDetails(Genre genre) {
    //     try {
    //         FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/GenreDetails.fxml")); // Adjust path as needed
    //         Parent root = loader.load();
            
    //         BookDetailsController controller = loader.getController();
    //         controller.initData(genre); // Assume initData is a method in your BookDetailsController
            
    //         Stage stage = new Stage();
    //         stage.setTitle("Book Details");
    //         stage.setScene(new Scene(root));
    //         stage.show();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }


}
