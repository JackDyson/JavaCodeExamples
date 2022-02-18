package Checkout;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javax.swing.*;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;

public class Controller {
    private int counter1 = 0;
    public static float totalPrice = 0;
    public TextField barcodeBox = new TextField("");
    public TextArea receiptBox = new TextArea("");
    public Button total = new Button();
    public Slider quantityBar = new Slider();
    private int stockUpdateType = 0;
    private boolean barcodeValid = true;

    public void initialize(){//sets everything to its initial value, needed for the program to work
        counter1 = 0;
        totalPrice = 0;
        receiptBox.setText("");
        System.out.println(Main.stockList);
    }

    public void stockUpdate(){
        if (barcodeValid) {
            String item = Main.receipt.get(counter1);
            if (stockUpdateType == 1) {//removes 1 stock item
                for (int x = 0; x < Main.item.size(); x++) {//increments for each item in the list
                    if (item.equals(Main.item.get(x))) {//finds the items location in the list
                        if (Main.stockList.get(x) <= 0) {//if the stock of the item is less than or equal to 0
                            JOptionPane.showMessageDialog(null, "This item is out of stock");
                            Main.receipt.remove(counter1);//removed from the list
                            Main.receipt.remove(counter1);
                        } else {
                            Main.stockList.set(x, Main.stockList.get(x) - 1);//1 is removed from the stock list
                            receiptBox.appendText(Main.receipt.get(counter1) + "-- £" + String.format("%.2f", Float.parseFloat(Main.receipt.get(counter1 + 1))) + "\n");//prints out one line on the receipt for the customer to view
                            counter1 = counter1 + 2;//increments the counter by 2 so the next item can be added
                        }
                    }
                }
            }
            if (stockUpdateType == 2) {//for quantity scan
                for (int x = 0; x < Main.item.size(); x++) {
                    if (item.equals(Main.item.get(x))) {//same as above
                        if ((int) ((Main.stockList.get(x) - quantityBar.getValue())) < 0) {
                            JOptionPane.showMessageDialog(null, "This item is out of stock");
                            System.out.println(Main.receipt);
                            Main.receipt.remove(counter1);
                            Main.receipt.remove(counter1);
                        } else {
                            Main.stockList.set(x, Main.stockList.get(x) - (int) quantityBar.getValue());// removes the amount scanned from the stock list
                            receiptBox.appendText(Main.receipt.get(counter1) + "-- £" + String.format("%.2f", Float.parseFloat(Main.receipt.get(counter1 + 1))) + "\n");//prints out a receipt for the customer to view
                            counter1 = counter1 + 2;//increments the counter by 2 so the next item can be added
                        }
                    }
                }
            }
            if (stockUpdateType == 3) {//for a return or removal of an item
                System.out.println(Main.stockList);
                for (int x = 0; x < Main.item.size(); x++) {
                    if (item.equals(Main.item.get(x))) {
                        Main.stockList.set(x, Main.stockList.get(x) + 1);//adds one to the stock list
                    }
                }
                System.out.println(Main.stockList);
            }
            barcodeBox.setText("");//sets the text entry to empty again
            stockUpdateType = 0;//reset the type of stock scan
            barcodeValid = false;
        }

    }
    public void getItem(ActionEvent actionEvent) {//when the enter button is pressed this is run
        String code = "";
        getItem(code);
        stockUpdateType = 1;//for a single item
        stockUpdate();
        //receiptBox.appendText(Main.receipt.get(counter1) + "-- £" + String.format("%.2f",Float.parseFloat(Main.receipt.get(counter1 + 1))) + "\n");//prints out a receipt for the customer to view

    }
    public ArrayList<String> getItem(String code) {
        code = barcodeBox.getText();//obtains the text that is inside the barcode box
        for (int i = 0; i < Main.itemCode.size(); i++) {//compares the user entry to every item code in the list
            if (Main.itemCode.get(i).equals(code)) {
                Main.receipt.add(Main.item.get(i));//gets corresponding name and price for the code entered
                Main.receipt.add(Main.itemPrice.get(i));
                barcodeValid = true;
                return Main.receipt;
            }
        }
        JOptionPane.showMessageDialog(null,"This barcode is invalid");//if the barcode matches none in the list this is output
        barcodeBox.setText("");
        barcodeValid = false;//stops large error message
        return null;
    }

    public void returnItem(ActionEvent actionEvent) {
        String code = "";
        getItem(code);
        Main.receipt.set(counter1+1,String.format("-%.2f",(Float.parseFloat(Main.receipt.get(counter1 + 1))))); //as it is a return, this gets the price of the item being returned and sets it to it's negative equivalent
        receiptBox.appendText(Main.receipt.get(counter1) + "-- £" + String.format("%.2f",Float.parseFloat(Main.receipt.get(counter1+1))) + "\n");//adds the return to the receipt
        stockUpdateType = 3;//for a return / remove
        stockUpdate();
        counter1 = counter1 + 2;
    }

    public void quantity(ActionEvent actionEvent) {
        String code = "";
        double quantity = 0;
        getItem(code);
        quantity = quantityBar.getValue();//obtains the value from the slider
        Main.receipt.set(counter1+1,String.format("%.2f",Float.parseFloat(Main.receipt.get(counter1 + 1))*quantity));//sets the price of the goods to "the price" multiplied by the value from the slider
        stockUpdateType = 2;//for a quantity scan
        stockUpdate();
    }

    public void endScan(ActionEvent actionEvent) throws Exception {
        int counter3 = 1;
        while (counter3 < Main.receipt.size() + 1) {//gets the total of all goods
            totalPrice = totalPrice + Float.parseFloat(Main.receipt.get(counter3));//adds up each individual price
            counter3 = counter3 + 2;//increments to location of next price
        }
        receiptBox.setText("");
        Stage newStage = new Stage(); //loads the payment stage and closes this stage
        Parent root = FXMLLoader.load(getClass().getResource("../Payment/payment.fxml"));
        newStage.setTitle("Payment");
        newStage.setScene(new Scene(root, 571, 319));
        Stage thisStage = (Stage) total.getScene().getWindow();
        newStage.show();
        thisStage.close();
    }

    public void endTransaction(ActionEvent actionEvent) {
        float quantity= 0;
        float actualPrice = 0;
        float individualPrice = 0;
        for (int x =0; x < Main.receipt.size(); x++){//increments by how many items in the receipt the user has
            for (int itemName =0; itemName < Main.item.size(); itemName++){//increments 10 times through item list
                if (Main.receipt.get(x).equals(Main.item.get(itemName))){//compares each item in the receipt to items in the list
                    actualPrice = Float.parseFloat(Main.receipt.get(x+1));//gets the price of the users item on the receipt
                    individualPrice = Float.parseFloat(Main.itemPrice.get(itemName));//gets how much that item should be
                    quantity = actualPrice / individualPrice;//divides the cost of how much the user spent on the item by the cost of an individual item (works out quantity)
                    int quantityAdd = (int) quantity; //converted to an integer
                    Main.stockList.set(itemName,Main.stockList.get(itemName) + quantityAdd);//adds the quantity of the item back onto the receipt
                }
            }
        }
        receiptBox.setText("");
        Main.receipt.clear();//resets receipt list
        counter1 = 0;//resets the counter
        totalPrice = 0;//resets the total price
        JOptionPane.showMessageDialog(null,"Transaction Void");
    }


    //below controls what button enters what number
    public void click0(ActionEvent actionEvent) {
        barcodeBox.appendText("0");
    }
    public void click1(ActionEvent actionEvent) {
        barcodeBox.appendText("1");
    }
    public void click2(ActionEvent actionEvent) {
        barcodeBox.appendText("2");
    }
    public void click3(ActionEvent actionEvent) {
        barcodeBox.appendText("3");
    }
    public void click4(ActionEvent actionEvent) {
        barcodeBox.appendText("4");
    }
    public void click5(ActionEvent actionEvent) {
        barcodeBox.appendText("5");
    }
    public void click6(ActionEvent actionEvent) {
        barcodeBox.appendText("6");
    }
    public void click7(ActionEvent actionEvent) {
        barcodeBox.appendText("7");
    }
    public void click8(ActionEvent actionEvent) {
        barcodeBox.appendText("8");
    }
    public void click9(ActionEvent actionEvent) {
        barcodeBox.appendText("9");
    }
    public void clearBar(ActionEvent actionEvent) {
        barcodeBox.setText("");
    }
}