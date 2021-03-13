package com.asennikolaev.learninganimals.model;

import com.asennikolaev.learninganimals.R;

import java.util.HashMap;
import java.util.Map;

public class ImageResources {

    protected static Map<Integer,String> imageAnswerMap = new HashMap<>();

    public static void initImages() {

        imageAnswerMap.put(R.drawable.bunny, "bunny");
        imageAnswerMap.put(R.drawable.deer, "deer");
        imageAnswerMap.put(R.drawable.fox, "fox");
        imageAnswerMap.put(R.drawable.wolf, "wolf");
        imageAnswerMap.put(R.drawable.camel, "camel");
        imageAnswerMap.put(R.drawable.shark, "shark");
        imageAnswerMap.put(R.drawable.frog, "frog");

    }
}
