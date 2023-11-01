package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonAdatOlvasas;
    private Button buttonAdatRogzites;
    private Button buttonAdatModositas;
    private Button buttonAdatTorles;
    private TextView textViewAdatok;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        buttonAdatOlvasas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adatLekerdezes();
            }
        });
        buttonAdatRogzites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AdatrogzitesActivity.class);
                startActivity(intent);
                finish();
            }
        });
        buttonAdatModositas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ModositasActivity.class);
                startActivity(intent);
                finish();
            }
        });
        buttonAdatTorles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TorlesActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void adatLekerdezes()
    {
        Cursor adatok = dbHelper.adatLekerdezes();
        if (adatok.getCount() == 0)
        {
            Toast.makeText(this, "Nincs az adatbázisban bejegyzés", Toast.LENGTH_SHORT).show();
        }
        else
        {
            StringBuffer builder = new StringBuffer();
            while (adatok.moveToNext())
            {
                builder.append("ID:").append(adatok.getInt(0)).append("\n");
                builder.append("Keresztnév:").append(adatok.getString(1)).append("\n");
                builder.append("Vezetéknév:").append(adatok.getString(2)).append("\n");
                builder.append("Jegy:").append(adatok.getInt(3)).append("\n\n");
            }
            textViewAdatok.setText(builder);
        }
    }

    public void init()
    {
        buttonAdatOlvasas = findViewById(R.id.buttonAdatOlvasas);
        buttonAdatRogzites = findViewById(R.id.buttonAdatRogzites);
        buttonAdatModositas = findViewById(R.id.buttonAdatModositas);
        buttonAdatTorles = findViewById(R.id.buttonAdatTorles);
        textViewAdatok = findViewById(R.id.textViewAdatok);
        textViewAdatok.setMovementMethod(new ScrollingMovementMethod());
        dbHelper = new DBHelper(MainActivity.this);
    }
}