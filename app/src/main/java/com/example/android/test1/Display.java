package com.example.android.test1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by rasmi on 8/24/16.
 */
public class Display extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        int totalItems = getIntent().getIntExtra(MainActivity.TOTAL_ITEMS, 0);
        TextView view = (TextView) findViewById(R.id.quantity_value);
        view.setText(String.valueOf(totalItems));
        int totalprice=getIntent().getIntExtra(MainActivity.TOTAL_Price,0);


    }
    public void finalorder(View v){

    }

}
