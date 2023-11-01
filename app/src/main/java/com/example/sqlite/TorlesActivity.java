package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TorlesActivity extends AppCompatActivity {

    private EditText editTextorlesId;
    private Button buttonTorlesTorles;
    private Button buttonTorlesVissza;
    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torles);

        init();

        buttonTorlesTorles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextorlesId.getText().toString().isEmpty())
                {
                    Toast.makeText(TorlesActivity.this, "A mezőt ki kell töltenie!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    dbHelper.torles(editTextorlesId.getText().toString());
                    Toast.makeText(TorlesActivity.this, "Adat sikeresen törölve", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonTorlesVissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TorlesActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void init()
    {
        editTextorlesId = findViewById(R.id.editTextorlesId);
        buttonTorlesTorles = findViewById(R.id.buttonTorlesTorles);
        buttonTorlesVissza = findViewById(R.id.buttonTorlesVissza);
        dbHelper = new DBHelper(TorlesActivity.this);
    }

}