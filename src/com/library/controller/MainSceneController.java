package com.library.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainSceneController {

    @FXML
    private TextField tfTitle;

    @FXML
    void btnOKClicked(ActionEvent event) {
        Stage mainWindow= (Stage) tfTitle.getScene().getWindow();
        String title = tfTitle.getText();
        mainWindow.setTitle(title);

    }

}