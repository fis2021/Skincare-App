package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.AccountException;
import org.loose.fis.sre.exceptions.IncorrectPasswordException;
import org.loose.fis.sre.model.User;

import java.util.Objects;

import static org.loose.fis.sre.services.UserService.getUserRole;
public class DermatologistController {
    @FXML
    public Button Questions;
    @FXML
    private Button logOutButton;

    public void handleQuestionsButtonAction() throws Exception{

    }
    public void handleLogOutButtonAction() throws Exception{
        Stage window = (Stage) logOutButton.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("login.fxml")));
        window.setScene(new Scene(root, 800,600));
    }

}
