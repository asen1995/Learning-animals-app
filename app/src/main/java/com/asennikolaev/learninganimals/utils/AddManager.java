package com.asennikolaev.learninganimals.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.asennikolaev.learninganimals.activities.QuizAnimalActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static android.content.ContentValues.TAG;

public class AddManager {

    private static InterstitialAd availableInterstitialAd;
    public static Integer failedTimes = 0;


    public static void loadAdd(final Context context) {

        AdRequest adRequest = new AdRequest.Builder().build();

        String testingAddId = "ca-app-pub-3940256099942544/1033173712";

        String addMobAddId = "";

        if(failedTimes < 2){
            //try to load

                InterstitialAd.load(context,testingAddId, adRequest, new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {

                        availableInterstitialAd = interstitialAd;


                        Log.i(TAG, "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.i(TAG, loadAdError.getMessage());
                        Log.i(TAG, "onAdFailedToLoad - call loadAdd again");
                        failedTimes++;

                        if(failedTimes == 2){
                            Toast.makeText(context,"add service unavailable",Toast.LENGTH_SHORT).show();
                        }

                    }
                });


        }





    }


    public static boolean isTimeForAdd(Integer quizTillNextAdd) {
        return (quizTillNextAdd == 0);
    }


    public static boolean isAddAvailable() {
       return availableInterstitialAd != null;
    }

    public static void showAdd(QuizAnimalActivity quizAnimalActivity) {
        availableInterstitialAd.show(quizAnimalActivity);
        availableInterstitialAd = null;
    }

    public static void resetFailCounter() {
        failedTimes = 0;
    }
}
