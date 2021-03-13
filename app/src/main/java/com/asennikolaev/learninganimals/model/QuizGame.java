package com.asennikolaev.learninganimals.model;

import android.util.Log;

import com.asennikolaev.learninganimals.R;
import com.asennikolaev.learninganimals.utils.AppConstants;
import com.asennikolaev.learninganimals.utils.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static android.content.ContentValues.TAG;
import static com.asennikolaev.learninganimals.model.ImageResources.imageAnswerMap;

public class QuizGame {

    public static List<QuizModel> quizModelList;

    public static void initializeNewGame() {

        quizModelList = new ArrayList();

        ImageResources.initImages();
        Log.i(TAG, "MyClass.getView() — get item number " + 5);

        List<Integer> listImages = new ArrayList(imageAnswerMap.keySet());

        for (Integer imageId: listImages
             ) {

            String correctAnswer = imageAnswerMap.get(imageId);

            quizModelList.add(initQuizModel(imageId,correctAnswer));

        }




    }

    private static QuizModel initQuizModel(Integer drawableImageId, String correctAnswer) {

        QuizModel quizModel = new QuizModel();
        quizModel.setDrawableImageId(drawableImageId);
        quizModel.setCorrectAnswer(correctAnswer);

        quizModel.generateAnswers();

        final Integer correctAnswerId = Generator.generateCorrectAnswerId(AppConstants.NUMBER_ANSWERS);

        quizModel.positionCorrectAnswer(correctAnswerId);

        return quizModel;
    }
}
