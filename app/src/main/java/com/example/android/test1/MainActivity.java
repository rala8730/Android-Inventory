package com.example.android.test1;


/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p/>
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.android.test1.R;

import java.text.NumberFormat;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity=0;
    int price=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String PriceMessage = "Total number of item = " + quantity + "\r\nTotal price = $" + quantity * price + "\r\n\r\nThank you for shopping today ^__^" + "\r\n\t\nHave a nice Day";
        displayMessage(PriceMessage);
        if (view.getId() == R.id.Border) {
            Intent i = new Intent(MainActivity.this, Display.class);
            startActivity(i);
        }

    }

    /**
     * /
     *  this methode starts a new activity- i'm starting the activity in display.java and Displlay.xml
     */
    /**
    public void onButtonClick(View v) {
        if (v.getId() == R.id.Bnext) {
            Intent i = new Intent(MainActivity.this, Display.class);
            startActivity(i);
        }


    }
     **/
    /**
     * This method is called when the + is clicked.
     */
    public void increment(View view) {

        quantity = quantity + 1;
        display(quantity);
    }

    /**
     * This method is called when the - is clicked.
     */
    public void decrement(View view) {
        if (quantity > 0) {
            quantity = quantity - 1;
            display(quantity);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     *
     * this method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);

    }

    /** things to add
     * welcome message  with welcome screen
     * list of inventory  clothing section  or bakery section
     *
     */
}