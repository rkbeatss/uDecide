package com.example.udecidefinal;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class cardInputActivity extends AppCompatActivity {
    private LinearLayout parentLinearLayout;
    private LinearLayout choiceFour, choiceFive, choiceSix;
    EditText editTextOne, editTextTwo, editTextThree, editTextFour, editTextFive, editTextSix;
    Button addButton;
    public static ArrayList<String> editTextValues = new ArrayList<String>();
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_input);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        parentLinearLayout = (LinearLayout) findViewById(R.id.parent_linear_layout);
        choiceFour = (LinearLayout) findViewById(R.id.choiceFour);
        choiceFive = (LinearLayout) findViewById(R.id.choiceFive);
        choiceSix = (LinearLayout) findViewById(R.id.choiceSix);

        editTextOne = (EditText) findViewById(R.id.textOne);
        editTextTwo = (EditText) findViewById(R.id.textTwo);
        editTextThree = (EditText) findViewById(R.id.textThree);
        editTextFour = (EditText) findViewById(R.id.textFour);
        editTextFive = (EditText) findViewById(R.id.textFive);
        editTextSix = (EditText) findViewById(R.id.textSix);

        addButton = (Button)findViewById(R.id.add_field_button);
        addButton.setEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    public void onAddField(View v) {
        counter++;
        if (counter == 1){
            choiceFour.setVisibility(View.VISIBLE);
        } else if (counter == 2){
            choiceFour.setVisibility(View.VISIBLE);
            choiceFive.setVisibility(View.VISIBLE);
        } else if (counter == 3){
            choiceFour.setVisibility(View.VISIBLE);
            choiceFive.setVisibility(View.VISIBLE);
            choiceSix.setVisibility(View.VISIBLE);
        } else {
            Toast.makeText(this, "Maximum of 6 inputs for this game",Toast.LENGTH_LONG).show();
        }
    }
    public void onDelete(View v) {
        counter--;
        if(v.getId()== R.id.buttonFour){
            choiceFour.setVisibility(View.GONE);
        }
        if(v.getId()== R.id.buttonFive){
            choiceFive.setVisibility(View.GONE);
        }
        if(v.getId()== R.id.buttonSix){
            choiceSix.setVisibility(View.GONE);
        }
    }
    public void onNext(View v){
       /* int count = parentLinearLayout.getChildCount();
        for (int i = 0; i<count ; i++){
            final View row = parentLinearLayout.getChildAt(i);
            EditText textVal = (EditText) row.findViewById(R.id.number_edit_text);
            editTextValues.add(textVal.getText().toString());
        }*/
        if(editTextOne.length() == 0 || editTextTwo.length() == 0  || editTextThree.length() == 0 ){
            Toast.makeText(this, "Please enter minimum 3 input choices",Toast.LENGTH_LONG).show();
        } else {
            editTextValues.add(editTextOne.getText().toString());
            editTextValues.add(editTextThree.getText().toString());
            editTextValues.add(editTextTwo.getText().toString());

            Intent cardIntent = new Intent(this, cardActivity.class);
            cardIntent.putExtra("numberCards", counter);
            this.startActivity(cardIntent);

            if (choiceFour.getVisibility() == View.VISIBLE && editTextFour.length() != 0) {
                editTextValues.add(editTextFour.getText().toString());
            }
            if (choiceFive.getVisibility() == View.VISIBLE && editTextFive.length() != 0) {
                editTextValues.add(editTextFive.getText().toString());
            }
            if (choiceSix.getVisibility() == View.VISIBLE && editTextSix.length() != 0) {
                editTextValues.add(editTextSix.getText().toString());
            }

        }
    }
    public void onClear(View view) {
        editTextOne.setText("");
        editTextTwo.setText("");
        editTextThree.setText("");
        if(editTextFour.length() != 0){
            editTextFour.setText("");
        }
        if(editTextFive.length() !=0 ){
            editTextFive.setText("");
        }
        if(editTextSix.length() !=0){
            editTextSix.setText("");
        }
    }
}
