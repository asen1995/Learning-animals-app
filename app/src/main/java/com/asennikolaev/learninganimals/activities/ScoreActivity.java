package com.asennikolaev.learninganimals.activities;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.asennikolaev.learninganimals.R;
import com.asennikolaev.learninganimals.score.QuizScore;

public class ScoreActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

       QuizScore quizScore = (QuizScore) getIntent().getSerializableExtra("QuizScore");
        Log.i("TAG","score is " + quizScore);

    }
}
