package Checkout;

import cash.CashPayment;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("checkout.fxml")); //the first stage to be loaded is the checkout stage
        primaryStage.setTitle("Checkout");
        primaryStage.setScene(new Scene(root, 571, 319));
        primaryStage.show();
        StockList(); // the lists used in the program are set up
    }


    public static void main(String[] args) {
        launch(args);
    }
        public static ArrayList<String> item;
        public static ArrayList<String> itemCode;
        public static ArrayList<String> itemPrice;
        public static ArrayList<String> receipt;
        public static ArrayList<Integer> stockList;
    
    public void StockList() {
        item = new ArrayList<>();
        itemCode = new ArrayList<>();
        itemPrice = new ArrayList<>();
        receipt = new ArrayList<>();
        stockList = new ArrayList<>();
        receipt.add("placeholder");
        receipt.clear();
        Controller.totalPrice = 0;
        CashPayment.totalPaid = 0;

        item.add("Chocolate");//adds names of items
        item.add("Crisps");
        item.add("Beer");
        item.add("Wine");
        item.add("Cola");
        item.add("Lemonade");
        item.add("Pizza");
        item.add("Burger");
        item.add("Sweets");
        item.add("Salad");

        itemCode.add("12345678");//adds item barcodes
        itemCode.add("03247978");
        itemCode.add("77568899");
        itemCode.add("11100239");
        itemCode.add("44567022");
        itemCode.add("87436509");
        itemCode.add("10293847");
        itemCode.add("29383474");
        itemCode.add("11223344");
        itemCode.add("00998877");

        itemPrice.add("1.5");//adds the price of each item
        itemPrice.add("0.6");
        itemPrice.add("5.67");
        itemPrice.add("14.7");
        itemPrice.add("1");
        itemPrice.add("0.97");
        itemPrice.add("5.45");
        itemPrice.add("2.5");
        itemPrice.add("1.2");
        itemPrice.add("0.1");

        stockList.add(12);//adds the stock of each item
        stockList.add(30);
        stockList.add(15);
        stockList.add(2);
        stockList.add(55);
        stockList.add(88);
        stockList.add(3);
        stockList.add(4);
        stockList.add(2);
        stockList.add(1);
        System.out.println(Main.stockList);

    }
}
