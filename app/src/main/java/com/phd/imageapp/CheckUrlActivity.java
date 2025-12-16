package com.phd.imageapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class CheckUrlActivity extends AppCompatActivity {

    private TextView resultView;
    private Button btnCheck;

    private Button btnHome;
    private ListView listCountry;

    private ArrayAdapter<String> adapter;
    private ArrayList<String> listCountry_;
    private String uriCatalog ="https://dl.apps.orange.com/application-delivery-tool/expo/v3/public/catalogues/PL";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_url);

        resultView = findViewById(R.id.resultView);
        btnCheck = findViewById(R.id.btnCheck);


        btnCheck.setOnClickListener(v -> {
            new Thread(() -> {

                String result = checkUrl(uriCatalog);

                runOnUiThread(() -> resultView.setText(result));
            }).start();

            ArrayList<String> listCountry_ = new ArrayList<>();

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
        });

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
}
