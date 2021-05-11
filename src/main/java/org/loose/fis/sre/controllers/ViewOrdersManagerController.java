package org.loose.fis.sre.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.model.Order;
import org.loose.fis.sre.services.OrderService;

import java.util.Objects;

public class ViewOrdersManagerController {

    @FXML
    private Button backButton;
    @FXML
    private TableView<Order> orderTable;
    @FXML
    private TableColumn<Order, String> orderUser;
    @FXML
    private TableColumn<Order, String> productNameOrder;
    @FXML
    private TableColumn<Order, Integer> orderPrice;
    @FXML
    private TableColumn<Order, String> orderStatus;

    public void initialize() {
        orderUser.setCellValueFactory(new PropertyValueFactory<>("client"));
        productNameOrder.setCellValueFactory(new PropertyValueFactory<>("productName"));
        orderPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        orderStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        orderTable.setItems(orders);

        update();
    }

    ObservableList<Order> orders = FXCollections.observableArrayList(OrderService.orders());

    public void handleConfirmButtonAction() {
        ObservableList<Order> typesSelected;
        typesSelected = orderTable.getSelectionModel().getSelectedItems();
        for(Order order : typesSelected) {
            if(order.getStatus().equals("Waiting")) {
                OrderService.acceptOrder(order);

            }
        }


    }

    public void handleRejectButtonAction() {

        ObservableList<Order> typesSelected;
        typesSelected = orderTable.getSelectionModel().getSelectedItems();
        for(Order order : typesSelected) {
            if(order.getStatus().equals("Waiting")) {
                OrderService.rejectOrder(order);

            }
        }

    }

    public void handleBackButtonAction() throws Exception {
        Stage window = (Stage) backButton.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("pageManager.fxml")));
        window.setScene(new Scene(root, 800, 600));
    }

    private void update(){
        orderStatus.setCellFactory(column -> new TableCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                setText(item);

                TableRow<Order> currentRow = getTableRow();

                if (!isEmpty()) {
                    if (item.equals("Waiting"))
                        currentRow.setStyle("-fx-background-color: blue");
                    else if (item.equals("Confirmed"))
                        currentRow.setStyle("-fx-background-color: #49942b");
                    else
                        currentRow.setStyle("-fx-background-color: green ");
                }
            }
        });
    }
}