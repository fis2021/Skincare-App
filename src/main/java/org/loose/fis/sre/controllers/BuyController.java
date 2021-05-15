
package org.loose.fis.sre.controllers;

        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.ChoiceBox;
        import javafx.scene.control.TextField;
        import javafx.scene.text.Text;
        import javafx.stage.Stage;

        import org.loose.fis.sre.model.ProductName;
        import org.loose.fis.sre.model.User;
        import org.loose.fis.sre.services.OrderService;
        import org.loose.fis.sre.services.ProductNameService;


        import java.util.ArrayList;

public class BuyController {
    @FXML
    private ChoiceBox<String> name;

    @FXML
    private Text orderButton;

    @FXML
    public void initialize() {
        ArrayList<String> names = new ArrayList<>();
        for (ProductName productName : ProductNameService.getAllProductNames())
            names.add(productName.getName());
        name.getItems().addAll(names);
    }

    public void handleMakeOrderButtonAction() throws Exception {
        if (name.getValue() == null) {
            orderButton.setText("No product has been selected");
            return;
        }


        ProductName productName = ProductNameService.getProductName(name.getValue());

        OrderService.addOrder(User.getCurrentUser(), productName);

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("buy.fxml"));
        Stage window = (Stage) name.getScene().getWindow();
        window.setScene(new Scene(root, 800, 600));
    }

    public void handleCancelButtonAction() throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("pageCustomer.fxml"));
        Stage window = (Stage) name.getScene().getWindow();
        window.setScene(new Scene(root, 800, 600));
    }


}
