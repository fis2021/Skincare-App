package org.loose.fis.sre.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.stage.Stage;
import org.loose.fis.sre.services.ProductNameService;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class CustomerController {

    public Button pointsButton;
    @FXML
    private Button logOutButton;
    @FXML
    private Button viewProductsButton;
    @FXML
    private Button helpButton;
    @FXML
    private Button viewOrdersCButton;
    @FXML
    private Button faqButton;



    public void handleLogOutButtonAction() throws Exception{
        Stage window = (Stage) logOutButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        window.setScene(new Scene(root, 800,600));
    }

    public void handleViewProductsButtonAction() throws Exception {

        Stage window = (Stage) viewProductsButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("viewProductsCustomer.fxml"));
        window.setScene(new Scene(root, 800,600));
    }
    public void handleHelpButtonAction() throws Exception{
        Stage window = (Stage) helpButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("askQuestions.fxml"));
        window.setScene(new Scene(root, 800,600));

    }

    public void handleViewOrdersCButtonAction() throws Exception{
        Stage window = (Stage) viewOrdersCButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("viewOrdersCustomer.fxml"));
        window.setScene(new Scene(root, 800,600));
    }

    public void handlefaqButtonAction() throws Exception{
        Stage window = (Stage) faqButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("questionsTable.fxml"));
        window.setScene(new Scene(root, 800,600));
    }

    public void handleViewPointsButtonAction() throws Exception{
        Stage window = (Stage) viewOrdersCButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fidelityPoints.fxml"));
        window.setScene(new Scene(root, 800,600));
    }
}
