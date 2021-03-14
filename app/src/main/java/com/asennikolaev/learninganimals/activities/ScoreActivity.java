package com.asennikolaev.learninganimals.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.asennikolaev.learninganimals.R;
import com.asennikolaev.learninganimals.score.QuizScore;

public class ScoreActivity  extends AppCompatActivity {

    private TextView correctAnswersCountTextView;
    private TextView incorrectAnswersCountTextView;

    private QuizScore quizScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        quizScore = (QuizScore) getIntent().getSerializableExtra("QuizScore");

        Log.i("TAG","score is " + quizScore);

        setContentView(R.layout.activity_score);

        initQuizScreenComponents();


    }

    private void initQuizScreenComponents() {

        correctAnswersCountTextView = (TextView) findViewById(R.id.correctAnswersCountTextView);
        incorrectAnswersCountTextView = (TextView) findViewById(R.id.incorrectAnswersCountTextView);

        correctAnswersCountTextView.setText("Correct answers: " + quizScore.getCorrectAnswersCount());
        incorrectAnswersCountTextView.setText("Incorrect answers: " + quizScore.getIncorrectAnswersCount());

    }
}
