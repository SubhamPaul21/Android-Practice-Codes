package com.example.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int totalPrice = calculatePrice();
        boolean hasWhippedCream = isWhippedCreamChecked();
        boolean hasChocolate = isChocolateChecked();
        String userName = getName();
        String bill = createOrderSummary(totalPrice,hasWhippedCream,hasChocolate, userName);
        //displayMessage(bill);
        composeEmail(bill);
    }

    /**
     * This method displays the given quantity value on the screen.
     * @param number of coffee being ordered by user.
     */
    private void display(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf(number));
    }

    /**
     * This method creates a summary of the order i.e. bill
     *
     * @param addWhippedCream is whether or not the user wants whipped cream in his/her coffee.
     * @param addChocolate is whether or not the user wants chocolate in his/her coffee.
     * @param totalPrice of the order.
     * @return order summary as text.
     */
    private String createOrderSummary(int totalPrice, boolean addWhippedCream, boolean addChocolate, String userName) {
        String message = "Name: " + userName;
        message += "\nAdd whipped cream? " + addWhippedCream;
        message += "\nAdd chocolate? " + addChocolate;
        message += "\nQuantity: " + quantity;
        message += "\nTotal: Rs. " + totalPrice;
        message += "\nThank you!";
        return message;
    }

    /**
     *  This method is used to know if whipped cream checkbox is checked or not
     * @return is whipped cream requested by user or not as boolean
     */
    private boolean isWhippedCreamChecked() {
        CheckBox checkBox = findViewById(R.id.whipped_cream_check_box);
        Log.i("MainActivity.java", String.valueOf(checkBox.isChecked()));
        return checkBox.isChecked();
    }

    /**
     *  This method is used to know if whipped cream checkbox is checked or not
     *  @return is chocolate requested by user or not as boolean
     */
    private boolean isChocolateChecked() {
        CheckBox checkBox = findViewById(R.id.chocolate_checkbox);
        Log.i("MainActivity.java", String.valueOf(checkBox.isChecked()));
        return checkBox.isChecked();
    }

    /**
     *  This method returns the price of order being placed.
     */
    private int calculatePrice() {
        int basePrice = 10;
        if (isWhippedCreamChecked()) {
            basePrice += 1;
        }
        if (isChocolateChecked()) {
            basePrice += 2;
        }
        return basePrice * quantity;
    }

//    /**
//     * This method displays the given string output on the screen
//     */
//    private void displayMessage(String message) {
//        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
//        orderSummaryTextView.setText(message);
//    }

    /**
     * This method increases the number of Coffees by 1
     */
    public void increment(View view) {
        if (quantity == 100) {
            Toast.makeText(this,"Cannot place order more than 100 cup", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        display(quantity);
    }

    /**
     * This method decreases the number of Coffees by 1
     */
    public void decrement(View view) {
        if (quantity == 1) {
            Toast.makeText(this,"Cannot place order less than 1 cup", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        display(quantity);
    }

    /**
     *  This method retrieves the name of the user inserted into the EditText View
     */
    private String getName() {
        EditText userName = findViewById(R.id.user_name_text_input);
        return userName.getText().toString();
    }

    /**
     *  This method retrieves the name of the user inserted into the EditText View
     */
    private String getEmail() {
        EditText userEmailId = findViewById(R.id.user_email_text_input);
        return userEmailId.getText().toString();
    }

    /**
     *  This method sends an Intent activity to the Gmail app to send the order summary to user via mail
     */
    public void composeEmail(String bill_summary) {
        String userName = getName();
        String userEmailId = getEmail();
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + userEmailId)); //only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Order summary of coffee order for " + userName);
        intent.putExtra(Intent.EXTRA_TEXT, bill_summary);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}