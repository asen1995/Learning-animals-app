package com.asennikolaev.learninganimals.sound;

import android.content.Context;
import android.media.MediaPlayer;

import com.asennikolaev.learninganimals.R;

public class SoundManager {

    private MediaPlayer buzzer;
    private MediaPlayer correctAnswer;

    public SoundManager(Context applicationContext) {
        buzzer = MediaPlayer.create( applicationContext, R.raw.buzzer);
        correctAnswer = MediaPlayer.create( applicationContext, R.raw.correctanswersound);
    }

    public void playBuzzerd() {
        buzzer.start();
    }

    public void playCorrectAnswerSound() {
        correctAnswer.start();
    }
}
