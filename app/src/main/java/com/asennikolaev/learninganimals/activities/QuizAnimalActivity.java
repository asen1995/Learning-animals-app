package com.asennikolaev.learninganimals.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.asennikolaev.learninganimals.R;
import com.asennikolaev.learninganimals.model.QuizGame;
import com.asennikolaev.learninganimals.model.QuizModel;
import com.asennikolaev.learninganimals.utils.ButtonHelperOperations;

import java.util.List;

import static android.content.ContentValues.TAG;

public class QuizAnimalActivity extends AppCompatActivity {

    private ImageView imageViewQuestion;

    private QuizModel currentQuiz;
    private Integer quizNumber;

    private Button buttonAnswer1;
    private Button buttonAnswer2;
    private Button buttonAnswer3;
    private Button buttonAnswer4;


    private Button righArrorNextQuestion;


    private void initQuizScreenComponents() {

        imageViewQuestion = (ImageView) findViewById(R.id.imageView);
        buttonAnswer1 = (Button) findViewById(R.id.buttonAnswer1);
        buttonAnswer2 = (Button) findViewById(R.id.buttonAnswer2);
        buttonAnswer3 = (Button) findViewById(R.id.buttonAnswer3);
        buttonAnswer4 = (Button) findViewById(R.id.buttonAnswer4);

        righArrorNextQuestion = (Button) findViewById(R.id.buttonArrow);

        ButtonHelperOperations.hideButton(righArrorNextQuestion);

        imageViewQuestion.setImageResource(R.drawable.deer);//set image

        initClickActions();

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

        currentQuiz = QuizGame.quizModelList.get(0);

        prepareQuestion(currentQuiz);
        quizNumber = 0;

    }

    private void prepareQuestion(QuizModel currentQuiz) {

        imageViewQuestion.setImageResource(currentQuiz.getDrawableImageId());

        buttonAnswer1.setText(currentQuiz.getAnswer1());
        buttonAnswer2.setText(currentQuiz.getAnswer2());
        buttonAnswer3.setText(currentQuiz.getAnswer3());
        buttonAnswer4.setText(currentQuiz.getAnswer4());

    }

    private void initClickActions() {

        buttonAnswer1.setOnClickListener(buttonsListener);
        buttonAnswer2.setOnClickListener(buttonsListener);
        buttonAnswer3.setOnClickListener(buttonsListener);
        buttonAnswer4.setOnClickListener(buttonsListener);

        righArrorNextQuestion.setOnClickListener(arrowButtonNextQuestionListener);

    }

    private View.OnClickListener buttonsListener = new View.OnClickListener() {
        public void onClick(View v) {
            Button b = (Button) v;
            String buttonText = b.getText().toString();

            if(isCorrectAnswer(buttonText)){
                Toast.makeText(getApplicationContext(), "correct " + buttonText, Toast.LENGTH_SHORT).show();
                b.setBackgroundColor(Color.GREEN);
                quizNumber++;
                showAllButtons();

               

            }else{
                b.setBackgroundColor(Color.RED);
                Toast.makeText(getApplicationContext(), "incorrect " + buttonText, Toast.LENGTH_SHORT).show();
                ButtonHelperOperations.hideButton(b);
            }
        }
    };

    private void showAllButtons() {
        ButtonHelperOperations.showButton(righArrorNextQuestion);
        ButtonHelperOperations.showButton(buttonAnswer1);
        ButtonHelperOperations.showButton(buttonAnswer2);
        ButtonHelperOperations.showButton(buttonAnswer3);
        ButtonHelperOperations.showButton(buttonAnswer4);
    }

    private View.OnClickListener arrowButtonNextQuestionListener = new View.OnClickListener() {
        public void onClick(View v) {

            currentQuiz = QuizGame.quizModelList.get(quizNumber);
            prepareQuestion(currentQuiz);

            buttonAnswer1.setBackgroundColor(Color.LTGRAY);
            buttonAnswer2.setBackgroundColor(Color.LTGRAY);
            buttonAnswer3.setBackgroundColor(Color.LTGRAY);
            buttonAnswer4.setBackgroundColor(Color.LTGRAY);

            ButtonHelperOperations.hideButton(righArrorNextQuestion);

        }
    };

    private boolean isCorrectAnswer(String buttonText) {
       return  buttonText.equalsIgnoreCase(currentQuiz.getCorrectAnswer());
    }



}