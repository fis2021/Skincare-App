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
import org.loose.fis.sre.model.Answer;
import org.loose.fis.sre.services.AnswerService;
import org.loose.fis.sre.services.OfferService;
import org.loose.fis.sre.services.QuestionService;

import java.io.IOException;
import java.util.Objects;

public class GiveAnswersController {


    @FXML
    private TextField idQ;

    @FXML
    private TextField answer;

    @FXML
    private Text addAnswer;



    public void handleSendAButtonAction()  {

        try {
            AnswerService.checkAnswerDoesNotAlreadyExist(Integer.parseInt(idQ.getText()));
            AnswerService.addAnswer(Integer.parseInt(idQ.getText()),answer.getText());
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("giveAnswers.fxml")));
            Stage window = (Stage) addAnswer.getScene().getWindow();
            window.setScene(new Scene(root, 800, 600));

        }catch (Exception e){
            addAnswer.setText(e.getMessage());
        }

    }
    public void handleBackButtonAAction() throws Exception{
        Stage window = (Stage) addAnswer.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("pageDermatologist.fxml"));
        window.setScene(new Scene(root, 800,600));
    }
}