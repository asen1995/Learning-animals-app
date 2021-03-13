package com.asennikolaev.learninganimals;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import com.asennikolaev.learninganimals.model.QuizGame;
import com.asennikolaev.learninganimals.model.QuizModel;

import java.util.List;

import static android.content.ContentValues.TAG;

public class QuizAnimalActivity extends AppCompatActivity {

    private ImageView imageViewQuestion;

    private Button buttonAnswer1;
    private Button buttonAnswer2;
    private Button buttonAnswer3;
    private Button buttonAnswer4;

    private void initQuizScreenComponents() {

        imageViewQuestion = (ImageView) findViewById(R.id.imageView);
        buttonAnswer1 = (Button) findViewById(R.id.buttonAnswer1);
        buttonAnswer2 = (Button) findViewById(R.id.buttonAnswer2);
        buttonAnswer3 = (Button) findViewById(R.id.buttonAnswer3);
        buttonAnswer4 = (Button) findViewById(R.id.buttonAnswer4);

        imageViewQuestion.setImageResource(R.drawable.deer);//set image

        System.out.println("initQuizScreenComponents completed");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_quiz_animal);
        initQuizScreenComponents();
        Log.i(TAG, "initQuizScreenComponents finished");
        QuizGame.initializeNewGame();

        Log.i(TAG, "initializeNewGame finished");


        playGame();
    }

    private void playGame() {

        QuizModel quizModel = QuizGame.quizModelList.get(2);

        imageViewQuestion.setImageResource(quizModel.getDrawableImageId());

        buttonAnswer1.setText(quizModel.getAnswer1());
        buttonAnswer2.setText(quizModel.getAnswer2());
        buttonAnswer3.setText(quizModel.getAnswer3());
        buttonAnswer4.setText(quizModel.getAnswer4());


    }


}