package Payment;

import Checkout.Controller;
import Checkout.Main;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.fxml.FXMLLoader;

public class Payment extends Controller {
    public TextArea receiptBox2 = new TextArea();
    public Label totalBar = new Label();
    public Button cashButton = new Button();
    public Button cardButton = new Button();
    public Button voucherButton = new Button();

    public void initialize() {
        for (int i = 0; i < Main.receipt.size(); i = i + 2) {//displays the receipt for the user
            receiptBox2.appendText(Main.receipt.get(i) + "-- £" + String.format("%.2f", Float.parseFloat(Main.receipt.get(i + 1))));
            receiptBox2.appendText("\n");
        }
        totalBar.setText("Total : £" + String.format("%.2f", totalPrice));
    }

    public void cashPay(ActionEvent actionEvent) throws IOException { //loads up the cash payment page with a button
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../cash/cashPayment.fxml"));
        newStage.setTitle("Cash");
        newStage.setScene(new Scene(root, 571, 319));
        newStage.show();
        Stage thisStage = (Stage) cashButton.getScene().getWindow();
        thisStage.close();
    }

    public void cardPay(ActionEvent actionEvent) throws IOException{//loads up the card payment page with a button
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../card/cardPayment.fxml"));
        newStage.setTitle("Card");
        newStage.setScene(new Scene(root, 571, 319));
        newStage.show();
        Stage thisStage = (Stage) cardButton.getScene().getWindow();
        thisStage.close();
    }

    public void voucherPay(ActionEvent actionEvent) throws IOException{//loads up the voucher payment page with a button
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../voucher/voucherPayment.fxml"));
        newStage.setTitle("Voucher");
        newStage.setScene(new Scene(root, 571, 319));
        newStage.show();
        Stage thisStage = (Stage) voucherButton.getScene().getWindow();
        thisStage.close();
    }
}



