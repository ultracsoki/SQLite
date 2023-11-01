package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ModositasActivity extends AppCompatActivity {

    private EditText editTextModositasId;
    private EditText editTextModositasVezeteknev;
    private EditText editTextModositasKeresztnev;
    private EditText editTextModositasJegy;
    private Button buttonModositasModositas;
    private Button buttonModositasVissza;
    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modositas);

        init();

        buttonModositasModositas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextModositasId.getText().toString().isEmpty() || editTextModositasVezeteknev.getText().toString().isEmpty() || editTextModositasKeresztnev.getText().toString().isEmpty() || editTextModositasJegy.getText().toString().isEmpty())
                {
                    Toast.makeText(ModositasActivity.this, "Mindegyik mezőt ki kell töltenie!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    dbHelper.modositas(editTextModositasId.getText().toString(),editTextModositasVezeteknev.getText().toString(),editTextModositasKeresztnev.getText().toString(),editTextModositasJegy.getText().toString());
                    Toast.makeText(ModositasActivity.this, "Adat sikeresen módosítva", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonModositasVissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ModositasActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

        public void init()
        {
            editTextModositasId = findViewById(R.id.editTextModositasId);
            editTextModositasVezeteknev = findViewById(R.id.editTextModositasVezeteknev);
            editTextModositasKeresztnev = findViewById(R.id.editTextModositasKeresztnev);
            editTextModositasJegy = findViewById(R.id.editTextModositasJegy);
            buttonModositasModositas = findViewById(R.id.buttonModositasModositas);
            buttonModositasVissza = findViewById(R.id.buttonModositasVissza);
            dbHelper = new DBHelper(ModositasActivity.this);
        }
}