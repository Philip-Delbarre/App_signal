package com.phd.imageapp;

import static android.app.ProgressDialog.show;
import static android.widget.Toast.LENGTH_LONG;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class CheckUrlActivity extends AppCompatActivity {

    private TextView resultView, pays;
    private Button btnCheck;

    private Button btnHome;
    private ListView listCountry;

    private ArrayAdapter<String> adapter;
    private ArrayList<String> listCountry_;
    private String uriCatalog ="https://dl.apps.orange.com/application-delivery-tool/expo/v3/public/catalogues/";
    String concatUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_url);

//  ===================== affichage Liste des Pays ===============
        listCountry_ = new ArrayList<>();

        listCountry_.add("🇫🇷 France");
        listCountry_.add("🇪🇸 Espagne");
        listCountry_.add("🇧🇪 Belgique");
        listCountry_.add("🇷🇴 Roumanie");
        listCountry_.add("🇵🇱 Pologne");
        listCountry = findViewById(R.id.listCountry);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                listCountry_
        );
        listCountry.setAdapter(adapter);
        pays = findViewById(R.id.pays);

        listCountry.setOnItemClickListener((parent, view, position, id) -> {
            // Récupère le texte de la ligne cliquée
            String item = (String) parent.getItemAtPosition(position);
            concatUrl = new String ( uriCatalog + item.substring(4, 7).toUpperCase() );
            fetchUrl(concatUrl, item);

            // Affiche un Toast avec ce texte
            Toast.makeText(CheckUrlActivity.this,
                    "Pays sélectionné : " + item,
                    Toast.LENGTH_LONG
            ).show();
        });

// =============== Test du pays PL ===========

        btnHome = findViewById(R.id.btnHome_);
        btnHome.setOnClickListener(v -> finish());
    }

    private String checkUrl(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int responseCode = connection.getResponseCode();

            return "Réponse: " + responseCode +
                    (responseCode == HttpURLConnection.HTTP_OK ? " (200 OK)" : " (Erreur)");

        } catch (Exception e) {
            return "Exception: " + e.getMessage();
        }
    }

    private void fetchUrl (String textMessage, String item)
    {
        new Thread(
                () -> {
                String result = checkUrl(concatUrl);
                if      (! result.equals("Erreur"))
                        { runOnUiThread ( () -> pays.setText(item + "  le test est Ok") );}
                else    { runOnUiThread ( () -> pays.setText(item + "  le test est mauvais") );}

                } ).start();
             }
    }
