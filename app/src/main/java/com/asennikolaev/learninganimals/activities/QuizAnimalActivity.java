package com.asennikolaev.learninganimals.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.asennikolaev.learninganimals.R;
import com.asennikolaev.learninganimals.model.QuizGame;
import com.asennikolaev.learninganimals.model.QuizModel;
import com.asennikolaev.learninganimals.score.QuizScore;
import com.asennikolaev.learninganimals.sound.SoundManager;
import com.asennikolaev.learninganimals.utils.ButtonHelperOperations;

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


    private SoundManager soundSystem;
    private QuizScore quizScore;

    private boolean correctAnswer;
    private boolean firstAnswer;

    private Drawable greenCorrectButtonGradient;
    private Drawable redIncorrectButtonGradient;

    private void initQuizScreenComponents() {

        imageViewQuestion = (ImageView) findViewById(R.id.imageView);
        buttonAnswer1 = (Button) findViewById(R.id.buttonAnswer1);
        buttonAnswer2 = (Button) findViewById(R.id.buttonAnswer2);
        buttonAnswer3 = (Button) findViewById(R.id.buttonAnswer3);
        buttonAnswer4 = (Button) findViewById(R.id.buttonAnswer4);

        defaultButtonColor();


        greenCorrectButtonGradient = getResources().getDrawable(R.drawable.gradient_button_correct);
        redIncorrectButtonGradient = getResources().getDrawable(R.drawable.gradient_button_wrong_answer);


        righArrorNextQuestion = (Button) findViewById(R.id.buttonArrow);

        ButtonHelperOperations.hideButton(righArrorNextQuestion);

        imageViewQuestion.setImageResource(R.drawable.deer);//set image

        initClickActions();

        System.out.println("initQuizScreenComponents completed");
    }

    private void defaultButtonColor() {
        buttonAnswer1.setBackgroundColor(Color.LTGRAY);
        buttonAnswer2.setBackgroundColor(Color.LTGRAY);
        buttonAnswer3.setBackgroundColor(Color.LTGRAY);
        buttonAnswer4.setBackgroundColor(Color.LTGRAY);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_quiz_animal);
        initQuizScreenComponents();


        Log.i(TAG, "initQuizScreenComponents finished");

        soundSystem = new SoundManager(getApplicationContext());
        quizScore = new QuizScore();

        QuizGame.initializeNewGame();

        Log.i(TAG, "initializeNewGame finished");


        playGame();
    }

    private void playGame() {

        currentQuiz = QuizGame.quizModelList.get(0);//first question in the list

        firstAnswer = true;
        prepareQuestion(currentQuiz);
        quizNumber = 0;

    }

    private void prepareQuestion(QuizModel currentQuiz) {

        imageViewQuestion.setImageResource(currentQuiz.getDrawableImageId());

        buttonAnswer1.setText(currentQuiz.getAnswer1());
        buttonAnswer2.setText(currentQuiz.getAnswer2());
        buttonAnswer3.setText(currentQuiz.getAnswer3());
        buttonAnswer4.setText(currentQuiz.getAnswer4());

        firstAnswer = true;
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


            if(waitingToMoveToNextQuestion()){
                return;
            }

            Button b = (Button) v;
            String buttonText = b.getText().toString();

            if(isCorrectAnswer(buttonText)){

                soundSystem.playCorrectAnswerSound();
                b.setBackground(greenCorrectButtonGradient);
                quizNumber++;
                showAllButtons();

                if(firstAnswer) {
                    quizScore.correctAnswer();
                    quizScore.getCorrectAnswersList().add(currentQuiz.getCorrectAnswer());
                    firstAnswer = false;
                    currentQuiz.setAnsweredCorrectly(true);
                }


            }else{
                soundSystem.playBuzzerd();
                b.setBackground(redIncorrectButtonGradient);
                ButtonHelperOperations.hideButton(b);

                if(firstAnswer) {
                    quizScore.incorrectAnswer();
                    quizScore.getIncorrectAnswersList().add(currentQuiz.getCorrectAnswer());
                    firstAnswer = false;
                    currentQuiz.setAnsweredCorrectly(false);
                }

            }



        }
    };

    private boolean waitingToMoveToNextQuestion() {
        return righArrorNextQuestion.getVisibility() == View.VISIBLE;
    }

    private void showAllButtons() {
        ButtonHelperOperations.showButton(righArrorNextQuestion);
        ButtonHelperOperations.showButton(buttonAnswer1);
        ButtonHelperOperations.showButton(buttonAnswer2);
        ButtonHelperOperations.showButton(buttonAnswer3);
        ButtonHelperOperations.showButton(buttonAnswer4);
    }

    private View.OnClickListener arrowButtonNextQuestionListener = new View.OnClickListener() {
        public void onClick(View v) {


            if(quizNumber > QuizGame.quizModelList.size() - 1){//end of the game
                goToScoringScreen();

            }else {
                currentQuiz = QuizGame.quizModelList.get(quizNumber);
                prepareQuestion(currentQuiz);

                defaultButtonColor();

                ButtonHelperOperations.hideButton(righArrorNextQuestion);
            }

        }
    };

    private void goToScoringScreen() {
        Intent intent = new Intent(QuizAnimalActivity.this, ScoreActivity.class);
        intent.putExtra("QuizScore", quizScore);

        startActivity(intent);
        finish();
    }

    private boolean isCorrectAnswer(String buttonText) {
       return  buttonText.equalsIgnoreCase(currentQuiz.getCorrectAnswer());
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(QuizAnimalActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_quiz_animal);

            changeOrientation();
        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_quiz_animal_land);
            changeOrientation();
        }
    }

    private void changeOrientation() {


        //backup visibility and colors
        final int visibility1 = buttonAnswer1.getVisibility();
        final Drawable background1 = buttonAnswer1.getBackground();

        final int visibility2 = buttonAnswer2.getVisibility();
        final Drawable background2 = buttonAnswer2.getBackground();

        final int visibility3 = buttonAnswer3.getVisibility();
        final Drawable background3 = buttonAnswer3.getBackground();

        final int visibility4 = buttonAnswer4.getVisibility();
        final Drawable background4 = buttonAnswer4.getBackground();

        boolean firstAnswerBackUp = this.firstAnswer;

        initQuizScreenComponents();


        buttonAnswer1.setVisibility(visibility1);
        buttonAnswer1.setBackground(background1);

        buttonAnswer2.setVisibility(visibility2);
        buttonAnswer2.setBackground(background2);

        buttonAnswer3.setVisibility(visibility3);
        buttonAnswer3.setBackground(background3);

        buttonAnswer4.setVisibility(visibility4);
        buttonAnswer4.setBackground(background4);

        prepareQuestion(currentQuiz);

        this.firstAnswer = firstAnswerBackUp;

    }

}