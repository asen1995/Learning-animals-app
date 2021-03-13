package com.asennikolaev.learninganimals.sound;

import android.content.Context;
import android.media.MediaPlayer;

import com.asennikolaev.learninganimals.R;

public class SoundManager {

    private MediaPlayer buzzer;

    public SoundManager(Context applicationContext) {
        buzzer = MediaPlayer.create( applicationContext, R.raw.buzzer);
    }

    public void playBuzzerd() {
        buzzer.start();
    }
}
