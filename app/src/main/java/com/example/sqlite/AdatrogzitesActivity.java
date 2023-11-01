package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdatrogzitesActivity extends AppCompatActivity {

    private EditText editTextRogzitesVezeteknev;
    private EditText editTextRogzitesKeresztnev;
    private EditText editTextRogzitesJegy;
    private Button buttonRogzitesRogzites;
    private Button buttonRogzitesVissza;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adatrogzites);

        init();

        buttonRogzitesRogzites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextRogzitesVezeteknev.getText().toString().isEmpty() || editTextRogzitesKeresztnev.getText().toString().isEmpty() || editTextRogzitesJegy.getText().toString().isEmpty())
                {
                    Toast.makeText(AdatrogzitesActivity.this, "Mindegyik mezőt ki kell töltenie!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    adatHozzaadas();
                }
            }
        });

        buttonRogzitesVissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdatrogzitesActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void adatHozzaadas()
    {
        String vezeteknev = editTextRogzitesVezeteknev.getText().toString();
        String keresztnev = editTextRogzitesKeresztnev.getText().toString();
        String jegy = editTextRogzitesJegy.getText().toString();
        int jegyInt = Integer.parseInt(jegy);
        if (dbHelper.rogzites(vezeteknev,keresztnev,jegyInt))
        {
            Toast.makeText(this, "Sikeres adatfelvétel", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Sikertelen adatfelvétel", Toast.LENGTH_SHORT).show();
        }
    }

    public void init()
    {
        editTextRogzitesVezeteknev = findViewById(R.id.editTextRogzitesVezeteknev);
        editTextRogzitesKeresztnev = findViewById(R.id.editTextRogzitesKeresztnev);
        editTextRogzitesJegy = findViewById(R.id.editTextRogzitesJegy);
        buttonRogzitesRogzites = findViewById(R.id.buttonRogzitesRogzites);
        buttonRogzitesVissza = findViewById(R.id.buttonRogzitesVissza);
        dbHelper = new DBHelper(AdatrogzitesActivity.this);
    }
}