package com.phd.imageapp;

import static android.view.View.INVISIBLE;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import android.widget.ListView;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.MediaController;



import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    VideoView videoView;
    private TextView acceuil;
    private int counterView;
    private String path;
    private Uri uri;






    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Active le SplashScreen moderne --- tentative infructueuse -------------
        //SplashScreen.installSplashScreen(this);
        //setTheme(R.style.Theme_MyApp);
        // ======================== retour en arrière =====================
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counterView=0;
        // ================
        acceuil = findViewById(R.id.txtEntry);
        String myWelcomMessage = "App de test App Center";
        acceuil.setText(myWelcomMessage.toUpperCase());
        // ================

        videoView = findViewById(R.id.teddy_video);
        path = "android.resource://" + getPackageName() + "/" + R.raw.logo_anime;
        uri = Uri.parse(path);
        videoView.setVideoURI(uri);
        //MediaController mediaController = new MediaController(this);
        //mediaController.setAnchorView(videoView);
        //videoView.setMediaController(mediaController);
            Toast.makeText(this, "compteur" + Integer.toString(counterView) , Toast.LENGTH_LONG).show();

        videoView.setClickable(true);
        videoView.setFocusable(true);
        videoView.setFocusableInTouchMode(true);
        Log.d("CLICK", "listener attached");

        videoView.setOnClickListener(v -> {
           videoView.start();
           if(counterView==3 )
            {
            Log.d("counter", Integer.toString(counterView) );
                Toast.makeText(MainActivity.this, "compteur" + Integer.toString(counterView) , Toast.LENGTH_LONG).show();
                videoView.setVisibility(INVISIBLE);   }
                counterView++;
            acceuil.setText(String.valueOf(counterView));
        });


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


