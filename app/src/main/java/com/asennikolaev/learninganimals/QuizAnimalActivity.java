package com.asennikolaev.learninganimals;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class QuizAnimalActivity extends AppCompatActivity {

    private ImageView imageViewQuestion;

    private Button buttonAnswer1;
    private Button buttonAnswer2;
    private Button buttonAnswer3;
    private Button buttonAnswer4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_animal);


        initQuizScreenComponents();
    }

    private void initQuizScreenComponents() {

        imageViewQuestion = (ImageView) findViewById(R.id.imageView);
        buttonAnswer1 = (Button) findViewById(R.id.buttonAnswer1);
        buttonAnswer2 = (Button) findViewById(R.id.buttonAnswer2);
        buttonAnswer3 = (Button) findViewById(R.id.buttonAnswer3);
        buttonAnswer4 = (Button) findViewById(R.id.buttonAnswer4);

        imageViewQuestion.setImageResource(R.drawable.bunny);//set image

        System.out.println("initQuizScreenComponents completed");
    }
}