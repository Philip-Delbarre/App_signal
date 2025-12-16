package com.phd.imageapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView myImageView;

    private ImageView randomImageNetwork;


    private LinearLayout home = findViewById(R.id.home);
    private LinearLayout signal = findViewById(R.id.signal_view);
    private TextView network;
    private TextView animal;
    private ListView listViewDays;
    private String networkValue;
    private String[] listAnimaux;
    private String[] listReseaux = {"teddy", "teddy_1bar", "teddy_2bars", "teddy_3bars", "teddy_4bars",};

    protected void display_animal() {
        animal = findViewById(R.id.Animal_);
        listAnimaux = new String[]{"Chat", "Renard", "Lapin"};
        StringBuilder builder = new StringBuilder();
        for (String animal : listAnimaux) {
            builder.append(animal).append("\n");
        }
        animal.setText(builder.toString());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onStart(){
        super.onStart();
        myImageView = findViewById(R.id.teddy);  // L'image est déjà définie dans le XML via android:src
        network = findViewById(R.id.Network_);
        networkValue = "85";
        network.setText(networkValue + " dbm");

        // Récupérer le tableau "jour" défini dans strings.xml
       /* listViewDays = findViewById(R.id.listViewDays);
        String[] days = getResources().getStringArray(R.array.jour);

        // Créer un ArrayAdapter pour relier le tableau au ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1, // layout Android par défaut
                days
        );

        // Associer l'adapter au ListView
        listViewDays.setAdapter(adapter);
        */

        // affiche la liste des animaux à la demande
        display_animal();

        Button Button_= findViewById(R.id.refresh);
        Button_.setOnClickListener (V ->     {

            home.setVisibility(V.GONE);
            Log.d("post refresh", "_____________ ");
            signal.setVisibility(V.VISIBLE);
            this.random_display();
        });

    }



    protected void random_display()

   {
        int random_value=(int) (Math.random() * 4);
        int resId = getResources().getIdentifier(
                this.listReseaux[random_value], // nom du drawable
                "drawable",                // type de ressource
                getPackageName()           // ton package
        );

        // Appliquer l'image
       this.randomImageNetwork.setImageResource(resId);
       Button home= findViewById(R.id.btnHome);
       home.setOnClickListener (V ->     {

           signal.setVisibility(V.GONE);
           home.setVisibility(V.VISIBLE);
       });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(  "finish application", "onDestroy: ");
    }
}


