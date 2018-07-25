package com.example.android.test1;

import android.support.v7.app.AppCompatActivity;


/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p/>
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.test1.R;

import java.text.NumberFormat;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    public static final String TOTAL_ITEMS = "totalItems";
    public static final String TOTAL_Price="totalprice";
    Button mocha_i, latte_i, crappuccino_i, mocha_d, latte_d, crappuccino_d;
    int lattequantity, mochaquantity, crappuccinoquantity = 0;
    int price = 3;
    int crappuccinoEachPrice,mocaEachPrice,latteEachPrice ;
    double tax = 0.1*((lattequantity + mochaquantity + crappuccinoquantity)*price);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mocha_i= (Button)findViewById(R.id.mocha_increment_id);
        mocha_i.setOnClickListener(new Clik());
        mocha_d= (Button)findViewById(R.id.mocha_decrement_id);
        mocha_d.setOnClickListener(new Clik());
        crappuccino_i= (Button) findViewById(R.id.crappuccino_increment_id);
        crappuccino_i.setOnClickListener(new Clik());
        crappuccino_d= (Button) findViewById(R.id.crappucino_decrement_id);
        crappuccino_d.setOnClickListener(new Clik());
        latte_i=(Button)findViewById(R.id.latteprice_increment_id);
        latte_i.setOnClickListener(new Clik());
        latte_d=(Button)findViewById(R.id.latteprice_decrement_id);
        latte_d.setOnClickListener(new Clik());


    }
    public void submitOrder(View v){
        Intent jumppage= new Intent(MainActivity.this, com.example.android.test1.Display.class);
        jumppage.putExtra(TOTAL_ITEMS, lattequantity + mochaquantity + crappuccinoquantity);
        jumppage.putExtra(TOTAL_Price,(lattequantity+mochaquantity+crappuccinoquantity)*price + tax);
        startActivity(jumppage);
    }

    public void total(View view)
    {
        String PriceMessage = (lattequantity + mochaquantity + crappuccinoquantity) + "\r\nLatte = " + lattequantity + "\r\nCrappuccino = " + crappuccinoquantity + "\r\nMocha = " + mochaquantity + "\r\nTotal price = $" + ((tax) + ((lattequantity + mochaquantity + crappuccinoquantity) * (price))) + "\r\n\r\nThank you for shopping today ^__^" + "\r\n\t\nHave a nice Day";
        displayMessage(PriceMessage);
    }

    public void clear(View view)
    {
        Intent jumppage=new Intent(MainActivity.this,Main2Activity.class);
        startActivity(jumppage);
    }

    /**
     * This method is called when the + is clicked.
     *
     * This method is called when the - is clicked.
     */

    public class Clik implements View.OnClickListener {
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.mocha_increment_id: {
                    mochaquantity ++;
                    mocadisplay(mochaquantity);
                    //mocaEachPrice = price * mochaquantity;
                    //price_display(mocaEachPrice);
                    break;
                }
                case R.id.mocha_decrement_id: {
                    if (mochaquantity>0){
                    mochaquantity --;
                    mocadisplay(mochaquantity);
                    }
                    //mocaEachPrice = price * mochaquantity;
                    //price_display(mocaEachPrice);
                    break;
                }
                case R.id.crappuccino_increment_id:{
                    crappuccinoquantity++;
                    crappucinodisplay(crappuccinoquantity);
                    break;
                }
                case R.id.crappucino_decrement_id:{
                    if(crappuccinoquantity >0){
                    crappuccinoquantity--;
                    crappucinodisplay(crappuccinoquantity);
                    }
                    break;
                }

                case R.id.latteprice_increment_id:{
                    lattequantity++;
                    lattedisplay(lattequantity);
                    break;
                }
                case R.id.latteprice_decrement_id:{
                    if(lattequantity>0){
                    lattequantity--;
                    lattedisplay(lattequantity);
                    }
                    break;
                }

            }
        }
    }
 /*   public void mochaincrement(View view)
    {
        Log.d("Main", getResources().getResourceEntryName(view.getId()));
        mochaquantity = mochaquantity + 1;
        mocadisplay(mochaquantity);
        mocaEachPrice=price*mochaquantity;
        price_display(mocaEachPrice);
    }

    public void mochadecrement(View view)

    {
        if (mochaquantity > 0)
        {
            mochaquantity = mochaquantity - 1;
            mocadisplay(mochaquantity);
            mocaEachPrice=-price;
            price_display(mocaEachPrice);
        }
        else {}
    }

    public void crappucinoincrement(View view)
    {
        crappuccinoquantity = crappuccinoquantity + 1;
        crappucinodisplay(crappuccinoquantity);

        crappuccinoEachPrice=price*crappuccinoquantity;
        price_display(crappuccinoEachPrice);


    }

    public void crappucinodecrement(View view)
    {
        if (crappuccinoquantity > 0)
        {
            crappuccinoquantity = crappuccinoquantity - 1;
            crappucinodisplay(crappuccinoquantity);
            crappuccinoEachPrice=-price;
            price_display(crappuccinoEachPrice);
        }
        else{}
    }

    public void latteincrement(View view)
    {
        lattequantity = lattequantity + 1;
        lattedisplay(lattequantity);
        latteEachPrice=price*lattequantity;
        price_display(latteEachPrice);

    }

    public void lattedecrement(View view)
    {
        if (lattequantity > 0) {
            lattequantity = lattequantity - 1;
            lattedisplay(lattequantity);
            latteEachPrice=-price;
            price_display(latteEachPrice);
        }
        else {}
    }
*/

    /**
     * This method displays the given price on the screen.
     */
    public void mocadisplay(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.Mocaquantity_text_view);
        quantityTextView.setText("" + number);
    }

    public void crappucinodisplay(int number) {
        /*
         * displays the quantity
         */
        TextView quantityTextView = (TextView) findViewById(R.id.crappuccinoquantity_text_view);
        quantityTextView.setText("" + number);
    }


    public void lattedisplay(int number) {

        TextView quantityTextView = (TextView) findViewById(R.id.lattequantity_text_view);
        quantityTextView.setText("" + number);
    }



    /**
     * this method displays the given text on the screen in the end of line .
     */
    public void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);

    }

    /* things to add
     * welcome message  with welcome screen
     * list of inventory  clothing section  or bakery section
     *
     */
}