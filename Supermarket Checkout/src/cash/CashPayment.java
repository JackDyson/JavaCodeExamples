package cash;

import Checkout.Main;
import Payment.Payment;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.*;
import java.io.IOException;

public class CashPayment extends Payment {
    public TextField cashBar = new TextField("");
    public Label custCash = new Label();
    public Label cashDue = new Label();
    public static float totalPaid = 0;
    public Button cancel = new Button();
    public Button confirm = new Button();

    public void initialize() {
        cashDue.setText("Cash Due: £"+ String.format("%.2f",totalPrice));
        totalPaid = 0;
    }

    public void confirm(ActionEvent actionEvent) throws IOException {
        if (totalPaid >= totalPrice){//if the total paid by the user exceeds or is equal to total price of all goods then the change is calculated and the user is sent back to the checkout
            float change = totalPaid - totalPrice;
            JOptionPane.showMessageDialog(null,"Change = £" + String.format("%.2f",change));
            Stage newStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../Checkout/checkout.fxml"));
            newStage.setTitle("Payment");
            newStage.setScene(new Scene(root, 571, 319));
            newStage.show();
            Main.receipt.clear();
            Stage thisStage = (Stage) confirm.getScene().getWindow();
            thisStage.close();
        }
        else{// the remaining total is calculated and the user is sent back to the payment page
            totalPrice = totalPrice - totalPaid;
            Stage newStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../Payment/payment.fxml"));
            newStage.setTitle("Payment");
            newStage.setScene(new Scene(root, 571, 319));
            newStage.show();
            Stage thisStage = (Stage) confirm.getScene().getWindow();
            thisStage.close();
        }

    }
    public void cancel(ActionEvent actionEvent) throws IOException { //the user is sent back to the payment page with nothing being "paid" for
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Payment/payment.fxml"));
        newStage.setTitle("Payment");
        newStage.setScene(new Scene(root, 571, 319));
        newStage.show();
        Stage thisStage = (Stage) confirm.getScene().getWindow();
        thisStage.close();
    }
    public void cashClear(ActionEvent actionEvent) {
        cashBar.setText("");
    }
    public void cashEnter(ActionEvent actionEvent) {
        totalPaid = totalPaid + Float.parseFloat(cashBar.getText()); //the value entered is added to the total amount the user has paid
        cashBar.setText("");
        custCash.setText("Cash Entered: £" + String.format("%.2f",totalPaid));
    }

    //controls the numpad
    public void cash0(ActionEvent actionEvent) {
        cashBar.appendText("0");
    }
    public void cash1(ActionEvent actionEvent) {
        cashBar.appendText("1");
    }
    public void cash2(ActionEvent actionEvent) {
        cashBar.appendText("2");
    }
    public void cash3(ActionEvent actionEvent) {
        cashBar.appendText("3");
    }
    public void cash4(ActionEvent actionEvent) {
        cashBar.appendText("4");
    }
    public void cash5(ActionEvent actionEvent) {
        cashBar.appendText("5");
    }
    public void cash6(ActionEvent actionEvent) {
        cashBar.appendText("6");
    }
    public void cash7(ActionEvent actionEvent) {
        cashBar.appendText("7");
    }
    public void cash8(ActionEvent actionEvent) {
        cashBar.appendText("8");
    }
    public void cash9(ActionEvent actionEvent) {
        cashBar.appendText("9");
    }
    public void cashPoint(ActionEvent actionEvent) {
        cashBar.appendText(".");
    }
}
