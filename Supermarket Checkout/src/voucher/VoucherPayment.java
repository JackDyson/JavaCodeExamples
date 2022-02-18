package voucher;

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

public class VoucherPayment extends Payment {
    private String voucherCode = "";
    private float voucherAmount = 0;
    public TextField voucherAmountBar = new TextField();
    public TextField voucherCodeBar = new TextField();
    private static ArrayList<String> voucherCodeList;
    public Button voucherConfirm = new Button();
    public Button voucherCancel = new Button();
    public Label cashDue = new Label();

    public void initialize(){
        voucherCodeList = new ArrayList<>(); //the voucher codes here are set up just fro proof of concept
        voucherCodeList.add("1234");
        voucherCodeList.add("0987");
        cashDue.setText("Cash Due: £"+ String.format("%.2f",totalPrice));
    }

    public void voucherConfirm(ActionEvent actionEvent) throws IOException {
        for (int i = 0; i < voucherCodeList.size(); i++){//increments through each voucher code
            if (voucherCode.equals(voucherCodeList.get(i))){//if the user entry matches a code in the list then...
                if(voucherAmount >= totalPrice){//if the amount the voucher is worth exceeds the total price of all the goods
                    float change = voucherAmount - totalPrice;//change is calculated
                    JOptionPane.showMessageDialog(null,"Change = £" + String.format("%.2f",change));
                    Stage newStage = new Stage();//the checkout page is loaded
                    Parent root = FXMLLoader.load(getClass().getResource("../Checkout/checkout.fxml"));
                    newStage.setTitle("Payment");
                    newStage.setScene(new Scene(root, 571, 319));
                    newStage.show();
                    Main.receipt.clear();
                    Stage thisStage = (Stage) voucherConfirm.getScene().getWindow();
                    thisStage.close();
                }
                else{
                    totalPrice = totalPrice - voucherAmount;//the total amount remaining is calculated and the user is sent back to the payment page
                    Stage newStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("../Payment/payment.fxml"));
                    newStage.setTitle("Payment");
                    newStage.setScene(new Scene(root, 571, 319));
                    newStage.show();
                    Stage thisStage = (Stage) voucherConfirm.getScene().getWindow();
                    thisStage.close();
                }
            }
        }
    }
    public void voucherCancel(ActionEvent actionEvent) throws IOException {//the user is sent back to the payment page
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Payment/payment.fxml"));
        newStage.setTitle("Payment");
        newStage.setScene(new Scene(root, 571, 319));
        newStage.show();
        Stage thisStage = (Stage) voucherCancel.getScene().getWindow();
        thisStage.close();
    }

//LEFT NUMPAD deals with voucher amount
    public void voucher00(ActionEvent actionEvent) {
        voucherAmountBar.appendText("0");
    }
    public void voucher11(ActionEvent actionEvent) {
        voucherAmountBar.appendText("1");
    }
    public void voucher22(ActionEvent actionEvent) {
        voucherAmountBar.appendText("2");
    }
    public void voucher33(ActionEvent actionEvent) {
        voucherAmountBar.appendText("3");
    }
    public void voucher44(ActionEvent actionEvent) {
        voucherAmountBar.appendText("4");
    }
    public void voucher55(ActionEvent actionEvent) {
        voucherAmountBar.appendText("5");
    }
    public void voucher66(ActionEvent actionEvent) {
        voucherAmountBar.appendText("6");
    }
    public void voucher77(ActionEvent actionEvent) {
        voucherAmountBar.appendText("7");
    }
    public void voucher88(ActionEvent actionEvent) {
        voucherAmountBar.appendText("8");
    }
    public void voucher99(ActionEvent actionEvent) {
        voucherAmountBar.appendText("9");
    }
    public void voucherPoint(ActionEvent actionEvent) {
        voucherAmountBar.appendText(".");
    }
    public void voucherClear1(ActionEvent actionEvent) {
        voucherAmountBar.setText("");
    }
    public void voucherEnter1(ActionEvent actionEvent) {
        voucherAmount = Float.parseFloat(voucherAmountBar.getText());
    }
//LEFT NUMPAD END

//RIGHT NUMPAD deals with voucher code
    public void voucherClear(ActionEvent actionEvent) {
        voucherCodeBar.setText("");
    }
    public void voucherEnter(ActionEvent actionEvent) {
        voucherCode = voucherCodeBar.getText();
    }
    public void voucher0(ActionEvent actionEvent) {
        voucherCodeBar.appendText("0");
    }
    public void voucher1(ActionEvent actionEvent) {
        voucherCodeBar.appendText("1");
    }
    public void voucher2(ActionEvent actionEvent) {
        voucherCodeBar.appendText("2");
    }
    public void voucher3(ActionEvent actionEvent) {
        voucherCodeBar.appendText("3");
    }
    public void voucher4(ActionEvent actionEvent) {
        voucherCodeBar.appendText("4");
    }
    public void voucher5(ActionEvent actionEvent) {
        voucherCodeBar.appendText("5");
    }
    public void voucher6(ActionEvent actionEvent) {
        voucherCodeBar.appendText("6");
    }
    public void voucher7(ActionEvent actionEvent) {
        voucherCodeBar.appendText("7");
    }
    public void voucher8(ActionEvent actionEvent) {
        voucherCodeBar.appendText("8");
    }
    public void voucher9(ActionEvent actionEvent) {
        voucherCodeBar.appendText("9");
    }
//RIGHT NUMPAD END
}
