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

    @FXML
    private Button logOutButton;
    @FXML
    private Button helpButton;


    public void handleLogOutButtonAction() throws Exception{
        Stage window = (Stage) logOutButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        window.setScene(new Scene(root, 800,600));
    }


    public void handleHelpButtonAction() throws Exception{

    }
}
