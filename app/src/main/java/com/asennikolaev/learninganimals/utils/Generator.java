package com.asennikolaev.learninganimals.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class Generator {

    public static List<Integer> generateNumbers(int numberCountNeeded, Set<Integer> range, Integer correctDrawableImageId) {

        List<Integer> numbersList = new ArrayList<>();

        Random random = new Random();


        List<Integer> keys = new ArrayList(range);


        while(numbersList.size() != numberCountNeeded){

            int rangeNumber = random.nextInt(range.size()); //5

            Integer keyOfImage = keys.get(rangeNumber);

            if(dontContainNumber(numbersList,keyOfImage)){

                if(keyOfImage != correctDrawableImageId) {
                    numbersList.add(keyOfImage);
                }
            }

        }

        return numbersList;

    }

    private static boolean dontContainNumber(List<Integer> numbersList, int randomNumber) {
        return !numbersList.contains(randomNumber);
    }

    public static Integer generateCorrectAnswerId(int range) {
        Integer i = new Random().nextInt(range);
        if(i == 0){
            i = generateCorrectAnswerId(range);
        }
        return i;
    }

}
