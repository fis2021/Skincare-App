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
import org.loose.fis.sre.services.QuestionService;

import java.io.IOException;
import java.util.Objects;


public class FidelityPointsController {
    @FXML
    public Button backButtonF;

    public void handleBackButtonFAction() throws Exception{
        Stage window = (Stage) backButtonF.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("pageCustomer.fxml"));
        window.setScene(new Scene(root, 800,600));
    }
}
