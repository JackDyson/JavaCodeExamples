package card;

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
import java.util.ArrayList;

public class CardPayment extends Payment {
    public Label cashDue = new Label();
    private static ArrayList<String> cardCode;
    public TextField cardBar = new TextField();
    public Button cardConfirm = new Button();
    public Button cardCancel = new Button();
    private String userCard = "";

    public void initialize() {
        cardCode = new ArrayList<>();//list of card numbers for proof of concept
        cardCode.add("1234567812345678");
        cardCode.add("0987654309876543");

        cashDue.setText("Cash Due: £"+ String.format("%.2f",totalPrice));
    }

    public void cardConfirm(ActionEvent actionEvent) throws IOException {
        boolean cardCheck = false;
        for (int i = 0; i < cardCode.size(); i++){//checks if the card number entered is in the list of cards
            if (userCard.equals(cardCode.get(i))){//if its in
                cardCheck = true;
                break;
            }
            else {//if its not in
                cardCheck = false;
            }
        }
        if (cardCheck){//if card is in list the payment is received
            JOptionPane.showMessageDialog(null,"Payment Received");
            Stage newStage = new Stage();//sends user to beginning
            Parent root = FXMLLoader.load(getClass().getResource("../Checkout/checkout.fxml"));
            newStage.setTitle("Checkout");
            newStage.setScene(new Scene(root, 571, 319));
            newStage.show();
            Main.receipt.clear();
            Stage thisStage = (Stage) cardConfirm.getScene().getWindow();
            thisStage.close();
        }
        else {//if card isnt in the list
            JOptionPane.showMessageDialog(null,"Card is invalid");
            Stage newStage = new Stage();//sends user back to the payment screen
            Parent root = FXMLLoader.load(getClass().getResource("../Payment/payment.fxml"));
            newStage.setTitle("Payment");
            newStage.setScene(new Scene(root, 571, 319));
            newStage.show();
            Stage thisStage = (Stage) cardConfirm.getScene().getWindow();
            thisStage.close();
        }
    }

    public void cardCancel(ActionEvent actionEvent) throws IOException {//if the cancel button is pressed
        Stage newStage = new Stage();//the user is sent back to the payment page
        Parent root = FXMLLoader.load(getClass().getResource("../Payment/payment.fxml"));
        newStage.setTitle("Payment");
        newStage.setScene(new Scene(root, 571, 319));
        newStage.show();
        Stage thisStage = (Stage) cardCancel.getScene().getWindow();
        thisStage.close();
    }
    public void cardClear(ActionEvent actionEvent) {
        cardBar.setText("");
    }
    public void cardEnter(ActionEvent actionEvent) {
        userCard = cardBar.getText();
    }
    public void card0(ActionEvent actionEvent) {
        cardBar.appendText("0");
    }
    public void card1(ActionEvent actionEvent) {
        cardBar.appendText("1");
    }
    public void card2(ActionEvent actionEvent) {
        cardBar.appendText("2");
    }
    public void card3(ActionEvent actionEvent) {
        cardBar.appendText("3");
    }
    public void card4(ActionEvent actionEvent) {
        cardBar.appendText("4");
    }
    public void card5(ActionEvent actionEvent) {
        cardBar.appendText("5");
    }
    public void card6(ActionEvent actionEvent) {
        cardBar.appendText("6");
    }
    public void card7(ActionEvent actionEvent) {
        cardBar.appendText("7");
    }
    public void card8(ActionEvent actionEvent) {
        cardBar.appendText("8");
    }
    public void card9(ActionEvent actionEvent) {
        cardBar.appendText("9");
    }
}
