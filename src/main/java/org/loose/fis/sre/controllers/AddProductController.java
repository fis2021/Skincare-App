package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.NameAlreadyExistsException;
import org.loose.fis.sre.services.ProductNameService;

import java.io.IOException;

public class AddProductController {

    @FXML
    private ChoiceBox category;

    @FXML
    private TextField name;

    @FXML
    private TextField price;


    @FXML
    public void initialize() {
        category.getItems().addAll("Dry Skin", "Oily Skin", "Sensitive Skin");
    }

    public void handleAddButtonAction() throws  IOException {

                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("viewProductsManager.fxml"));
                Stage window = (Stage) category.getScene().getWindow();
                window.setScene(new Scene(root, 800, 600));

        }


    public void handleCancelButtonAction() throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("viewProductsManager.fxml"));
        Stage window = (Stage) category.getScene().getWindow();
        window.setScene(new Scene(root, 800, 600));
    }
}
