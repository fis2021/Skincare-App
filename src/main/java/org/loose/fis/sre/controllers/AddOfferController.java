package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.NameAlreadyExistsException;
import org.loose.fis.sre.model.ProductName;
import org.loose.fis.sre.services.OfferService;

import java.io.IOException;
import java.util.Objects;

public class AddOfferController {


    @FXML
    private TextField nameOffer;

    @FXML
    private TextField points;


    @FXML
    private Text addOffer;


    public void handleAddButton4Action()  {

        try {
            OfferService.checkOfferDoesNotAlreadyExist(nameOffer.getText());
            OfferService.addOffer(  nameOffer.getText(),Integer.parseInt(points.getText()));
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("makeOffersManager.fxml")));
            Stage window = (Stage) addOffer.getScene().getWindow();
            window.setScene(new Scene(root, 800, 600));

        }catch (Exception e){
            addOffer.setText(e.getMessage());
        }

    }
    public void handleBackButton4Action() throws Exception{
        Stage window = (Stage) addOffer.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("pageManager.fxml"));
        window.setScene(new Scene(root, 800,600));
    }
}