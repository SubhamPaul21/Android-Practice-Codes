package com.example.justjava;

import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     *
     *
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice();
        String bill = createOrderSummary(price);
        displayMessage(bill);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText(number);
    }

    /**
     * This method creates a summary of the order i.e. bill
     */
    private String createOrderSummary(int price) {
        String message = "Name: Subham Paul";
        message += "\n Add whipped cream? " + isWhippedCreamChecked();
        message += "\n Quantity: " + quantity;
        message += "\n Total: Rs. " + price;
        message += "\n Thank you.";
        return message;
    }

    /**
     *  This method is used to know if whipped cream checkbox is checked or not
     */
    private boolean isWhippedCreamChecked() {
        CheckBox checkBox = findViewById(R.id.check_whipped_cream_box);
        Log.i("MainActivity.java", String.valueOf(checkBox.isChecked()));
        return checkBox.isChecked();
    }

    /**
     *  This method returns the price of order being placed.
     */
    private int calculatePrice() {
        return quantity * 5;
    }

    /**
     * This method displays the given string output on the screen
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * This method increases the number of Coffees by 1
     */
    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }

    /**
     * This method decreases the number of Coffees by 1
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        display(quantity);
    }

}