package com.asennikolaev.learninganimals.utils;

public class AddManager {
    public static boolean isTimeForAdd(Integer quizTillNextAdd) {
        return (quizTillNextAdd == 0);
    }
}
