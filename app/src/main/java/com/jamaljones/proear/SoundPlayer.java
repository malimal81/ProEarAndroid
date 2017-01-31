package com.jamaljones.proear;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;

/**
 * Created by jamaljones on 12/9/15.
 */
public class SoundPlayer {
    private Context context;
    SoundPool player;
    int soundID1;
    int soundID2;
    int soundID3;
    public void play3Chord (int note1, int note2, int note3) {

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
            player = new SoundPool.Builder().setMaxStreams(7).build();
        } else {
            player = new SoundPool(7, AudioManager.STREAM_MUSIC,1);
        }
        soundID1 = player.load(context, R.raw.c3piano, 1);
        soundID2 = player.load(context, R.raw.e3piano, 1);
        soundID3 = player.load(context, R.raw.g3piano, 1);
        player.play(soundID1,1,1,1,0,1);
        player.play(soundID2,1,1,1,0,1);
        player.play(soundID3,1,1,1,0,1);


    }
}
