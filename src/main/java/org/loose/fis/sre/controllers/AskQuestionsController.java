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

public class AskQuestionsController {


    @FXML
    private TextField idQ;

    @FXML
    private TextField question;


    @FXML
    private Text addQuestion;


    public void handleSendQButtonAction()  {

        try {
            QuestionService.checkQuestionDoesNotAlreadyExist(Integer.parseInt(idQ.getText()));
            QuestionService.addQuestion(Integer.parseInt(idQ.getText()),question.getText());
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("askQuestion.fxml")));
            Stage window = (Stage) addQuestion.getScene().getWindow();
            window.setScene(new Scene(root, 800, 600));

        }catch (Exception e){
            addQuestion.setText(e.getMessage());
        }

    }
    public void handleBackButtonQAction() throws Exception{
        Stage window = (Stage) addQuestion.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("pageCustomer.fxml"));
        window.setScene(new Scene(root, 800,600));
    }
}
