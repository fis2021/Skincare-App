package org.loose.fis.sre.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import org.loose.fis.sre.model.ProductName;
import org.loose.fis.sre.services.ProductNameService;
import java.util.List;

public class ViewProductsCustomerController {

    @FXML
    private TableView<ProductName> productTable;
    @FXML
    private TableColumn<ProductName, String> productNameColumn;
    @FXML
    private TableColumn<ProductName, String> productCategoryColumn;
    @FXML
    private TableColumn<ProductName, Integer> productPriceColumn;



    public void initialize() {
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        productCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        productTable.setItems(categories);
    }

    public void handleBackButton5Action() throws Exception{
        Stage window = (Stage) productTable.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("pageCustomer.fxml"));
        window.setScene(new Scene(root, 800,600));
    }

    public void handleBuyButtonAction() throws Exception{
        Stage window = (Stage) productTable.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("buy.fxml"));
        window.setScene(new Scene(root, 800,600));
    }

    private ObservableList<ProductName> categories = FXCollections.observableArrayList(ProductNameService.getAllProductNames());
    public List <ProductName> getProductNamesFromTable() {
        return productTable.getItems();
    }

}