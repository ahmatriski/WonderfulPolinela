package com.riski.wonderfulpolinela;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class PanganActivity extends AppCompatActivity {


    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pangan);


        DatabaseHelper mDBHelper = new DatabaseHelper(this);
        if (mDBHelper.openDatabase())
            db = mDBHelper.getReadableDatabase();

        ListView lv_daftar_prodi = findViewById(R.id.list);

        ArrayList<HashMap<String, String>> list = new ArrayList<>();
//        ambil data prodi dari database
        String query_prodi = "SELECT kdprodi,nmprodi FROM PANGAN ORDER BY kdprodi";
        Cursor cursor_prodi = db.rawQuery(query_prodi, null);
        while (cursor_prodi.moveToNext()) {
//            masukkan ke list
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("kdprodi", cursor_prodi.getString(0));
            map.put("nmprodi", cursor_prodi.getString(1));
            list.add(map);
        }
        cursor_prodi.close();

//        adapter untuk listview
        SimpleAdapter adapter = new SimpleAdapter(
                PanganActivity.this,
                list,
                R.layout.list_prodi,
                new String[]{"kdprodi", "nmprodi"},
                new int[]{R.id.kdprodi, R.id.nmprodi});
        lv_daftar_prodi.setAdapter(adapter);

//        jika di klik salah satu prodi tampilkan activity detail prodi
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View container,
                                    int position, long id) {
                if (position == 0) {
                    Intent myIntent = new Intent(container.getContext(), TanamanOrganik.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 1) {
                    Intent myIntent = new Intent(container.getContext(), ProduksiPangan.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 2) {
                    Intent myIntent = new Intent(container.getContext(), Holti.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 3) {
                    Intent myIntent = new Intent(container.getContext(), TekPembenihan.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 4) {
                    Intent myIntent = new Intent(container.getContext(), ProHolti.class);
                    startActivityForResult(myIntent, 0);
                }
            }
        };

        lv_daftar_prodi.setOnItemClickListener(itemClickListener);
    }

    //    biar tombol back di toolbar dan tombol back di device tidak me restart menu sebelumnya/menu activity
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}