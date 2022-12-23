package com.riski.wonderfulpolinela;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;

public class  MenuUtama extends AppCompatActivity {
    private CardView ekbis,kebun,pangan,pertanian,peternakan,pasca;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);

        ekbis   =(CardView) findViewById(R.id.button1);
        ekbis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Ekbis.class);
                startActivity(i);
            }
        });
        kebun   =(CardView) findViewById(R.id.button2);
        kebun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),KebunActivity.class);
                startActivity(i);
            }
        });
        pangan   =(CardView) findViewById(R.id.button3);
        pangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),PanganActivity.class);
                startActivity(i);
            }
        });
        pertanian =(CardView) findViewById(R.id.button4);
        pertanian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),PertanianActivity.class);
                startActivity(i);
            }
        });
        peternakan   =(CardView) findViewById(R.id.button5);
        peternakan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),PeternakanActivity.class);
                startActivity(i);
            }
        });
        pasca   =(CardView) findViewById(R.id.button6);
        pasca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),PascaActivity.class);
                startActivity(i);
            }
        });
    }
}
