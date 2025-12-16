package com.phd.imageapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import android.widget.ListView;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageView myImageView;
    private LinearLayout home;
    private LinearLayout signal;

    private ListView listViewDays;
    private String networkValue;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myImageView = findViewById(R.id.teddy);  // L'image est déjà définie dans le XML via android:src


        Button refreshBtn = findViewById(R.id.refresh);
        refreshBtn.setOnClickListener(V -> {

            Intent intent = new Intent(MainActivity.this, Network_display.class);
            startActivity(intent);
        });

        Button catalogBtn = findViewById(R.id.catalog);
        catalogBtn.setOnClickListener(V -> {

            Intent intent = new Intent(MainActivity.this, mobilesView.class);
            startActivity(intent);
        });


        Button btnUrlCheck = findViewById(R.id.btnUrlCheck);
        btnUrlCheck.setOnClickListener(V -> {

            Intent intent = new Intent(MainActivity.this, CheckUrlActivity.class);
            startActivity(intent);
        });


    }

   
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(  "finish application", "onDestroy: ");
    }


}


