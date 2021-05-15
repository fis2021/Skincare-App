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
import org.loose.fis.sre.model.Offer;
import org.loose.fis.sre.services.OfferService;
import java.util.List;

public class FAQController {

    @FXML
    private TableView<Offer> offerTable;

    @FXML
    private TableColumn<Offer, String> offerNameColumn;
    @FXML
    private TableColumn<Offer, Integer> pointsColumn;

    @FXML
    private Button addButtonQ;


    public void initialize() {
        offerNameColumn.setCellValueFactory(new PropertyValueFactory<>("nameOffer"));
        pointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));

        offerTable.setItems(offers);
    }

    public void handleBackButtonQAction() throws Exception{
        Stage window = (Stage) offerTable.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("pageManager.fxml"));
        window.setScene(new Scene(root, 800,600));
    }

    private ObservableList<Offer> offers = FXCollections.observableArrayList(OfferService.getAllOffers());
    public List <Offer> getOfferFromTable() {
        return offerTable.getItems();
    }
}

