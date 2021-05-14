package org.sa.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.Objects;

public class CustomerController {
    @FXML
    private Button logOutButton;
    @FXML
    private Button helpButton;
    @FXML
    private Button searchButton;

    public void handleLogOutButtonAction() throws Exception{
        Stage window = (Stage) logOutButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        window.setScene(new Scene(root, 800,600));
    }

    public void handlesearchButtonAction() throws Exception{
    }

    public void handleHelpButtonAction() throws Exception{

    }
}
