package com.example.udecidefinal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;

public class coinSelect extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coin_select);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void cadClick(View view){

        Intent intent = new Intent(this, coinActivity.class);
        intent.putExtra("Currency", "cad");
        this.startActivity(intent);
    }

    public void euroClick(View view){
        Intent intent = new Intent(this, coinActivity.class);
        intent.putExtra("Currency", "euro");
        this.startActivity(intent);
    }

    public void usdClick(View view){
        Intent intent = new Intent(this, coinActivity.class);
        intent.putExtra("Currency", "usd");
        this.startActivity(intent);
    }
}
