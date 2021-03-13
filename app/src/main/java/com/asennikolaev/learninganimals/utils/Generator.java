package com.asennikolaev.learninganimals.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {

    public static List<Integer> generateNumbers(int numberCountNeeded, int range) {

        List<Integer> numbersList = new ArrayList<>();

        Random random = new Random(range);

        while(numbersList.size() != numberCountNeeded){

            int randomNumber = random.nextInt();

            if(dontContainNumber(numbersList,randomNumber)){
                numbersList.add(randomNumber);
            }

        }

        return numbersList;

    }

    private static boolean dontContainNumber(List<Integer> numbersList, int randomNumber) {
        return !numbersList.contains(randomNumber);
    }

    public static Integer generateCorrectAnswerId(int range) {
       return new Random(range).nextInt();
    }

}
