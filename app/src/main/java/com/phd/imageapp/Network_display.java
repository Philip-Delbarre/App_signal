package com.phd.imageapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Context;
import android.widget.TextView;
import android.net.ConnectivityManager;
import android.net.Network;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Network_display extends AppCompatActivity {

    private ImageView randomImageNetwork;
    private Button btnHome, btnRefresh, btnRefreshConnect;
    private TextView textReseau, textConnect;
    private int compteurIndice;
    private String txtRetour;
    private String[] listReseaux = {  "teddy", "teddy_1bar", "teddy_2bars", "teddy_3bars", "teddy_4bars" };
    // tableau de correspondance des images
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signal_level); // ⚡ crée un layout activity_signal.xml
        //

        randomImageNetwork = findViewById(R.id.teddy_image);

        textReseau = findViewById(R.id.netLevel);
        textReseau.setText("init");
        textConnect = findViewById(R.id.netConnect);
        textConnect.setText(resfreshConnectivity());
    }



    @Override
    protected void onStart() {
        super.onStart();
        randomImageNetwork = findViewById(R.id.teddy_image);
        btnRefresh = findViewById(R.id.btnRefresh);
        btnRefresh.setOnClickListener(v ->
                random_display()
        );

        btnRefreshConnect = findViewById(R.id.btnRefreshConnect);
        btnRefreshConnect.setOnClickListener(v-> {
            textConnect.setText(resfreshConnectivity());
                 }
       );




        btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(v -> finish());

        // Appel direct de la fonction random_display au démarrage


}
    private void random_display() {
        //int random_value = (int) (Math.random() * listReseaux.length);
        if ( compteurIndice == 5 ) // s'il atteind 5 alors reset
            { compteurIndice =0; };

        int resId = getResources().getIdentifier(
                    listReseaux[compteurIndice],
                    "drawable",
                    getPackageName()
        );

        randomImageNetwork.setImageResource(resId);
        textReseau.setText("Niveau réseau : " + compteurIndice + "/4");
        incCompteur();
    }
public void incCompteur(){
        compteurIndice++; }

public String resfreshConnectivity () {

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        Network activeNetwork = cm.getActiveNetwork();

        NetManager statutReseau = new NetManager(cm, textReseau.getText().toString(), activeNetwork);
        txtRetour = statutReseau.statusFeedback(activeNetwork);
        // un petit message vers le user
        Toast.makeText(this, "le statut réseau est rafraichit", Toast.LENGTH_LONG).show();
       return txtRetour;
    }

}

