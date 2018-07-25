package com.example.android.test1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        int totalItems = getIntent().getIntExtra(MainActivity.TOTAL_ITEMS, 0);
        int totalprice=getIntent().getIntExtra(MainActivity.TOTAL_Price,0);

    }
    public void back(View view)
    {
        Intent jumppage=new Intent(Main2Activity.this,MainActivity.class);
        startActivity(jumppage);
    }

}
