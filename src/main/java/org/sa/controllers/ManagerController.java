package org.sa.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ManagerController {
    @FXML
    private Button MakeOffersButton;
    @FXML
    private Button logOutButton;
    @FXML
    private Button viewProductsButton;

    @FXML
    private Button OrdersButton;
    @FXML
    private ChoiceBox category;

    @FXML
    private TextField name;

    @FXML
    private TextField price;

    public void handleLogOutButtonAction() throws Exception{
        Stage window = (Stage) logOutButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        window.setScene(new Scene(root, 800,600));
    }

    public void handleViewOrdersButtonAction() throws Exception{
        Stage window = (Stage) OrdersButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("viewOrdersManager.fxml"));
        window.setScene(new Scene(root, 800,600));
    }

    public void handleViewProductsButtonAction() throws Exception {

        Stage window = (Stage) viewProductsButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("viewProductsManager.fxml"));
        window.setScene(new Scene(root, 800,600));
    }

    public void handleMakeOffersButtonAction() throws Exception{
        Stage window = (Stage) MakeOffersButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("MakeOffersManager.fxml"));
        window.setScene(new Scene(root, 800,600));

    }
}
