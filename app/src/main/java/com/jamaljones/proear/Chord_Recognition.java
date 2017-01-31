package com.jamaljones.proear;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.media.SoundPool.Builder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Random;


public class Chord_Recognition extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    private ProgressBar progressBar;
    private Button playButton;
    private int progress = 0;
    private TextView textView;
    MediaPlayer audio;
    MediaPlayer audio1;
    MediaPlayer audio2;
    MediaPlayer audio3;
    MediaPlayer audio4;
    MediaPlayer audio5;
    MediaPlayer audio6;
    MediaPlayer audio7;
    MediaPlayer audio8;
    private int instrument = 1;
    private String instrumentName = "piano";
    private String lvl;
    private int octave = 3;
    private int chord = 1;
    private int delay = 0;
    private int delay1 = 0;
    private int delay2 = 0;
    private int delay3 = 0;
    private int delay4 = 0;
    private int key = 1;
    private boolean playPressed = false;
    private CountDownTimer timer;
    private CountDownTimer timer1;
    private CountDownTimer timer2;
    private CountDownTimer timer3;
    private CountDownTimer timer4;
    private CountDownTimer timer5;
    private CountDownTimer timer6;
    private CountDownTimer timer7;
    private CountDownTimer timer8;
    private CountDownTimer timer9;
    private int correctNote1 = 0;
    private int correctNote2 = 0;
    private int correctNote3 = 0;
    private int correctNote4 = 0;
    private int correctNote5 = 0;
    private int correctNote6 = 0;
    private int correctNote7 = 0;
    private String note = "c3piano";
    private String note1 = "c3piano";
    private String note2 = "g3piano";
    private String note3 = "c3piano";
    private String note4 = "c3piano";
    private String note5 = "g3piano";
    private String note6 = "c3piano";
    private String note7 = "g3piano";
    private String chordName = "";
    private String chordAnswer = "";
    private String keyName = "";
    private String octaveName = "2";
    private String inversionName = "";
    private String fullChord = "";
    private String answer = "Answer";
    private String currentLevel;
    private boolean levelChanged = true;
    private int level = 0;
    private SoundPool player;
    int soundID1 = 0;
    int soundID2 = 0;
    int soundID3 = 0;
    int soundID4 = 0;
    int soundID5 = 0;
    int soundID6 = 0;
    int soundID7 = 0;
    int soundID8 = 0;
    int soundID9 = 0;
    int soundID10 = 0;
    int soundID11 = 0;
    int soundID12 = 0;
    int soundID13 = 0;
    int soundID14 = 0;
    int soundID15 = 0;
    int soundID16 = 0;
    int soundID17 = 0;
    int soundID18 = 0;
    int soundID19 = 0;
    int soundID20 = 0;
    int soundID21 = 0;
    int soundID22 = 0;
    int soundID23 = 0;
    int soundID24 = 0;
    Context context;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chord__recognition);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle("Chord Recognition");


        spinner = (Spinner) findViewById(R.id.spinner);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        textView = (TextView) findViewById(R.id.progressTextView);
        progressBar.getProgressDrawable().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.chordlevels, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);


        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
            player = new SoundPool.Builder().setMaxStreams(7).build();
        } else {
            player = new SoundPool(7, AudioManager.STREAM_MUSIC,1);
        }

        Runnable r = new Runnable() {
            @Override
            public void run() {
                loadSounds();
//                soundID1 = player.load(context, R.raw.c1piano, 1);
//                soundID2 = player.load(context, R.raw.cs1piano, 1);
//                soundID3 = player.load(context, R.raw.d1piano, 1);
//                soundID4 = player.load(context, R.raw.ds1piano, 1);
//                soundID5 = player.load(context, R.raw.e1piano, 1);
//                soundID6 = player.load(context, R.raw.f1piano, 1);
//                soundID7 = player.load(context, R.raw.fs1piano, 1);
//                soundID8 = player.load(context, R.raw.g1piano, 1);
//                soundID9 = player.load(context, R.raw.gs1piano, 1);
//                soundID10 = player.load(context, R.raw.a1piano, 1);
//                soundID11 = player.load(context, R.raw.as1piano, 1);
//                soundID12 = player.load(context, R.raw.b1piano, 1);
//                soundID13 = player.load(context, R.raw.c2piano, 1);
//                soundID14 = player.load(context, R.raw.cs2piano, 1);
//                soundID15 = player.load(context, R.raw.d2piano, 1);
//                soundID16 = player.load(context, R.raw.ds2piano, 1);
//                soundID17 = player.load(context, R.raw.e2piano, 1);
//                soundID18 = player.load(context, R.raw.f2piano, 1);
//                soundID19 = player.load(context, R.raw.fs2piano, 1);
//                soundID20 = player.load(context, R.raw.g2piano, 1);
//                soundID21 = player.load(context, R.raw.gs2piano, 1);
//                soundID22 = player.load(context, R.raw.a2piano, 1);
//                soundID23 = player.load(context, R.raw.as2piano, 1);
//                soundID24 = player.load(context, R.raw.b2piano, 1);
            }
        };

        Thread myThread = new Thread(r);
        myThread.start();

        setLevel();
        resetColor();
        setMenuButton();
        setPlayButton();
        setMajorButton();
        setMinorButton();
        setDiminishedButton();
        setAugmentedButton();
        setSus2Button();
        setSus4Button();
        setSevenButton();
        setMin7Button();
        setMaj7Button();
        setMaj6Button();
        setMin6Button();
        setSevenSharp5Button();
        setSevenFlat5Button();
        setMaj7Flat3Button();
        setMin7Flat5Button();
        setSevenSus4Button();
        setMin7Sharp5Button();
        setNineButton();
        setMin9Button();
        setMaj9Button();
        setNineSharp5Button();
        setNineFlat5Button();
        setSevenFlat9Button();
        setNinePlusButton();
        setSixAdd9Button();
        setElevenButton();
        setElevenPlusButton();
        setThirteenButton();
        setThirteenFlat9Button();
        setThirteenFlat9Flat5Button();
        progressBar.setProgress(0);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void setInstrument() {

        if (instrument == 1) {
            instrumentName = "piano";

        }
        if (instrument == 2) {
            instrumentName = "guitar";
        }
        if (instrument == 3) {
            instrumentName = "organ";
        }

    }

    public void loadSounds () {

        soundID1 = player.load(this, R.raw.c1piano, 1);
        soundID2 = player.load(this, R.raw.cs1piano, 1);
        soundID3 = player.load(this, R.raw.d1piano, 1);
        soundID4 = player.load(this, R.raw.ds1piano, 1);
        soundID5 = player.load(this, R.raw.e1piano, 1);
        soundID6 = player.load(this, R.raw.f1piano, 1);
        soundID7 = player.load(this, R.raw.fs1piano, 1);
        soundID8 = player.load(this, R.raw.g1piano, 1);
        soundID9 = player.load(this, R.raw.gs1piano, 1);
        soundID10 = player.load(this, R.raw.a1piano, 1);
        soundID11 = player.load(this, R.raw.as1piano, 1);
        soundID12 = player.load(this, R.raw.b1piano, 1);
        soundID13 = player.load(this, R.raw.c2piano, 1);
        soundID14 = player.load(this, R.raw.cs2piano, 1);
        soundID15 = player.load(this, R.raw.d2piano, 1);
        soundID16 = player.load(this, R.raw.ds2piano, 1);
        soundID17 = player.load(this, R.raw.e2piano, 1);
        soundID18 = player.load(this, R.raw.f2piano, 1);
        soundID19 = player.load(this, R.raw.fs2piano, 1);
        soundID20 = player.load(this, R.raw.g2piano, 1);
        soundID21 = player.load(this, R.raw.gs2piano, 1);
        soundID22 = player.load(this, R.raw.a2piano, 1);
        soundID23 = player.load(this, R.raw.as2piano, 1);
        soundID24 = player.load(this, R.raw.b2piano, 1);

    }



    private void setMenuButton() {
        Button menuButton = (Button) findViewById(R.id.menuButton);
        menuButton.setTransformationMethod(null);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Thread.sleep(2000);
                    player.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                player.release();

                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                cancelTimer6();
                cancelTimer7();
                cancelTimer8();
                cancelTimer9();
                stop();

                startActivity(new Intent(Chord_Recognition.this, MainActivity.class));
            }
        });

    }

    private void setPlayButton() {
        Button playButton = (Button) findViewById(R.id.playButton);

        playButton.setTransformationMethod(null);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView answerLabel = (TextView) findViewById(R.id.answerLabel);
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                cancelTimer6();
                cancelTimer7();
                cancelTimer8();
                cancelTimer9();
                stop();
                setLevel();
                resetColor();
                resetChord();
                answerLabel.setVisibility(View.INVISIBLE);
                setKey();
                if (instrument == 2) {
                    octave = 2;
                } else {
                    final Random rand = new Random();
                    octave = rand.nextInt(4) + 1;
                }
                countDown9();

                playPressed = true;
                levelChanged = false;

            }
        });

    }

    private void playThreeNotes(String sound1, String sound2, String sound3) {
        int resID1 = getResources().getIdentifier(sound1, "raw", getPackageName());
        MediaPlayer audio1 = MediaPlayer.create(Chord_Recognition.this, resID1);
        int resID2 = getResources().getIdentifier(sound2, "raw", getPackageName());
        MediaPlayer audio2 = MediaPlayer.create(Chord_Recognition.this, resID2);
        int resID3 = getResources().getIdentifier(sound3, "raw", getPackageName());
        MediaPlayer audio3 = MediaPlayer.create(Chord_Recognition.this, resID3);
        audio1.start();
        audio2.start();
        audio3.start();
        audio1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio1) {
                audio1.release();

            }

        });
        audio2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio2) {
                audio2.release();

            }

        });
        audio3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio3) {
                audio3.release();

            }

        });
    }

    private void playFourNotes(String sound1, String sound2, String sound3, String sound4) {
        int resID1 = getResources().getIdentifier(sound1, "raw", getPackageName());
        MediaPlayer audio1 = MediaPlayer.create(Chord_Recognition.this, resID1);
        int resID2 = getResources().getIdentifier(sound2, "raw", getPackageName());
        MediaPlayer audio2 = MediaPlayer.create(Chord_Recognition.this, resID2);
        int resID3 = getResources().getIdentifier(sound3, "raw", getPackageName());
        MediaPlayer audio3 = MediaPlayer.create(Chord_Recognition.this, resID3);
        int resID4 = getResources().getIdentifier(sound4, "raw", getPackageName());
        MediaPlayer audio4 = MediaPlayer.create(Chord_Recognition.this, resID4);
        audio1.start();
        audio2.start();
        audio3.start();
        audio4.start();
        audio1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio1) {
                audio1.release();

            }

        });
        audio2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio2) {
                audio2.release();

            }

        });
        audio3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio3) {
                audio3.release();

            }

        });
        audio4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio4) {
                audio4.release();

            }

        });
    }

    private void playFiveNotes(String sound1, String sound2, String sound3, String sound4, String sound5) {
        int resID1 = getResources().getIdentifier(sound1, "raw", getPackageName());
        MediaPlayer audio1 = MediaPlayer.create(Chord_Recognition.this, resID1);
        int resID2 = getResources().getIdentifier(sound2, "raw", getPackageName());
        MediaPlayer audio2 = MediaPlayer.create(Chord_Recognition.this, resID2);
        int resID3 = getResources().getIdentifier(sound3, "raw", getPackageName());
        MediaPlayer audio3 = MediaPlayer.create(Chord_Recognition.this, resID3);
        int resID4 = getResources().getIdentifier(sound4, "raw", getPackageName());
        MediaPlayer audio4 = MediaPlayer.create(Chord_Recognition.this, resID4);
        int resID5 = getResources().getIdentifier(sound5, "raw", getPackageName());
        MediaPlayer audio5 = MediaPlayer.create(Chord_Recognition.this, resID5);
        audio1.start();
        audio2.start();
        audio3.start();
        audio4.start();
        audio5.start();
        audio1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio1) {
                audio1.release();

            }

        });
        audio2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio2) {
                audio2.release();

            }

        });
        audio3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio3) {
                audio3.release();

            }

        });
        audio4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio4) {
                audio4.release();

            }

        });
        audio5.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio5) {
                audio5.release();

            }

        });
    }

    private void playSixNotes(String sound1, String sound2, String sound3, String sound4, String sound5, String sound6) {
        int resID1 = getResources().getIdentifier(sound1, "raw", getPackageName());
        MediaPlayer audio1 = MediaPlayer.create(Chord_Recognition.this, resID1);
        int resID2 = getResources().getIdentifier(sound2, "raw", getPackageName());
        MediaPlayer audio2 = MediaPlayer.create(Chord_Recognition.this, resID2);
        int resID3 = getResources().getIdentifier(sound3, "raw", getPackageName());
        MediaPlayer audio3 = MediaPlayer.create(Chord_Recognition.this, resID3);
        int resID4 = getResources().getIdentifier(sound4, "raw", getPackageName());
        MediaPlayer audio4 = MediaPlayer.create(Chord_Recognition.this, resID4);
        int resID5 = getResources().getIdentifier(sound5, "raw", getPackageName());
        MediaPlayer audio5 = MediaPlayer.create(Chord_Recognition.this, resID5);
        int resID6 = getResources().getIdentifier(sound6, "raw", getPackageName());
        MediaPlayer audio6 = MediaPlayer.create(Chord_Recognition.this, resID6);
        audio1.start();
        audio2.start();
        audio3.start();
        audio4.start();
        audio5.start();
        audio6.start();
        audio1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio1) {
                audio1.release();

            }

        });
        audio2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio2) {
                audio2.release();

            }

        });
        audio3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio3) {
                audio3.release();

            }

        });
        audio4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio4) {
                audio4.release();

            }

        });
        audio5.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio5) {
                audio5.release();

            }

        });
        audio6.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio6) {
                audio6.release();

            }

        });
    }

    private void playSevenNotes(String sound1, String sound2, String sound3, String sound4, String sound5, String sound6, String sound7) {
        int resID1 = getResources().getIdentifier(sound1, "raw", getPackageName());
        MediaPlayer audio1 = MediaPlayer.create(Chord_Recognition.this, resID1);
        int resID2 = getResources().getIdentifier(sound2, "raw", getPackageName());
        MediaPlayer audio2 = MediaPlayer.create(Chord_Recognition.this, resID2);
        int resID3 = getResources().getIdentifier(sound3, "raw", getPackageName());
        MediaPlayer audio3 = MediaPlayer.create(Chord_Recognition.this, resID3);
        int resID4 = getResources().getIdentifier(sound4, "raw", getPackageName());
        MediaPlayer audio4 = MediaPlayer.create(Chord_Recognition.this, resID4);
        int resID5 = getResources().getIdentifier(sound5, "raw", getPackageName());
        MediaPlayer audio5 = MediaPlayer.create(Chord_Recognition.this, resID5);
        int resID6 = getResources().getIdentifier(sound6, "raw", getPackageName());
        MediaPlayer audio6 = MediaPlayer.create(Chord_Recognition.this, resID6);
        int resID7 = getResources().getIdentifier(sound7, "raw", getPackageName());
        MediaPlayer audio7 = MediaPlayer.create(Chord_Recognition.this, resID7);
        audio1.start();
        audio2.start();
        audio3.start();
        audio4.start();
        audio5.start();
        audio6.start();
        audio7.start();
        audio1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio1) {
                audio1.release();

            }

        });
        audio2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio2) {
                audio2.release();

            }

        });
        audio3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio3) {
                audio3.release();

            }

        });
        audio4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio4) {
                audio4.release();

            }

        });
        audio5.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio5) {
                audio5.release();

            }

        });
        audio6.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio6) {
                audio6.release();

            }

        });
        audio7.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio7) {
                audio7.release();

            }

        });
    }


    private void play1(String sound) {
        int resID1 = getResources().getIdentifier(sound, "raw", getPackageName());
        MediaPlayer audio1 = MediaPlayer.create(Chord_Recognition.this, resID1);
        audio1.start();
        audio1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio1) {
                audio1.release();

            }


        });
    }


    private void play2(String sound) {
        int resID2 = getResources().getIdentifier(sound, "raw", getPackageName());
        MediaPlayer audio2 = MediaPlayer.create(Chord_Recognition.this, resID2);
        audio2.start();
        audio2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio2) {
                audio2.release();

            }


        });
    }


    private void play3(String sound) {
        int resID3 = getResources().getIdentifier(sound, "raw", getPackageName());
        MediaPlayer audio3 = MediaPlayer.create(Chord_Recognition.this, resID3);
        audio3.start();
        audio3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio3) {
                audio3.release();

            }


        });
    }

    private void play4(String sound) {
        int resID4 = getResources().getIdentifier(sound, "raw", getPackageName());
        MediaPlayer audio4 = MediaPlayer.create(Chord_Recognition.this, resID4);
        audio4.start();
        audio4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio4) {
                audio4.release();

            }


        });
    }


    private void play5(String sound) {
        int resID5 = getResources().getIdentifier(sound, "raw", getPackageName());
        MediaPlayer audio5 = MediaPlayer.create(Chord_Recognition.this, resID5);
        audio5.start();
        audio5.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio5) {
                audio5.release();

            }


        });
    }

    private void play6(String sound) {
        int resID6 = getResources().getIdentifier(sound, "raw", getPackageName());
        MediaPlayer audio6 = MediaPlayer.create(Chord_Recognition.this, resID6);
        audio6.start();
        audio6.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio6) {
                audio6.release();

            }


        });
    }


    private void play7(String sound) {
        int resID7 = getResources().getIdentifier(sound, "raw", getPackageName());
        MediaPlayer audio7 = MediaPlayer.create(Chord_Recognition.this, resID7);
        audio7.start();
        audio7.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio7) {
                audio7.release();

            }


        });
    }


    private void stop() {

        if (audio1 != null && audio1.isPlaying()) {
            audio1.stop();
            audio1.release();
        }
        if (audio2 != null && audio2.isPlaying()) {
            audio2.stop();
            audio2.release();
        }
        if (audio3 != null && audio3.isPlaying()) {
            audio3.stop();
            audio3.release();
        }
        if (audio4 != null && audio4.isPlaying()) {
            audio4.stop();
            audio4.release();
        }
        if (audio5 != null && audio5.isPlaying()) {
            audio5.stop();
            audio5.release();
        }
        if (audio6 != null && audio6.isPlaying()) {
            audio6.stop();
            audio6.release();
        }
        if (audio7 != null && audio7.isPlaying()) {
            audio7.stop();
            audio7.release();
        }

    }

    private void cancelTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }

    }

    private void cancelTimer1() {
        if (timer1 != null) {
            timer1.cancel();
            timer1 = null;
        }

    }

    private void cancelTimer2() {
        if (timer2 != null) {
            timer2.cancel();
            timer2 = null;
        }

    }

    private void cancelTimer3() {
        if (timer3 != null) {
            timer3.cancel();
            timer3 = null;
        }

    }

    private void cancelTimer4() {
        if (timer4 != null) {
            timer4.cancel();
            timer4 = null;
        }

    }

    private void cancelTimer5() {
        if (timer5 != null) {
            timer5.cancel();
            timer5 = null;
        }

    }

    private void cancelTimer6() {
        if (timer6 != null) {
            timer6.cancel();
            timer6 = null;
        }

    }

    private void cancelTimer7() {
        if (timer7 != null) {
            timer7.cancel();
            timer7 = null;
        }

    }

    private void cancelTimer8() {
        if (timer8 != null) {
            timer8.cancel();
            timer8 = null;
        }

    }

    private void cancelTimer9() {
        if (timer9 != null) {
            timer9.cancel();
            timer9 = null;
        }

    }


    private void countDown() {
        timer = new CountDownTimer(5000, 5000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                progress = 0;
                displayAnswer();
                playPressed = false;
                updateProgress();
                playAnswer();
                cancelTimer();

            }
        }.start();
    }

    private void countDown1() {
        timer1 = new CountDownTimer(500, 500) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                play1(note1);
                countDown2();
                cancelTimer1();

            }
        }.start();
    }

    private void countDown2() {
        timer2 = new CountDownTimer(500, 500) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                play2(note2);
                countDown3();
                cancelTimer2();

            }
        }.start();
    }

    private void countDown3() {
        timer3 = new CountDownTimer(500, 500) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                play3(note3);
                if (chord < 7) {
                    countDown8();
                } else {
                    countDown4();
                }
                cancelTimer3();

            }
        }.start();
    }

    private void countDown4() {
        timer4 = new CountDownTimer(500, 500) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                play4(note4);
                if (chord < 18) {
                    countDown8();
                } else {
                    countDown5();
                }
                cancelTimer4();

            }
        }.start();
    }

    private void countDown5() {
        timer5 = new CountDownTimer(500, 500) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                play5(note5);
                if (chord < 26) {
                    countDown8();
                } else {
                    countDown6();
                }
                cancelTimer5();

            }
        }.start();
    }

    private void countDown6() {
        timer6 = new CountDownTimer(500, 500) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                play6(note6);
                if (chord < 28) {
                    countDown8();
                } else {
                    countDown7();
                }
                cancelTimer6();

            }
        }.start();
    }

    private void countDown7() {
        timer7 = new CountDownTimer(500, 500) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                play7(note7);
                countDown8();
                cancelTimer7();

            }
        }.start();
    }

    private void countDown8() {
        timer8 = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                //stop();
                playChord();
                cancelTimer8();

            }
        }.start();
    }

    private void countDown9() {
        timer9 = new CountDownTimer(300, 300) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                player.play(soundID1,1,1,1,0,1);
                player.play(soundID5,1,1,1,0,1);
                player.play(soundID8,1,1,1,0,1);
                player.play(soundID11,1,1,1,0,1);
                player.play(soundID15,1,1,1,0,1);
                player.play(soundID18,1,1,1,0,1);
                player.play(soundID22,1,1,1,0,1);
                cancelTimer9();

            }
        }.start();
    }

    private void playAnswer() {

        countDown1();
    }

    private void playChord() {
        stop();

        if (chord < 7) {
            playThreeNotes(note1, note2, note3);
        }

        if (chord >= 7 && chord < 18) {
            playFourNotes(note1, note2, note3, note4);
        }
        if (chord >= 18 && chord < 26) {
            playFiveNotes(note1, note2, note3, note4, note5);
        }
        if (chord >= 26 && chord < 28) {
            playSixNotes(note1, note2, note3, note4, note5, note6);
        }
        if (chord >= 28) {
            playSevenNotes(note1, note2, note3, note4, note5, note6, note7);
        }

    }


    private void playPrompt() {

        correctNotes();
        setNotes();
        playChord();
        countDown();


    }


    private void setKey() {
        final Random rand = new Random();
        key = rand.nextInt(12) + 1;
    }

    private void resetChord() {
        final Random rand = new Random();
        chord = rand.nextInt(level + 1) + 1;
        final Random rand1 = new Random();
        //instrument = rand1.nextInt(3) + 1;
        setInstrument();
    }


    private void setMajorButton() {
        Button majorButton = (Button) findViewById(R.id.majorButton);
        majorButton.setTransformationMethod(null);
        majorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                cancelTimer6();
                cancelTimer7();
                cancelTimer8();
                cancelTimer9();

                if (playPressed) {

                    if (chord == 1) {
                        displayAnswer();
                        progress++;

                    } else {
                        progress = 0;
                        displayAnswer();
                        playAnswer();
                    }
                }

                playPressed = false;

                if (progress >= 20 && level < 29) {
                    progress = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner) findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();
                }
                updateProgress();

            }
        });

    }


    private void setMinorButton() {
        Button minorButton = (Button) findViewById(R.id.minorButton);
        minorButton.setTransformationMethod(null);
        minorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                cancelTimer6();
                cancelTimer7();
                cancelTimer8();
                cancelTimer9();

                if (chord == 2) {
                    displayAnswer();
                    progress++;

                } else {
                    progress = 0;
                    displayAnswer();
                    playAnswer();

                }


                playPressed = false;

                if (progress >= 20 && level < 29) {
                    progress = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner) findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();
                }
                updateProgress();

            }
        });

    }

    private void setDiminishedButton() {
        Button diminishedButton = (Button) findViewById(R.id.diminishedButton);
        diminishedButton.setTransformationMethod(null);
        diminishedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                cancelTimer6();
                cancelTimer7();
                cancelTimer8();
                cancelTimer9();

                if (chord == 3) {
                    displayAnswer();
                    progress++;

                } else {
                    progress = 0;
                    displayAnswer();
                    playAnswer();

                }


                playPressed = false;

                if (progress >= 20 && level < 29) {
                    progress = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner) findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();
                }
                updateProgress();

            }

        });

    }

    private void setAugmentedButton() {
        Button augmentedButton = (Button) findViewById(R.id.augmentedButton);
        augmentedButton.setTransformationMethod(null);
        augmentedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                cancelTimer6();
                cancelTimer7();
                cancelTimer8();
                cancelTimer9();

                if (chord == 4) {
                    displayAnswer();
                    progress++;

                } else {
                    progress = 0;
                    displayAnswer();
                    playAnswer();
                }


                playPressed = false;
                if (progress >= 20 && level < 29) {
                    progress = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner) findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();
                }
                updateProgress();

            }
        });

    }

    private void setSus2Button() {
        Button sus2Button = (Button) findViewById(R.id.sus2Button);
        sus2Button.setTransformationMethod(null);
        sus2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                cancelTimer6();
                cancelTimer7();
                cancelTimer8();
                cancelTimer9();

                if (chord == 5) {
                    displayAnswer();
                    progress++;

                } else {
                    progress = 0;
                    displayAnswer();
                    playAnswer();
                }


                playPressed = false;
                if (progress >= 20 && level < 29) {
                    progress = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner) findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();
                }
                updateProgress();

            }
        });

    }

    private void setSus4Button() {
        Button sus4Button = (Button) findViewById(R.id.sus4Button);
        sus4Button.setTransformationMethod(null);
        sus4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                cancelTimer6();
                cancelTimer7();
                cancelTimer8();
                cancelTimer9();

                if (chord == 6) {
                    displayAnswer();
                    progress++;

                } else {
                    progress = 0;
                    displayAnswer();
                    playAnswer();
                }


                playPressed = false;
                if (progress >= 20 && level < 29) {
                    progress = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner) findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();
                }
                updateProgress();

            }
        });

    }

    private void setSevenButton() {
        Button sevenButton = (Button) findViewById(R.id.sevenButton);
        sevenButton.setTransformationMethod(null);
        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                cancelTimer6();
                cancelTimer7();
                cancelTimer8();
                cancelTimer9();

                if (chord == 7) {
                    displayAnswer();
                    progress++;

                } else {
                    progress = 0;
                    displayAnswer();
                    playAnswer();
                }


                playPressed = false;
                if (progress >= 20 && level < 29) {
                    progress = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner) findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();
                }
                updateProgress();

            }
        });

    }

    private void setMin7Button() {
        Button min7Button = (Button) findViewById(R.id.minor7Button);
        min7Button.setTransformationMethod(null);
        min7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                cancelTimer6();
                cancelTimer7();
                cancelTimer8();
                cancelTimer9();

                if (chord == 8) {
                    displayAnswer();
                    progress++;

                } else {
                    progress = 0;
                    displayAnswer();
                    playAnswer();
                }


                playPressed = false;
                if (progress >= 20 && level < 29) {
                    progress = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner) findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();
                }
                updateProgress();

            }
        });

    }

    private void setMaj7Button() {
        Button maj7Button = (Button) findViewById(R.id.major7Button);
        maj7Button.setTransformationMethod(null);
        maj7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                cancelTimer6();
                cancelTimer7();
                cancelTimer8();
                cancelTimer9();

                if (chord == 9) {
                    displayAnswer();
                    progress++;

                } else {
                    progress = 0;
                    displayAnswer();
                    playAnswer();
                }


                playPressed = false;
                if (progress >= 20 && level < 29) {
                    progress = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner) findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();
                }
                updateProgress();

            }
        });

    }

    private void setMaj6Button() {
        Button maj6Button = (Button) findViewById(R.id.major6Button);
        maj6Button.setTransformationMethod(null);
        maj6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                cancelTimer6();
                cancelTimer7();
                cancelTimer8();
                cancelTimer9();

                if (chord == 10) {
                    displayAnswer();
                    progress++;

                } else {
                    progress = 0;
                    displayAnswer();
                    playAnswer();
                }


                playPressed = false;
                if (progress >= 20 && level < 29) {
                    progress = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner) findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();
                }
                updateProgress();

            }
        });

    }

    private void setMin6Button() {
        Button min6Button = (Button) findViewById(R.id.minor6Button);
        min6Button.setTransformationMethod(null);
        min6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                cancelTimer6();
                cancelTimer7();
                cancelTimer8();
                cancelTimer9();

                if (chord == 11) {
                    displayAnswer();
                    progress++;

                } else {
                    progress = 0;
                    displayAnswer();
                    playAnswer();
                }


                playPressed = false;
                if (progress >= 20 && level < 29) {
                    progress = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner) findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();
                }
                updateProgress();

            }
        });

    }

    private void setSevenSharp5Button() {
        Button sevenSharp5Button = (Button) findViewById(R.id.sevenSharp5Button);
        sevenSharp5Button.setTransformationMethod(null);
        sevenSharp5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                cancelTimer6();
                cancelTimer7();
                cancelTimer8();
                cancelTimer9();

                if (chord == 12) {
                    displayAnswer();
                    progress++;

                } else {
                    progress = 0;
                    displayAnswer();
                    playAnswer();
                }


                playPressed = false;
                if (progress >= 20 && level < 29) {
                    progress = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner) findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();
                }
                updateProgress();

            }
        });

    }

    private void setSevenFlat5Button() {
        Button sevenFlat5Button = (Button) findViewById(R.id.sevenFlat5Button);
        sevenFlat5Button.setTransformationMethod(null);
        sevenFlat5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                cancelTimer6();
                cancelTimer7();
                cancelTimer8();
                cancelTimer9();

                if (chord == 13) {
                    displayAnswer();
                    progress++;

                } else {
                    progress = 0;
                    displayAnswer();
                    playAnswer();
                }


                playPressed = false;
                if (progress >= 20 && level < 29) {
                    progress = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner) findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();
                }
                updateProgress();

            }
        });

    }

    private void setMaj7Flat3Button() {
        Button maj7Flat3Button = (Button) findViewById(R.id.major7Flat3Button);
        maj7Flat3Button.setTransformationMethod(null);
        maj7Flat3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                cancelTimer6();
                cancelTimer7();
                cancelTimer8();
                cancelTimer9();

                if (chord == 14) {
                    displayAnswer();
                    progress++;

                } else {
                    progress = 0;
                    displayAnswer();
                    playAnswer();
                }


                playPressed = false;


                playPressed = false;
                if (progress >= 20 && level < 29) {
                    progress = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner) findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();
                }
                updateProgress();

            }
        });

    }

    private void setMin7Flat5Button() {
        Button min7Flat5Button = (Button) findViewById(R.id.minor7Flat5Button);
        min7Flat5Button.setTransformationMethod(null);
        min7Flat5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                cancelTimer6();
                cancelTimer7();
                cancelTimer8();
                cancelTimer9();

                if (chord == 15) {
                    displayAnswer();
                    progress++;

                } else {
                    progress = 0;
                    displayAnswer();
                    playAnswer();
                }


                playPressed = false;


                playPressed = false;
                if (progress >= 20 && level < 29) {
                    progress = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner) findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();
                }
                updateProgress();

            }
        });

    }

    private void setSevenSus4Button() {
        Button sevenSus4Button = (Button) findViewById(R.id.sevenSus4Button);
        sevenSus4Button.setTransformationMethod(null);
        sevenSus4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                cancelTimer6();
                cancelTimer7();
                cancelTimer8();
                cancelTimer9();

                if (chord == 16) {
                    displayAnswer();
                    progress++;

                } else {
                    progress = 0;
                    displayAnswer();
                    playAnswer();
                }


                playPressed = false;

                playPressed = false;
                if (progress >= 20 && level < 29) {
                    progress = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner) findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();
                }
                updateProgress();

            }
        });

    }

    private void setMin7Sharp5Button() {
        Button min7Sharp5Button = (Button) findViewById(R.id.minor7Sharp5Button);
        min7Sharp5Button.setTransformationMethod(null);
        min7Sharp5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                cancelTimer6();
                cancelTimer7();
                cancelTimer8();
                cancelTimer9();

                if (chord == 17) {
                    displayAnswer();
                    progress++;

                } else {
                    progress = 0;
                    displayAnswer();
                    playAnswer();
                }


                playPressed = false;


                playPressed = false;
                if (progress >= 20 && level < 29) {
                    progress = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner) findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();
                }
                updateProgress();

            }
        });

    }

    private void setNineButton() {
        Button nineButton = (Button) findViewById(R.id.nineButton);
        nineButton.setTransformationMethod(null);
        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                cancelTimer6();
                cancelTimer7();
                cancelTimer8();
                cancelTimer9();

                if (chord == 18) {
                    displayAnswer();
                    progress++;

                } else {
                    progress = 0;
                    displayAnswer();
                    playAnswer();
                }


                playPressed = false;


                playPressed = false;
                if (progress >= 20 && level < 29) {
                    progress = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner) findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();
                }
                updateProgress();

            }
        });

    }

    private void setMin9Button() {
        Button min9Button = (Button) findViewById(R.id.minor9Button);
        min9Button.setTransformationMethod(null);
        min9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                cancelTimer6();
                cancelTimer7();
                cancelTimer8();
                cancelTimer9();

                if (chord == 19) {
                    displayAnswer();
                    progress++;

                } else {
                    progress = 0;
                    displayAnswer();
                    playAnswer();
                }


                playPressed = false;


                playPressed = false;
                if (progress >= 20 && level < 29) {
                    progress = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner) findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();
                }
                updateProgress();

            }
        });

    }


    private void setMaj9Button() {
        Button maj9Button = (Button) findViewById(R.id.major9Button);
        maj9Button.setTransformationMethod(null);
        maj9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                cancelTimer6();
                cancelTimer7();
                cancelTimer8();
                cancelTimer9();

                if (chord == 20) {
                    displayAnswer();
                    progress++;

                } else {
                    progress = 0;
                    displayAnswer();
                    playAnswer();
                }


                playPressed = false;


                playPressed = false;
                if (progress >= 20 && level < 29) {
                    progress = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner) findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();
                }
                updateProgress();

            }
        });

    }

    private void setNineSharp5Button() {
        Button nineSharp5Button = (Button) findViewById(R.id.nineSharp5Button);
        nineSharp5Button.setTransformationMethod(null);
        nineSharp5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                cancelTimer6();
                cancelTimer7();
                cancelTimer8();
                cancelTimer9();

                if (chord == 21) {
                    displayAnswer();
                    progress++;

                } else {
                    progress = 0;
                    displayAnswer();
                    playAnswer();
                }


                playPressed = false;


                playPressed = false;
                if (progress >= 20 && level < 29) {
                    progress = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner) findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();
                }
                updateProgress();

            }
        });

    }

    private void setNineFlat5Button() {
        Button nineFlat5Button = (Button) findViewById(R.id.nineFlat5Button);
        nineFlat5Button.setTransformationMethod(null);
        nineFlat5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                cancelTimer6();
                cancelTimer7();
                cancelTimer8();
                cancelTimer9();

                if (chord == 22) {
                    displayAnswer();
                    progress++;

                } else {
                    progress = 0;
                    displayAnswer();
                    playAnswer();
                }


                playPressed = false;

                playPressed = false;
                if (progress >= 20 && level < 29) {
                    progress = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner) findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();
                }
                updateProgress();

            }
        });

    }

    private void setSevenFlat9Button() {
        Button sevenFlat9Button = (Button) findViewById(R.id.sevenFlat9Button);
        sevenFlat9Button.setTransformationMethod(null);
        sevenFlat9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                cancelTimer6();
                cancelTimer7();
                cancelTimer8();
                cancelTimer9();

                if (chord == 23) {
                    displayAnswer();
                    progress++;

                } else {
                    progress = 0;
                    displayAnswer();
                    playAnswer();
                }


                playPressed = false;


                playPressed = false;
                if (progress >= 20 && level < 29) {
                    progress = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner) findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();
                }
                updateProgress();

            }
        });

    }

    private void setNinePlusButton() {
        Button ninePlusButton = (Button) findViewById(R.id.ninePlusButton);
        ninePlusButton.setTransformationMethod(null);
        ninePlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                cancelTimer6();
                cancelTimer7();
                cancelTimer8();
                cancelTimer9();

                if (chord == 24) {
                    displayAnswer();
                    progress++;

                } else {
                    progress = 0;
                    displayAnswer();
                    playAnswer();
                }


                playPressed = false;


                playPressed = false;
                if (progress >= 20 && level < 29) {
                    progress = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner) findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();
                }
                updateProgress();

            }
        });

    }

    private void setSixAdd9Button() {
        Button sixAdd9Button = (Button) findViewById(R.id.sixAdd9Button);
        sixAdd9Button.setTransformationMethod(null);
        sixAdd9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                cancelTimer6();
                cancelTimer7();
                cancelTimer8();
                cancelTimer9();

                if (chord == 25) {
                    displayAnswer();
                    progress++;

                } else {
                    progress = 0;
                    displayAnswer();
                    playAnswer();
                }


                playPressed = false;


                playPressed = false;
                if (progress >= 20 && level < 29) {
                    progress = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner) findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();
                }
                updateProgress();

            }
        });

    }

    private void setElevenButton() {
        Button elevenButton = (Button) findViewById(R.id.elevenButton);
        elevenButton.setTransformationMethod(null);
        elevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                cancelTimer6();
                cancelTimer7();
                cancelTimer8();
                cancelTimer9();

                if (chord == 26) {
                    displayAnswer();
                    progress++;

                } else {
                    progress = 0;
                    displayAnswer();
                    playAnswer();
                }


                playPressed = false;


                playPressed = false;
                if (progress >= 20 && level < 29) {
                    progress = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner) findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();
                }
                updateProgress();

            }
        });

    }

    private void setElevenPlusButton() {
        Button elevenPlusButton = (Button) findViewById(R.id.elevenPlusButton);
        elevenPlusButton.setTransformationMethod(null);
        elevenPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                cancelTimer6();
                cancelTimer7();
                cancelTimer8();
                cancelTimer9();

                if (chord == 27) {
                    displayAnswer();
                    progress++;

                } else {
                    progress = 0;
                    displayAnswer();
                    playAnswer();
                }


                playPressed = false;


                playPressed = false;
                if (progress >= 20 && level < 29) {
                    progress = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner) findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();
                }
                updateProgress();

            }
        });

    }

    private void setThirteenButton() {
        Button thirteenButton = (Button) findViewById(R.id.thirteenButton);
        thirteenButton.setTransformationMethod(null);
        thirteenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                cancelTimer6();
                cancelTimer7();
                cancelTimer8();
                cancelTimer9();

                if (chord == 28) {
                    displayAnswer();
                    progress++;

                } else {
                    progress = 0;
                    displayAnswer();
                    playAnswer();
                }


                playPressed = false;


                playPressed = false;
                if (progress >= 20 && level < 29) {
                    progress = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner) findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();
                }
                updateProgress();

            }
        });

    }

    private void setThirteenFlat9Button() {
        Button thirteenFlat9Button = (Button) findViewById(R.id.thirteenFlat9Button);
        thirteenFlat9Button.setTransformationMethod(null);
        thirteenFlat9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                cancelTimer6();
                cancelTimer7();
                cancelTimer8();
                cancelTimer9();

                if (chord == 29) {
                    displayAnswer();
                    progress++;

                } else {
                    progress = 0;
                    displayAnswer();
                    playAnswer();
                }


                playPressed = false;


                playPressed = false;
                if (progress >= 20 && level < 29) {
                    progress = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner) findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();
                }
                updateProgress();

            }
        });

    }

    private void setThirteenFlat9Flat5Button() {
        Button thirteenb9b5Button = (Button) findViewById(R.id.thirteenFlat9Flat5Button);
        thirteenb9b5Button.setTransformationMethod(null);
        thirteenb9b5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                cancelTimer6();
                cancelTimer7();
                cancelTimer8();
                cancelTimer9();

                if (chord == 30) {
                    displayAnswer();
                    progress++;

                } else {
                    progress = 0;
                    displayAnswer();
                    playAnswer();
                }


                playPressed = false;


                playPressed = false;
                if (progress >= 20 && level < 29) {
                    progress = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner) findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();
                }
                updateProgress();

            }
        });

    }


    private void updateProgress() {

        progressBar.setProgress(progress);
        textView.setText("Progress: " + progress);
    }


    private void setLevel() {
        Button majButton = (Button) findViewById(R.id.majorButton);
        Button minButton = (Button) findViewById(R.id.minorButton);
        Button dimButton = (Button) findViewById(R.id.diminishedButton);
        Button augButton = (Button) findViewById(R.id.augmentedButton);
        Button sus2Button = (Button) findViewById(R.id.sus2Button);
        Button sus4Button = (Button) findViewById(R.id.sus4Button);
        Button sevenButton = (Button) findViewById(R.id.sevenButton);
        Button min7Button = (Button) findViewById(R.id.minor7Button);
        Button M7Button = (Button) findViewById(R.id.major7Button);
        Button M6Button = (Button) findViewById(R.id.major6Button);
        Button min6Button = (Button) findViewById(R.id.minor6Button);
        Button sevensharp5Button = (Button) findViewById(R.id.sevenSharp5Button);
        Button sevenflat5Button = (Button) findViewById(R.id.sevenFlat5Button);
        Button M7flat3Button = (Button) findViewById(R.id.major7Flat3Button);
        Button m7b5Button = (Button) findViewById(R.id.minor7Flat5Button);
        Button sevensus4Button = (Button) findViewById(R.id.sevenSus4Button);
        Button m7sharp5Button = (Button) findViewById(R.id.minor7Sharp5Button);
        Button nineButton = (Button) findViewById(R.id.nineButton);
        Button min9Button = (Button) findViewById(R.id.minor9Button);
        Button M9Button = (Button) findViewById(R.id.major9Button);
        Button ninesharp5Button = (Button) findViewById(R.id.nineSharp5Button);
        Button nineb5Button = (Button) findViewById(R.id.nineFlat5Button);
        Button sevenb9Button = (Button) findViewById(R.id.sevenFlat9Button);
        Button nineplusButton = (Button) findViewById(R.id.ninePlusButton);
        Button sixadd9Button = (Button) findViewById(R.id.sixAdd9Button);
        Button elevenButton = (Button) findViewById(R.id.elevenButton);
        Button elevenplusButton = (Button) findViewById(R.id.elevenPlusButton);
        Button thirteenButton = (Button) findViewById(R.id.thirteenButton);
        Button thirteenb9Button = (Button) findViewById(R.id.thirteenFlat9Button);
        Button thirteenb9b5Button = (Button) findViewById(R.id.thirteenFlat9Flat5Button);


        resetColor();

        lvl = spinner.getSelectedItem().toString();

        if (!lvl.equals(currentLevel)) {
            levelChanged = true;
        }

        if (levelChanged) {
            progress = 0;
        }

        if (lvl.equals("Level: 1")) {
            level = 1;
            majButton.setEnabled(true);
            minButton.setEnabled(true);
            dimButton.setEnabled(false);
            augButton.setEnabled(false);
            sus2Button.setEnabled(false);
            sus4Button.setEnabled(false);
            sevenButton.setEnabled(false);
            min7Button.setEnabled(false);
            M7Button.setEnabled(false);
            M6Button.setEnabled(false);
            min6Button.setEnabled(false);
            sevensharp5Button.setEnabled(false);
            sevenflat5Button.setEnabled(false);
            M7flat3Button.setEnabled(false);
            m7b5Button.setEnabled(false);
            sevensus4Button.setEnabled(false);
            m7sharp5Button.setEnabled(false);
            nineButton.setEnabled(false);
            min9Button.setEnabled(false);
            M9Button.setEnabled(false);
            ninesharp5Button.setEnabled(false);
            nineb5Button.setEnabled(false);
            sevenb9Button.setEnabled(false);
            nineplusButton.setEnabled(false);
            sixadd9Button.setEnabled(false);
            elevenButton.setEnabled(false);
            elevenplusButton.setEnabled(false);
            thirteenButton.setEnabled(false);
            thirteenb9Button.setEnabled(false);
            thirteenb9b5Button.setEnabled(false);
        }

        if (lvl.equals("Level: 2")) {
            level = 2;
            majButton.setEnabled(true);
            minButton.setEnabled(true);
            dimButton.setEnabled(true);
            augButton.setEnabled(false);
            sus2Button.setEnabled(false);
            sus4Button.setEnabled(false);
            sevenButton.setEnabled(false);
            min7Button.setEnabled(false);
            M7Button.setEnabled(false);
            M6Button.setEnabled(false);
            min6Button.setEnabled(false);
            sevensharp5Button.setEnabled(false);
            sevenflat5Button.setEnabled(false);
            M7flat3Button.setEnabled(false);
            m7b5Button.setEnabled(false);
            sevensus4Button.setEnabled(false);
            m7sharp5Button.setEnabled(false);
            nineButton.setEnabled(false);
            min9Button.setEnabled(false);
            M9Button.setEnabled(false);
            ninesharp5Button.setEnabled(false);
            nineb5Button.setEnabled(false);
            sevenb9Button.setEnabled(false);
            nineplusButton.setEnabled(false);
            sixadd9Button.setEnabled(false);
            elevenButton.setEnabled(false);
            elevenplusButton.setEnabled(false);
            thirteenButton.setEnabled(false);
            thirteenb9Button.setEnabled(false);
            thirteenb9b5Button.setEnabled(false);
        }

        if (lvl.equals("Level: 3")) {
            level = 3;
            majButton.setEnabled(true);
            minButton.setEnabled(true);
            dimButton.setEnabled(true);
            augButton.setEnabled(true);
            sus2Button.setEnabled(false);
            sus4Button.setEnabled(false);
            sevenButton.setEnabled(false);
            min7Button.setEnabled(false);
            M7Button.setEnabled(false);
            M6Button.setEnabled(false);
            min6Button.setEnabled(false);
            sevensharp5Button.setEnabled(false);
            sevenflat5Button.setEnabled(false);
            M7flat3Button.setEnabled(false);
            m7b5Button.setEnabled(false);
            sevensus4Button.setEnabled(false);
            m7sharp5Button.setEnabled(false);
            nineButton.setEnabled(false);
            min9Button.setEnabled(false);
            M9Button.setEnabled(false);
            ninesharp5Button.setEnabled(false);
            nineb5Button.setEnabled(false);
            sevenb9Button.setEnabled(false);
            nineplusButton.setEnabled(false);
            sixadd9Button.setEnabled(false);
            elevenButton.setEnabled(false);
            elevenplusButton.setEnabled(false);
            thirteenButton.setEnabled(false);
            thirteenb9Button.setEnabled(false);
            thirteenb9b5Button.setEnabled(false);
        }

        if (lvl.equals("Level: 4")) {
            level = 4;
            majButton.setEnabled(true);
            minButton.setEnabled(true);
            dimButton.setEnabled(true);
            augButton.setEnabled(true);
            sus2Button.setEnabled(true);
            sus4Button.setEnabled(false);
            sevenButton.setEnabled(false);
            min7Button.setEnabled(false);
            M7Button.setEnabled(false);
            M6Button.setEnabled(false);
            min6Button.setEnabled(false);
            sevensharp5Button.setEnabled(false);
            sevenflat5Button.setEnabled(false);
            M7flat3Button.setEnabled(false);
            m7b5Button.setEnabled(false);
            sevensus4Button.setEnabled(false);
            m7sharp5Button.setEnabled(false);
            nineButton.setEnabled(false);
            min9Button.setEnabled(false);
            M9Button.setEnabled(false);
            ninesharp5Button.setEnabled(false);
            nineb5Button.setEnabled(false);
            sevenb9Button.setEnabled(false);
            nineplusButton.setEnabled(false);
            sixadd9Button.setEnabled(false);
            elevenButton.setEnabled(false);
            elevenplusButton.setEnabled(false);
            thirteenButton.setEnabled(false);
            thirteenb9Button.setEnabled(false);
            thirteenb9b5Button.setEnabled(false);
        }

        if (lvl.equals("Level: 5")) {
            level = 5;
            majButton.setEnabled(true);
            minButton.setEnabled(true);
            dimButton.setEnabled(true);
            augButton.setEnabled(true);
            sus2Button.setEnabled(true);
            sus4Button.setEnabled(true);
            sevenButton.setEnabled(false);
            min7Button.setEnabled(false);
            M7Button.setEnabled(false);
            M6Button.setEnabled(false);
            min6Button.setEnabled(false);
            sevensharp5Button.setEnabled(false);
            sevenflat5Button.setEnabled(false);
            M7flat3Button.setEnabled(false);
            m7b5Button.setEnabled(false);
            sevensus4Button.setEnabled(false);
            m7sharp5Button.setEnabled(false);
            nineButton.setEnabled(false);
            min9Button.setEnabled(false);
            M9Button.setEnabled(false);
            ninesharp5Button.setEnabled(false);
            nineb5Button.setEnabled(false);
            sevenb9Button.setEnabled(false);
            nineplusButton.setEnabled(false);
            sixadd9Button.setEnabled(false);
            elevenButton.setEnabled(false);
            elevenplusButton.setEnabled(false);
            thirteenButton.setEnabled(false);
            thirteenb9Button.setEnabled(false);
            thirteenb9b5Button.setEnabled(false);
        }

        if (lvl.equals("Level: 6")) {
            level = 6;
            majButton.setEnabled(true);
            minButton.setEnabled(true);
            dimButton.setEnabled(true);
            augButton.setEnabled(true);
            sus2Button.setEnabled(true);
            sus4Button.setEnabled(true);
            sevenButton.setEnabled(true);
            min7Button.setEnabled(false);
            M7Button.setEnabled(false);
            M6Button.setEnabled(false);
            min6Button.setEnabled(false);
            sevensharp5Button.setEnabled(false);
            sevenflat5Button.setEnabled(false);
            M7flat3Button.setEnabled(false);
            m7b5Button.setEnabled(false);
            sevensus4Button.setEnabled(false);
            m7sharp5Button.setEnabled(false);
            nineButton.setEnabled(false);
            min9Button.setEnabled(false);
            M9Button.setEnabled(false);
            ninesharp5Button.setEnabled(false);
            nineb5Button.setEnabled(false);
            sevenb9Button.setEnabled(false);
            nineplusButton.setEnabled(false);
            sixadd9Button.setEnabled(false);
            elevenButton.setEnabled(false);
            elevenplusButton.setEnabled(false);
            thirteenButton.setEnabled(false);
            thirteenb9Button.setEnabled(false);
            thirteenb9b5Button.setEnabled(false);
        }

        if (lvl.equals("Level: 7")) {
            level = 7;
            majButton.setEnabled(true);
            minButton.setEnabled(true);
            dimButton.setEnabled(true);
            augButton.setEnabled(true);
            sus2Button.setEnabled(true);
            sus4Button.setEnabled(true);
            sevenButton.setEnabled(true);
            min7Button.setEnabled(true);
            M7Button.setEnabled(false);
            M6Button.setEnabled(false);
            min6Button.setEnabled(false);
            sevensharp5Button.setEnabled(false);
            sevenflat5Button.setEnabled(false);
            M7flat3Button.setEnabled(false);
            m7b5Button.setEnabled(false);
            sevensus4Button.setEnabled(false);
            m7sharp5Button.setEnabled(false);
            nineButton.setEnabled(false);
            min9Button.setEnabled(false);
            M9Button.setEnabled(false);
            ninesharp5Button.setEnabled(false);
            nineb5Button.setEnabled(false);
            sevenb9Button.setEnabled(false);
            nineplusButton.setEnabled(false);
            sixadd9Button.setEnabled(false);
            elevenButton.setEnabled(false);
            elevenplusButton.setEnabled(false);
            thirteenButton.setEnabled(false);
            thirteenb9Button.setEnabled(false);
            thirteenb9b5Button.setEnabled(false);
        }

        if (lvl.equals("Level: 8")) {
            level = 8;
            majButton.setEnabled(true);
            minButton.setEnabled(true);
            dimButton.setEnabled(true);
            augButton.setEnabled(true);
            sus2Button.setEnabled(true);
            sus4Button.setEnabled(true);
            sevenButton.setEnabled(true);
            min7Button.setEnabled(true);
            M7Button.setEnabled(true);
            M6Button.setEnabled(false);
            min6Button.setEnabled(false);
            sevensharp5Button.setEnabled(false);
            sevenflat5Button.setEnabled(false);
            M7flat3Button.setEnabled(false);
            m7b5Button.setEnabled(false);
            sevensus4Button.setEnabled(false);
            m7sharp5Button.setEnabled(false);
            nineButton.setEnabled(false);
            min9Button.setEnabled(false);
            M9Button.setEnabled(false);
            ninesharp5Button.setEnabled(false);
            nineb5Button.setEnabled(false);
            sevenb9Button.setEnabled(false);
            nineplusButton.setEnabled(false);
            sixadd9Button.setEnabled(false);
            elevenButton.setEnabled(false);
            elevenplusButton.setEnabled(false);
            thirteenButton.setEnabled(false);
            thirteenb9Button.setEnabled(false);
            thirteenb9b5Button.setEnabled(false);
        }

        if (lvl.equals("Level: 9")) {
            level = 9;
            majButton.setEnabled(true);
            minButton.setEnabled(true);
            dimButton.setEnabled(true);
            augButton.setEnabled(true);
            sus2Button.setEnabled(true);
            sus4Button.setEnabled(true);
            sevenButton.setEnabled(true);
            min7Button.setEnabled(true);
            M7Button.setEnabled(true);
            M6Button.setEnabled(true);
            min6Button.setEnabled(false);
            sevensharp5Button.setEnabled(false);
            sevenflat5Button.setEnabled(false);
            M7flat3Button.setEnabled(false);
            m7b5Button.setEnabled(false);
            sevensus4Button.setEnabled(false);
            m7sharp5Button.setEnabled(false);
            nineButton.setEnabled(false);
            min9Button.setEnabled(false);
            M9Button.setEnabled(false);
            ninesharp5Button.setEnabled(false);
            nineb5Button.setEnabled(false);
            sevenb9Button.setEnabled(false);
            nineplusButton.setEnabled(false);
            sixadd9Button.setEnabled(false);
            elevenButton.setEnabled(false);
            elevenplusButton.setEnabled(false);
            thirteenButton.setEnabled(false);
            thirteenb9Button.setEnabled(false);
            thirteenb9b5Button.setEnabled(false);
        }

        if (lvl.equals("Level: 10")) {
            level = 10;
            majButton.setEnabled(true);
            minButton.setEnabled(true);
            dimButton.setEnabled(true);
            augButton.setEnabled(true);
            sus2Button.setEnabled(true);
            sus4Button.setEnabled(true);
            sevenButton.setEnabled(true);
            min7Button.setEnabled(true);
            M7Button.setEnabled(true);
            M6Button.setEnabled(true);
            min6Button.setEnabled(true);
            sevensharp5Button.setEnabled(false);
            sevenflat5Button.setEnabled(false);
            M7flat3Button.setEnabled(false);
            m7b5Button.setEnabled(false);
            sevensus4Button.setEnabled(false);
            m7sharp5Button.setEnabled(false);
            nineButton.setEnabled(false);
            min9Button.setEnabled(false);
            M9Button.setEnabled(false);
            ninesharp5Button.setEnabled(false);
            nineb5Button.setEnabled(false);
            sevenb9Button.setEnabled(false);
            nineplusButton.setEnabled(false);
            sixadd9Button.setEnabled(false);
            elevenButton.setEnabled(false);
            elevenplusButton.setEnabled(false);
            thirteenButton.setEnabled(false);
            thirteenb9Button.setEnabled(false);
            thirteenb9b5Button.setEnabled(false);
        }

        if (lvl.equals("Level: 11")) {
            level = 11;
            majButton.setEnabled(true);
            minButton.setEnabled(true);
            dimButton.setEnabled(true);
            augButton.setEnabled(true);
            sus2Button.setEnabled(true);
            sus4Button.setEnabled(true);
            sevenButton.setEnabled(true);
            min7Button.setEnabled(true);
            M7Button.setEnabled(true);
            M6Button.setEnabled(true);
            min6Button.setEnabled(true);
            sevensharp5Button.setEnabled(true);
            sevenflat5Button.setEnabled(false);
            M7flat3Button.setEnabled(false);
            m7b5Button.setEnabled(false);
            sevensus4Button.setEnabled(false);
            m7sharp5Button.setEnabled(false);
            nineButton.setEnabled(false);
            min9Button.setEnabled(false);
            M9Button.setEnabled(false);
            ninesharp5Button.setEnabled(false);
            nineb5Button.setEnabled(false);
            sevenb9Button.setEnabled(false);
            nineplusButton.setEnabled(false);
            sixadd9Button.setEnabled(false);
            elevenButton.setEnabled(false);
            elevenplusButton.setEnabled(false);
            thirteenButton.setEnabled(false);
            thirteenb9Button.setEnabled(false);
            thirteenb9b5Button.setEnabled(false);
        }

        if (lvl.equals("Level: 12")) {
            level = 12;
            majButton.setEnabled(true);
            minButton.setEnabled(true);
            dimButton.setEnabled(true);
            augButton.setEnabled(true);
            sus2Button.setEnabled(true);
            sus4Button.setEnabled(true);
            sevenButton.setEnabled(true);
            min7Button.setEnabled(true);
            M7Button.setEnabled(true);
            M6Button.setEnabled(true);
            min6Button.setEnabled(true);
            sevensharp5Button.setEnabled(true);
            sevenflat5Button.setEnabled(true);
            M7flat3Button.setEnabled(false);
            m7b5Button.setEnabled(false);
            sevensus4Button.setEnabled(false);
            m7sharp5Button.setEnabled(false);
            nineButton.setEnabled(false);
            min9Button.setEnabled(false);
            M9Button.setEnabled(false);
            ninesharp5Button.setEnabled(false);
            nineb5Button.setEnabled(false);
            sevenb9Button.setEnabled(false);
            nineplusButton.setEnabled(false);
            sixadd9Button.setEnabled(false);
            elevenButton.setEnabled(false);
            elevenplusButton.setEnabled(false);
            thirteenButton.setEnabled(false);
            thirteenb9Button.setEnabled(false);
            thirteenb9b5Button.setEnabled(false);
        }

        if (lvl.equals("Level: 13")) {
            level = 13;
            majButton.setEnabled(true);
            minButton.setEnabled(true);
            dimButton.setEnabled(true);
            augButton.setEnabled(true);
            sus2Button.setEnabled(true);
            sus4Button.setEnabled(true);
            sevenButton.setEnabled(true);
            min7Button.setEnabled(true);
            M7Button.setEnabled(true);
            M6Button.setEnabled(true);
            min6Button.setEnabled(true);
            sevensharp5Button.setEnabled(true);
            sevenflat5Button.setEnabled(true);
            M7flat3Button.setEnabled(true);
            m7b5Button.setEnabled(false);
            sevensus4Button.setEnabled(false);
            m7sharp5Button.setEnabled(false);
            nineButton.setEnabled(false);
            min9Button.setEnabled(false);
            M9Button.setEnabled(false);
            ninesharp5Button.setEnabled(false);
            nineb5Button.setEnabled(false);
            sevenb9Button.setEnabled(false);
            nineplusButton.setEnabled(false);
            sixadd9Button.setEnabled(false);
            elevenButton.setEnabled(false);
            elevenplusButton.setEnabled(false);
            thirteenButton.setEnabled(false);
            thirteenb9Button.setEnabled(false);
            thirteenb9b5Button.setEnabled(false);
        }

        if (lvl.equals("Level: 14")) {
            level = 14;
            majButton.setEnabled(true);
            minButton.setEnabled(true);
            dimButton.setEnabled(true);
            augButton.setEnabled(true);
            sus2Button.setEnabled(true);
            sus4Button.setEnabled(true);
            sevenButton.setEnabled(true);
            min7Button.setEnabled(true);
            M7Button.setEnabled(true);
            M6Button.setEnabled(true);
            min6Button.setEnabled(true);
            sevensharp5Button.setEnabled(true);
            sevenflat5Button.setEnabled(true);
            M7flat3Button.setEnabled(true);
            m7b5Button.setEnabled(true);
            sevensus4Button.setEnabled(false);
            m7sharp5Button.setEnabled(false);
            nineButton.setEnabled(false);
            min9Button.setEnabled(false);
            M9Button.setEnabled(false);
            ninesharp5Button.setEnabled(false);
            nineb5Button.setEnabled(false);
            sevenb9Button.setEnabled(false);
            nineplusButton.setEnabled(false);
            sixadd9Button.setEnabled(false);
            elevenButton.setEnabled(false);
            elevenplusButton.setEnabled(false);
            thirteenButton.setEnabled(false);
            thirteenb9Button.setEnabled(false);
            thirteenb9b5Button.setEnabled(false);
        }

        if (lvl.equals("Level: 15")) {
            level = 15;
            majButton.setEnabled(true);
            minButton.setEnabled(true);
            dimButton.setEnabled(true);
            augButton.setEnabled(true);
            sus2Button.setEnabled(true);
            sus4Button.setEnabled(true);
            sevenButton.setEnabled(true);
            min7Button.setEnabled(true);
            M7Button.setEnabled(true);
            M6Button.setEnabled(true);
            min6Button.setEnabled(true);
            sevensharp5Button.setEnabled(true);
            sevenflat5Button.setEnabled(true);
            M7flat3Button.setEnabled(true);
            m7b5Button.setEnabled(true);
            sevensus4Button.setEnabled(true);
            m7sharp5Button.setEnabled(false);
            nineButton.setEnabled(false);
            min9Button.setEnabled(false);
            M9Button.setEnabled(false);
            ninesharp5Button.setEnabled(false);
            nineb5Button.setEnabled(false);
            sevenb9Button.setEnabled(false);
            nineplusButton.setEnabled(false);
            sixadd9Button.setEnabled(false);
            elevenButton.setEnabled(false);
            elevenplusButton.setEnabled(false);
            thirteenButton.setEnabled(false);
            thirteenb9Button.setEnabled(false);
            thirteenb9b5Button.setEnabled(false);
        }

        if (lvl.equals("Level: 16")) {
            level = 16;
            majButton.setEnabled(true);
            minButton.setEnabled(true);
            dimButton.setEnabled(true);
            augButton.setEnabled(true);
            sus2Button.setEnabled(true);
            sus4Button.setEnabled(true);
            sevenButton.setEnabled(true);
            min7Button.setEnabled(true);
            M7Button.setEnabled(true);
            M6Button.setEnabled(true);
            min6Button.setEnabled(true);
            sevensharp5Button.setEnabled(true);
            sevenflat5Button.setEnabled(true);
            M7flat3Button.setEnabled(true);
            m7b5Button.setEnabled(true);
            sevensus4Button.setEnabled(true);
            m7sharp5Button.setEnabled(true);
            nineButton.setEnabled(false);
            min9Button.setEnabled(false);
            M9Button.setEnabled(false);
            ninesharp5Button.setEnabled(false);
            nineb5Button.setEnabled(false);
            sevenb9Button.setEnabled(false);
            nineplusButton.setEnabled(false);
            sixadd9Button.setEnabled(false);
            elevenButton.setEnabled(false);
            elevenplusButton.setEnabled(false);
            thirteenButton.setEnabled(false);
            thirteenb9Button.setEnabled(false);
            thirteenb9b5Button.setEnabled(false);
        }

        if (lvl.equals("Level: 17")) {
            level = 17;
            majButton.setEnabled(true);
            minButton.setEnabled(true);
            dimButton.setEnabled(true);
            augButton.setEnabled(true);
            sus2Button.setEnabled(true);
            sus4Button.setEnabled(true);
            sevenButton.setEnabled(true);
            min7Button.setEnabled(true);
            M7Button.setEnabled(true);
            M6Button.setEnabled(true);
            min6Button.setEnabled(true);
            sevensharp5Button.setEnabled(true);
            sevenflat5Button.setEnabled(true);
            M7flat3Button.setEnabled(true);
            m7b5Button.setEnabled(true);
            sevensus4Button.setEnabled(true);
            m7sharp5Button.setEnabled(true);
            nineButton.setEnabled(true);
            min9Button.setEnabled(false);
            M9Button.setEnabled(false);
            ninesharp5Button.setEnabled(false);
            nineb5Button.setEnabled(false);
            sevenb9Button.setEnabled(false);
            nineplusButton.setEnabled(false);
            sixadd9Button.setEnabled(false);
            elevenButton.setEnabled(false);
            elevenplusButton.setEnabled(false);
            thirteenButton.setEnabled(false);
            thirteenb9Button.setEnabled(false);
            thirteenb9b5Button.setEnabled(false);
        }

        if (lvl.equals("Level: 18")) {
            level = 18;
            majButton.setEnabled(true);
            minButton.setEnabled(true);
            dimButton.setEnabled(true);
            augButton.setEnabled(true);
            sus2Button.setEnabled(true);
            sus4Button.setEnabled(true);
            sevenButton.setEnabled(true);
            min7Button.setEnabled(true);
            M7Button.setEnabled(true);
            M6Button.setEnabled(true);
            min6Button.setEnabled(true);
            sevensharp5Button.setEnabled(true);
            sevenflat5Button.setEnabled(true);
            M7flat3Button.setEnabled(true);
            m7b5Button.setEnabled(true);
            sevensus4Button.setEnabled(true);
            m7sharp5Button.setEnabled(true);
            nineButton.setEnabled(true);
            min9Button.setEnabled(true);
            M9Button.setEnabled(false);
            ninesharp5Button.setEnabled(false);
            nineb5Button.setEnabled(false);
            sevenb9Button.setEnabled(false);
            nineplusButton.setEnabled(false);
            sixadd9Button.setEnabled(false);
            elevenButton.setEnabled(false);
            elevenplusButton.setEnabled(false);
            thirteenButton.setEnabled(false);
            thirteenb9Button.setEnabled(false);
            thirteenb9b5Button.setEnabled(false);
        }

        if (lvl.equals("Level: 19")) {
            level = 19;
            majButton.setEnabled(true);
            minButton.setEnabled(true);
            dimButton.setEnabled(true);
            augButton.setEnabled(true);
            sus2Button.setEnabled(true);
            sus4Button.setEnabled(true);
            sevenButton.setEnabled(true);
            min7Button.setEnabled(true);
            M7Button.setEnabled(true);
            M6Button.setEnabled(true);
            min6Button.setEnabled(true);
            sevensharp5Button.setEnabled(true);
            sevenflat5Button.setEnabled(true);
            M7flat3Button.setEnabled(true);
            m7b5Button.setEnabled(true);
            sevensus4Button.setEnabled(true);
            m7sharp5Button.setEnabled(true);
            nineButton.setEnabled(true);
            min9Button.setEnabled(true);
            M9Button.setEnabled(true);
            ninesharp5Button.setEnabled(false);
            nineb5Button.setEnabled(false);
            sevenb9Button.setEnabled(false);
            nineplusButton.setEnabled(false);
            sixadd9Button.setEnabled(false);
            elevenButton.setEnabled(false);
            elevenplusButton.setEnabled(false);
            thirteenButton.setEnabled(false);
            thirteenb9Button.setEnabled(false);
            thirteenb9b5Button.setEnabled(false);
        }

        if (lvl.equals("Level: 20")) {
            level = 20;
            majButton.setEnabled(true);
            minButton.setEnabled(true);
            dimButton.setEnabled(true);
            augButton.setEnabled(true);
            sus2Button.setEnabled(true);
            sus4Button.setEnabled(true);
            sevenButton.setEnabled(true);
            min7Button.setEnabled(true);
            M7Button.setEnabled(true);
            M6Button.setEnabled(true);
            min6Button.setEnabled(true);
            sevensharp5Button.setEnabled(true);
            sevenflat5Button.setEnabled(true);
            M7flat3Button.setEnabled(true);
            m7b5Button.setEnabled(true);
            sevensus4Button.setEnabled(true);
            m7sharp5Button.setEnabled(true);
            nineButton.setEnabled(true);
            min9Button.setEnabled(true);
            M9Button.setEnabled(true);
            ninesharp5Button.setEnabled(true);
            nineb5Button.setEnabled(false);
            sevenb9Button.setEnabled(false);
            nineplusButton.setEnabled(false);
            sixadd9Button.setEnabled(false);
            elevenButton.setEnabled(false);
            elevenplusButton.setEnabled(false);
            thirteenButton.setEnabled(false);
            thirteenb9Button.setEnabled(false);
            thirteenb9b5Button.setEnabled(false);
        }

        if (lvl.equals("Level: 21")) {
            level = 21;
            majButton.setEnabled(true);
            minButton.setEnabled(true);
            dimButton.setEnabled(true);
            augButton.setEnabled(true);
            sus2Button.setEnabled(true);
            sus4Button.setEnabled(true);
            sevenButton.setEnabled(true);
            min7Button.setEnabled(true);
            M7Button.setEnabled(true);
            M6Button.setEnabled(true);
            min6Button.setEnabled(true);
            sevensharp5Button.setEnabled(true);
            sevenflat5Button.setEnabled(true);
            M7flat3Button.setEnabled(true);
            m7b5Button.setEnabled(true);
            sevensus4Button.setEnabled(true);
            m7sharp5Button.setEnabled(true);
            nineButton.setEnabled(true);
            min9Button.setEnabled(true);
            M9Button.setEnabled(true);
            ninesharp5Button.setEnabled(true);
            nineb5Button.setEnabled(true);
            sevenb9Button.setEnabled(false);
            nineplusButton.setEnabled(false);
            sixadd9Button.setEnabled(false);
            elevenButton.setEnabled(false);
            elevenplusButton.setEnabled(false);
            thirteenButton.setEnabled(false);
            thirteenb9Button.setEnabled(false);
            thirteenb9b5Button.setEnabled(false);
        }

        if (lvl.equals("Level: 22")) {
            level = 22;
            majButton.setEnabled(true);
            minButton.setEnabled(true);
            dimButton.setEnabled(true);
            augButton.setEnabled(true);
            sus2Button.setEnabled(true);
            sus4Button.setEnabled(true);
            sevenButton.setEnabled(true);
            min7Button.setEnabled(true);
            M7Button.setEnabled(true);
            M6Button.setEnabled(true);
            min6Button.setEnabled(true);
            sevensharp5Button.setEnabled(true);
            sevenflat5Button.setEnabled(true);
            M7flat3Button.setEnabled(true);
            m7b5Button.setEnabled(true);
            sevensus4Button.setEnabled(true);
            m7sharp5Button.setEnabled(true);
            nineButton.setEnabled(true);
            min9Button.setEnabled(true);
            M9Button.setEnabled(true);
            ninesharp5Button.setEnabled(true);
            nineb5Button.setEnabled(true);
            sevenb9Button.setEnabled(true);
            nineplusButton.setEnabled(false);
            sixadd9Button.setEnabled(false);
            elevenButton.setEnabled(false);
            elevenplusButton.setEnabled(false);
            thirteenButton.setEnabled(false);
            thirteenb9Button.setEnabled(false);
            thirteenb9b5Button.setEnabled(false);
        }

        if (lvl.equals("Level: 23")) {
            level = 23;
            majButton.setEnabled(true);
            minButton.setEnabled(true);
            dimButton.setEnabled(true);
            augButton.setEnabled(true);
            sus2Button.setEnabled(true);
            sus4Button.setEnabled(true);
            sevenButton.setEnabled(true);
            min7Button.setEnabled(true);
            M7Button.setEnabled(true);
            M6Button.setEnabled(true);
            min6Button.setEnabled(true);
            sevensharp5Button.setEnabled(true);
            sevenflat5Button.setEnabled(true);
            M7flat3Button.setEnabled(true);
            m7b5Button.setEnabled(true);
            sevensus4Button.setEnabled(true);
            m7sharp5Button.setEnabled(true);
            nineButton.setEnabled(true);
            min9Button.setEnabled(true);
            M9Button.setEnabled(true);
            ninesharp5Button.setEnabled(true);
            nineb5Button.setEnabled(true);
            sevenb9Button.setEnabled(true);
            nineplusButton.setEnabled(true);
            sixadd9Button.setEnabled(false);
            elevenButton.setEnabled(false);
            elevenplusButton.setEnabled(false);
            thirteenButton.setEnabled(false);
            thirteenb9Button.setEnabled(false);
            thirteenb9b5Button.setEnabled(false);
        }

        if (lvl.equals("Level: 24")) {
            level = 24;
            majButton.setEnabled(true);
            minButton.setEnabled(true);
            dimButton.setEnabled(true);
            augButton.setEnabled(true);
            sus2Button.setEnabled(true);
            sus4Button.setEnabled(true);
            sevenButton.setEnabled(true);
            min7Button.setEnabled(true);
            M7Button.setEnabled(true);
            M6Button.setEnabled(true);
            min6Button.setEnabled(true);
            sevensharp5Button.setEnabled(true);
            sevenflat5Button.setEnabled(true);
            M7flat3Button.setEnabled(true);
            m7b5Button.setEnabled(true);
            sevensus4Button.setEnabled(true);
            m7sharp5Button.setEnabled(true);
            nineButton.setEnabled(true);
            min9Button.setEnabled(true);
            M9Button.setEnabled(true);
            ninesharp5Button.setEnabled(true);
            nineb5Button.setEnabled(true);
            sevenb9Button.setEnabled(true);
            nineplusButton.setEnabled(true);
            sixadd9Button.setEnabled(true);
            elevenButton.setEnabled(false);
            elevenplusButton.setEnabled(false);
            thirteenButton.setEnabled(false);
            thirteenb9Button.setEnabled(false);
            thirteenb9b5Button.setEnabled(false);
        }

        if (lvl.equals("Level: 25")) {
            level = 25;
            majButton.setEnabled(true);
            minButton.setEnabled(true);
            dimButton.setEnabled(true);
            augButton.setEnabled(true);
            sus2Button.setEnabled(true);
            sus4Button.setEnabled(true);
            sevenButton.setEnabled(true);
            min7Button.setEnabled(true);
            M7Button.setEnabled(true);
            M6Button.setEnabled(true);
            min6Button.setEnabled(true);
            sevensharp5Button.setEnabled(true);
            sevenflat5Button.setEnabled(true);
            M7flat3Button.setEnabled(true);
            m7b5Button.setEnabled(true);
            sevensus4Button.setEnabled(true);
            m7sharp5Button.setEnabled(true);
            nineButton.setEnabled(true);
            min9Button.setEnabled(true);
            M9Button.setEnabled(true);
            ninesharp5Button.setEnabled(true);
            nineb5Button.setEnabled(true);
            sevenb9Button.setEnabled(true);
            nineplusButton.setEnabled(true);
            sixadd9Button.setEnabled(true);
            elevenButton.setEnabled(true);
            elevenplusButton.setEnabled(false);
            thirteenButton.setEnabled(false);
            thirteenb9Button.setEnabled(false);
            thirteenb9b5Button.setEnabled(false);
        }

        if (lvl.equals("Level: 26")) {
            level = 26;
            majButton.setEnabled(true);
            minButton.setEnabled(true);
            dimButton.setEnabled(true);
            augButton.setEnabled(true);
            sus2Button.setEnabled(true);
            sus4Button.setEnabled(true);
            sevenButton.setEnabled(true);
            min7Button.setEnabled(true);
            M7Button.setEnabled(true);
            M6Button.setEnabled(true);
            min6Button.setEnabled(true);
            sevensharp5Button.setEnabled(true);
            sevenflat5Button.setEnabled(true);
            M7flat3Button.setEnabled(true);
            m7b5Button.setEnabled(true);
            sevensus4Button.setEnabled(true);
            m7sharp5Button.setEnabled(true);
            nineButton.setEnabled(true);
            min9Button.setEnabled(true);
            M9Button.setEnabled(true);
            ninesharp5Button.setEnabled(true);
            nineb5Button.setEnabled(true);
            sevenb9Button.setEnabled(true);
            nineplusButton.setEnabled(true);
            sixadd9Button.setEnabled(true);
            elevenButton.setEnabled(true);
            elevenplusButton.setEnabled(true);
            thirteenButton.setEnabled(false);
            thirteenb9Button.setEnabled(false);
            thirteenb9b5Button.setEnabled(false);
        }

        if (lvl.equals("Level: 27")) {
            level = 27;
            majButton.setEnabled(true);
            minButton.setEnabled(true);
            dimButton.setEnabled(true);
            augButton.setEnabled(true);
            sus2Button.setEnabled(true);
            sus4Button.setEnabled(true);
            sevenButton.setEnabled(true);
            min7Button.setEnabled(true);
            M7Button.setEnabled(true);
            M6Button.setEnabled(true);
            min6Button.setEnabled(true);
            sevensharp5Button.setEnabled(true);
            sevenflat5Button.setEnabled(true);
            M7flat3Button.setEnabled(true);
            m7b5Button.setEnabled(true);
            sevensus4Button.setEnabled(true);
            m7sharp5Button.setEnabled(true);
            nineButton.setEnabled(true);
            min9Button.setEnabled(true);
            M9Button.setEnabled(true);
            ninesharp5Button.setEnabled(true);
            nineb5Button.setEnabled(true);
            sevenb9Button.setEnabled(true);
            nineplusButton.setEnabled(true);
            sixadd9Button.setEnabled(true);
            elevenButton.setEnabled(true);
            elevenplusButton.setEnabled(true);
            thirteenButton.setEnabled(true);
            thirteenb9Button.setEnabled(false);
            thirteenb9b5Button.setEnabled(false);
        }

        if (lvl.equals("Level: 28")) {
            level = 28;
            majButton.setEnabled(true);
            minButton.setEnabled(true);
            dimButton.setEnabled(true);
            augButton.setEnabled(true);
            sus2Button.setEnabled(true);
            sus4Button.setEnabled(true);
            sevenButton.setEnabled(true);
            min7Button.setEnabled(true);
            M7Button.setEnabled(true);
            M6Button.setEnabled(true);
            min6Button.setEnabled(true);
            sevensharp5Button.setEnabled(true);
            sevenflat5Button.setEnabled(true);
            M7flat3Button.setEnabled(true);
            m7b5Button.setEnabled(true);
            sevensus4Button.setEnabled(true);
            m7sharp5Button.setEnabled(true);
            nineButton.setEnabled(true);
            min9Button.setEnabled(true);
            M9Button.setEnabled(true);
            ninesharp5Button.setEnabled(true);
            nineb5Button.setEnabled(true);
            sevenb9Button.setEnabled(true);
            nineplusButton.setEnabled(true);
            sixadd9Button.setEnabled(true);
            elevenButton.setEnabled(true);
            elevenplusButton.setEnabled(true);
            thirteenButton.setEnabled(true);
            thirteenb9Button.setEnabled(true);
            thirteenb9b5Button.setEnabled(false);
        }

        if (lvl.equals("Level: 29")) {
            level = 29;
            majButton.setEnabled(true);
            minButton.setEnabled(true);
            dimButton.setEnabled(true);
            augButton.setEnabled(true);
            sus2Button.setEnabled(true);
            sus4Button.setEnabled(true);
            sevenButton.setEnabled(true);
            min7Button.setEnabled(true);
            M7Button.setEnabled(true);
            M6Button.setEnabled(true);
            min6Button.setEnabled(true);
            sevensharp5Button.setEnabled(true);
            sevenflat5Button.setEnabled(true);
            M7flat3Button.setEnabled(true);
            m7b5Button.setEnabled(true);
            sevensus4Button.setEnabled(true);
            m7sharp5Button.setEnabled(true);
            nineButton.setEnabled(true);
            min9Button.setEnabled(true);
            M9Button.setEnabled(true);
            ninesharp5Button.setEnabled(true);
            nineb5Button.setEnabled(true);
            sevenb9Button.setEnabled(true);
            nineplusButton.setEnabled(true);
            sixadd9Button.setEnabled(true);
            elevenButton.setEnabled(true);
            elevenplusButton.setEnabled(true);
            thirteenButton.setEnabled(true);
            thirteenb9Button.setEnabled(true);
            thirteenb9b5Button.setEnabled(true);
        }


        currentLevel = lvl;
        updateProgress();
        levelChanged = false;


    }


    private void resetColor() {
        Button majButton = (Button) findViewById(R.id.majorButton);
        Button minButton = (Button) findViewById(R.id.minorButton);
        Button dimButton = (Button) findViewById(R.id.diminishedButton);
        Button augButton = (Button) findViewById(R.id.augmentedButton);
        Button sus2Button = (Button) findViewById(R.id.sus2Button);
        Button sus4Button = (Button) findViewById(R.id.sus4Button);
        Button sevenButton = (Button) findViewById(R.id.sevenButton);
        Button min7Button = (Button) findViewById(R.id.minor7Button);
        Button M7Button = (Button) findViewById(R.id.major7Button);
        Button M6Button = (Button) findViewById(R.id.major6Button);
        Button min6Button = (Button) findViewById(R.id.minor6Button);
        Button sevensharp5Button = (Button) findViewById(R.id.sevenSharp5Button);
        Button sevenflat5Button = (Button) findViewById(R.id.sevenFlat5Button);
        Button M7flat3Button = (Button) findViewById(R.id.major7Flat3Button);
        Button m7b5Button = (Button) findViewById(R.id.minor7Flat5Button);
        Button sevensus4Button = (Button) findViewById(R.id.sevenSus4Button);
        Button m7sharp5Button = (Button) findViewById(R.id.minor7Sharp5Button);
        Button nineButton = (Button) findViewById(R.id.nineButton);
        Button min9Button = (Button) findViewById(R.id.minor9Button);
        Button M9Button = (Button) findViewById(R.id.major9Button);
        Button ninesharp5Button = (Button) findViewById(R.id.nineSharp5Button);
        Button nineb5Button = (Button) findViewById(R.id.nineFlat5Button);
        Button sevenb9Button = (Button) findViewById(R.id.sevenFlat9Button);
        Button nineplusButton = (Button) findViewById(R.id.ninePlusButton);
        Button sixadd9Button = (Button) findViewById(R.id.sixAdd9Button);
        Button elevenButton = (Button) findViewById(R.id.elevenButton);
        Button elevenplusButton = (Button) findViewById(R.id.elevenPlusButton);
        Button thirteenButton = (Button) findViewById(R.id.thirteenButton);
        Button thirteenb9Button = (Button) findViewById(R.id.thirteenFlat9Button);
        Button thirteenb9b5Button = (Button) findViewById(R.id.thirteenFlat9Flat5Button);

        if (level == 1) {
            majButton.setTextColor(Color.parseColor("#FF007AFF"));
            minButton.setTextColor(Color.parseColor("#FF007AFF"));
            dimButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            augButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus2Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
        }

        if (level == 2) {
            majButton.setTextColor(Color.parseColor("#FF007AFF"));
            minButton.setTextColor(Color.parseColor("#FF007AFF"));
            dimButton.setTextColor(Color.parseColor("#FF007AFF"));
            augButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus2Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
        }

        if (level == 3) {
            majButton.setTextColor(Color.parseColor("#FF007AFF"));
            minButton.setTextColor(Color.parseColor("#FF007AFF"));
            dimButton.setTextColor(Color.parseColor("#FF007AFF"));
            augButton.setTextColor(Color.parseColor("#FF007AFF"));
            sus2Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
        }
        if (level == 4) {
            majButton.setTextColor(Color.parseColor("#FF007AFF"));
            minButton.setTextColor(Color.parseColor("#FF007AFF"));
            dimButton.setTextColor(Color.parseColor("#FF007AFF"));
            augButton.setTextColor(Color.parseColor("#FF007AFF"));
            sus2Button.setTextColor(Color.parseColor("#FF007AFF"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
        }
        if (level == 5) {
            majButton.setTextColor(Color.parseColor("#FF007AFF"));
            minButton.setTextColor(Color.parseColor("#FF007AFF"));
            dimButton.setTextColor(Color.parseColor("#FF007AFF"));
            augButton.setTextColor(Color.parseColor("#FF007AFF"));
            sus2Button.setTextColor(Color.parseColor("#FF007AFF"));
            sus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
        }
        if (level == 6) {
            majButton.setTextColor(Color.parseColor("#FF007AFF"));
            minButton.setTextColor(Color.parseColor("#FF007AFF"));
            dimButton.setTextColor(Color.parseColor("#FF007AFF"));
            augButton.setTextColor(Color.parseColor("#FF007AFF"));
            sus2Button.setTextColor(Color.parseColor("#FF007AFF"));
            sus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenButton.setTextColor(Color.parseColor("#FF007AFF"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
        }
        if (level == 7) {
            majButton.setTextColor(Color.parseColor("#FF007AFF"));
            minButton.setTextColor(Color.parseColor("#FF007AFF"));
            dimButton.setTextColor(Color.parseColor("#FF007AFF"));
            augButton.setTextColor(Color.parseColor("#FF007AFF"));
            sus2Button.setTextColor(Color.parseColor("#FF007AFF"));
            sus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenButton.setTextColor(Color.parseColor("#FF007AFF"));
            min7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
        }
        if (level == 8) {
            majButton.setTextColor(Color.parseColor("#FF007AFF"));
            minButton.setTextColor(Color.parseColor("#FF007AFF"));
            dimButton.setTextColor(Color.parseColor("#FF007AFF"));
            augButton.setTextColor(Color.parseColor("#FF007AFF"));
            sus2Button.setTextColor(Color.parseColor("#FF007AFF"));
            sus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenButton.setTextColor(Color.parseColor("#FF007AFF"));
            min7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
        }
        if (level == 9) {
            majButton.setTextColor(Color.parseColor("#FF007AFF"));
            minButton.setTextColor(Color.parseColor("#FF007AFF"));
            dimButton.setTextColor(Color.parseColor("#FF007AFF"));
            augButton.setTextColor(Color.parseColor("#FF007AFF"));
            sus2Button.setTextColor(Color.parseColor("#FF007AFF"));
            sus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenButton.setTextColor(Color.parseColor("#FF007AFF"));
            min7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M6Button.setTextColor(Color.parseColor("#FF007AFF"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
        }
        if (level == 10) {
            majButton.setTextColor(Color.parseColor("#FF007AFF"));
            minButton.setTextColor(Color.parseColor("#FF007AFF"));
            dimButton.setTextColor(Color.parseColor("#FF007AFF"));
            augButton.setTextColor(Color.parseColor("#FF007AFF"));
            sus2Button.setTextColor(Color.parseColor("#FF007AFF"));
            sus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenButton.setTextColor(Color.parseColor("#FF007AFF"));
            min7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M6Button.setTextColor(Color.parseColor("#FF007AFF"));
            min6Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
        }
        if (level == 11) {
            majButton.setTextColor(Color.parseColor("#FF007AFF"));
            minButton.setTextColor(Color.parseColor("#FF007AFF"));
            dimButton.setTextColor(Color.parseColor("#FF007AFF"));
            augButton.setTextColor(Color.parseColor("#FF007AFF"));
            sus2Button.setTextColor(Color.parseColor("#FF007AFF"));
            sus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenButton.setTextColor(Color.parseColor("#FF007AFF"));
            min7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M6Button.setTextColor(Color.parseColor("#FF007AFF"));
            min6Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
        }
        if (level == 12) {
            majButton.setTextColor(Color.parseColor("#FF007AFF"));
            minButton.setTextColor(Color.parseColor("#FF007AFF"));
            dimButton.setTextColor(Color.parseColor("#FF007AFF"));
            augButton.setTextColor(Color.parseColor("#FF007AFF"));
            sus2Button.setTextColor(Color.parseColor("#FF007AFF"));
            sus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenButton.setTextColor(Color.parseColor("#FF007AFF"));
            min7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M6Button.setTextColor(Color.parseColor("#FF007AFF"));
            min6Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenflat5Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
        }
        if (level == 13) {
            majButton.setTextColor(Color.parseColor("#FF007AFF"));
            minButton.setTextColor(Color.parseColor("#FF007AFF"));
            dimButton.setTextColor(Color.parseColor("#FF007AFF"));
            augButton.setTextColor(Color.parseColor("#FF007AFF"));
            sus2Button.setTextColor(Color.parseColor("#FF007AFF"));
            sus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenButton.setTextColor(Color.parseColor("#FF007AFF"));
            min7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M6Button.setTextColor(Color.parseColor("#FF007AFF"));
            min6Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenflat5Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7flat3Button.setTextColor(Color.parseColor("#FF007AFF"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
        }
        if (level == 14) {
            majButton.setTextColor(Color.parseColor("#FF007AFF"));
            minButton.setTextColor(Color.parseColor("#FF007AFF"));
            dimButton.setTextColor(Color.parseColor("#FF007AFF"));
            augButton.setTextColor(Color.parseColor("#FF007AFF"));
            sus2Button.setTextColor(Color.parseColor("#FF007AFF"));
            sus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenButton.setTextColor(Color.parseColor("#FF007AFF"));
            min7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M6Button.setTextColor(Color.parseColor("#FF007AFF"));
            min6Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenflat5Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7flat3Button.setTextColor(Color.parseColor("#FF007AFF"));
            m7b5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
        }
        if (level == 15) {
            majButton.setTextColor(Color.parseColor("#FF007AFF"));
            minButton.setTextColor(Color.parseColor("#FF007AFF"));
            dimButton.setTextColor(Color.parseColor("#FF007AFF"));
            augButton.setTextColor(Color.parseColor("#FF007AFF"));
            sus2Button.setTextColor(Color.parseColor("#FF007AFF"));
            sus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenButton.setTextColor(Color.parseColor("#FF007AFF"));
            min7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M6Button.setTextColor(Color.parseColor("#FF007AFF"));
            min6Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenflat5Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7flat3Button.setTextColor(Color.parseColor("#FF007AFF"));
            m7b5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
        }
        if (level == 16) {
            majButton.setTextColor(Color.parseColor("#FF007AFF"));
            minButton.setTextColor(Color.parseColor("#FF007AFF"));
            dimButton.setTextColor(Color.parseColor("#FF007AFF"));
            augButton.setTextColor(Color.parseColor("#FF007AFF"));
            sus2Button.setTextColor(Color.parseColor("#FF007AFF"));
            sus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenButton.setTextColor(Color.parseColor("#FF007AFF"));
            min7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M6Button.setTextColor(Color.parseColor("#FF007AFF"));
            min6Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenflat5Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7flat3Button.setTextColor(Color.parseColor("#FF007AFF"));
            m7b5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            m7sharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
        }
        if (level == 17) {
            majButton.setTextColor(Color.parseColor("#FF007AFF"));
            minButton.setTextColor(Color.parseColor("#FF007AFF"));
            dimButton.setTextColor(Color.parseColor("#FF007AFF"));
            augButton.setTextColor(Color.parseColor("#FF007AFF"));
            sus2Button.setTextColor(Color.parseColor("#FF007AFF"));
            sus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenButton.setTextColor(Color.parseColor("#FF007AFF"));
            min7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M6Button.setTextColor(Color.parseColor("#FF007AFF"));
            min6Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenflat5Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7flat3Button.setTextColor(Color.parseColor("#FF007AFF"));
            m7b5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            m7sharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            nineButton.setTextColor(Color.parseColor("#FF007AFF"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
        }
        if (level == 18) {
            majButton.setTextColor(Color.parseColor("#FF007AFF"));
            minButton.setTextColor(Color.parseColor("#FF007AFF"));
            dimButton.setTextColor(Color.parseColor("#FF007AFF"));
            augButton.setTextColor(Color.parseColor("#FF007AFF"));
            sus2Button.setTextColor(Color.parseColor("#FF007AFF"));
            sus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenButton.setTextColor(Color.parseColor("#FF007AFF"));
            min7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M6Button.setTextColor(Color.parseColor("#FF007AFF"));
            min6Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenflat5Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7flat3Button.setTextColor(Color.parseColor("#FF007AFF"));
            m7b5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            m7sharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            nineButton.setTextColor(Color.parseColor("#FF007AFF"));
            min9Button.setTextColor(Color.parseColor("#FF007AFF"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
        }
        if (level == 19) {
            majButton.setTextColor(Color.parseColor("#FF007AFF"));
            minButton.setTextColor(Color.parseColor("#FF007AFF"));
            dimButton.setTextColor(Color.parseColor("#FF007AFF"));
            augButton.setTextColor(Color.parseColor("#FF007AFF"));
            sus2Button.setTextColor(Color.parseColor("#FF007AFF"));
            sus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenButton.setTextColor(Color.parseColor("#FF007AFF"));
            min7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M6Button.setTextColor(Color.parseColor("#FF007AFF"));
            min6Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenflat5Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7flat3Button.setTextColor(Color.parseColor("#FF007AFF"));
            m7b5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            m7sharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            nineButton.setTextColor(Color.parseColor("#FF007AFF"));
            min9Button.setTextColor(Color.parseColor("#FF007AFF"));
            M9Button.setTextColor(Color.parseColor("#FF007AFF"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
        }
        if (level == 20) {
            majButton.setTextColor(Color.parseColor("#FF007AFF"));
            minButton.setTextColor(Color.parseColor("#FF007AFF"));
            dimButton.setTextColor(Color.parseColor("#FF007AFF"));
            augButton.setTextColor(Color.parseColor("#FF007AFF"));
            sus2Button.setTextColor(Color.parseColor("#FF007AFF"));
            sus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenButton.setTextColor(Color.parseColor("#FF007AFF"));
            min7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M6Button.setTextColor(Color.parseColor("#FF007AFF"));
            min6Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenflat5Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7flat3Button.setTextColor(Color.parseColor("#FF007AFF"));
            m7b5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            m7sharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            nineButton.setTextColor(Color.parseColor("#FF007AFF"));
            min9Button.setTextColor(Color.parseColor("#FF007AFF"));
            M9Button.setTextColor(Color.parseColor("#FF007AFF"));
            ninesharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
        }
        if (level == 21) {
            majButton.setTextColor(Color.parseColor("#FF007AFF"));
            minButton.setTextColor(Color.parseColor("#FF007AFF"));
            dimButton.setTextColor(Color.parseColor("#FF007AFF"));
            augButton.setTextColor(Color.parseColor("#FF007AFF"));
            sus2Button.setTextColor(Color.parseColor("#FF007AFF"));
            sus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenButton.setTextColor(Color.parseColor("#FF007AFF"));
            min7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M6Button.setTextColor(Color.parseColor("#FF007AFF"));
            min6Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenflat5Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7flat3Button.setTextColor(Color.parseColor("#FF007AFF"));
            m7b5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            m7sharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            nineButton.setTextColor(Color.parseColor("#FF007AFF"));
            min9Button.setTextColor(Color.parseColor("#FF007AFF"));
            M9Button.setTextColor(Color.parseColor("#FF007AFF"));
            ninesharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            nineb5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
        }
        if (level == 22) {
            majButton.setTextColor(Color.parseColor("#FF007AFF"));
            minButton.setTextColor(Color.parseColor("#FF007AFF"));
            dimButton.setTextColor(Color.parseColor("#FF007AFF"));
            augButton.setTextColor(Color.parseColor("#FF007AFF"));
            sus2Button.setTextColor(Color.parseColor("#FF007AFF"));
            sus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenButton.setTextColor(Color.parseColor("#FF007AFF"));
            min7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M6Button.setTextColor(Color.parseColor("#FF007AFF"));
            min6Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenflat5Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7flat3Button.setTextColor(Color.parseColor("#FF007AFF"));
            m7b5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            m7sharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            nineButton.setTextColor(Color.parseColor("#FF007AFF"));
            min9Button.setTextColor(Color.parseColor("#FF007AFF"));
            M9Button.setTextColor(Color.parseColor("#FF007AFF"));
            ninesharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            nineb5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenb9Button.setTextColor(Color.parseColor("#FF007AFF"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
        }
        if (level == 23) {
            majButton.setTextColor(Color.parseColor("#FF007AFF"));
            minButton.setTextColor(Color.parseColor("#FF007AFF"));
            dimButton.setTextColor(Color.parseColor("#FF007AFF"));
            augButton.setTextColor(Color.parseColor("#FF007AFF"));
            sus2Button.setTextColor(Color.parseColor("#FF007AFF"));
            sus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenButton.setTextColor(Color.parseColor("#FF007AFF"));
            min7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M6Button.setTextColor(Color.parseColor("#FF007AFF"));
            min6Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenflat5Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7flat3Button.setTextColor(Color.parseColor("#FF007AFF"));
            m7b5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            m7sharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            nineButton.setTextColor(Color.parseColor("#FF007AFF"));
            min9Button.setTextColor(Color.parseColor("#FF007AFF"));
            M9Button.setTextColor(Color.parseColor("#FF007AFF"));
            ninesharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            nineb5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenb9Button.setTextColor(Color.parseColor("#FF007AFF"));
            nineplusButton.setTextColor(Color.parseColor("#FF007AFF"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
        }
        if (level == 24) {
            majButton.setTextColor(Color.parseColor("#FF007AFF"));
            minButton.setTextColor(Color.parseColor("#FF007AFF"));
            dimButton.setTextColor(Color.parseColor("#FF007AFF"));
            augButton.setTextColor(Color.parseColor("#FF007AFF"));
            sus2Button.setTextColor(Color.parseColor("#FF007AFF"));
            sus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenButton.setTextColor(Color.parseColor("#FF007AFF"));
            min7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M6Button.setTextColor(Color.parseColor("#FF007AFF"));
            min6Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenflat5Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7flat3Button.setTextColor(Color.parseColor("#FF007AFF"));
            m7b5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            m7sharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            nineButton.setTextColor(Color.parseColor("#FF007AFF"));
            min9Button.setTextColor(Color.parseColor("#FF007AFF"));
            M9Button.setTextColor(Color.parseColor("#FF007AFF"));
            ninesharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            nineb5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenb9Button.setTextColor(Color.parseColor("#FF007AFF"));
            nineplusButton.setTextColor(Color.parseColor("#FF007AFF"));
            sixadd9Button.setTextColor(Color.parseColor("#FF007AFF"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
        }
        if (level == 25) {
            majButton.setTextColor(Color.parseColor("#FF007AFF"));
            minButton.setTextColor(Color.parseColor("#FF007AFF"));
            dimButton.setTextColor(Color.parseColor("#FF007AFF"));
            augButton.setTextColor(Color.parseColor("#FF007AFF"));
            sus2Button.setTextColor(Color.parseColor("#FF007AFF"));
            sus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenButton.setTextColor(Color.parseColor("#FF007AFF"));
            min7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M6Button.setTextColor(Color.parseColor("#FF007AFF"));
            min6Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenflat5Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7flat3Button.setTextColor(Color.parseColor("#FF007AFF"));
            m7b5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            m7sharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            nineButton.setTextColor(Color.parseColor("#FF007AFF"));
            min9Button.setTextColor(Color.parseColor("#FF007AFF"));
            M9Button.setTextColor(Color.parseColor("#FF007AFF"));
            ninesharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            nineb5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenb9Button.setTextColor(Color.parseColor("#FF007AFF"));
            nineplusButton.setTextColor(Color.parseColor("#FF007AFF"));
            sixadd9Button.setTextColor(Color.parseColor("#FF007AFF"));
            elevenButton.setTextColor(Color.parseColor("#FF007AFF"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
        }
        if (level == 26) {
            majButton.setTextColor(Color.parseColor("#FF007AFF"));
            minButton.setTextColor(Color.parseColor("#FF007AFF"));
            dimButton.setTextColor(Color.parseColor("#FF007AFF"));
            augButton.setTextColor(Color.parseColor("#FF007AFF"));
            sus2Button.setTextColor(Color.parseColor("#FF007AFF"));
            sus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenButton.setTextColor(Color.parseColor("#FF007AFF"));
            min7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M6Button.setTextColor(Color.parseColor("#FF007AFF"));
            min6Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenflat5Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7flat3Button.setTextColor(Color.parseColor("#FF007AFF"));
            m7b5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            m7sharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            nineButton.setTextColor(Color.parseColor("#FF007AFF"));
            min9Button.setTextColor(Color.parseColor("#FF007AFF"));
            M9Button.setTextColor(Color.parseColor("#FF007AFF"));
            ninesharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            nineb5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenb9Button.setTextColor(Color.parseColor("#FF007AFF"));
            nineplusButton.setTextColor(Color.parseColor("#FF007AFF"));
            sixadd9Button.setTextColor(Color.parseColor("#FF007AFF"));
            elevenButton.setTextColor(Color.parseColor("#FF007AFF"));
            elevenplusButton.setTextColor(Color.parseColor("#FF007AFF"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
        }
        if (level == 27) {
            majButton.setTextColor(Color.parseColor("#FF007AFF"));
            minButton.setTextColor(Color.parseColor("#FF007AFF"));
            dimButton.setTextColor(Color.parseColor("#FF007AFF"));
            augButton.setTextColor(Color.parseColor("#FF007AFF"));
            sus2Button.setTextColor(Color.parseColor("#FF007AFF"));
            sus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenButton.setTextColor(Color.parseColor("#FF007AFF"));
            min7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M6Button.setTextColor(Color.parseColor("#FF007AFF"));
            min6Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenflat5Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7flat3Button.setTextColor(Color.parseColor("#FF007AFF"));
            m7b5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            m7sharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            nineButton.setTextColor(Color.parseColor("#FF007AFF"));
            min9Button.setTextColor(Color.parseColor("#FF007AFF"));
            M9Button.setTextColor(Color.parseColor("#FF007AFF"));
            ninesharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            nineb5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenb9Button.setTextColor(Color.parseColor("#FF007AFF"));
            nineplusButton.setTextColor(Color.parseColor("#FF007AFF"));
            sixadd9Button.setTextColor(Color.parseColor("#FF007AFF"));
            elevenButton.setTextColor(Color.parseColor("#FF007AFF"));
            elevenplusButton.setTextColor(Color.parseColor("#FF007AFF"));
            thirteenButton.setTextColor(Color.parseColor("#FF007AFF"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
        }
        if (level == 28) {
            majButton.setTextColor(Color.parseColor("#FF007AFF"));
            minButton.setTextColor(Color.parseColor("#FF007AFF"));
            dimButton.setTextColor(Color.parseColor("#FF007AFF"));
            augButton.setTextColor(Color.parseColor("#FF007AFF"));
            sus2Button.setTextColor(Color.parseColor("#FF007AFF"));
            sus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenButton.setTextColor(Color.parseColor("#FF007AFF"));
            min7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M6Button.setTextColor(Color.parseColor("#FF007AFF"));
            min6Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenflat5Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7flat3Button.setTextColor(Color.parseColor("#FF007AFF"));
            m7b5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            m7sharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            nineButton.setTextColor(Color.parseColor("#FF007AFF"));
            min9Button.setTextColor(Color.parseColor("#FF007AFF"));
            M9Button.setTextColor(Color.parseColor("#FF007AFF"));
            ninesharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            nineb5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenb9Button.setTextColor(Color.parseColor("#FF007AFF"));
            nineplusButton.setTextColor(Color.parseColor("#FF007AFF"));
            sixadd9Button.setTextColor(Color.parseColor("#FF007AFF"));
            elevenButton.setTextColor(Color.parseColor("#FF007AFF"));
            elevenplusButton.setTextColor(Color.parseColor("#FF007AFF"));
            thirteenButton.setTextColor(Color.parseColor("#FF007AFF"));
            thirteenb9Button.setTextColor(Color.parseColor("#FF007AFF"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
        }
        if (level == 29) {
            majButton.setTextColor(Color.parseColor("#FF007AFF"));
            minButton.setTextColor(Color.parseColor("#FF007AFF"));
            dimButton.setTextColor(Color.parseColor("#FF007AFF"));
            augButton.setTextColor(Color.parseColor("#FF007AFF"));
            sus2Button.setTextColor(Color.parseColor("#FF007AFF"));
            sus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenButton.setTextColor(Color.parseColor("#FF007AFF"));
            min7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7Button.setTextColor(Color.parseColor("#FF007AFF"));
            M6Button.setTextColor(Color.parseColor("#FF007AFF"));
            min6Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenflat5Button.setTextColor(Color.parseColor("#FF007AFF"));
            M7flat3Button.setTextColor(Color.parseColor("#FF007AFF"));
            m7b5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevensus4Button.setTextColor(Color.parseColor("#FF007AFF"));
            m7sharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            nineButton.setTextColor(Color.parseColor("#FF007AFF"));
            min9Button.setTextColor(Color.parseColor("#FF007AFF"));
            M9Button.setTextColor(Color.parseColor("#FF007AFF"));
            ninesharp5Button.setTextColor(Color.parseColor("#FF007AFF"));
            nineb5Button.setTextColor(Color.parseColor("#FF007AFF"));
            sevenb9Button.setTextColor(Color.parseColor("#FF007AFF"));
            nineplusButton.setTextColor(Color.parseColor("#FF007AFF"));
            sixadd9Button.setTextColor(Color.parseColor("#FF007AFF"));
            elevenButton.setTextColor(Color.parseColor("#FF007AFF"));
            elevenplusButton.setTextColor(Color.parseColor("#FF007AFF"));
            thirteenButton.setTextColor(Color.parseColor("#FF007AFF"));
            thirteenb9Button.setTextColor(Color.parseColor("#FF007AFF"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#FF007AFF"));
        }

    }


    private void displayAnswer() {
        TextView answerLabel = (TextView) findViewById(R.id.answerLabel);
        Button majButton = (Button) findViewById(R.id.majorButton);
        Button minButton = (Button) findViewById(R.id.minorButton);
        Button dimButton = (Button) findViewById(R.id.diminishedButton);
        Button augButton = (Button) findViewById(R.id.augmentedButton);
        Button sus2Button = (Button) findViewById(R.id.sus2Button);
        Button sus4Button = (Button) findViewById(R.id.sus4Button);
        Button sevenButton = (Button) findViewById(R.id.sevenButton);
        Button min7Button = (Button) findViewById(R.id.minor7Button);
        Button M7Button = (Button) findViewById(R.id.major7Button);
        Button M6Button = (Button) findViewById(R.id.major6Button);
        Button min6Button = (Button) findViewById(R.id.minor6Button);
        Button sevensharp5Button = (Button) findViewById(R.id.sevenSharp5Button);
        Button sevenflat5Button = (Button) findViewById(R.id.sevenFlat5Button);
        Button M7flat3Button = (Button) findViewById(R.id.major7Flat3Button);
        Button m7b5Button = (Button) findViewById(R.id.minor7Flat5Button);
        Button sevensus4Button = (Button) findViewById(R.id.sevenSus4Button);
        Button m7sharp5Button = (Button) findViewById(R.id.minor7Sharp5Button);
        Button nineButton = (Button) findViewById(R.id.nineButton);
        Button min9Button = (Button) findViewById(R.id.minor9Button);
        Button M9Button = (Button) findViewById(R.id.major9Button);
        Button ninesharp5Button = (Button) findViewById(R.id.nineSharp5Button);
        Button nineb5Button = (Button) findViewById(R.id.nineFlat5Button);
        Button sevenb9Button = (Button) findViewById(R.id.sevenFlat9Button);
        Button nineplusButton = (Button) findViewById(R.id.ninePlusButton);
        Button sixadd9Button = (Button) findViewById(R.id.sixAdd9Button);
        Button elevenButton = (Button) findViewById(R.id.elevenButton);
        Button elevenplusButton = (Button) findViewById(R.id.elevenPlusButton);
        Button thirteenButton = (Button) findViewById(R.id.thirteenButton);
        Button thirteenb9Button = (Button) findViewById(R.id.thirteenFlat9Button);
        Button thirteenb9b5Button = (Button) findViewById(R.id.thirteenFlat9Flat5Button);

        if (chord == 1) {
            answerLabel.setText("Major");

            majButton.setTextColor(Color.parseColor("#FF29C95D"));
            minButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            dimButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            augButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus2Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));

        }

        if (chord == 2) {
            answerLabel.setText("Minor");

            majButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            minButton.setTextColor(Color.parseColor("#FF29C95D"));
            dimButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            augButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus2Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));

        }

        if (chord == 3) {
            answerLabel.setText("Diminished");

            majButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            minButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            dimButton.setTextColor(Color.parseColor("#FF29C95D"));

            augButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus2Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));

        }
        if (chord == 4) {
            answerLabel.setText("Augmented");

            majButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            minButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            dimButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            augButton.setTextColor(Color.parseColor("#FF29C95D"));
            sus2Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));

        }
        if (chord == 5) {
            answerLabel.setText("Suspended 2nd");

            majButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            minButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            dimButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            augButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus2Button.setTextColor(Color.parseColor("#FF29C95D"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));

        }
        if (chord == 6) {
            answerLabel.setText("Suspended 4th");

            majButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            minButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            dimButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            augButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus2Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus4Button.setTextColor(Color.parseColor("#FF29C95D"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));

        }
        if (chord == 7) {
            answerLabel.setText("Dominant 7th");

            majButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            minButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            dimButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            augButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus2Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#FF29C95D"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));

        }
        if (chord == 8) {
            answerLabel.setText("Minor 7th");

            majButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            minButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            dimButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            augButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus2Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#FF29C95D"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));

        }
        if (chord == 9) {
            answerLabel.setText("Major 7th");

            majButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            minButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            dimButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            augButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus2Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#FF29C95D"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));

        }
        if (chord == 10) {
            answerLabel.setText("Major 6th");

            majButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            minButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            dimButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            augButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus2Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#FF29C95D"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));

        }
        if (chord == 11) {
            answerLabel.setText("Minor 6th");

            majButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            minButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            dimButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            augButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus2Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#FF29C95D"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));

        }
        if (chord == 12) {
            answerLabel.setText("Seventh #5th");

            majButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            minButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            dimButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            augButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus2Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#FF29C95D"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));

        }
        if (chord == 13) {
            answerLabel.setText("Seventh flat 5th");

            majButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            minButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            dimButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            augButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus2Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#FF29C95D"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));

        }
        if (chord == 14) {
            answerLabel.setText("Major 7th flat 3rd");

            majButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            minButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            dimButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            augButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus2Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#FF29C95D"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));

        }
        if (chord == 15) {
            answerLabel.setText("Minor 7th flat 5th");

            majButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            minButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            dimButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            augButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus2Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#FF29C95D"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));

        }
        if (chord == 16) {
            answerLabel.setText("Dominant 7th Sus 4th");

            majButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            minButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            dimButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            augButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus2Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#FF29C95D"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));

        }
        if (chord == 17) {
            answerLabel.setText("Minor Seventh #5th");

            majButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            minButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            dimButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            augButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus2Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#FF29C95D"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));

        }
        if (chord == 17) {
            answerLabel.setText("Minor Seventh #5th");

            majButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            minButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            dimButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            augButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus2Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#FF29C95D"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));

        }
        if (chord == 18) {
            answerLabel.setText("Ninth");

            majButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            minButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            dimButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            augButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus2Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#FF29C95D"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));

        }
        if (chord == 19) {
            answerLabel.setText("Minor Ninth");

            majButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            minButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            dimButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            augButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus2Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#FF29C95D"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));

        }
        if (chord == 20) {
            answerLabel.setText("Major Ninth");

            majButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            minButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            dimButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            augButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus2Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#FF29C95D"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));

        }
        if (chord == 21) {
            answerLabel.setText("Ninth Augmented 5th");

            majButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            minButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            dimButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            augButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus2Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#FF29C95D"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));

        }
        if (chord == 22) {
            answerLabel.setText("Ninth flat 5th");

            majButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            minButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            dimButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            augButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus2Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#FF29C95D"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));

        }
        if (chord == 23) {
            answerLabel.setText("Seventh flat 9th");

            majButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            minButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            dimButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            augButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus2Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#FF29C95D"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));

        }
        if (chord == 24) {
            answerLabel.setText("Augmented 9th");

            majButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            minButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            dimButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            augButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus2Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#FF29C95D"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));

        }
        if (chord == 25) {
            answerLabel.setText("Sixth add 9");

            majButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            minButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            dimButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            augButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus2Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#FF29C95D"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));

        }
        if (chord == 26) {
            answerLabel.setText("Eleventh");

            majButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            minButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            dimButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            augButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus2Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#FF29C95D"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));

        }
        if (chord == 27) {
            answerLabel.setText("Augmented Eleventh");

            majButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            minButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            dimButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            augButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus2Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#FF29C95D"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));

        }
        if (chord == 28) {
            answerLabel.setText("Thirteenth");

            majButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            minButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            dimButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            augButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus2Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#FF29C95D"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));

        }
        if (chord == 29) {
            answerLabel.setText("Thirteenth flat 9th");

            majButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            minButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            dimButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            augButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus2Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#FF29C95D"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));

        }
        if (chord == 30) {
            answerLabel.setText("13th flat 9th flat 5th");

            majButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            minButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            dimButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            augButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus2Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            min6Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenflat5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M7flat3Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7b5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevensus4Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            m7sharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            min9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            M9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            ninesharp5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineb5Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            sevenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            nineplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            sixadd9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            elevenplusButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenButton.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9Button.setTextColor(Color.parseColor("#E6AAAAAA"));
            thirteenb9b5Button.setTextColor(Color.parseColor("#FF29C95D"));

        }

        answerLabel.setVisibility(View.VISIBLE);
    }


    private void correctNotes() {

        correctNote1 = (12 * (octave - 1)) + (key);
        //major
        if (chord == 1) {
            correctNote2 = correctNote1 + 4;
            correctNote3 = correctNote1 + 7;
        }
        //minor
        if (chord == 2) {
            correctNote2 = correctNote1 + 3;
            correctNote3 = correctNote1 + 7;
        }
        //dim
        if (chord == 3) {
            correctNote2 = correctNote1 + 3;
            correctNote3 = correctNote1 + 6;
        }
        //aug
        if (chord == 4) {
            correctNote2 = correctNote1 + 4;
            correctNote3 = correctNote1 + 8;
        }
        //sus2
        if (chord == 5) {
            correctNote2 = correctNote1 + 2;
            correctNote3 = correctNote1 + 7;
        }
        //sus4
        if (chord == 6) {
            correctNote2 = correctNote1 + 5;
            correctNote3 = correctNote1 + 7;
        }
        //dom
        if (chord == 7) {
            correctNote2 = correctNote1 + 4;
            correctNote3 = correctNote1 + 7;
            correctNote4 = correctNote1 + 10;
        }
        //min7
        if (chord == 8) {
            correctNote2 = correctNote1 + 3;
            correctNote3 = correctNote1 + 7;
            correctNote4 = correctNote1 + 10;
        }
        //Maj7
        if (chord == 9) {
            correctNote2 = correctNote1 + 4;
            correctNote3 = correctNote1 + 7;
            correctNote4 = correctNote1 + 11;
        }
        //Maj6
        if (chord == 10) {
            correctNote2 = correctNote1 + 4;
            correctNote3 = correctNote1 + 7;
            correctNote4 = correctNote1 + 9;
        }
        //min6
        if (chord == 11) {
            correctNote2 = correctNote1 + 3;
            correctNote3 = correctNote1 + 7;
            correctNote4 = correctNote1 + 9;
        }
        //7#5
        if (chord == 12) {
            correctNote2 = correctNote1 + 4;
            correctNote3 = correctNote1 + 8;
            correctNote4 = correctNote1 + 10;
        }
        //7b5
        if (chord == 13) {
            correctNote2 = correctNote1 + 4;
            correctNote3 = correctNote1 + 6;
            correctNote4 = correctNote1 + 10;
        }
        //M7b3
        if (chord == 14) {
            correctNote2 = correctNote1 + 3;
            correctNote3 = correctNote1 + 7;
            correctNote4 = correctNote1 + 11;
        }
        //m7b5
        if (chord == 15) {
            correctNote2 = correctNote1 + 3;
            correctNote3 = correctNote1 + 6;
            correctNote4 = correctNote1 + 10;
        }
        //7sus4
        if (chord == 16) {
            correctNote2 = correctNote1 + 5;
            correctNote3 = correctNote1 + 7;
            correctNote4 = correctNote1 + 10;
        }
        //m7#5
        if (chord == 17) {
            correctNote2 = correctNote1 + 3;
            correctNote3 = correctNote1 + 8;
            correctNote4 = correctNote1 + 10;
        }
        //9
        if (chord == 18) {
            correctNote2 = correctNote1 + 4;
            correctNote3 = correctNote1 + 7;
            correctNote4 = correctNote1 + 10;
            correctNote5 = correctNote1 + 14;
        }
        //min9
        if (chord == 19) {
            correctNote2 = correctNote1 + 3;
            correctNote3 = correctNote1 + 7;
            correctNote4 = correctNote1 + 10;
            correctNote5 = correctNote1 + 14;
        }
        //Maj9
        if (chord == 20) {
            correctNote2 = correctNote1 + 4;
            correctNote3 = correctNote1 + 7;
            correctNote4 = correctNote1 + 11;
            correctNote5 = correctNote1 + 14;
        }
        //9#5
        if (chord == 21) {
            correctNote2 = correctNote1 + 4;
            correctNote3 = correctNote1 + 8;
            correctNote4 = correctNote1 + 10;
            correctNote5 = correctNote1 + 14;
        }
        //9b5
        if (chord == 22) {
            correctNote2 = correctNote1 + 4;
            correctNote3 = correctNote1 + 6;
            correctNote4 = correctNote1 + 10;
            correctNote5 = correctNote1 + 14;
        }
        //7b9
        if (chord == 23) {
            correctNote2 = correctNote1 + 4;
            correctNote3 = correctNote1 + 7;
            correctNote4 = correctNote1 + 10;
            correctNote5 = correctNote1 + 13;
        }
        //9+
        if (chord == 24) {
            correctNote2 = correctNote1 + 4;
            correctNote3 = correctNote1 + 7;
            correctNote4 = correctNote1 + 10;
            correctNote5 = correctNote1 + 15;
        }
        //6add9
        if (chord == 25) {
            correctNote2 = correctNote1 + 4;
            correctNote3 = correctNote1 + 7;
            correctNote4 = correctNote1 + 9;
            correctNote5 = correctNote1 + 14;
        }
        //11
        if (chord == 26) {
            correctNote2 = correctNote1 + 4;
            correctNote3 = correctNote1 + 7;
            correctNote4 = correctNote1 + 10;
            correctNote5 = correctNote1 + 14;
            correctNote6 = correctNote1 + 17;
        }
        //11+
        if (chord == 27) {
            correctNote2 = correctNote1 + 4;
            correctNote3 = correctNote1 + 7;
            correctNote4 = correctNote1 + 10;
            correctNote5 = correctNote1 + 14;
            correctNote6 = correctNote1 + 18;
        }
        //13
        if (chord == 28) {
            correctNote2 = correctNote1 + 4;
            correctNote3 = correctNote1 + 7;
            correctNote4 = correctNote1 + 10;
            correctNote5 = correctNote1 + 14;
            correctNote6 = correctNote1 + 17;
            correctNote7 = correctNote1 + 21;
        }
        //13b9
        if (chord == 29) {
            correctNote2 = correctNote1 + 4;
            correctNote3 = correctNote1 + 7;
            correctNote4 = correctNote1 + 10;
            correctNote5 = correctNote1 + 13;
            correctNote6 = correctNote1 + 17;
            correctNote7 = correctNote1 + 21;
        }
        //13b9b5
        if (chord == 30) {
            correctNote2 = correctNote1 + 4;
            correctNote3 = correctNote1 + 6;
            correctNote4 = correctNote1 + 10;
            correctNote5 = correctNote1 + 13;
            correctNote6 = correctNote1 + 17;
            correctNote7 = correctNote1 + 21;
        }


    }


    private void setNotes() {

        if (correctNote1 == 1) {
            note1 = "c1" + instrumentName;
        }
        if (correctNote1 == 2) {
            note1 = "cs1" + instrumentName;
        }
        if (correctNote1 == 3) {
            note1 = "d1" + instrumentName;
        }
        if (correctNote1 == 4) {
            note1 = "ds1" + instrumentName;
        }
        if (correctNote1 == 5) {
            note1 = "e1" + instrumentName;
        }
        if (correctNote1 == 6) {
            note1 = "f1" + instrumentName;
        }
        if (correctNote1 == 7) {
            note1 = "fs1" + instrumentName;
        }
        if (correctNote1 == 8) {
            note1 = "g1" + instrumentName;
        }
        if (correctNote1 == 9) {
            note1 = "gs1" + instrumentName;
        }
        if (correctNote1 == 10) {
            note1 = "a1" + instrumentName;
        }
        if (correctNote1 == 11) {
            note1 = "as1" + instrumentName;
        }
        if (correctNote1 == 12) {
            note1 = "b1" + instrumentName;
        }


        if (correctNote1 == 13) {
            note1 = "c2" + instrumentName;
        }
        if (correctNote1 == 14) {
            note1 = "cs2" + instrumentName;
        }
        if (correctNote1 == 15) {
            note1 = "d2" + instrumentName;
        }
        if (correctNote1 == 16) {
            note1 = "ds2" + instrumentName;
        }
        if (correctNote1 == 17) {
            note1 = "e2" + instrumentName;
        }
        if (correctNote1 == 18) {
            note1 = "f2" + instrumentName;
        }
        if (correctNote1 == 19) {
            note1 = "fs2" + instrumentName;
        }
        if (correctNote1 == 20) {
            note1 = "g2" + instrumentName;
        }
        if (correctNote1 == 21) {
            note1 = "gs2" + instrumentName;
        }
        if (correctNote1 == 22) {
            note1 = "a2" + instrumentName;
        }
        if (correctNote1 == 23) {
            note1 = "as2" + instrumentName;
        }
        if (correctNote1 == 24) {
            note1 = "b2" + instrumentName;
        }

        if (correctNote1 == 25) {
            note1 = "c3" + instrumentName;
        }
        if (correctNote1 == 26) {
            note1 = "cs3" + instrumentName;
        }
        if (correctNote1 == 27) {
            note1 = "d3" + instrumentName;
        }
        if (correctNote1 == 28) {
            note1 = "ds3" + instrumentName;
        }
        if (correctNote1 == 29) {
            note1 = "e3" + instrumentName;
        }
        if (correctNote1 == 30) {
            note1 = "f3" + instrumentName;
        }
        if (correctNote1 == 31) {
            note1 = "fs3" + instrumentName;
        }
        if (correctNote1 == 32) {
            note1 = "g3" + instrumentName;
        }
        if (correctNote1 == 33) {
            note1 = "gs3" + instrumentName;
        }
        if (correctNote1 == 34) {
            note1 = "a3" + instrumentName;
        }
        if (correctNote1 == 35) {
            note1 = "as3" + instrumentName;
        }
        if (correctNote1 == 36) {
            note1 = "b3" + instrumentName;
        }

        if (correctNote1 == 37) {
            note1 = "c4" + instrumentName;
        }
        if (correctNote1 == 38) {
            note1 = "cs4" + instrumentName;
        }
        if (correctNote1 == 39) {
            note1 = "d4" + instrumentName;
        }
        if (correctNote1 == 40) {
            note1 = "ds4" + instrumentName;
        }
        if (correctNote1 == 41) {
            note1 = "e4" + instrumentName;
        }
        if (correctNote1 == 42) {
            note1 = "f4" + instrumentName;
        }
        if (correctNote1 == 43) {
            note1 = "fs4" + instrumentName;
        }
        if (correctNote1 == 44) {
            note1 = "g4" + instrumentName;
        }
        if (correctNote1 == 45) {
            note1 = "gs4" + instrumentName;
        }
        if (correctNote1 == 46) {
            note1 = "a4" + instrumentName;
        }
        if (correctNote1 == 47) {
            note1 = "as4" + instrumentName;
        }
        if (correctNote1 == 48) {
            note1 = "b4" + instrumentName;
        }


        if (correctNote1 == 49) {
            note1 = "c5" + instrumentName;
        }
        if (correctNote1 == 50) {
            note1 = "cs5" + instrumentName;
        }
        if (correctNote1 == 51) {
            note1 = "d5" + instrumentName;
        }
        if (correctNote1 == 52) {
            note1 = "ds5" + instrumentName;
        }
        if (correctNote1 == 53) {
            note1 = "e5" + instrumentName;
        }
        if (correctNote1 == 54) {
            note1 = "f5" + instrumentName;
        }
        if (correctNote1 == 55) {
            note1 = "fs5" + instrumentName;
        }
        if (correctNote1 == 56) {
            note1 = "g5" + instrumentName;
        }
        if (correctNote1 == 57) {
            note1 = "gs5" + instrumentName;
        }
        if (correctNote1 == 58) {
            note1 = "a5" + instrumentName;
        }
        if (correctNote1 == 59) {
            note1 = "as5" + instrumentName;
        }
        if (correctNote1 == 60) {
            note1 = "b5" + instrumentName;
        }


        if (correctNote1 == 61) {
            note1 = "c6" + instrumentName;
        }
        if (correctNote1 == 62) {
            note1 = "cs6" + instrumentName;
        }
        if (correctNote1 == 63) {
            note1 = "d6" + instrumentName;
        }
        if (correctNote1 == 64) {
            note1 = "ds6" + instrumentName;
        }
        if (correctNote1 == 65) {
            note1 = "e6" + instrumentName;
        }
        if (correctNote1 == 66) {
            note1 = "f6" + instrumentName;
        }
        if (correctNote1 == 67) {
            note1 = "fs6" + instrumentName;
        }
        if (correctNote1 == 68) {
            note1 = "g6" + instrumentName;
        }
        if (correctNote1 == 69) {
            note1 = "gs6" + instrumentName;
        }
        if (correctNote1 == 70) {
            note1 = "a6" + instrumentName;
        }
        if (correctNote1 == 71) {
            note1 = "as6" + instrumentName;
        }
        if (correctNote1 == 72) {
            note1 = "b6" + instrumentName;
        }


        if (correctNote2 == 1) {
            note2 = "c1" + instrumentName;
        }
        if (correctNote2 == 2) {
            note2 = "cs1" + instrumentName;
        }
        if (correctNote2 == 3) {
            note2 = "d1" + instrumentName;
        }
        if (correctNote2 == 4) {
            note2 = "ds1" + instrumentName;
        }
        if (correctNote2 == 5) {
            note2 = "e1" + instrumentName;
        }
        if (correctNote2 == 6) {
            note2 = "f1" + instrumentName;
        }
        if (correctNote2 == 7) {
            note2 = "fs1" + instrumentName;
        }
        if (correctNote2 == 8) {
            note2 = "g1" + instrumentName;
        }
        if (correctNote2 == 9) {
            note2 = "gs1" + instrumentName;
        }
        if (correctNote2 == 10) {
            note2 = "a1" + instrumentName;
        }
        if (correctNote2 == 11) {
            note2 = "as1" + instrumentName;
        }
        if (correctNote2 == 12) {
            note2 = "b1" + instrumentName;
        }


        if (correctNote2 == 13) {
            note2 = "c2" + instrumentName;
        }
        if (correctNote2 == 14) {
            note2 = "cs2" + instrumentName;
        }
        if (correctNote2 == 15) {
            note2 = "d2" + instrumentName;
        }
        if (correctNote2 == 16) {
            note2 = "ds2" + instrumentName;
        }
        if (correctNote2 == 17) {
            note2 = "e2" + instrumentName;
        }
        if (correctNote2 == 18) {
            note2 = "f2" + instrumentName;
        }
        if (correctNote2 == 19) {
            note2 = "fs2" + instrumentName;
        }
        if (correctNote2 == 20) {
            note2 = "g2" + instrumentName;
        }
        if (correctNote2 == 21) {
            note2 = "gs2" + instrumentName;
        }
        if (correctNote2 == 22) {
            note2 = "a2" + instrumentName;
        }
        if (correctNote2 == 23) {
            note2 = "as2" + instrumentName;
        }
        if (correctNote2 == 24) {
            note2 = "b2" + instrumentName;
        }

        if (correctNote2 == 25) {
            note2 = "c3" + instrumentName;
        }
        if (correctNote2 == 26) {
            note2 = "cs3" + instrumentName;
        }
        if (correctNote2 == 27) {
            note2 = "d3" + instrumentName;
        }
        if (correctNote2 == 28) {
            note2 = "ds3" + instrumentName;
        }
        if (correctNote2 == 29) {
            note2 = "e3" + instrumentName;
        }
        if (correctNote2 == 30) {
            note2 = "f3" + instrumentName;
        }
        if (correctNote2 == 31) {
            note2 = "fs3" + instrumentName;
        }
        if (correctNote2 == 32) {
            note2 = "g3" + instrumentName;
        }
        if (correctNote2 == 33) {
            note2 = "gs3" + instrumentName;
        }
        if (correctNote2 == 34) {
            note2 = "a3" + instrumentName;
        }
        if (correctNote2 == 35) {
            note2 = "as3" + instrumentName;
        }
        if (correctNote2 == 36) {
            note2 = "b3" + instrumentName;
        }

        if (correctNote2 == 37) {
            note2 = "c4" + instrumentName;
        }
        if (correctNote2 == 38) {
            note2 = "cs4" + instrumentName;
        }
        if (correctNote2 == 39) {
            note2 = "d4" + instrumentName;
        }
        if (correctNote2 == 40) {
            note2 = "ds4" + instrumentName;
        }
        if (correctNote2 == 41) {
            note2 = "e4" + instrumentName;
        }
        if (correctNote2 == 42) {
            note2 = "f4" + instrumentName;
        }
        if (correctNote2 == 43) {
            note2 = "fs4" + instrumentName;
        }
        if (correctNote2 == 44) {
            note2 = "g4" + instrumentName;
        }
        if (correctNote2 == 45) {
            note2 = "gs4" + instrumentName;
        }
        if (correctNote2 == 46) {
            note2 = "a4" + instrumentName;
        }
        if (correctNote2 == 47) {
            note2 = "as4" + instrumentName;
        }
        if (correctNote2 == 48) {
            note2 = "b4" + instrumentName;
        }


        if (correctNote2 == 49) {
            note2 = "c5" + instrumentName;
        }
        if (correctNote2 == 50) {
            note2 = "cs5" + instrumentName;
        }
        if (correctNote2 == 51) {
            note2 = "d5" + instrumentName;
        }
        if (correctNote2 == 52) {
            note2 = "ds5" + instrumentName;
        }
        if (correctNote2 == 53) {
            note2 = "e5" + instrumentName;
        }
        if (correctNote2 == 54) {
            note2 = "f5" + instrumentName;
        }
        if (correctNote2 == 55) {
            note2 = "fs5" + instrumentName;
        }
        if (correctNote2 == 56) {
            note2 = "g5" + instrumentName;
        }
        if (correctNote2 == 57) {
            note2 = "gs5" + instrumentName;
        }
        if (correctNote2 == 58) {
            note2 = "a5" + instrumentName;
        }
        if (correctNote2 == 59) {
            note2 = "as5" + instrumentName;
        }
        if (correctNote2 == 60) {
            note2 = "b5" + instrumentName;
        }


        if (correctNote2 == 61) {
            note2 = "c6" + instrumentName;
        }
        if (correctNote2 == 62) {
            note2 = "cs6" + instrumentName;
        }
        if (correctNote2 == 63) {
            note2 = "d6" + instrumentName;
        }
        if (correctNote2 == 64) {
            note2 = "ds6" + instrumentName;
        }
        if (correctNote2 == 65) {
            note2 = "e6" + instrumentName;
        }
        if (correctNote2 == 66) {
            note2 = "f6" + instrumentName;
        }
        if (correctNote2 == 67) {
            note2 = "fs6" + instrumentName;
        }
        if (correctNote2 == 68) {
            note2 = "g6" + instrumentName;
        }
        if (correctNote2 == 69) {
            note2 = "gs6" + instrumentName;
        }
        if (correctNote2 == 70) {
            note2 = "a6" + instrumentName;
        }
        if (correctNote2 == 71) {
            note2 = "as6" + instrumentName;
        }
        if (correctNote2 == 72) {
            note2 = "b6" + instrumentName;
        }


        if (correctNote3 == 1) {
            note3 = "c1" + instrumentName;
        }
        if (correctNote3 == 2) {
            note3 = "cs1" + instrumentName;
        }
        if (correctNote3 == 3) {
            note3 = "d1" + instrumentName;
        }
        if (correctNote3 == 4) {
            note3 = "ds1" + instrumentName;
        }
        if (correctNote3 == 5) {
            note3 = "e1" + instrumentName;
        }
        if (correctNote3 == 6) {
            note3 = "f1" + instrumentName;
        }
        if (correctNote3 == 7) {
            note3 = "fs1" + instrumentName;
        }
        if (correctNote3 == 8) {
            note3 = "g1" + instrumentName;
        }
        if (correctNote3 == 9) {
            note3 = "gs1" + instrumentName;
        }
        if (correctNote3 == 10) {
            note3 = "a1" + instrumentName;
        }
        if (correctNote3 == 11) {
            note3 = "as1" + instrumentName;
        }
        if (correctNote3 == 12) {
            note3 = "b1" + instrumentName;
        }


        if (correctNote3 == 13) {
            note3 = "c2" + instrumentName;
        }
        if (correctNote3 == 14) {
            note3 = "cs2" + instrumentName;
        }
        if (correctNote3 == 15) {
            note3 = "d2" + instrumentName;
        }
        if (correctNote3 == 16) {
            note3 = "ds2" + instrumentName;
        }
        if (correctNote3 == 17) {
            note3 = "e2" + instrumentName;
        }
        if (correctNote3 == 18) {
            note3 = "f2" + instrumentName;
        }
        if (correctNote3 == 19) {
            note3 = "fs2" + instrumentName;
        }
        if (correctNote3 == 20) {
            note3 = "g2" + instrumentName;
        }
        if (correctNote3 == 21) {
            note3 = "gs2" + instrumentName;
        }
        if (correctNote3 == 22) {
            note3 = "a2" + instrumentName;
        }
        if (correctNote3 == 23) {
            note3 = "as2" + instrumentName;
        }
        if (correctNote3 == 24) {
            note3 = "b2" + instrumentName;
        }

        if (correctNote3 == 25) {
            note3 = "c3" + instrumentName;
        }
        if (correctNote3 == 26) {
            note3 = "cs3" + instrumentName;
        }
        if (correctNote3 == 27) {
            note3 = "d3" + instrumentName;
        }
        if (correctNote3 == 28) {
            note3 = "ds3" + instrumentName;
        }
        if (correctNote3 == 29) {
            note3 = "e3" + instrumentName;
        }
        if (correctNote3 == 30) {
            note3 = "f3" + instrumentName;
        }
        if (correctNote3 == 31) {
            note3 = "fs3" + instrumentName;
        }
        if (correctNote3 == 32) {
            note3 = "g3" + instrumentName;
        }
        if (correctNote3 == 33) {
            note3 = "gs3" + instrumentName;
        }
        if (correctNote3 == 34) {
            note3 = "a3" + instrumentName;
        }
        if (correctNote3 == 35) {
            note3 = "as3" + instrumentName;
        }
        if (correctNote3 == 36) {
            note3 = "b3" + instrumentName;
        }

        if (correctNote3 == 37) {
            note3 = "c4" + instrumentName;
        }
        if (correctNote3 == 38) {
            note3 = "cs4" + instrumentName;
        }
        if (correctNote3 == 39) {
            note3 = "d4" + instrumentName;
        }
        if (correctNote3 == 40) {
            note3 = "ds4" + instrumentName;
        }
        if (correctNote3 == 41) {
            note3 = "e4" + instrumentName;
        }
        if (correctNote3 == 42) {
            note3 = "f4" + instrumentName;
        }
        if (correctNote3 == 43) {
            note3 = "fs4" + instrumentName;
        }
        if (correctNote3 == 44) {
            note3 = "g4" + instrumentName;
        }
        if (correctNote3 == 45) {
            note3 = "gs4" + instrumentName;
        }
        if (correctNote3 == 46) {
            note3 = "a4" + instrumentName;
        }
        if (correctNote3 == 47) {
            note3 = "as4" + instrumentName;
        }
        if (correctNote3 == 48) {
            note3 = "b4" + instrumentName;
        }


        if (correctNote3 == 49) {
            note3 = "c5" + instrumentName;
        }
        if (correctNote3 == 50) {
            note3 = "cs5" + instrumentName;
        }
        if (correctNote3 == 51) {
            note3 = "d5" + instrumentName;
        }
        if (correctNote3 == 52) {
            note3 = "ds5" + instrumentName;
        }
        if (correctNote3 == 53) {
            note3 = "e5" + instrumentName;
        }
        if (correctNote3 == 54) {
            note3 = "f5" + instrumentName;
        }
        if (correctNote3 == 55) {
            note3 = "fs5" + instrumentName;
        }
        if (correctNote3 == 56) {
            note3 = "g5" + instrumentName;
        }
        if (correctNote3 == 57) {
            note3 = "gs5" + instrumentName;
        }
        if (correctNote3 == 58) {
            note3 = "a5" + instrumentName;
        }
        if (correctNote3 == 59) {
            note3 = "as5" + instrumentName;
        }
        if (correctNote3 == 60) {
            note3 = "b5" + instrumentName;
        }


        if (correctNote3 == 61) {
            note3 = "c6" + instrumentName;
        }
        if (correctNote3 == 62) {
            note3 = "cs6" + instrumentName;
        }
        if (correctNote3 == 63) {
            note3 = "d6" + instrumentName;
        }
        if (correctNote3 == 64) {
            note3 = "ds6" + instrumentName;
        }
        if (correctNote3 == 65) {
            note3 = "e6" + instrumentName;
        }
        if (correctNote3 == 66) {
            note3 = "f6" + instrumentName;
        }
        if (correctNote3 == 67) {
            note3 = "fs6" + instrumentName;
        }
        if (correctNote3 == 68) {
            note3 = "g6" + instrumentName;
        }
        if (correctNote3 == 69) {
            note3 = "gs6" + instrumentName;
        }
        if (correctNote3 == 70) {
            note3 = "a6" + instrumentName;
        }
        if (correctNote3 == 71) {
            note3 = "as6" + instrumentName;
        }
        if (correctNote3 == 72) {
            note3 = "b6" + instrumentName;
        }


        if (correctNote4 == 1) {
            note4 = "c1" + instrumentName;
        }
        if (correctNote4 == 2) {
            note4 = "cs1" + instrumentName;
        }
        if (correctNote4 == 3) {
            note4 = "d1" + instrumentName;
        }
        if (correctNote4 == 4) {
            note4 = "ds1" + instrumentName;
        }
        if (correctNote4 == 5) {
            note4 = "e1" + instrumentName;
        }
        if (correctNote4 == 6) {
            note4 = "f1" + instrumentName;
        }
        if (correctNote4 == 7) {
            note4 = "fs1" + instrumentName;
        }
        if (correctNote4 == 8) {
            note4 = "g1" + instrumentName;
        }
        if (correctNote4 == 9) {
            note4 = "gs1" + instrumentName;
        }
        if (correctNote4 == 10) {
            note4 = "a1" + instrumentName;
        }
        if (correctNote4 == 11) {
            note4 = "as1" + instrumentName;
        }
        if (correctNote4 == 12) {
            note4 = "b1" + instrumentName;
        }


        if (correctNote4 == 13) {
            note4 = "c2" + instrumentName;
        }
        if (correctNote4 == 14) {
            note4 = "cs2" + instrumentName;
        }
        if (correctNote4 == 15) {
            note4 = "d2" + instrumentName;
        }
        if (correctNote4 == 16) {
            note4 = "ds2" + instrumentName;
        }
        if (correctNote4 == 17) {
            note4 = "e2" + instrumentName;
        }
        if (correctNote4 == 18) {
            note4 = "f2" + instrumentName;
        }
        if (correctNote4 == 19) {
            note4 = "fs2" + instrumentName;
        }
        if (correctNote4 == 20) {
            note4 = "g2" + instrumentName;
        }
        if (correctNote4 == 21) {
            note4 = "gs2" + instrumentName;
        }
        if (correctNote4 == 22) {
            note4 = "a2" + instrumentName;
        }
        if (correctNote4 == 23) {
            note4 = "as2" + instrumentName;
        }
        if (correctNote4 == 24) {
            note4 = "b2" + instrumentName;
        }

        if (correctNote4 == 25) {
            note4 = "c3" + instrumentName;
        }
        if (correctNote4 == 26) {
            note4 = "cs3" + instrumentName;
        }
        if (correctNote4 == 27) {
            note4 = "d3" + instrumentName;
        }
        if (correctNote4 == 28) {
            note4 = "ds3" + instrumentName;
        }
        if (correctNote4 == 29) {
            note4 = "e3" + instrumentName;
        }
        if (correctNote4 == 30) {
            note4 = "f3" + instrumentName;
        }
        if (correctNote4 == 31) {
            note4 = "fs3" + instrumentName;
        }
        if (correctNote4 == 32) {
            note4 = "g3" + instrumentName;
        }
        if (correctNote4 == 33) {
            note4 = "gs3" + instrumentName;
        }
        if (correctNote4 == 34) {
            note4 = "a3" + instrumentName;
        }
        if (correctNote4 == 35) {
            note4 = "as3" + instrumentName;
        }
        if (correctNote4 == 36) {
            note4 = "b3" + instrumentName;
        }

        if (correctNote4 == 37) {
            note4 = "c4" + instrumentName;
        }
        if (correctNote4 == 38) {
            note4 = "cs4" + instrumentName;
        }
        if (correctNote4 == 39) {
            note4 = "d4" + instrumentName;
        }
        if (correctNote4 == 40) {
            note4 = "ds4" + instrumentName;
        }
        if (correctNote4 == 41) {
            note4 = "e4" + instrumentName;
        }
        if (correctNote4 == 42) {
            note4 = "f4" + instrumentName;
        }
        if (correctNote4 == 43) {
            note4 = "fs4" + instrumentName;
        }
        if (correctNote4 == 44) {
            note4 = "g4" + instrumentName;
        }
        if (correctNote4 == 45) {
            note4 = "gs4" + instrumentName;
        }
        if (correctNote4 == 46) {
            note4 = "a4" + instrumentName;
        }
        if (correctNote4 == 47) {
            note4 = "as4" + instrumentName;
        }
        if (correctNote4 == 48) {
            note4 = "b4" + instrumentName;
        }


        if (correctNote4 == 49) {
            note4 = "c5" + instrumentName;
        }
        if (correctNote4 == 50) {
            note4 = "cs5" + instrumentName;
        }
        if (correctNote4 == 51) {
            note4 = "d5" + instrumentName;
        }
        if (correctNote4 == 52) {
            note4 = "ds5" + instrumentName;
        }
        if (correctNote4 == 53) {
            note4 = "e5" + instrumentName;
        }
        if (correctNote4 == 54) {
            note4 = "f5" + instrumentName;
        }
        if (correctNote4 == 55) {
            note4 = "fs5" + instrumentName;
        }
        if (correctNote4 == 56) {
            note4 = "g5" + instrumentName;
        }
        if (correctNote4 == 57) {
            note4 = "gs5" + instrumentName;
        }
        if (correctNote4 == 58) {
            note4 = "a5" + instrumentName;
        }
        if (correctNote4 == 59) {
            note4 = "as5" + instrumentName;
        }
        if (correctNote4 == 60) {
            note4 = "b5" + instrumentName;
        }


        if (correctNote4 == 61) {
            note4 = "c6" + instrumentName;
        }
        if (correctNote4 == 62) {
            note4 = "cs6" + instrumentName;
        }
        if (correctNote4 == 63) {
            note4 = "d6" + instrumentName;
        }
        if (correctNote4 == 64) {
            note4 = "ds6" + instrumentName;
        }
        if (correctNote4 == 65) {
            note4 = "e6" + instrumentName;
        }
        if (correctNote4 == 66) {
            note4 = "f6" + instrumentName;
        }
        if (correctNote4 == 67) {
            note4 = "fs6" + instrumentName;
        }
        if (correctNote4 == 68) {
            note4 = "g6" + instrumentName;
        }
        if (correctNote4 == 69) {
            note4 = "gs6" + instrumentName;
        }
        if (correctNote4 == 70) {
            note4 = "a6" + instrumentName;
        }
        if (correctNote4 == 71) {
            note4 = "as6" + instrumentName;
        }
        if (correctNote4 == 72) {
            note4 = "b6" + instrumentName;
        }


        if (correctNote5 == 1) {
            note5 = "c1" + instrumentName;
        }
        if (correctNote5 == 2) {
            note5 = "cs1" + instrumentName;
        }
        if (correctNote5 == 3) {
            note5 = "d1" + instrumentName;
        }
        if (correctNote5 == 4) {
            note5 = "ds1" + instrumentName;
        }
        if (correctNote5 == 5) {
            note5 = "e1" + instrumentName;
        }
        if (correctNote5 == 6) {
            note5 = "f1" + instrumentName;
        }
        if (correctNote5 == 7) {
            note5 = "fs1" + instrumentName;
        }
        if (correctNote5 == 8) {
            note5 = "g1" + instrumentName;
        }
        if (correctNote5 == 9) {
            note5 = "gs1" + instrumentName;
        }
        if (correctNote5 == 10) {
            note5 = "a1" + instrumentName;
        }
        if (correctNote5 == 11) {
            note5 = "as1" + instrumentName;
        }
        if (correctNote5 == 12) {
            note5 = "b1" + instrumentName;
        }


        if (correctNote5 == 13) {
            note5 = "c2" + instrumentName;
        }
        if (correctNote5 == 14) {
            note5 = "cs2" + instrumentName;
        }
        if (correctNote5 == 15) {
            note5 = "d2" + instrumentName;
        }
        if (correctNote5 == 16) {
            note5 = "ds2" + instrumentName;
        }
        if (correctNote5 == 17) {
            note5 = "e2" + instrumentName;
        }
        if (correctNote5 == 18) {
            note5 = "f2" + instrumentName;
        }
        if (correctNote5 == 19) {
            note5 = "fs2" + instrumentName;
        }
        if (correctNote5 == 20) {
            note5 = "g2" + instrumentName;
        }
        if (correctNote5 == 21) {
            note5 = "gs2" + instrumentName;
        }
        if (correctNote5 == 22) {
            note5 = "a2" + instrumentName;
        }
        if (correctNote5 == 23) {
            note5 = "as2" + instrumentName;
        }
        if (correctNote5 == 24) {
            note5 = "b2" + instrumentName;
        }

        if (correctNote5 == 25) {
            note5 = "c3" + instrumentName;
        }
        if (correctNote5 == 26) {
            note5 = "cs3" + instrumentName;
        }
        if (correctNote5 == 27) {
            note5 = "d3" + instrumentName;
        }
        if (correctNote5 == 28) {
            note5 = "ds3" + instrumentName;
        }
        if (correctNote5 == 29) {
            note5 = "e3" + instrumentName;
        }
        if (correctNote5 == 30) {
            note5 = "f3" + instrumentName;
        }
        if (correctNote5 == 31) {
            note5 = "fs3" + instrumentName;
        }
        if (correctNote5 == 32) {
            note5 = "g3" + instrumentName;
        }
        if (correctNote5 == 33) {
            note5 = "gs3" + instrumentName;
        }
        if (correctNote5 == 34) {
            note5 = "a3" + instrumentName;
        }
        if (correctNote5 == 35) {
            note5 = "as3" + instrumentName;
        }
        if (correctNote5 == 36) {
            note5 = "b3" + instrumentName;
        }

        if (correctNote5 == 37) {
            note5 = "c4" + instrumentName;
        }
        if (correctNote5 == 38) {
            note5 = "cs4" + instrumentName;
        }
        if (correctNote5 == 39) {
            note5 = "d4" + instrumentName;
        }
        if (correctNote5 == 40) {
            note5 = "ds4" + instrumentName;
        }
        if (correctNote5 == 41) {
            note5 = "e4" + instrumentName;
        }
        if (correctNote5 == 42) {
            note5 = "f4" + instrumentName;
        }
        if (correctNote5 == 43) {
            note5 = "fs4" + instrumentName;
        }
        if (correctNote5 == 44) {
            note5 = "g4" + instrumentName;
        }
        if (correctNote5 == 45) {
            note5 = "gs4" + instrumentName;
        }
        if (correctNote5 == 46) {
            note5 = "a4" + instrumentName;
        }
        if (correctNote5 == 47) {
            note5 = "as4" + instrumentName;
        }
        if (correctNote5 == 48) {
            note5 = "b4" + instrumentName;
        }


        if (correctNote5 == 49) {
            note5 = "c5" + instrumentName;
        }
        if (correctNote5 == 50) {
            note5 = "cs5" + instrumentName;
        }
        if (correctNote5 == 51) {
            note5 = "d5" + instrumentName;
        }
        if (correctNote5 == 52) {
            note5 = "ds5" + instrumentName;
        }
        if (correctNote5 == 53) {
            note5 = "e5" + instrumentName;
        }
        if (correctNote5 == 54) {
            note5 = "f5" + instrumentName;
        }
        if (correctNote5 == 55) {
            note5 = "fs5" + instrumentName;
        }
        if (correctNote5 == 56) {
            note5 = "g5" + instrumentName;
        }
        if (correctNote5 == 57) {
            note5 = "gs5" + instrumentName;
        }
        if (correctNote5 == 58) {
            note5 = "a5" + instrumentName;
        }
        if (correctNote5 == 59) {
            note5 = "as5" + instrumentName;
        }
        if (correctNote5 == 60) {
            note5 = "b5" + instrumentName;
        }


        if (correctNote5 == 61) {
            note5 = "c6" + instrumentName;
        }
        if (correctNote5 == 62) {
            note5 = "cs6" + instrumentName;
        }
        if (correctNote5 == 63) {
            note5 = "d6" + instrumentName;
        }
        if (correctNote5 == 64) {
            note5 = "ds6" + instrumentName;
        }
        if (correctNote5 == 65) {
            note5 = "e6" + instrumentName;
        }
        if (correctNote5 == 66) {
            note5 = "f6" + instrumentName;
        }
        if (correctNote5 == 67) {
            note5 = "fs6" + instrumentName;
        }
        if (correctNote5 == 68) {
            note5 = "g6" + instrumentName;
        }
        if (correctNote5 == 69) {
            note5 = "gs6" + instrumentName;
        }
        if (correctNote5 == 70) {
            note5 = "a6" + instrumentName;
        }
        if (correctNote5 == 71) {
            note5 = "as6" + instrumentName;
        }
        if (correctNote5 == 72) {
            note5 = "b6" + instrumentName;
        }


        if (correctNote6 == 1) {
            note6 = "c1" + instrumentName;
        }
        if (correctNote6 == 2) {
            note6 = "cs1" + instrumentName;
        }
        if (correctNote6 == 3) {
            note6 = "d1" + instrumentName;
        }
        if (correctNote6 == 4) {
            note6 = "ds1" + instrumentName;
        }
        if (correctNote6 == 5) {
            note6 = "e1" + instrumentName;
        }
        if (correctNote6 == 6) {
            note6 = "f1" + instrumentName;
        }
        if (correctNote6 == 7) {
            note6 = "fs1" + instrumentName;
        }
        if (correctNote6 == 8) {
            note6 = "g1" + instrumentName;
        }
        if (correctNote6 == 9) {
            note6 = "gs1" + instrumentName;
        }
        if (correctNote6 == 10) {
            note6 = "a1" + instrumentName;
        }
        if (correctNote6 == 11) {
            note6 = "as1" + instrumentName;
        }
        if (correctNote6 == 12) {
            note6 = "b1" + instrumentName;
        }


        if (correctNote6 == 13) {
            note6 = "c2" + instrumentName;
        }
        if (correctNote6 == 14) {
            note6 = "cs2" + instrumentName;
        }
        if (correctNote6 == 15) {
            note6 = "d2" + instrumentName;
        }
        if (correctNote6 == 16) {
            note6 = "ds2" + instrumentName;
        }
        if (correctNote6 == 17) {
            note6 = "e2" + instrumentName;
        }
        if (correctNote6 == 18) {
            note6 = "f2" + instrumentName;
        }
        if (correctNote6 == 19) {
            note6 = "fs2" + instrumentName;
        }
        if (correctNote6 == 20) {
            note6 = "g2" + instrumentName;
        }
        if (correctNote6 == 21) {
            note6 = "gs2" + instrumentName;
        }
        if (correctNote6 == 22) {
            note6 = "a2" + instrumentName;
        }
        if (correctNote6 == 23) {
            note6 = "as2" + instrumentName;
        }
        if (correctNote6 == 24) {
            note6 = "b2" + instrumentName;
        }

        if (correctNote6 == 25) {
            note6 = "c3" + instrumentName;
        }
        if (correctNote6 == 26) {
            note6 = "cs3" + instrumentName;
        }
        if (correctNote6 == 27) {
            note6 = "d3" + instrumentName;
        }
        if (correctNote6 == 28) {
            note6 = "ds3" + instrumentName;
        }
        if (correctNote6 == 29) {
            note6 = "e3" + instrumentName;
        }
        if (correctNote6 == 30) {
            note6 = "f3" + instrumentName;
        }
        if (correctNote6 == 31) {
            note6 = "fs3" + instrumentName;
        }
        if (correctNote6 == 32) {
            note6 = "g3" + instrumentName;
        }
        if (correctNote6 == 33) {
            note6 = "gs3" + instrumentName;
        }
        if (correctNote6 == 34) {
            note6 = "a3" + instrumentName;
        }
        if (correctNote6 == 35) {
            note6 = "as3" + instrumentName;
        }
        if (correctNote6 == 36) {
            note6 = "b3" + instrumentName;
        }

        if (correctNote6 == 37) {
            note6 = "c4" + instrumentName;
        }
        if (correctNote6 == 38) {
            note6 = "cs4" + instrumentName;
        }
        if (correctNote6 == 39) {
            note6 = "d4" + instrumentName;
        }
        if (correctNote6 == 40) {
            note6 = "ds4" + instrumentName;
        }
        if (correctNote6 == 41) {
            note6 = "e4" + instrumentName;
        }
        if (correctNote6 == 42) {
            note6 = "f4" + instrumentName;
        }
        if (correctNote6 == 43) {
            note6 = "fs4" + instrumentName;
        }
        if (correctNote6 == 44) {
            note6 = "g4" + instrumentName;
        }
        if (correctNote6 == 45) {
            note6 = "gs4" + instrumentName;
        }
        if (correctNote6 == 46) {
            note6 = "a4" + instrumentName;
        }
        if (correctNote6 == 47) {
            note6 = "as4" + instrumentName;
        }
        if (correctNote6 == 48) {
            note6 = "b4" + instrumentName;
        }


        if (correctNote6 == 49) {
            note6 = "c5" + instrumentName;
        }
        if (correctNote6 == 50) {
            note6 = "cs5" + instrumentName;
        }
        if (correctNote6 == 51) {
            note6 = "d5" + instrumentName;
        }
        if (correctNote6 == 52) {
            note6 = "ds5" + instrumentName;
        }
        if (correctNote6 == 53) {
            note6 = "e5" + instrumentName;
        }
        if (correctNote6 == 54) {
            note6 = "f5" + instrumentName;
        }
        if (correctNote6 == 55) {
            note6 = "fs5" + instrumentName;
        }
        if (correctNote6 == 56) {
            note6 = "g5" + instrumentName;
        }
        if (correctNote6 == 57) {
            note6 = "gs5" + instrumentName;
        }
        if (correctNote6 == 58) {
            note6 = "a5" + instrumentName;
        }
        if (correctNote6 == 59) {
            note6 = "as5" + instrumentName;
        }
        if (correctNote6 == 60) {
            note6 = "b5" + instrumentName;
        }


        if (correctNote6 == 61) {
            note6 = "c6" + instrumentName;
        }
        if (correctNote6 == 62) {
            note6 = "cs6" + instrumentName;
        }
        if (correctNote6 == 63) {
            note6 = "d6" + instrumentName;
        }
        if (correctNote6 == 64) {
            note6 = "ds6" + instrumentName;
        }
        if (correctNote6 == 65) {
            note6 = "e6" + instrumentName;
        }
        if (correctNote6 == 66) {
            note6 = "f6" + instrumentName;
        }
        if (correctNote6 == 67) {
            note6 = "fs6" + instrumentName;
        }
        if (correctNote6 == 68) {
            note6 = "g6" + instrumentName;
        }
        if (correctNote6 == 69) {
            note6 = "gs6" + instrumentName;
        }
        if (correctNote6 == 70) {
            note6 = "a6" + instrumentName;
        }
        if (correctNote6 == 71) {
            note6 = "as6" + instrumentName;
        }
        if (correctNote6 == 72) {
            note6 = "b6" + instrumentName;
        }


        if (correctNote7 == 1) {
            note7 = "c1" + instrumentName;
        }
        if (correctNote7 == 2) {
            note7 = "cs1" + instrumentName;
        }
        if (correctNote7 == 3) {
            note7 = "d1" + instrumentName;
        }
        if (correctNote7 == 4) {
            note7 = "ds1" + instrumentName;
        }
        if (correctNote7 == 5) {
            note7 = "e1" + instrumentName;
        }
        if (correctNote7 == 6) {
            note7 = "f1" + instrumentName;
        }
        if (correctNote7 == 7) {
            note7 = "fs1" + instrumentName;
        }
        if (correctNote7 == 8) {
            note7 = "g1" + instrumentName;
        }
        if (correctNote7 == 9) {
            note7 = "gs1" + instrumentName;
        }
        if (correctNote7 == 10) {
            note7 = "a1" + instrumentName;
        }
        if (correctNote7 == 11) {
            note7 = "as1" + instrumentName;
        }
        if (correctNote7 == 12) {
            note7 = "b1" + instrumentName;
        }


        if (correctNote7 == 13) {
            note7 = "c2" + instrumentName;
        }
        if (correctNote7 == 14) {
            note7 = "cs2" + instrumentName;
        }
        if (correctNote7 == 15) {
            note7 = "d2" + instrumentName;
        }
        if (correctNote7 == 16) {
            note7 = "ds2" + instrumentName;
        }
        if (correctNote7 == 17) {
            note7 = "e2" + instrumentName;
        }
        if (correctNote7 == 18) {
            note7 = "f2" + instrumentName;
        }
        if (correctNote7 == 19) {
            note7 = "fs2" + instrumentName;
        }
        if (correctNote7 == 20) {
            note7 = "g2" + instrumentName;
        }
        if (correctNote7 == 21) {
            note7 = "gs2" + instrumentName;
        }
        if (correctNote7 == 22) {
            note7 = "a2" + instrumentName;
        }
        if (correctNote7 == 23) {
            note7 = "as2" + instrumentName;
        }
        if (correctNote7 == 24) {
            note7 = "b2" + instrumentName;
        }

        if (correctNote7 == 25) {
            note7 = "c3" + instrumentName;
        }
        if (correctNote7 == 26) {
            note7 = "cs3" + instrumentName;
        }
        if (correctNote7 == 27) {
            note7 = "d3" + instrumentName;
        }
        if (correctNote7 == 28) {
            note7 = "ds3" + instrumentName;
        }
        if (correctNote7 == 29) {
            note7 = "e3" + instrumentName;
        }
        if (correctNote7 == 30) {
            note7 = "f3" + instrumentName;
        }
        if (correctNote7 == 31) {
            note7 = "fs3" + instrumentName;
        }
        if (correctNote7 == 32) {
            note7 = "g3" + instrumentName;
        }
        if (correctNote7 == 33) {
            note7 = "gs3" + instrumentName;
        }
        if (correctNote7 == 34) {
            note7 = "a3" + instrumentName;
        }
        if (correctNote7 == 35) {
            note7 = "as3" + instrumentName;
        }
        if (correctNote7 == 36) {
            note7 = "b3" + instrumentName;
        }

        if (correctNote7 == 37) {
            note7 = "c4" + instrumentName;
        }
        if (correctNote7 == 38) {
            note7 = "cs4" + instrumentName;
        }
        if (correctNote7 == 39) {
            note7 = "d4" + instrumentName;
        }
        if (correctNote7 == 40) {
            note7 = "ds4" + instrumentName;
        }
        if (correctNote7 == 41) {
            note7 = "e4" + instrumentName;
        }
        if (correctNote7 == 42) {
            note7 = "f4" + instrumentName;
        }
        if (correctNote7 == 43) {
            note7 = "fs4" + instrumentName;
        }
        if (correctNote7 == 44) {
            note7 = "g4" + instrumentName;
        }
        if (correctNote7 == 45) {
            note7 = "gs4" + instrumentName;
        }
        if (correctNote7 == 46) {
            note7 = "a4" + instrumentName;
        }
        if (correctNote7 == 47) {
            note7 = "as4" + instrumentName;
        }
        if (correctNote7 == 48) {
            note7 = "b4" + instrumentName;
        }


        if (correctNote7 == 49) {
            note7 = "c5" + instrumentName;
        }
        if (correctNote7 == 50) {
            note7 = "cs5" + instrumentName;
        }
        if (correctNote7 == 51) {
            note7 = "d5" + instrumentName;
        }
        if (correctNote7 == 52) {
            note7 = "ds5" + instrumentName;
        }
        if (correctNote7 == 53) {
            note7 = "e5" + instrumentName;
        }
        if (correctNote7 == 54) {
            note7 = "f5" + instrumentName;
        }
        if (correctNote7 == 55) {
            note7 = "fs5" + instrumentName;
        }
        if (correctNote7 == 56) {
            note7 = "g5" + instrumentName;
        }
        if (correctNote7 == 57) {
            note7 = "gs5" + instrumentName;
        }
        if (correctNote7 == 58) {
            note7 = "a5" + instrumentName;
        }
        if (correctNote7 == 59) {
            note7 = "as5" + instrumentName;
        }
        if (correctNote7 == 60) {
            note7 = "b5" + instrumentName;
        }


        if (correctNote7 == 61) {
            note7 = "c6" + instrumentName;
        }
        if (correctNote7 == 62) {
            note7 = "cs6" + instrumentName;
        }
        if (correctNote7 == 63) {
            note7 = "d6" + instrumentName;
        }
        if (correctNote7 == 64) {
            note7 = "ds6" + instrumentName;
        }
        if (correctNote7 == 65) {
            note7 = "e6" + instrumentName;
        }
        if (correctNote7 == 66) {
            note7 = "f6" + instrumentName;
        }
        if (correctNote7 == 67) {
            note7 = "fs6" + instrumentName;
        }
        if (correctNote7 == 68) {
            note7 = "g6" + instrumentName;
        }
        if (correctNote7 == 69) {
            note7 = "gs6" + instrumentName;
        }
        if (correctNote7 == 70) {
            note7 = "a6" + instrumentName;
        }
        if (correctNote7 == 71) {
            note7 = "as6" + instrumentName;
        }
        if (correctNote7 == 72) {
            note7 = "b6" + instrumentName;
        }


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView myText = (TextView) view;
        String levelNum = String.valueOf(position + 1);
        Toast.makeText(this, "Level:" + levelNum, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Chord_Recognition Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.jamaljones.proear/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Chord_Recognition Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.jamaljones.proear/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
