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
import org.loose.fis.sre.model.ProductName;
import org.loose.fis.sre.services.ProductNameService;

import java.util.Objects;

public class ViewProductsManagerController {

    @FXML
    private TableView<ProductName> productTable;
    @FXML
    private TableColumn<ProductName, String> productNameColumn;
    @FXML
    private TableColumn<ProductName, String> categoryColumn;
    @FXML
    private TableColumn<ProductName, Integer> productPriceColumn;


    public void initialize() {
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        productTable.setItems(categories);

    }

    public void handleAddButtonAction() throws Exception{
        Stage window = (Stage) productTable.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("addProduct.fxml"));
        window.setScene(new Scene(root, 800,600));
    }

    public void handleDeleteNameButtonAction() {
        ObservableList<ProductName> categoriesSelected;
        categoriesSelected = productTable.getSelectionModel().getSelectedItems();
        for(ProductName productName : categoriesSelected) {
            ProductNameService.removeName(productName);
        }
        categoriesSelected.forEach(categories::remove);
    }




    public void handleBackButtonAction() throws Exception{
        Stage window = (Stage) productTable.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("pageManager.fxml")));
        window.setScene(new Scene(root, 800,600));
    }

    private ObservableList<ProductName> categories = FXCollections.observableArrayList(ProductNameService.productNames());

}
