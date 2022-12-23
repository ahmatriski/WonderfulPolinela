package com.riski.wonderfulpolinela;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private int waktu_loading=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent1 = new Intent(MainActivity.this, MenuPolinela.class);
                startActivity(intent1);
                finish();
            }
        },waktu_loading);
    }
}