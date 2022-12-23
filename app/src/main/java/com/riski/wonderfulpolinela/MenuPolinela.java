package com.riski.wonderfulpolinela;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuPolinela extends AppCompatActivity {
    private CardView image1, image2, image3, image4, image5, image6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_polinela);

        image1   =(CardView) findViewById(R.id.image1);
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ProfilActivity.class);
                startActivity(i);
            }
        });
        image2   =(CardView) findViewById(R.id.image2);
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MenuUtama.class);
                startActivity(i);
            }
        });
        image3   =(CardView) findViewById(R.id.image3);
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),FasilitasActivity.class);
                startActivity(i);
            }
        });
        image4   =(CardView) findViewById(R.id.image4);
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MapsPolinelaActivity.class);
                startActivity(i);
            }
        });
        image5   =(CardView) findViewById(R.id.image5);
        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ContactActivity.class);
                startActivity(i);
            }
        });
        image6   =(CardView) findViewById(R.id.image6);
        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),AboutActivity.class);
                startActivity(i);
            }
        });
    }
}