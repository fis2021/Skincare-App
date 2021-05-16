package org.loose.fis.sre.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.loose.fis.sre.model.Order;
import org.loose.fis.sre.model.User;
import org.loose.fis.sre.services.OrderService;

import java.util.List;

public class ViewOrdersCustomerController {

    @FXML
    private TableView<Order> orderTable;
    @FXML
    private TableColumn<Order, String> productNameOrder;
    @FXML
    private TableColumn<Order, Integer> orderPrice;
    @FXML
    private TableColumn<Order, String> orderStatus;

    public void initialize() {
        productNameOrder.setCellValueFactory(new PropertyValueFactory<>("productName"));
        orderPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        orderStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        orderTable.setItems(orders);

        orderStatus.setCellFactory(column -> new TableCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                setText(item);

                TableRow<Order> currentRow = getTableRow();

                if(!isEmpty()){
                    if(item.equals("Waiting"))
                        currentRow.setStyle("-fx-background-color: #D2B4DE\n");
                    else if(item.equals("On its way!"))
                        currentRow.setStyle("-fx-background-color: #E8DAEF\n");
                    else
                        currentRow.setStyle("-fx-background-color: red");
                }
            }
        });
    }

    ObservableList<Order> orders = FXCollections.observableArrayList(OrderService.orders(User.getCurrentUser()));

    public void handleBackButtonAction() throws Exception{
        Stage window = (Stage) orderTable.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("pageCustomer.fxml"));
        window.setScene(new Scene(root, 800,600));
    }

    public List<Order> getAllOrdersFromTable()
    {
        return orderTable.getItems();
    }


}