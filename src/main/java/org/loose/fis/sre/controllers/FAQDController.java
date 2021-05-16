package org.loose.fis.sre.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import org.loose.fis.sre.model.Answer;
import org.loose.fis.sre.model.Offer;
import org.loose.fis.sre.model.Question;
import org.loose.fis.sre.services.OfferService;
import org.loose.fis.sre.services.QuestionService;
import org.loose.fis.sre.services.AnswerService;

import java.util.List;

public class FAQDController {
    @FXML
    public Button backButtonQ;
    @FXML
    private TableView<Question> questionTableD;

    @FXML
    private TableColumn<Question, Integer> idQColumn;
    @FXML
    private TableColumn<Question, String> questionsColumn;

    @FXML
    private TableView<Answer> answerTable;

    @FXML
    private TableColumn<Answer, Integer> idAColumn;
    @FXML
    private TableColumn<Answer, String> answerColumn;


    public void initialize() {
        idQColumn.setCellValueFactory(new PropertyValueFactory<>("idQ"));
        questionsColumn.setCellValueFactory(new PropertyValueFactory<>("questions"));

        questionTableD.setItems(questions);

        idAColumn.setCellValueFactory(new PropertyValueFactory<>("idQ"));
        answerColumn.setCellValueFactory(new PropertyValueFactory<>("answers"));

        answerTable.setItems(answers);
    }


    public void handleBackButtonQAction() throws Exception{
        Stage window = (Stage) questionTableD.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("pageDermatologist.fxml"));
        window.setScene(new Scene(root, 800,600));
    }

    private ObservableList<Question> questions = FXCollections.observableArrayList(QuestionService.getAllQuestions());
    public List <Question> getQuestionFromTable() {
        return questionTableD.getItems();
    }

    private ObservableList<Answer> answers = FXCollections.observableArrayList(AnswerService.getAllAnswers());
    public List <Answer> getAnswerFromTable() {
        return answerTable.getItems();
    }
}
