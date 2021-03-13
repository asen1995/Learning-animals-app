package com.asennikolaev.learninganimals.utils;

import android.view.View;
import android.widget.Button;

public class ButtonHelperOperations {

    public static void hideButton(Button button) {
        button.setVisibility(View.GONE);
    }

    public static void showButton(Button button) {
        button.setVisibility(View.VISIBLE);
    }

}
