package org.sa.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.sa.services.ProductNameService;

public class AddProductController {

    @FXML
    private ChoiceBox<String> category;

    @FXML
    private TextField name;

    @FXML
    private TextField price;


    @FXML
    private Text addMessage;
    @FXML
    public void initialize() {
        category.getItems().addAll("Dry Skin", "Oily Skin", "Sensitive Skin");
    }

    public void handleAddButtonAction()  {

        try {
            ProductNameService.checkNameDoesNotAlreadyExist(name.getText());
            ProductNameService.addName(name.getText(), category.getValue(), Integer.parseInt(price.getText()));
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("viewProductsManager.fxml"));
            Stage window = (Stage) addMessage.getScene().getWindow();
            window.setScene(new Scene(root, 800, 600));

        }catch (Exception e){
            addMessage.setText(e.getMessage());
        }

        }
    public void handleBack2ButtonAction() throws Exception{
        Stage window = (Stage) addMessage.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("pageManager.fxml"));
        window.setScene(new Scene(root, 800,600));
    }
}
