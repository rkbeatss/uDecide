package com.example.udecidefinal;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;
import android.content.Intent;




public class coinFlip extends AppCompatActivity {
    private static String[] choices = new String[2];

    private ImageView coinImg;
    private ImageView coinImgBackSide;
    private Button flipBtn;
    private Button homeBtn;
    private Bundle extras;
    private TextView choicePop;

    Random rand = new Random();


    private int coinSide;
    private int curSide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coin_flip);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        choices[0] = coinActivity.userInputs.get(0);
        choices[1] = coinActivity.userInputs.get(1);
        coinActivity.userInputs.remove(1);
        coinActivity.userInputs.remove(0);
        coinImg = findViewById(R.id.coinCurrency);
        coinImgBackSide = findViewById(R.id.coinCurrencybackside);
        flipBtn = findViewById(R.id.coinFlipBtn);
        homeBtn = findViewById(R.id.coinHomeBtn);
        choicePop = findViewById(R.id.coinChoice);

        extras = getIntent().getExtras();

        choicePop.setVisibility(View.GONE);

        if(extras.getString("Currency").equals("cad")){
            coinImg.setImageResource(R.drawable.toonie_front);
            coinImgBackSide.setImageResource(R.drawable.toonie_back);
            curSide = R.drawable.toonie_front;
            coinImg = findViewById(R.id.coinCurrency);

        } else if (extras.getString("Currency").equals("euro") ){
            coinImg.setImageResource(R.drawable.euro_front);
            coinImgBackSide.setImageResource(R.drawable.euro_back);
            curSide = R.drawable.euro_front;
            coinImg = findViewById(R.id.coinCurrency);

        } else if (extras.getString("Currency").equals("usd")){
            coinImg.setImageResource(R.drawable.usd_front);
            coinImgBackSide.setImageResource(R.drawable.usd_back);
            curSide = R.drawable.usd_front;
            coinImg = findViewById(R.id.coinCurrency);

        }
        coinSide = rand.nextInt(2);
        flipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choicePop.setVisibility(View.GONE);
                flipCoin();
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(coinFlip.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    /*
    * This code was taken from https://github.com/TeamLS/CoinToss and modified to suit our application
     */

    private long animateCoin(boolean stayTheSame) {

        FlipAnimation animation;

        if (curSide == R.drawable.toonie_front) {
            animation = new FlipAnimation(coinImg, R.drawable.toonie_front, R.drawable.toonie_back, 0, 180, 0, 0, 0, 0);
        } else if (curSide == R.drawable.toonie_back){
            animation = new FlipAnimation(coinImg, R.drawable.toonie_back, R.drawable.toonie_front, 0, 180, 0, 0, 0, 0);
        } else if (curSide == R.drawable.euro_front){
            animation = new FlipAnimation(coinImg, R.drawable.euro_front, R.drawable.euro_back, 0, 180, 0, 0, 0, 0);
        } else if (curSide == R.drawable.euro_back){
            animation = new FlipAnimation(coinImg, R.drawable.euro_back, R.drawable.euro_front, 0, 180, 0, 0, 0, 0);
        } else if (curSide == R.drawable.usd_front){
            animation = new FlipAnimation(coinImg, R.drawable.usd_front, R.drawable.usd_back, 0, 180, 0, 0, 0, 0);
        } else {
            animation = new FlipAnimation(coinImg, R.drawable.usd_back, R.drawable.usd_front, 0, 180, 0, 0, 0, 0);
        }
        if (stayTheSame) {
            animation.setRepeatCount(5); // must be odd (5+1 = 6 flips so the side will stay the same)
        } else {
            animation.setRepeatCount(6); // must be even (6+1 = 7 flips so the side will not stay the same)
        }

        animation.setDuration(110);
        animation.setInterpolator(new LinearInterpolator());

        coinImg.startAnimation(animation);

        flipBtn.setEnabled(false);

        return animation.getDuration() * (animation.getRepeatCount() + 1);
    }

    /*
     * This code was taken from https://github.com/TeamLS/CoinToss and modified to suit our application
     */
    public void flipCoin() {

        coinSide = rand.nextInt(2);

        if (coinSide == 0){
            boolean stayTheSame = (curSide == R.drawable.toonie_back || curSide == R.drawable.euro_back || curSide == R.drawable.usd_back);
            long timeOfAnimation = animateCoin(stayTheSame);

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    flipBtn.setEnabled(true);
                    choicePop.setText(choices[1]);
                    choicePop.setVisibility(View.VISIBLE);
                }
            }, timeOfAnimation + 100);
        } else {
            boolean stayTheSame = (curSide == R.drawable.toonie_front || curSide == R.drawable.euro_front || curSide == R.drawable.usd_front);
            long timeOfAnimation = animateCoin(stayTheSame);

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    flipBtn.setEnabled(true);
                    choicePop.setText(choices[0]);
                    choicePop.setVisibility(View.VISIBLE);
                }
            }, timeOfAnimation + 100);
        }


    }



}
