package com.example.android.test1;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;


/**
 * Created by rasmi on 8/24/16.
 */
public class Display extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
    }
    int quantity =new  MainActivity().quantity;
    int price =new MainActivity().price;
    /**
     * This method is called when the order button is clicked.
     */
    public void finalorder(View view) {
        String PriceMessage = "Total number of item = " + quantity + "\r\nTotal price = $" + quantity * price + "\r\n\r\nThank you for shopping today ^__^" + "\r\n\t\nHave a nice Day";
        displayMessage(PriceMessage);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);

    }
}
