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
import androidx.core.splashscreen.SplashScreen;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ImageView myImageView;
    private TextView acceuil;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Active le SplashScreen moderne --- tentative infructueuse -------------
        //SplashScreen.installSplashScreen(this);
        //setTheme(R.style.Theme_MyApp);
        // ======================== retour en arrière =====================
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myImageView = findViewById(R.id.teddy);  // L'image est déjà définie dans le XML via android:src
        acceuil = findViewById(R.id.txtEntry);
        String myWelcomMessage = "App de test App Center";
        acceuil.setText(myWelcomMessage.toUpperCase());

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

        Button btnGetUrl = findViewById(R.id.btnGetUrl);
        btnGetUrl.setOnClickListener(V -> {

            Intent intent = new Intent(MainActivity.this, GetJsonContent.class);
            startActivity(intent);
        });


    }

   
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(  "finish application", "onDestroy: ");
    }


}


