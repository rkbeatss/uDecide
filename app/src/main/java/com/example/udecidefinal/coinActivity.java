package com.example.udecidefinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class coinActivity extends AppCompatActivity {
    private EditText heads;
    private EditText tails;
    public static ArrayList<String> userInputs = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        heads = findViewById(R.id.headsInput);
        tails = findViewById(R.id.tailsInput);



    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void submitChoice(View view) {

        String h = heads.getText().toString();
        String t = tails.getText().toString();

        if (h.length() != 0 && t.length() != 0) {
            userInputs.add(h);
            userInputs.add(t);
            Bundle extras = getIntent().getExtras();
            Intent intent = new Intent(this, coinFlip.class);
            intent.putExtra("Currency", extras.getString("Currency"));

            this.startActivity(intent);
        } else {
            Toast.makeText(this, "Please enter values for Heads/Tails",Toast.LENGTH_LONG).show();
        }
    }


}



