package com.asennikolaev.learninganimals.score;

import java.util.ArrayList;
import java.util.List;

public class QuizScore {

    private Integer correctAnswersCount;
    private List<String> correctAnswersList;
    private Integer incorrectAnswersCount;
    private List<String> incorrectAnswersList;


    public QuizScore() {
        this.correctAnswersCount = 0;
        this.correctAnswersList = new ArrayList<>();
        this.incorrectAnswersCount = 0;
        this.incorrectAnswersList = new ArrayList<>();
    }



    public Integer getCorrectAnswersCount() {
        return correctAnswersCount;
    }

    public void setCorrectAnswersCount(Integer correctAnswersCount) {
        this.correctAnswersCount = correctAnswersCount;
    }

    public List<String> getCorrectAnswersList() {
        return correctAnswersList;
    }

    public void setCorrectAnswersList(List<String> correctAnswersList) {
        this.correctAnswersList = correctAnswersList;
    }

    public Integer getIncorrectAnswersCount() {
        return incorrectAnswersCount;
    }

    public void setIncorrectAnswersCount(Integer incorrectAnswersCount) {
        this.incorrectAnswersCount = incorrectAnswersCount;
    }

    public List<String> getIncorrectAnswersList() {
        return incorrectAnswersList;
    }

    public void setIncorrectAnswersList(List<String> incorrectAnswersList) {
        this.incorrectAnswersList = incorrectAnswersList;
    }

    public void correctAnswer() {
        this.correctAnswersCount++;
    }

    public void incorrectAnswer() {
        this.incorrectAnswersCount++;
    }
}
