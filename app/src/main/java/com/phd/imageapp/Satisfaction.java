package com.phd.imageapp;


import static android.widget.Toast.LENGTH_LONG;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Satisfaction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);


        ImageView left_dog = findViewById(R.id.img_cocker_left);
        ImageView face_dog = findViewById(R.id.img_cocker_face);
        ImageView right_dog = findViewById(R.id.img_cocker_right);

        left_dog.setOnClickListener(v -> Toast.makeText(this,"you're unsatisfied, too bad for me !" , LENGTH_LONG).show());

        face_dog.setOnClickListener(v -> Toast.makeText(this,"you're quite satisfied, that's quite great !" , LENGTH_LONG).show());

        right_dog.setOnClickListener(v ->Toast.makeText(this,"you're very satisfied, I am so delighted !" , LENGTH_LONG).show());

        Button home_ = findViewById(R.id.btn__Home__);
        home_.setOnClickListener(v-> {finish();});




    }
}