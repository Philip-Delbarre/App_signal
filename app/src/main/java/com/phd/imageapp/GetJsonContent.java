package com.phd.imageapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.phd.imageapp.sub_class.Alternate_data;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetJsonContent extends AppCompatActivity {
    private String urlString;
    private TextView txtCatalog, txtMobilesPl, txtResult;
    private ImageView galaxy;
    private Button home_, launch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("on_create", "onCreate lancé");
        setContentView(R.layout.activity_catalog_pl);
        urlString = "https://dl.apps.orange.com/application-delivery-tool/expo/v3/public/catalogues/SM-A366B/PL";
        String textCatalog = "Samsung Galaxy A36 -Pologne";
        galaxy = findViewById(R.id.imageGalaxyA36);
        txtMobilesPl  = findViewById(R.id.mobileModelPL);
        txtResult  = findViewById(R.id.retourTestCat);
        txtMobilesPl.setText(textCatalog);

        txtCatalog = findViewById(R.id.catalogName);
        launch = findViewById(R.id.btnThread);

        Button home_ = findViewById(R.id.btn_Home_);
        home_.setOnClickListener(v -> finish());

        Button survey = findViewById(R.id.btn_survey_);
        survey.setOnClickListener(v -> {
        Intent intent = new Intent(GetJsonContent.this, Satisfaction.class);
        startActivity(intent);}
        );


// lance une thread de

        launch.setOnClickListener(V -> {

            new Thread(() -> {
                String json = getWebContent(urlString);

                runOnUiThread(() -> {
                    if (!json.equals("Erreur")) {
                        List<Applications> appList = parseJson(json);

                        // ============ En tête de la liste ======================
                        String afficheApp="-\uD83D\uDE80 List of the apps \uD83D\uDE80-\n";
                        // + app.getPackageName() pour rajouter le nom de package
                        for (Applications app : appList) {
                            txtCatalog.setText(afficheApp += "name: " +app.getVersionLabel() + "\n");
                        }
                        txtResult.setText("Test Catalogue is OK : \uD83D\uDC4D");
                    } else {
                        txtCatalog.setText("List des app : vide - \uD83D\uDC4E\uD83C\uDFFC");
                        txtResult.setText("Test Catalogue is KO - \uD83D\uDC4E\uD83C\uDFFC");
                    }

                });
            }).start();

        });
    }

    private String getWebContent(String urlString) {
        Log.d("retour", "Thread lancé (OkHttp)");

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(urlString)
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {

            if (!response.isSuccessful()) {
                Log.e("retour", "Erreur HTTP: " + response.code());
                return "Erreur HTTP " + response.code();
            }

            // Récupère le corps de la réponse
            String body = response.body().string();
            // Log partiel pour debug
            String partial = body.length() >= 50 ? body.substring(0, 50) : body;
            Log.d("retour", "Réponse partielle: " + partial);

            return body;

        } catch (Exception e) {
            Log.e("retour", "Exception réseau", e);
            return "Erreur";
        }
    }


    private List<Applications> parseJson(String json) {
        Gson gson = new Gson();
        Catalogue app = gson.fromJson(json, Catalogue.class);
        // Affiche le corps de la réponse (JSON)
        List<Applications> appList = app.getApplications() ;
        return appList;
    }
}