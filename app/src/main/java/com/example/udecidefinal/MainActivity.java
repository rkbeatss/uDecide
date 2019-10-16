package com.example.udecidefinal;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void coinToss(View view){
        Intent coinIntent = new Intent (this, coinSelect.class);
        this.startActivity(coinIntent);
    }
    public void pickCard(View view){
        Intent cardIntent = new Intent(this, cardInputActivity.class);
        this.startActivity(cardIntent);
    }
    public void helpPage(View view){
        Intent helpIntent = new Intent(this, helpPage.class);
        this.startActivity(helpIntent);
    }
}
