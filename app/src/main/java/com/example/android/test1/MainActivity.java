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

public class MainActivity extends AppCompatActivity {
    public static final String TOTAL_ITEMS ="totalItems";
    public static final String TOTAL_PRICE="totalprice";
    Button mocha_i, latte_i, crappuccino_i, mocha_d, latte_d, crappuccino_d;

    int lattequantity, mochaquantity, crappuccinoquantity = 0;
    int price = 3;
    int crappuccinoEachPrice,mocaEachPrice,latteEachPrice;
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
        jumppage.putExtra(TOTAL_PRICE,(lattequantity+mochaquantity+crappuccinoquantity)*price + tax);
        startActivity(jumppage);
    }

    /**
     * This method is called when the + is clicked.
     *
     * This method is called when the - is clicked.
     */

    public class Clik implements View.OnClickListener {
        public void onClick(View v) {
            int id=v.getId();
            switch (id) {

                case R.id.mocha_increment_id: {
                    mochaquantity ++;
                    display(mochaquantity);
                    display(eachprice(price,mochaquantity));
                    break;
                }
                case R.id.mocha_decrement_id: {
                    if (mochaquantity>0){
                        mochaquantity --;
                        display(mochaquantity);
                        display(eachprice(price,mochaquantity));
                    }
                    break;
                }
                case R.id.crappuccino_increment_id:{
                    crappuccinoquantity++;
                    display(crappuccinoquantity);
                    display(eachprice(price,crappuccinoquantity));
                    break;
                }
                case R.id.crappucino_decrement_id:{
                    if(crappuccinoquantity >0){
                        crappuccinoquantity--;
                        display(crappuccinoquantity);
                        display(eachprice(price,crappuccinoquantity));
                    }
                    break;
                }

                case R.id.latteprice_increment_id:{
                    lattequantity++;
                    display(lattequantity);
                    display(eachprice(price,lattequantity));
                    break;
                }
                case R.id.latteprice_decrement_id:{
                    if(lattequantity>0){
                        lattequantity--;
                        display(lattequantity);
                        display(eachprice(price,lattequantity));
                    }
                    break;
                }

            }
        }
    }


    /**
     * This method displays the given price on the screen.
     */
    public int eachprice(int amount, int quantity){
        return amount*quantity;
    }
    public void display( int number){
        if(number==crappuccinoquantity){
                TextView quantityTextView = (TextView) findViewById(R.id.crappuccinoquantity_text_view);
                quantityTextView.setText("" + crappuccinoquantity);
            }
            else if(number==mochaquantity){
                TextView quantityTextView = (TextView) findViewById(R.id.Mocaquantity_text_view);
                quantityTextView.setText("" + number);
            }
            else if(number==lattequantity){
                TextView quantityTextView = (TextView) findViewById(R.id.lattequantity_text_view);
                quantityTextView.setText("" + number);
            }

    }

}