package com.asennikolaev.learninganimals.model;

import com.asennikolaev.learninganimals.utils.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.asennikolaev.learninganimals.R;
import static com.asennikolaev.learninganimals.model.ImageResources.imageAnswerMap;

public class QuizModel {

    private Integer drawableImageId;
    private String correctAnswer;

    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;

    public Integer getDrawableImageId() {
        return drawableImageId;
    }

    public void setDrawableImageId(Integer drawableImageId) {
        this.drawableImageId = drawableImageId;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public void generateAnswers() {

        List<Integer> randomNumbersPicked = Generator.generateNumbers(4, imageAnswerMap.keySet(),drawableImageId);

        setAnswer1(imageAnswerMap.get(randomNumbersPicked.get(0)));
        setAnswer2(imageAnswerMap.get(randomNumbersPicked.get(1)));
        setAnswer3(imageAnswerMap.get(randomNumbersPicked.get(2)));
        setAnswer4(imageAnswerMap.get(randomNumbersPicked.get(3)));

    }

    public void positionCorrectAnswer(Integer correctAnswerId) {

        switch (correctAnswerId){
            case 1:
                this.answer1 = correctAnswer;
                break;
            case 2:
                this.answer2 = correctAnswer;
                break;
            case 3:
                this.answer3 = correctAnswer;
                break;
            case 4:
                this.answer4 = correctAnswer;
                break;

            default: break;

        }
    }
}
