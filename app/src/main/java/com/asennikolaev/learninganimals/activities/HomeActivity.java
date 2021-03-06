package com.asennikolaev.learninganimals.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.asennikolaev.learninganimals.R;
import com.asennikolaev.learninganimals.model.QuizGame;
import com.asennikolaev.learninganimals.utils.AddManager;
import com.asennikolaev.learninganimals.utils.ButtonHelperOperations;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class HomeActivity extends AppCompatActivity {

    private Button newGame;
    private Button closeApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initScreenComponents();


        AddManager.resetFailCounter();
        //Initialize the Mobile Ads SDK
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                Log.i("add", "init complete");
            }
        });

    }

    private void initScreenComponents() {

        newGame = (Button) findViewById(R.id.newGame);
        closeApp = (Button) findViewById(R.id.closeApp);


        initClickActions();

        System.out.println("initScreenComponents completed");

    }

    private void initClickActions() {
        newGame.setOnClickListener(newGameListener);
        closeApp.setOnClickListener(closeAppListener);
    }


    private View.OnClickListener closeAppListener = new View.OnClickListener() {
        public void onClick(View v) {
            finish();
            System.exit(0);
        }
    };


    private View.OnClickListener newGameListener = new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(HomeActivity.this, QuizAnimalActivity.class);
            startActivity(intent);
            finish();
        }
    };




}