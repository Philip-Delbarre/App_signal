package com.phd.imageapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class mobilesView extends AppCompatActivity {

    private ListView mobileList;
    private List<ListItems> mobileCatalog;
    private Button btnHome;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_mobiles); // la liste gonflée

        mobileCatalog = new ArrayList<>();
        mobileCatalog.add(new ListItems("Samsung", 130));
        mobileCatalog.add( new ListItems("Oppo", 320));
        mobileCatalog.add( new ListItems("Apple", 790));


        mobileList = findViewById(R.id.listViewMobiles);
        mobileList.setAdapter(new ArrayAdapter(this, mobileCatalog)); // tu passes ta liste d'objet à ta classe ArrayAdpter

        btnHome = (Button) findViewById(R.id.refresh);
        btnHome.setOnClickListener(v -> finish());
        // Termine la vue en cours si click
       // mobileList.getView();
//
    }
}