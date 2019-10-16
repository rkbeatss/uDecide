package com.example.udecidefinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class cardActivity extends AppCompatActivity implements Animation.AnimationListener, View.OnClickListener {
    ImageView cardOne, cardTwo, cardThree, cardFour, cardFive, cardSix;
    List <String> cards = new ArrayList<>();

    public static String[] choices = new String[6];

    int size = cardInputActivity.editTextValues.size();
    Button shuffleButton;

    boolean showBackOne = true, showBackTwo = true, showBackThree = true,showBackFour = true, showBackFive = true, showBackSix = true;
    Animation toMiddle, fromMiddle;



    int cardFlag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        cardOne = (ImageView)findViewById(R.id.cardone);
        cardTwo = (ImageView)findViewById(R.id.cardtwo);
        cardThree = (ImageView)findViewById(R.id.cardthree);

        cardFour = (ImageView)findViewById(R.id.cardfour);
        cardFive = (ImageView)findViewById(R.id.cardfive);
        cardSix = (ImageView)findViewById(R.id.cardsix);

        shuffleButton = (Button) findViewById(R.id.shuffle);

        toMiddle = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.to_middle);
        fromMiddle = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.from_middle);

        toMiddle.setAnimationListener(this);
        fromMiddle.setAnimationListener(this);

        cardOne.setOnClickListener(this);
        cardTwo.setOnClickListener(this);
        cardThree.setOnClickListener(this);

        cardFour.setOnClickListener(this);
        cardFive.setOnClickListener(this);
        cardSix.setOnClickListener(this);

        shuffleButton.setOnClickListener(this);

        if (size == 4){
            choices[0] = cardInputActivity.editTextValues.get(0);
            choices[1] = cardInputActivity.editTextValues.get(1);
            choices[2] = cardInputActivity.editTextValues.get(2);
            choices[3] = cardInputActivity.editTextValues.get(3);
            cardInputActivity.editTextValues.remove(3);
            cardInputActivity.editTextValues.remove(2);
            cardInputActivity.editTextValues.remove(1);
            cardInputActivity.editTextValues.remove(0);
        }
        if (size == 5){
            choices[0] = cardInputActivity.editTextValues.get(0);
            choices[1] = cardInputActivity.editTextValues.get(1);
            choices[2] = cardInputActivity.editTextValues.get(2);
            choices[3] = cardInputActivity.editTextValues.get(3);
            choices[4] = cardInputActivity.editTextValues.get(4);

            cardInputActivity.editTextValues.remove(4);
            cardInputActivity.editTextValues.remove(3);
            cardInputActivity.editTextValues.remove(2);
            cardInputActivity.editTextValues.remove(1);
            cardInputActivity.editTextValues.remove(0);
        }

      if (size == 6){
          choices[0] = cardInputActivity.editTextValues.get(0);
          choices[1] = cardInputActivity.editTextValues.get(1);
          choices[2] = cardInputActivity.editTextValues.get(2);
          choices[3] = cardInputActivity.editTextValues.get(3);
          choices[4] = cardInputActivity.editTextValues.get(4);
          choices[5] = cardInputActivity.editTextValues.get(5);

          cardInputActivity.editTextValues.remove(5);
          cardInputActivity.editTextValues.remove(4);
          cardInputActivity.editTextValues.remove(3);
          cardInputActivity.editTextValues.remove(2);
          cardInputActivity.editTextValues.remove(1);
          cardInputActivity.editTextValues.remove(0);

      }
        setUp();

        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("numberCards", 0);

        if (intValue == 1){
            cardFour.setVisibility(View.VISIBLE);
        } else if (intValue == 2){
            cardFour.setVisibility(View.VISIBLE);
            cardFive.setVisibility(View.VISIBLE);
        } else if (intValue == 3){
            cardFour.setVisibility(View.VISIBLE);
            cardFive.setVisibility(View.VISIBLE);
            cardSix.setVisibility(View.VISIBLE);
        } else { //when it's 0
            cardFour.setVisibility(View.INVISIBLE);
            cardFive.setVisibility(View.INVISIBLE);
            cardSix.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void setUp() {
        cards.clear();
        cards.add("a");
        cards.add("k");
        cards.add("k");
        cards.add("a");
        cards.add("k");
        cards.add("k");
        Collections.shuffle(cards);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (cardFlag == 0) {
            if (animation == toMiddle) {
                if (showBackOne) {
                    showCard(showBackOne, (ImageView) findViewById(R.id.cardone), cardFlag);
                } else {
                    ((ImageView) findViewById(R.id.cardone)).setImageResource(R.drawable.card_back_black);
                }
                ((ImageView) findViewById(R.id.cardone)).clearAnimation();
                ((ImageView) findViewById(R.id.cardone)).setAnimation(fromMiddle);
                ((ImageView) findViewById(R.id.cardone)).startAnimation(fromMiddle);
            } else {
                showBackOne = !showBackOne;
            }
        } else if (cardFlag == 1) {
            if (animation == toMiddle) {
                if (showBackTwo) {
                    showCard(showBackTwo, (ImageView) findViewById(R.id.cardtwo), cardFlag);
                } else {
                    ((ImageView) findViewById(R.id.cardtwo)).setImageResource(R.drawable.card_back_blue);
                }
                ((ImageView) findViewById(R.id.cardtwo)).clearAnimation();
                ((ImageView) findViewById(R.id.cardtwo)).setAnimation(fromMiddle);
                ((ImageView) findViewById(R.id.cardtwo)).startAnimation(fromMiddle);
            } else {
                showBackTwo = !showBackTwo;
            }

        } else if (cardFlag == 2) {
            if (animation == toMiddle) {
                if (showBackThree) {
                    showCard(showBackThree, (ImageView) findViewById(R.id.cardthree), cardFlag);
                } else {
                    ((ImageView) findViewById(R.id.cardthree)).setImageResource(R.drawable.card_back_red);
                }
                ((ImageView) findViewById(R.id.cardthree)).clearAnimation();
                ((ImageView) findViewById(R.id.cardthree)).setAnimation(fromMiddle);
                ((ImageView) findViewById(R.id.cardthree)).startAnimation(fromMiddle);
            } else {
                showBackThree = !showBackThree;
            }

        } else if (cardFlag == 3) {
            if (animation == toMiddle) {
                if (showBackFour) {
                    showCard(showBackFour, (ImageView) findViewById(R.id.cardfour), cardFlag);
                } else {
                    ((ImageView) findViewById(R.id.cardfour)).setImageResource(R.drawable.card_back_purple);
                }
                ((ImageView) findViewById(R.id.cardfour)).clearAnimation();
                ((ImageView) findViewById(R.id.cardfour)).setAnimation(fromMiddle);
                ((ImageView) findViewById(R.id.cardfour)).startAnimation(fromMiddle);
            } else {
                showBackFour = !showBackFour;
            }
        } else if (cardFlag == 4) {
            if (animation == toMiddle) {
                if (showBackFive) {
                    showCard(showBackFive, (ImageView) findViewById(R.id.cardfive), cardFlag);
                } else {
                    ((ImageView) findViewById(R.id.cardfive)).setImageResource(R.drawable.card_back_green);
                }
                ((ImageView) findViewById(R.id.cardfive)).clearAnimation();
                ((ImageView) findViewById(R.id.cardfive)).setAnimation(fromMiddle);
                ((ImageView) findViewById(R.id.cardfive)).startAnimation(fromMiddle);
            } else {
                showBackFive = !showBackFive;
            }
        }
        else if (cardFlag == 5) {
            if (animation == toMiddle) {
                if (showBackSix) {
                    showCard(showBackSix, (ImageView) findViewById(R.id.cardsix), cardFlag);
                } else {
                    ((ImageView) findViewById(R.id.cardsix)).setImageResource(R.drawable.card_back_orange);
                }
                ((ImageView) findViewById(R.id.cardsix)).clearAnimation();
                ((ImageView) findViewById(R.id.cardsix)).setAnimation(fromMiddle);
                ((ImageView) findViewById(R.id.cardsix)).startAnimation(fromMiddle);
            } else {
                showBackSix = !showBackSix;
            }
        }
    }

    private void showCard(boolean showBackOne, ImageView viewById, int cardFlag) {
        if(showBackOne){
            if (cardFlag == 0){
                if(cards.get(0).equals("a") ){
                    viewById.setImageResource(R.drawable.king_of_hearts2);
                }
                else if(cards.get(0).equals("k") ){
                    viewById.setImageResource(R.drawable.queen_of_diamonds2);
                }
            } else if (cardFlag == 1){
                if(cards.get(1).equals("a") ){
                    viewById.setImageResource(R.drawable.king_of_hearts2);
                }
                else if(cards.get(1).equals("k") ){
                    viewById.setImageResource(R.drawable.queen_of_diamonds2);
                }
            } else if (cardFlag == 2){
                if(cards.get(2).equals("a") ){
                    viewById.setImageResource(R.drawable.king_of_hearts2);
                }
                else if(cards.get(2).equals("k") ){
                    viewById.setImageResource(R.drawable.queen_of_diamonds2);
                }
            }else if (cardFlag == 3){
                if(cards.get(3).equals("a") ){
                    viewById.setImageResource(R.drawable.king_of_hearts2);
                }
                else if(cards.get(3).equals("k") ){
                    viewById.setImageResource(R.drawable.queen_of_diamonds2);
                }
            } else if (cardFlag == 4){
                if(cards.get(4).equals("a") ){
                    viewById.setImageResource(R.drawable.king_of_hearts2);
                }
                else if(cards.get(4).equals("k") ){
                    viewById.setImageResource(R.drawable.queen_of_diamonds2);
                }
            } else if (cardFlag == 5){
                if(cards.get(5).equals("a") ){
                    viewById.setImageResource(R.drawable.king_of_hearts2);
                }
                else if(cards.get(5).equals("k") ){
                    viewById.setImageResource(R.drawable.queen_of_diamonds2);
                }
            }

        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.shuffle) {
            startNewGame();
        } else {

            view.clearAnimation();
            view.setAnimation(toMiddle);
            view.startAnimation(toMiddle);



            Random rand = new Random();
            int n = rand.nextInt(size);
            Toast.makeText(this, choices[n],Toast.LENGTH_LONG).show();




            if (view.getId() == R.id.cardone) {
                cardFlag = 0;
            } else if (view.getId() == R.id.cardtwo) {
                cardFlag = 1;
            } else if (view.getId() == R.id.cardthree) {
                cardFlag = 2;
            } else if (view.getId() == R.id.cardfour){
                cardFlag = 3;
            } else if (view.getId() == R.id.cardfive){
                cardFlag = 4;
            } else if (view.getId() == R.id.cardsix){
                cardFlag = 5;
            }
        }
    }

    private void startNewGame() {
        Collections.shuffle(cards);
        Animation anim_one = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_one);
        Animation anim_two = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_two);

        cardOne.startAnimation(anim_one);
        cardTwo.startAnimation(anim_two);
        cardThree.startAnimation(anim_two);


        cardOne.setImageResource(R.drawable.card_back_black);
        cardTwo.setImageResource(R.drawable.card_back_blue);
        cardThree.setImageResource(R.drawable.card_back_red);

        showBackOne = showBackTwo = showBackThree = true;

        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("numberCards", 0);

        if (intValue == 1){
            cardFour.startAnimation(anim_two);
            cardFour.setImageResource(R.drawable.card_back_purple);
            showBackFour = true;

        } else if (intValue == 2){
            cardFour.startAnimation(anim_two);
            cardFive.startAnimation(anim_two);

            cardFour.setImageResource(R.drawable.card_back_purple);
            cardFive.setImageResource(R.drawable.card_back_green);
            showBackFour = showBackFive = true;

        } else if (intValue == 3){

            cardFour.startAnimation(anim_two);
            cardFive.startAnimation(anim_two);
            cardSix.startAnimation(anim_two);

            cardFour.setImageResource(R.drawable.card_back_purple);
            cardFive.setImageResource(R.drawable.card_back_green);
            cardSix.setImageResource(R.drawable.card_back_orange);
            showBackFour = showBackFive = showBackSix = true;

        }

    }
}
