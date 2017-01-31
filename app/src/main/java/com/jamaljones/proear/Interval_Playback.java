package com.jamaljones.proear;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.graphics.Color;

import java.util.Random;

public class Interval_Playback extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    MediaPlayer audio;
    MediaPlayer audio1;
    MediaPlayer audio2;
    private ProgressBar progressBar;
    private Button playButton;
    private int progressStatus = 0;
    private TextView textView;
    private int correctNote1 = 0;
    private int correctNote2 = 0;
    private int level = 0;
    private String instrumentName = "piano";
    private String answer;
    private String lvl;
    private String currentLevel;
    private boolean levelChanged = true;
    private boolean isCorrect = false;
    private int octave = 3;
    private int delay = 0;
    private int delay1 = 0;
    private int delay2 = 0;
    private int interval = 0;
    private int intervalDirection = 0;
    private int key = 1;
    private int instrument = 1;
    private int harmonic = 0;
    private String note = "c3piano";
    private String note1 = "c3piano";
    private String note2 = "g3piano";
    private boolean running = true;
    private CountDownTimer timer;
    private CountDownTimer timer1;
    private CountDownTimer timer2;
    private CountDownTimer timer3;
    private int sharp = 0;
    private boolean firstNotePressed = false;
    private boolean secondNotePressed = false;
    private boolean playPressed = false;
    private boolean noteOneCorrect = false;
    private boolean noteTwoCorrect = false;
    private boolean W1 = false;
    private boolean W2 = false;
    private boolean W3 = false;
    private boolean W4 = false;
    private boolean W5 = false;
    private boolean W6 = false;
    private boolean W7 = false;
    private boolean W8 = false;
    private boolean W9 = false;
    private boolean BL1 = false;
    private boolean BL2 = false;
    private boolean BL3 = false;
    private boolean BL4 = false;
    private boolean BL5 = false;
    private boolean BL6 = false;
    private boolean BL7 = false;
    private boolean BL8 = false;
    private boolean BL9 = false;
    private boolean BL10 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interval__playback);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Interval Playback");

        spinner= (Spinner) findViewById(R.id.spinner);
        progressBar= (ProgressBar) findViewById(R.id.progressBar);
        textView = (TextView) findViewById(R.id.progressTextView);
        progressBar.getProgressDrawable().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);

        ArrayAdapter adapter=ArrayAdapter.createFromResource(this,R.array.intervallevels,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        setKey();
        setBoard();
        setLevel();

        setMenuButton();
        setPlayButton();
        setW1Button();
        setW2Button();
        setW3Button();
        setW4Button();
        setW5Button();
        setW6Button();
        setW7Button();
        setW8Button();
        setW9Button();
        setBL1Button();
        setBL2Button();
        setBL3Button();
        setBL4Button();
        setBL5Button();
        setBL6Button();
        setBL7Button();
        setBL8Button();
        setBL9Button();
        setBL10Button();
        progressBar.setProgress(0);
    }

    private void setMenuButton() {
        Button menuButton = (Button) findViewById(R.id.menuButton);
        menuButton.setTransformationMethod(null);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                stop();
                startActivity(new Intent(Interval_Playback.this, MainActivity.class));
            }
        });

    }

    private void setPlayButton() {
        Button playButton = (Button) findViewById(R.id.playButton);
        playButton.setTransformationMethod(null);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                stop();
                playAnswer();
                playPressed = true;
                levelChanged = false;

            }
        });

    }

    private void play(String sound) {
        int resID = getResources().getIdentifier(sound, "raw", getPackageName());
        MediaPlayer audio = MediaPlayer.create(Interval_Playback.this, resID);
        audio.start();
        audio.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio) {
                audio.release();

            }


        });
    }

    private void play1(String sound) {
        int resID1 = getResources().getIdentifier(sound, "raw", getPackageName());
        MediaPlayer audio1 = MediaPlayer.create(Interval_Playback.this, resID1);
        audio1.start();
        audio1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio1) {
                audio1.release();

            }


        });
    }


    private void play2(String sound) {
        int resID2 = getResources().getIdentifier(sound, "raw", getPackageName());
        MediaPlayer audio2 = MediaPlayer.create(Interval_Playback.this, resID2);
        audio2.start();
        audio2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio2) {
                audio2.release();

            }


        });
    }

    private void stop() {
        if (audio != null && audio.isPlaying()) {
            audio.stop();
        }
        if (audio1 != null && audio1.isPlaying()) {
            audio1.stop();
        }
        if (audio2 != null && audio2.isPlaying()) {
            audio2.stop();
        }

    }


    private void cancelTimer() {
        if(timer != null) {
            timer.cancel();
            timer = null;
        }

    }
    private void cancelTimer1() {
        if(timer1 != null) {
            timer1.cancel();
            timer1 = null;
        }

    }
    private void cancelTimer2() {
        if(timer2 != null) {
            timer2.cancel();
            timer2 = null;
        }

    }


    private void countDown() {
        timer = new CountDownTimer(900, 900) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                    hideWrong();
                    stop();
                    play1(note1);
                    displayAnswer1();
                    progressStatus = 0;
                    playPressed = false;
                    updateProgress();
                    cancelTimer();
                    countDown1();
            }
        }.start();
    }

    private void countDown1() {
        timer1 = new CountDownTimer(delay, delay) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                play2(note2);
                displayAnswer2();
                resetNotes();
                cancelTimer1();

            }
        }.start();
    }

    private void countDown2() {
        timer2 = new CountDownTimer(delay, delay) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                play2(note2);
                cancelTimer2();

            }
        }.start();
    }



    private void setKey () {
        final Random rand = new Random();
        key = rand.nextInt(12) + 1;
    }


    private void setW1Button() {
        Button W1Button = (Button) findViewById(R.id.W1Button);
        W1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                stop();

                if (key == 1) {
                    if (octave == 1) {
                        note = "c1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "c2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "c3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "c4" + instrumentName;
                    }

                }

                if (key == 2) {
                    if (octave == 1) {
                        note = "c1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "c2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "c3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "c4" + instrumentName;
                    }

                }

                if (key == 3) {
                    if (octave == 1) {
                        note = "d1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "d2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "d3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "d4" + instrumentName;
                    }

                }

                if (key == 4) {
                    if (octave == 1) {
                        note = "d1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "d2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "d3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "d4" + instrumentName;
                    }

                }

                if (key == 5) {
                    if (octave == 1) {
                        note = "e1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "e2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "e3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "e4" + instrumentName;
                    }

                }

                if (key == 6) {
                    if (octave == 1) {
                        note = "f1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "f2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "f3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "f4" + instrumentName;
                    }

                }
                if (key == 7) {
                    if (octave == 1) {
                        note = "f1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "f2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "f3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "f4" + instrumentName;
                    }

                }
                if (key == 8) {
                    if (octave == 1) {
                        note = "g1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "g2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "g3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "g4" + instrumentName;
                    }

                }
                if (key == 9) {
                    if (octave == 1) {
                        note = "g1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "g2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "g3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "g4" + instrumentName;
                    }

                }
                if (key == 10) {
                    if (octave == 1) {
                        note = "a1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "a2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "a3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "a4" + instrumentName;
                    }

                }
                if (key == 11) {
                    if (octave == 1) {
                        note = "a1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "a2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "a3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "a4" + instrumentName;
                    }

                }
                if (key == 12) {
                    if (octave == 1) {
                        note = "b1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "b2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "b3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "b4" + instrumentName;
                    }

                }


                play(note);

                if (firstNotePressed)  {
                    if (W1)  {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                }
                if (secondNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect) {
                        ImageView W1Green = (ImageView) findViewById(R.id.W1Green);
                        W1Green.setVisibility(View.VISIBLE);
                        hideWrong();
                        progressStatus++;
                        resetNotes();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    } else {
                        countDown();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    }

                }
                if (playPressed) {
                    if (key == 2 || key == 4 || key == 7 || key == 9 || key == 11) {
                        noteOneCorrect = false;

                    } else {
                        if (intervalDirection == 1) {
                            noteOneCorrect = true;

                        } else {
                            noteOneCorrect = false;

                        }
                    }
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 12) {

                    progressStatus = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner)findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();

                }
                updateProgress();


            }
        });

    }

    private void setW2Button() {
        Button W2Button = (Button) findViewById(R.id.W2Button);
        W2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                stop();
                if (key == 1) {
                    if (octave == 1) {
                        note = "d1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "d2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "d3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "d4" + instrumentName;
                    }

                }

                if (key == 2) {
                    if (octave == 1) {
                        note = "d1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "d2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "d3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "d4" + instrumentName;
                    }

                }

                if (key == 3) {
                    if (octave == 1) {
                        note = "e1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "e2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "e3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "e4" + instrumentName;
                    }

                }

                if (key == 4) {
                    if (octave == 1) {
                        note = "e1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "e2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "e3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "e4" + instrumentName;
                    }
                }

                if (key == 5) {
                    if (octave == 1) {
                        note = "f1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "f2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "f3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "f4" + instrumentName;
                    }

                }

                if (key == 6) {
                    if (octave == 1) {
                        note = "g1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "g2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "g3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "g4" + instrumentName;
                    }

                }
                if (key == 7) {
                    if (octave == 1) {
                        note = "g1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "g2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "g3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "g4" + instrumentName;
                    }

                }
                if (key == 8) {
                    if (octave == 1) {
                        note = "a1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "a2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "a3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "a4" + instrumentName;
                    }

                }
                if (key == 9) {
                    if (octave == 1) {
                        note = "a1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "a2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "a3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "a4" + instrumentName;
                    }
                }
                if (key == 10) {
                    if (octave == 1) {
                        note = "b1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "b2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "b3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "b4" + instrumentName;
                    }

                }
                if (key == 11) {
                    if (octave == 1) {
                        note = "b1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "b2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "b3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "b4" + instrumentName;
                    }

                }
                if (key == 12) {
                    if (octave == 1) {
                        note = "c2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "c3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "c4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "c5" + instrumentName;
                    }

                }


                play(note);

                if (firstNotePressed)  {
                    if (W2)  {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                }
                if (secondNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect) {
                        ImageView W2Green = (ImageView) findViewById(R.id.W2Green);
                        W2Green.setVisibility(View.VISIBLE);
                        hideWrong();
                        progressStatus++;
                        resetNotes();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    } else {
                        countDown();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    }

                }
                if (playPressed) {
                    noteOneCorrect = false;
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 12) {

                    progressStatus = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner)findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();

                }
                updateProgress();

            }
        });

    }

    private void setW3Button() {
        Button W3Button = (Button) findViewById(R.id.W3Button);
        W3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                stop();

                if (key == 1) {
                    if (octave == 1) {
                        note = "e1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "e2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "e3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "e4" + instrumentName;
                    }


                }

                if (key == 2) {
                    if (octave == 1) {
                        note = "e1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "e2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "e3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "e4" + instrumentName;
                    }


                }

                if (key == 3) {
                    if (octave == 1) {
                        note = "f1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "f2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "f3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "f4" + instrumentName;
                    }

                }

                if (key == 4) {
                    if (octave == 1) {
                        note = "f1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "f2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "f3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "f4" + instrumentName;
                    }

                }

                if (key == 5) {
                    if (octave == 1) {
                        note = "g1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "g2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "g3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "g4" + instrumentName;
                    }

                }

                if (key == 6) {
                    if (octave == 1) {
                        note = "a1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "a2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "a3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "a4" + instrumentName;
                    }

                }
                if (key == 7) {
                    if (octave == 1) {
                        note = "a1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "a2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "a3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "a4" + instrumentName;
                    }
                }
                if (key == 8) {
                    if (octave == 1) {
                        note = "b1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "b2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "b3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "b4" + instrumentName;
                    }

                }
                if (key == 9) {
                    if (octave == 1) {
                        note = "b1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "b2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "b3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "b4" + instrumentName;
                    }

                }
                if (key == 10) {
                    if (octave == 1) {
                        note = "c2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "c3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "c4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "c5" + instrumentName;
                    }

                }
                if (key == 11) {
                    if (octave == 1) {
                        note = "c2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "c3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "c4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "c5" + instrumentName;
                    }

                }
                if (key == 12) {
                    if (octave == 1) {
                        note = "d2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "d3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "d4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "d5" + instrumentName;
                    }

                }


                play(note);

                if (firstNotePressed)  {
                    if (W3)  {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                }
                if (secondNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect) {
                        ImageView W3Green = (ImageView) findViewById(R.id.W3Green);
                        W3Green.setVisibility(View.VISIBLE);
                        hideWrong();
                        progressStatus++;
                        resetNotes();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    } else {
                        countDown();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    }

                }
                if (playPressed) {
                    noteOneCorrect = false;
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 12) {

                    progressStatus = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner)findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();

                }
                updateProgress();


            }
        });

    }

    private void setW4Button() {
        Button W4Button = (Button) findViewById(R.id.W4Button);
        W4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                stop();

                if (key == 1) {
                    if (octave == 1) {
                        note = "f1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "f2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "f3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "f4" + instrumentName;
                    }

                }

                if (key == 2) {
                    if (octave == 1) {
                        note = "f1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "f2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "f3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "f4" + instrumentName;
                    }

                }

                if (key == 3) {
                    if (octave == 1) {
                        note = "g1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "g2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "g3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "g4" + instrumentName;
                    }

                }

                if (key == 4) {
                    if (octave == 1) {
                        note = "g1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "g2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "g3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "g4" + instrumentName;
                    }

                }

                if (key == 5) {
                    if (octave == 1) {
                        note = "a1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "a2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "a3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "a4" + instrumentName;
                    }

                }

                if (key == 6) {
                    if (octave == 1) {
                        note = "b1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "b2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "b3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "b4" + instrumentName;
                    }

                }
                if (key == 7) {
                    if (octave == 1) {
                        note = "b1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "b2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "b3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "b4" + instrumentName;
                    }

                }
                if (key == 8) {
                    if (octave == 1) {
                        note = "c2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "c3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "c4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "c5" + instrumentName;
                    }

                }
                if (key == 9) {
                    if (octave == 1) {
                        note = "c2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "c3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "c4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "c5" + instrumentName;
                    }

                }
                if (key == 10) {
                    if (octave == 1) {
                        note = "d2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "d3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "d4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "d5" + instrumentName;
                    }

                }
                if (key == 11) {
                    if (octave == 1) {
                        note = "d2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "d3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "d4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "d5" + instrumentName;
                    }

                }
                if (key == 12) {
                    if (octave == 1) {
                        note = "e2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "e3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "e4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "e5" + instrumentName;
                    }

                }


                play(note);

                if (firstNotePressed)  {
                    if (W4)  {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                }
                if (secondNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect) {
                        ImageView W4Green = (ImageView) findViewById(R.id.W4Green);
                        W4Green.setVisibility(View.VISIBLE);
                        hideWrong();
                        progressStatus++;
                        resetNotes();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    } else {
                        countDown();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    }

                }
                if (playPressed) {
                    noteOneCorrect = false;
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 12) {

                    progressStatus = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner)findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();

                }
                updateProgress();


            }
        });

    }

    private void setW5Button() {
        Button W5Button = (Button) findViewById(R.id.W5Button);
        W5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                stop();

                if (key == 1) {
                    if (octave == 1) {
                        note = "g1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "g2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "g3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "g4" + instrumentName;
                    }

                }

                if (key == 2) {
                    if (octave == 1) {
                        note = "g1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "g2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "g3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "g4" + instrumentName;
                    }

                }

                if (key == 3) {
                    if (octave == 1) {
                        note = "a1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "a2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "a3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "a4" + instrumentName;
                    }

                }

                if (key == 4) {
                    if (octave == 1) {
                        note = "a1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "a2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "a3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "a4" + instrumentName;
                    }

                }

                if (key == 5) {
                    if (octave == 1) {
                        note = "b1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "b2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "b3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "b4" + instrumentName;
                    }

                }

                if (key == 6) {
                    if (octave == 1) {
                        note = "c2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "c3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "c4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "c5" + instrumentName;
                    }

                }
                if (key == 7) {
                    if (octave == 1) {
                        note = "c2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "c3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "c4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "c5" + instrumentName;
                    }

                }
                if (key == 8) {
                    if (octave == 1) {
                        note = "d2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "d3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "d4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "d5" + instrumentName;
                    }

                }
                if (key == 9) {
                    if (octave == 1) {
                        note = "d2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "d3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "d4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "d5" + instrumentName;
                    }

                }
                if (key == 10) {
                    if (octave == 1) {
                        note = "e2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "e3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "e4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "e5" + instrumentName;
                    }

                }
                if (key == 11) {
                    if (octave == 1) {
                        note = "e2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "e3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "e4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "e5" + instrumentName;
                    }

                }
                if (key == 12) {
                    if (octave == 1) {
                        note = "f2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "f3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "f4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "f5" + instrumentName;
                    }

                }



                play(note);

                if (firstNotePressed)  {
                    if (W5)  {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                }
                if (secondNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect) {
                        ImageView W5Green = (ImageView) findViewById(R.id.W5Green);
                        W5Green.setVisibility(View.VISIBLE);
                        hideWrong();
                        progressStatus++;
                        resetNotes();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    } else {
                        countDown();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    }

                }
                if (playPressed) {
                    noteOneCorrect = false;
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 12) {

                    progressStatus = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner)findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();

                }
                updateProgress();


            }
        });

    }

    private void setW6Button() {
        Button W6Button = (Button) findViewById(R.id.W6Button);
        W6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                stop();

                if (key == 1) {
                    if (octave == 1) {
                        note = "a1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "a2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "a3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "a4" + instrumentName;
                    }

                }

                if (key == 2) {
                    if (octave == 1) {
                        note = "a1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "a2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "a3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "a4" + instrumentName;
                    }

                }

                if (key == 3) {
                    if (octave == 1) {
                        note = "b1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "b2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "b3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "b4" + instrumentName;
                    }

                }

                if (key == 4) {
                    if (octave == 1) {
                        note = "b1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "b2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "b3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "b4" + instrumentName;
                    }

                }

                if (key == 5) {
                    if (octave == 1) {
                        note = "c2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "c3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "c4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "c5" + instrumentName;
                    }

                }

                if (key == 6) {
                    if (octave == 1) {
                        note = "d2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "d3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "d4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "d5" + instrumentName;
                    }

                }
                if (key == 7) {
                    if (octave == 1) {
                        note = "d2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "d3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "d4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "d5" + instrumentName;
                    }

                }
                if (key == 8) {
                    if (octave == 1) {
                        note = "e2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "e3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "e4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "e5" + instrumentName;
                    }

                }
                if (key == 9) {
                    if (octave == 1) {
                        note = "e2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "e3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "e4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "e5" + instrumentName;
                    }

                }
                if (key == 10) {
                    if (octave == 1) {
                        note = "f2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "f3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "f4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "f5" + instrumentName;
                    }

                }
                if (key == 11) {
                    if (octave == 1) {
                        note = "f2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "f3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "f4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "f5" + instrumentName;
                    }

                }
                if (key == 12) {
                    if (octave == 1) {
                        note = "g2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "g3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "g4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "g5" + instrumentName;
                    }

                }


                play(note);

                if (firstNotePressed)  {
                    if (W6)  {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                }
                if (secondNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect) {
                        ImageView W6Green = (ImageView) findViewById(R.id.W6Green);
                        W6Green.setVisibility(View.VISIBLE);
                        hideWrong();
                        progressStatus++;
                        resetNotes();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    } else {
                        countDown();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    }

                }
                if (playPressed) {
                    noteOneCorrect = false;
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 12) {

                    progressStatus = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner)findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();

                }
                updateProgress();


            }
        });

    }

    private void setW7Button() {
        Button W7Button = (Button) findViewById(R.id.W7Button);
        W7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                stop();

                if (key == 1) {
                    if (octave == 1) {
                        note = "b1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "b2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "b3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "b4" + instrumentName;
                    }

                }

                if (key == 2) {
                    if (octave == 1) {
                        note = "b1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "b2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "b3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "b4" + instrumentName;
                    }

                }

                if (key == 3) {
                    if (octave == 1) {
                        note = "c2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "c3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "c4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "c5" + instrumentName;
                    }

                }

                if (key == 4) {
                    if (octave == 1) {
                        note = "c2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "c3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "c4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "c5" + instrumentName;
                    }

                }

                if (key == 5) {
                    if (octave == 1) {
                        note = "d2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "d3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "d4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "d5" + instrumentName;
                    }

                }

                if (key == 6) {
                    if (octave == 1) {
                        note = "e2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "e3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "e4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "e5" + instrumentName;
                    }

                }
                if (key == 7) {
                    if (octave == 1) {
                        note = "e2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "e3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "e4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "e5" + instrumentName;
                    }

                }
                if (key == 8) {
                    if (octave == 1) {
                        note = "f2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "f3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "f4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "f5" + instrumentName;
                    }

                }
                if (key == 9) {
                    if (octave == 1) {
                        note = "f2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "f3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "f4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "f5" + instrumentName;
                    }

                }
                if (key == 10) {
                    if (octave == 1) {
                        note = "g2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "g3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "g4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "g5" + instrumentName;
                    }

                }
                if (key == 11) {
                    if (octave == 1) {
                        note = "g2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "g3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "g4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "g5" + instrumentName;
                    }

                }
                if (key == 12) {
                    if (octave == 1) {
                        note = "a2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "a3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "a4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "a5" + instrumentName;
                    }

                }



                play(note);

                if (firstNotePressed)  {
                    if (W7)  {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                }
                if (secondNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect) {
                        ImageView W7Green = (ImageView) findViewById(R.id.W7Green);
                        W7Green.setVisibility(View.VISIBLE);
                        hideWrong();
                        progressStatus++;
                        resetNotes();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    } else {
                        countDown();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    }

                }
                if (playPressed) {
                    noteOneCorrect = false;
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 12) {

                    progressStatus = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner)findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();

                }
                updateProgress();


            }
        });

    }

    private void setW8Button() {
        Button W8Button = (Button) findViewById(R.id.W8Button);
        W8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                stop();

                if (key == 1) {
                    if (octave == 1) {
                        note = "c2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "c3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "c4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "c5" + instrumentName;
                    }

                }

                if (key == 2) {
                    if (octave == 1) {
                        note = "c2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "c3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "c4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "c5" + instrumentName;
                    }

                }

                if (key == 3) {
                    if (octave == 1) {
                        note = "d2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "d3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "d4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "d5" + instrumentName;
                    }


                }

                if (key == 4) {
                    if (octave == 1) {
                        note = "d2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "d3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "d4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "d5" + instrumentName;
                    }


                }

                if (key == 5) {
                    if (octave == 1) {
                        note = "e2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "e3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "e4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "e5" + instrumentName;
                    }

                }

                if (key == 6) {
                    if (octave == 1) {
                        note = "f2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "f3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "f4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "f5" + instrumentName;
                    }

                }
                if (key == 7) {
                    if (octave == 1) {
                        note = "f2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "f3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "f4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "f5" + instrumentName;
                    }

                }
                if (key == 8) {
                    if (octave == 1) {
                        note = "g2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "g3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "g4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "g5" + instrumentName;
                    }

                }
                if (key == 9) {
                    if (octave == 1) {
                        note = "g2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "g3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "g4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "g5" + instrumentName;
                    }

                }
                if (key == 10) {
                    if (octave == 1) {
                        note = "a2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "a3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "a4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "a5" + instrumentName;
                    }

                }
                if (key == 11) {
                    if (octave == 1) {
                        note = "a2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "a3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "a4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "a5" + instrumentName;
                    }
                }
                if (key == 12) {
                    if (octave == 1) {
                        note = "b2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "b3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "b4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "b5" + instrumentName;
                    }

                }


                play(note);

                if (firstNotePressed)  {
                    if (W8)  {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                }
                if (secondNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect) {
                        ImageView W8Green = (ImageView) findViewById(R.id.W8Green);
                        W8Green.setVisibility(View.VISIBLE);
                        hideWrong();
                        progressStatus++;
                        resetNotes();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    } else {
                        countDown();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    }

                }
                if (playPressed) {
                    if (key == 2 || key == 4 || key == 7 || key == 9 || key == 11) {
                        noteOneCorrect = false;

                    } else {
                        if (intervalDirection == 2) {
                            noteOneCorrect = true;

                        } else {
                            noteOneCorrect = false;

                        }
                    }
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 12) {

                    progressStatus = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner)findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();

                }
                updateProgress();

            }
        });

    }

    private void setW9Button() {
        Button W9Button = (Button) findViewById(R.id.W9Button);
        W9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                stop();

                if (key == 1) {
                    if (octave == 1) {
                        note = "d2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "d3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "d4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "d5" + instrumentName;
                    }

                }

                if (key == 2) {
                    if (octave == 1) {
                        note = "d2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "d3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "d4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "d5" + instrumentName;
                    }

                }

                if (key == 3) {
                    if (octave == 1) {
                        note = "e2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "e3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "e4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "e5" + instrumentName;
                    }

                }

                if (key == 4) {
                    if (octave == 1) {
                        note = "e2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "e3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "e4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "e5" + instrumentName;
                    }

                }

                if (key == 5) {
                    if (octave == 1) {
                        note = "f2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "f3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "f4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "f5" + instrumentName;
                    }

                }

                if (key == 6) {
                    if (octave == 1) {
                        note = "g2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "g3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "g4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "g5" + instrumentName;
                    }

                }
                if (key == 7) {
                    if (octave == 1) {
                        note = "g2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "g3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "g4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "g5" + instrumentName;
                    }

                }
                if (key == 8) {
                    if (octave == 1) {
                        note = "a2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "a3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "a4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "a5" + instrumentName;
                    }

                }
                if (key == 9) {
                    if (octave == 1) {
                        note = "a2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "a3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "a4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "a5" + instrumentName;
                    }

                }
                if (key == 10) {
                    if (octave == 1) {
                        note = "b2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "b3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "b4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "b5" + instrumentName;
                    }

                }
                if (key == 11) {
                    if (octave == 1) {
                        note = "b2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "b3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "b4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "b5" + instrumentName;
                    }

                }
                if (key == 12) {
                    if (octave == 1) {
                        note = "c3" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "c4" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "c5" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "c6" + instrumentName;
                    }

                }


                play(note);

                if (firstNotePressed)  {
                    if (W9)  {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                }
                if (secondNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect) {
                        ImageView W9Green = (ImageView) findViewById(R.id.W9Green);
                        W9Green.setVisibility(View.VISIBLE);
                        hideWrong();
                        progressStatus++;
                        resetNotes();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    } else {
                        countDown();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    }

                }
                if (playPressed) {
                    noteOneCorrect = false;
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 12) {

                    progressStatus = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner)findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();

                }
                updateProgress();


            }
        });

    }

    private void setBL1Button() {
        Button BL1Button = (Button) findViewById(R.id.BL1Button);
        BL1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                stop();

                if (key == 3) {
                    if (octave == 1) {
                        note = "cs1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "cs2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "cs3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "cs4" + instrumentName;
                    }

                }

                if (key == 4) {
                    if (octave == 1) {
                        note = "cs1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "cs2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "cs3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "cs4" + instrumentName;
                    }

                }

                if (key == 5) {
                    if (octave == 1) {
                        note = "ds1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "ds2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "ds3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "ds4" + instrumentName;
                    }

                }
                if (key == 8) {
                    if (octave == 1) {
                        note = "fs1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "fs2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "fs3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "fs4" + instrumentName;
                    }

                }
                if (key == 9) {
                    if (octave == 1) {
                        note = "fs1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "fs2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "fs3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "fs4" + instrumentName;
                    }

                }
                if (key == 10) {
                    if (octave == 1) {
                        note = "gs1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "gs2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "gs3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "gs4" + instrumentName;
                    }

                }
                if (key == 11) {
                    if (octave == 1) {
                        note = "gs1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "gs2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "gs3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "gs4" + instrumentName;
                    }

                }
                if (key == 12) {
                    if (octave == 1) {
                        note = "as1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "as2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "as3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "as4" + instrumentName;
                    }

                }


                play(note);

                if (firstNotePressed)  {
                    if (BL1)  {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                }
                if (secondNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect) {
                        ImageView BL1Green = (ImageView) findViewById(R.id.BL1Green);
                        BL1Green.setVisibility(View.VISIBLE);
                        hideWrong();
                        progressStatus++;
                        resetNotes();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    } else {
                        countDown();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    }

                }
                if (playPressed) {
                    noteOneCorrect = false;
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 12) {

                    progressStatus = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner)findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();

                }
                updateProgress();


            }
        });

    }

    private void setBL2Button() {
        Button BL2Button = (Button) findViewById(R.id.BL2Button);
        BL2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                stop();

                if (key == 1) {
                    if (octave == 1) {
                        note = "cs1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "cs2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "cs3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "cs4" + instrumentName;
                    }

                }
                if (key == 2) {
                    if (octave == 1) {
                        note = "cs1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "cs2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "cs3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "cs4" + instrumentName;
                    }

                }
                if (key == 3) {
                    if (octave == 1) {
                        note = "ds1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "ds2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "ds3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "ds4" + instrumentName;
                    }

                }
                if (key == 4) {
                    if (octave == 1) {
                        note = "ds1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "ds2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "ds3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "ds4" + instrumentName;
                    }

                }
                if (key == 6) {
                    if (octave == 1) {
                        note = "fs1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "fs2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "fs3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "fs4" + instrumentName;
                    }

                }
                if (key == 7) {
                    if (octave == 1) {
                        note = "fs1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "fs2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "fs3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "fs4" + instrumentName;
                    }

                }
                if (key == 8) {
                    if (octave == 1) {
                        note = "gs1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "gs2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "gs3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "gs4" + instrumentName;
                    }

                }
                if (key == 9) {
                    if (octave == 1) {
                        note = "gs1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "gs2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "gs3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "gs4" + instrumentName;
                    }

                }
                if (key == 10) {
                    if (octave == 1) {
                        note = "as1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "as2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "as3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "as4" + instrumentName;
                    }

                }
                if (key == 11) {
                    if (octave == 1) {
                        note = "as1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "as2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "as3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "as4" + instrumentName;
                    }

                }

                play(note);

                if (firstNotePressed)  {
                    if (BL2)  {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                }
                if (secondNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect) {
                        ImageView BL2Green = (ImageView) findViewById(R.id.BL2Green);
                        BL2Green.setVisibility(View.VISIBLE);
                        hideWrong();
                        progressStatus++;
                        resetNotes();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    } else {
                        countDown();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    }

                }
                if (playPressed) {
                    if (key == 1 || key == 3 || key == 5 || key == 6 || key == 8 || key == 10 || key == 12) {
                        noteOneCorrect = false;

                    } else {
                        if (intervalDirection == 1) {
                            noteOneCorrect = true;

                        } else {
                            noteOneCorrect = false;

                        }
                    }
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 12) {

                    progressStatus = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner)findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();

                }
                updateProgress();

            }
        });

    }

    private void setBL3Button() {
        Button BL3Button = (Button) findViewById(R.id.BL3Button);
        BL3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                stop();

                if (key == 1) {
                    if (octave == 1) {
                        note = "ds1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "ds2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "ds3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "ds4" + instrumentName;
                    }

                }
                if (key == 2) {
                    if (octave == 1) {
                        note = "ds1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "ds2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "ds3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "ds4" + instrumentName;
                    }

                }
                if (key == 5) {
                    if (octave == 1) {
                        note = "fs1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "fs2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "fs3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "fs4" + instrumentName;
                    }

                }
                if (key == 6) {
                    if (octave == 1) {
                        note = "gs1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "gs2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "gs3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "gs4" + instrumentName;
                    }

                }
                if (key == 7) {
                    if (octave == 1) {
                        note = "gs1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "gs2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "gs3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "gs4" + instrumentName;
                    }

                }
                if (key == 8) {
                    if (octave == 1) {
                        note = "as1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "as2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "as3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "as4" + instrumentName;
                    }

                }
                if (key == 9) {
                    if (octave == 1) {
                        note = "as1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "as2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "as3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "as4" + instrumentName;
                    }

                }
                if (key == 12) {
                    if (octave == 1) {
                        note = "cs2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "cs3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "cs4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "cs5" + instrumentName;
                    }

                }

                play(note);

                if (firstNotePressed)  {
                    if (BL3)  {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                }
                if (secondNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect) {
                        ImageView BL3Green = (ImageView) findViewById(R.id.BL3Green);
                        BL3Green.setVisibility(View.VISIBLE);
                        hideWrong();
                        progressStatus++;
                        resetNotes();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    } else {
                        countDown();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    }

                }
                if (playPressed) {
                    noteOneCorrect = false;
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 12) {

                    progressStatus = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner)findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();

                }
                updateProgress();


            }
        });

    }

    private void setBL4Button() {
        Button BL4Button = (Button) findViewById(R.id.BL4Button);
        BL4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                stop();


                if (key == 3) {
                    if (octave == 1) {
                        note = "fs1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "fs2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "fs3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "fs4" + instrumentName;
                    }

                }
                if (key == 4) {
                    if (octave == 1) {
                        note = "fs1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "fs2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "fs3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "fs4" + instrumentName;
                    }
                }
                if (key == 5) {
                    if (octave == 1) {
                        note = "gs1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "gs2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "gs3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "gs4" + instrumentName;
                    }

                }
                if (key == 6) {
                    if (octave == 1) {
                        note = "as1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "as2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "as3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "as4" + instrumentName;
                    }

                }
                if (key == 7) {
                    if (octave == 1) {
                        note = "as1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "as2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "as3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "as4" + instrumentName;
                    }

                }
                if (key == 10) {
                    if (octave == 1) {
                        note = "cs2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "cs3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "cs4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "cs5" + instrumentName;
                    }

                }
                if (key == 11) {
                    if (octave == 1) {
                        note = "cs2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "cs3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "cs4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "cs5" + instrumentName;
                    }

                }
                if (key == 12) {
                    if (octave == 1) {
                        note = "ds2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "ds3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "ds4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "ds5" + instrumentName;
                    }

                }



                play(note);

                if (firstNotePressed)  {
                    if (BL4)  {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                }
                if (secondNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect) {
                        ImageView BL4Green = (ImageView) findViewById(R.id.BL4Green);
                        BL4Green.setVisibility(View.VISIBLE);
                        hideWrong();
                        progressStatus++;
                        resetNotes();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    } else {
                        countDown();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    }

                }
                if (playPressed) {
                    noteOneCorrect = false;
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 12) {

                    progressStatus = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner)findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();

                }
                updateProgress();


            }
        });

    }

    private void setBL5Button() {
        Button BL5Button = (Button) findViewById(R.id.BL5Button);
        BL5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                stop();

                if (key == 1) {
                    if (octave == 1) {
                        note = "fs1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "fs2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "fs3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "fs4" + instrumentName;
                    }

                }
                if (key == 2) {
                    if (octave == 1) {
                        note = "fs1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "fs2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "fs3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "fs4" + instrumentName;
                    }

                }
                if (key == 3) {
                    if (octave == 1) {
                        note = "gs1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "gs2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "gs3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "gs4" + instrumentName;
                    }

                }
                if (key == 4) {
                    if (octave == 1) {
                        note = "gs1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "gs2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "gs3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "gs4" + instrumentName;
                    }

                }
                if (key == 5) {
                    if (octave == 1) {
                        note = "as1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "as2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "as3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "as4" + instrumentName;
                    }

                }
                if (key == 8) {
                    if (octave == 1) {
                        note = "cs2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "cs3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "cs4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "cs5" + instrumentName;
                    }

                }
                if (key == 9) {
                    if (octave == 1) {
                        note = "cs2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "cs3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "cs4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "cs5" + instrumentName;
                    }

                }
                if (key == 10) {
                    if (octave == 1) {
                        note = "ds2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "ds3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "ds4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "ds5" + instrumentName;
                    }

                }
                if (key == 11) {
                    if (octave == 1) {
                        note = "ds2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "ds3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "ds4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "ds5" + instrumentName;
                    }

                }



                play(note);

                if (firstNotePressed)  {
                    if (BL5)  {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                }
                if (secondNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect) {
                        ImageView BL5Green = (ImageView) findViewById(R.id.BL5Green);
                        BL5Green.setVisibility(View.VISIBLE);
                        hideWrong();
                        progressStatus++;
                        resetNotes();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    } else {
                        countDown();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    }

                }
                if (playPressed) {
                    noteOneCorrect = false;
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 12) {

                    progressStatus = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner)findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();

                }
                updateProgress();


            }
        });

    }

    private void setBL6Button() {
        Button BL6Button = (Button) findViewById(R.id.BL6Button);
        BL6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                stop();

                if (key == 1) {
                    if (octave == 1) {
                        note = "gs1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "gs2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "gs3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "gs4" + instrumentName;
                    }

                }
                if (key == 2) {
                    if (octave == 1) {
                        note = "gs1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "gs2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "gs3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "gs4" + instrumentName;
                    }

                }
                if (key == 3) {
                    if (octave == 1) {
                        note = "as1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "as2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "as3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "as4" + instrumentName;
                    }

                }
                if (key == 4) {
                    if (octave == 1) {
                        note = "as1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "as2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "as3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "as4" + instrumentName;
                    }

                }
                if (key == 6) {
                    if (octave == 1) {
                        note = "cs2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "cs3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "cs4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "cs5" + instrumentName;
                    }

                }
                if (key == 7) {
                    if (octave == 1) {
                        note = "cs2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "cs3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "cs4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "cs5" + instrumentName;
                    }

                }
                if (key == 8) {
                    if (octave == 1) {
                        note = "ds2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "ds3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "ds4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "ds5" + instrumentName;
                    }

                }
                if (key == 9) {
                    if (octave == 1) {
                        note = "ds2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "ds3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "ds4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "ds5" + instrumentName;
                    }

                }
                if (key == 12) {
                    if (octave == 1) {
                        note = "fs2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "fs3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "fs4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "fs5" + instrumentName;
                    }

                }


                play(note);

                if (firstNotePressed)  {
                    if (BL6)  {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                }
                if (secondNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect) {
                        ImageView BL6Green = (ImageView) findViewById(R.id.BL6Green);
                        BL6Green.setVisibility(View.VISIBLE);
                        hideWrong();
                        progressStatus++;
                        resetNotes();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    } else {
                        countDown();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    }

                }
                if (playPressed) {
                    noteOneCorrect = false;
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 12) {

                    progressStatus = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner)findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();

                }
                updateProgress();


            }
        });

    }

    private void setBL7Button() {
        Button BL7Button = (Button) findViewById(R.id.BL7Button);
        BL7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                stop();

                if (key == 1) {
                    if (octave == 1) {
                        note = "as1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "as2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "as3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "as4" + instrumentName;
                    }

                }
                if (key == 2) {
                    if (octave == 1) {
                        note = "as1" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "as2" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "as3" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "as4" + instrumentName;
                    }

                }
                if (key == 5) {
                    if (octave == 1) {
                        note = "cs2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "cs3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "cs4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "cs5" + instrumentName;
                    }

                }
                if (key == 6) {
                    if (octave == 1) {
                        note = "ds2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "ds3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "ds4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "ds5" + instrumentName;
                    }

                }
                if (key == 7) {
                    if (octave == 1) {
                        note = "ds2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "ds3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "ds4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "ds5" + instrumentName;
                    }

                }
                if (key == 10) {
                    if (octave == 1) {
                        note = "fs2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "fs3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "fs4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "fs5" + instrumentName;
                    }

                }
                if (key == 11) {
                    if (octave == 1) {
                        note = "fs2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "fs3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "fs4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "fs5" + instrumentName;
                    }

                }
                if (key == 12) {
                    if (octave == 1) {
                        note = "gs2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "gs3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "gs4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "gs5" + instrumentName;
                    }

                }



                play(note);

                if (firstNotePressed)  {
                    if (BL7)  {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                }
                if (secondNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect) {
                        ImageView BL7Green = (ImageView) findViewById(R.id.BL7Green);
                        BL7Green.setVisibility(View.VISIBLE);
                        hideWrong();
                        progressStatus++;
                        resetNotes();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    } else {
                        countDown();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    }

                }
                if (playPressed) {
                    noteOneCorrect = false;
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 12) {

                    progressStatus = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner)findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();

                }
                updateProgress();


            }
        });

    }

    private void setBL8Button() {
        Button BL8Button = (Button) findViewById(R.id.BL8Button);
        BL8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                stop();

                if (key == 3) {
                    if (octave == 1) {
                        note = "cs2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "cs3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "cs4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "cs5" + instrumentName;
                    }

                }
                if (key == 4) {
                    if (octave == 1) {
                        note = "cs2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "cs3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "cs4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "cs5" + instrumentName;
                    }

                }
                if (key == 5) {
                    if (octave == 1) {
                        note = "ds2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "ds3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "ds4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "ds5" + instrumentName;
                    }

                }
                if (key == 8) {
                    if (octave == 1) {
                        note = "fs2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "fs3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "fs4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "fs5" + instrumentName;
                    }

                }
                if (key == 9) {
                    if (octave == 1) {
                        note = "fs2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "fs3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "fs4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "fs5" + instrumentName;
                    }

                }
                if (key == 10) {
                    if (octave == 1) {
                        note = "gs2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "gs3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "gs4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "gs5" + instrumentName;
                    }

                }

                if (key == 11) {
                    if (octave == 1) {
                        note = "gs2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "gs3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "gs4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "gs5" + instrumentName;
                    }

                }
                if (key == 12) {
                    if (octave == 1) {
                        note = "as2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "as3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "as4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "as5" + instrumentName;
                    }

                }



                play(note);

                if (firstNotePressed)  {
                    if (BL8)  {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                }
                if (secondNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect) {
                        ImageView BL8Green = (ImageView) findViewById(R.id.BL8Green);
                        BL8Green.setVisibility(View.VISIBLE);
                        hideWrong();
                        progressStatus++;
                        resetNotes();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    } else {
                        countDown();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    }

                }
                if (playPressed) {
                    noteOneCorrect = false;
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 12) {

                    progressStatus = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner)findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();

                }
                updateProgress();


            }
        });

    }

    private void setBL9Button() {
        Button BL9Button = (Button) findViewById(R.id.BL9Button);
        BL9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                stop();

                if (key == 1) {
                    if (octave == 1) {
                        note = "cs2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "cs3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "cs4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "cs5" + instrumentName;
                    }

                }
                if (key == 2) {
                    if (octave == 1) {
                        note = "cs2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "cs3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "cs4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "cs5" + instrumentName;
                    }

                }
                if (key == 3) {
                    if (octave == 1) {
                        note = "ds2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "ds3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "ds4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "ds5" + instrumentName;
                    }

                }
                if (key == 4) {
                    if (octave == 1) {
                        note = "ds2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "ds3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "ds4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "ds5" + instrumentName;
                    }

                }
                if (key == 6) {
                    if (octave == 1) {
                        note = "fs2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "fs3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "fs4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "fs5" + instrumentName;
                    }

                }
                if (key == 7) {
                    if (octave == 1) {
                        note = "fs2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "fs3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "fs4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "fs5" + instrumentName;
                    }

                }
                if (key == 8) {
                    if (octave == 1) {
                        note = "gs2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "gs3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "gs4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "gs5" + instrumentName;
                    }

                }
                if (key == 9) {
                    if (octave == 1) {
                        note = "gs2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "gs3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "gs4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "gs5" + instrumentName;
                    }

                }
                if (key == 10) {
                    if (octave == 1) {
                        note = "as2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "as3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "as4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "as5" + instrumentName;
                    }

                }
                if (key == 11) {
                    if (octave == 1) {
                        note = "as2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "as3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "as4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "as5" + instrumentName;
                    }

                }



                play(note);

                if (firstNotePressed)  {
                    if (BL9)  {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                }
                if (secondNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect) {
                        ImageView BL9Green = (ImageView) findViewById(R.id.BL9Green);
                        BL9Green.setVisibility(View.VISIBLE);
                        hideWrong();
                        progressStatus++;
                        resetNotes();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    } else {
                        countDown();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    }

                }
                if (playPressed) {
                    if (key == 1 || key == 3 || key == 5 || key == 6 || key == 8 || key == 10 || key == 12) {
                        noteOneCorrect = false;

                    } else {
                        if (intervalDirection == 2) {
                            noteOneCorrect = true;

                        } else {
                            noteOneCorrect = false;

                        }
                    }
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 12) {

                    progressStatus = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner)findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();

                }
                updateProgress();


            }
        });

    }

    private void setBL10Button() {
        Button BL10Button = (Button) findViewById(R.id.BL10Button);
        BL10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                stop();

                if (key == 1) {
                    if (octave == 1) {
                        note = "ds2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "ds3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "ds4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "ds5" + instrumentName;
                    }

                }
                if (key == 2) {
                    if (octave == 1) {
                        note = "ds2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "ds3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "ds4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "ds5" + instrumentName;
                    }

                }
                if (key == 5) {
                    if (octave == 1) {
                        note = "fs2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "fs3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "fs4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "fs5" + instrumentName;
                    }

                }
                if (key == 6) {
                    if (octave == 1) {
                        note = "gs2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "gs3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "gs4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "gs5" + instrumentName;
                    }

                }
                if (key == 7) {
                    if (octave == 1) {
                        note = "gs2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "gs3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "gs4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "gs5" + instrumentName;
                    }

                }
                if (key == 8) {
                    if (octave == 1) {
                        note = "as2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "as3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "as4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "as5" + instrumentName;
                    }

                }
                if (key == 9) {
                    if (octave == 1) {
                        note = "as2" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "as3" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "as4" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "as5" + instrumentName;
                    }

                }
                if (key == 12) {
                    if (octave == 1) {
                        note = "cs3" + instrumentName;
                    }
                    if (octave == 2) {
                        note = "cs4" + instrumentName;
                    }
                    if (octave == 3) {
                        note = "cs5" + instrumentName;
                    }
                    if (octave == 4) {
                        note = "cs6" + instrumentName;
                    }

                }



                play(note);

                if (firstNotePressed)  {
                    if (BL10)  {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                }
                if (secondNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect) {
                        ImageView BL10Green = (ImageView) findViewById(R.id.BL10Green);
                        BL10Green.setVisibility(View.VISIBLE);
                        hideWrong();
                        progressStatus++;
                        resetNotes();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    } else {
                        countDown();
                        firstNotePressed = false;
                        secondNotePressed = false;
                        playPressed = false;

                    }

                }
                if (playPressed) {
                    noteOneCorrect = false;
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 12) {

                    progressStatus = 0;
                    levelChanged = true;
                    Spinner spinner = (Spinner)findViewById(R.id.spinner);
                    level++;
                    spinner.setSelection(level - 1);
                    setLevel();

                }
                updateProgress();


            }
        });

    }


    private void updateProgress() {

        progressBar.setProgress(progressStatus);
        textView.setText("Progress: " + progressStatus);
    }

    private void resetNotes() {

        correctNote1 = 0;
        correctNote2 = 0;

        W1 = false;
        W2 = false;
        W3 = false;
        W4 = false;
        W5 = false;
        W6 = false;
        W7 = false;
        W8 = false;
        W9 = false;
        BL1 = false;
        BL2 = false;
        BL3 = false;
        BL4 = false;
        BL5 = false;
        BL6 = false;
        BL7 = false;
        BL8 = false;
        BL9 = false;
        BL10 = false;

    }


    private void setLevel() {

        lvl = spinner.getSelectedItem().toString();

        if (!lvl.equals(currentLevel)) {
            levelChanged = true;
        }

        if (levelChanged) {
            resetNotes();
            progressStatus = 0;
        }

        if (lvl.equals("Level: 1")) {
            level = 1;
        }

        if (lvl.equals("Level: 2")) {
            level = 2;
        }

        if (lvl.equals("Level: 3")) {
            level = 3;
        }

        if (lvl.equals("Level: 4")) {
            level = 4;
        }

        if (lvl.equals("Level: 5")) {
            level = 5;
        }

        if (lvl.equals("Level: 6")) {
            level = 6;
        }

        if (lvl.equals("Level: 7")) {
            level = 7;
        }

        if (lvl.equals("Level: 8")) {
            level = 8;
        }

        if (lvl.equals("Level: 9")) {
            level = 9;
        }

        if (lvl.equals("Level: 10")) {
            level = 10;
        }

        if (lvl.equals("Level: 11")) {
            level = 11;
        }

        if (lvl.equals("Level: 12")) {
            level = 12;
        }

        currentLevel = lvl;
        updateProgress();
        levelChanged = false;
    }

    private void displayAnswer1() {

        ImageView BL2Green = (ImageView) findViewById(R.id.BL2Green);
        ImageView W1Green = (ImageView) findViewById(R.id.W1Green);
        ImageView BL9Green = (ImageView) findViewById(R.id.BL9Green);
        ImageView W8Green = (ImageView) findViewById(R.id.W8Green);

        resetColor();

        if (intervalDirection == 1) {
            if (key == 2 || key == 4 || key == 7 || key == 9 || key == 11) {
                BL2Green.setVisibility(View.VISIBLE);
            } else {
                W1Green.setVisibility(View.VISIBLE);
            }
        }
        if (intervalDirection == 2) {
            if (key == 2 || key == 4 || key == 7 || key == 9 || key == 11) {
                BL9Green.setVisibility(View.VISIBLE);
            } else {
                W8Green.setVisibility(View.VISIBLE);
            }
        }

    }

    private void hideWrong () {

        ImageView BL2Green = (ImageView) findViewById(R.id.BL2Green);
        ImageView W1Green = (ImageView) findViewById(R.id.W1Green);
        ImageView BL9Green = (ImageView) findViewById(R.id.BL9Green);
        ImageView W8Green = (ImageView) findViewById(R.id.W8Green);

        if (interval != 3) {
            if (key == 2 || key == 4 || key == 7 || key == 9 || key == 11) {
                if (intervalDirection == 1) {
                    BL9Green.setVisibility(View.INVISIBLE);
                } else {
                    BL2Green.setVisibility(View.INVISIBLE);
                }
            } else {
                if (intervalDirection == 1) {
                    W8Green.setVisibility(View.INVISIBLE);
                } else {
                    W1Green.setVisibility(View.INVISIBLE);
                }
            }
        }
    }


    private void resetColor() {

        ImageView W1Green = (ImageView) findViewById(R.id.W1Green);
        ImageView W2Green = (ImageView) findViewById(R.id.W2Green);
        ImageView W3Green = (ImageView) findViewById(R.id.W3Green);
        ImageView W4Green = (ImageView) findViewById(R.id.W4Green);
        ImageView W5Green = (ImageView) findViewById(R.id.W5Green);
        ImageView W6Green = (ImageView) findViewById(R.id.W6Green);
        ImageView W7Green = (ImageView) findViewById(R.id.W7Green);
        ImageView W8Green = (ImageView) findViewById(R.id.W8Green);
        ImageView W9Green = (ImageView) findViewById(R.id.W9Green);

        ImageView BL1Green = (ImageView) findViewById(R.id.BL1Green);
        ImageView BL2Green = (ImageView) findViewById(R.id.BL2Green);
        ImageView BL3Green = (ImageView) findViewById(R.id.BL3Green);
        ImageView BL4Green = (ImageView) findViewById(R.id.BL4Green);
        ImageView BL5Green = (ImageView) findViewById(R.id.BL5Green);
        ImageView BL6Green = (ImageView) findViewById(R.id.BL6Green);
        ImageView BL7Green = (ImageView) findViewById(R.id.BL7Green);
        ImageView BL8Green = (ImageView) findViewById(R.id.BL8Green);
        ImageView BL9Green = (ImageView) findViewById(R.id.BL9Green);
        ImageView BL10Green = (ImageView) findViewById(R.id.BL10Green);

        W1Green.setVisibility(View.INVISIBLE);
        W2Green.setVisibility(View.INVISIBLE);
        W3Green.setVisibility(View.INVISIBLE);
        W4Green.setVisibility(View.INVISIBLE);
        W5Green.setVisibility(View.INVISIBLE);
        W6Green.setVisibility(View.INVISIBLE);
        W7Green.setVisibility(View.INVISIBLE);
        W8Green.setVisibility(View.INVISIBLE);
        W9Green.setVisibility(View.INVISIBLE);

        BL1Green.setVisibility(View.INVISIBLE);
        BL2Green.setVisibility(View.INVISIBLE);
        BL3Green.setVisibility(View.INVISIBLE);
        BL4Green.setVisibility(View.INVISIBLE);
        BL5Green.setVisibility(View.INVISIBLE);
        BL6Green.setVisibility(View.INVISIBLE);
        BL7Green.setVisibility(View.INVISIBLE);
        BL8Green.setVisibility(View.INVISIBLE);
        BL9Green.setVisibility(View.INVISIBLE);
        BL10Green.setVisibility(View.INVISIBLE);


    }


    private void displayAnswer2() {

        ImageView W1Green = (ImageView) findViewById(R.id.W1Green);
        ImageView W2Green = (ImageView) findViewById(R.id.W2Green);
        ImageView W3Green = (ImageView) findViewById(R.id.W3Green);
        ImageView W4Green = (ImageView) findViewById(R.id.W4Green);
        ImageView W5Green = (ImageView) findViewById(R.id.W5Green);
        ImageView W6Green = (ImageView) findViewById(R.id.W6Green);
        ImageView W7Green = (ImageView) findViewById(R.id.W7Green);
        ImageView W8Green = (ImageView) findViewById(R.id.W8Green);
        ImageView W9Green = (ImageView) findViewById(R.id.W9Green);

        ImageView BL1Green = (ImageView) findViewById(R.id.BL1Green);
        ImageView BL2Green = (ImageView) findViewById(R.id.BL2Green);
        ImageView BL3Green = (ImageView) findViewById(R.id.BL3Green);
        ImageView BL4Green = (ImageView) findViewById(R.id.BL4Green);
        ImageView BL5Green = (ImageView) findViewById(R.id.BL5Green);
        ImageView BL6Green = (ImageView) findViewById(R.id.BL6Green);
        ImageView BL7Green = (ImageView) findViewById(R.id.BL7Green);
        ImageView BL8Green = (ImageView) findViewById(R.id.BL8Green);
        ImageView BL9Green = (ImageView) findViewById(R.id.BL9Green);
        ImageView BL10Green = (ImageView) findViewById(R.id.BL10Green);


        if (intervalDirection == 1) {
            if (key == 1) {
                if (interval == 1) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (interval == 2) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 3) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (interval == 4) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 5) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 7) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 8) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 9) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 10) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 11) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 12) {
                    BL5Green.setVisibility(View.VISIBLE);
                }

            }
            if (key == 2) {
                if (interval == 1) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 2) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (interval == 3) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (interval == 4) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 5) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 7) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 8) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 9) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 10) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 11) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (interval == 12) {
                    W5Green.setVisibility(View.VISIBLE);
                }

            }
            if (key == 3) {
                if (interval == 1) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (interval == 2) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 3) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (interval == 4) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 5) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 7) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 8) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 9) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 10) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 11) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
                if (interval == 12) {
                    BL5Green.setVisibility(View.VISIBLE);
                }

            }
            if (key == 4) {
                if (interval == 1) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 2) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (interval == 3) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (interval == 4) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 5) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 6) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 7) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 9) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 10) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
                if (interval == 11) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (interval == 12) {
                    W5Green.setVisibility(View.VISIBLE);
                }

            }
            if (key == 5) {
                if (interval == 1) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (interval == 2) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 3) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (interval == 4) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 5) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 7) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 8) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 9) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 10) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 11) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
                if (interval == 12) {
                    BL5Green.setVisibility(View.VISIBLE);
                }

            }
            if (key == 6) {
                if (interval == 1) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (interval == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 3) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (interval == 4) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 5) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 7) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 8) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 9) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 10) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 11) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 12) {
                    W4Green.setVisibility(View.VISIBLE);
                }

            }
            if (key == 7) {
                if (interval == 1) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 2) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 3) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (interval == 4) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 5) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 7) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 8) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 9) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 10) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 11) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (interval == 12) {
                    W5Green.setVisibility(View.VISIBLE);
                }

            }
            if (key == 8) {
                if (interval == 1) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (interval == 2) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 3) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (interval == 4) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 5) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 7) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 8) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 9) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 10) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 11) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
                if (interval == 12) {
                    BL5Green.setVisibility(View.VISIBLE);
                }

            }
            if (key == 9) {
                if (interval == 1) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 2) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (interval == 3) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (interval == 4) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 5) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 7) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 9) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 10) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
                if (interval == 11) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (interval == 12) {
                    W5Green.setVisibility(View.VISIBLE);
                }

            }
            if (key == 10) {
                if (interval == 1) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (interval == 2) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 3) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (interval == 4) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 5) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 7) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 8) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 9) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 10) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 11) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
                if (interval == 12) {
                    BL5Green.setVisibility(View.VISIBLE);
                }

            }
            if (key == 11) {
                if (interval == 1) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 2) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (interval == 3) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (interval == 4) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 5) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 6) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 7) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 9) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 10) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
                if (interval == 11) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (interval == 12) {
                    W5Green.setVisibility(View.VISIBLE);
                }

            }
            if (key == 12) {
                if (interval == 1) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 2) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 3) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (interval == 4) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 5) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 7) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 8) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 9) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 10) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 11) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
                if (interval == 12) {
                    W5Green.setVisibility(View.VISIBLE);
                }

            }

        }
        if (intervalDirection == 2) {
            if (key == 1) {
                if (interval == 1) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 2) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (interval == 3) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (interval == 4) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 5) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 6) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 7) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 8) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 9) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 10) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 11) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 12) {
                    BL5Green.setVisibility(View.VISIBLE);
                }

            }
            if (key == 2) {
                if (interval == 1) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (interval == 2) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 3) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 4) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 5) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 6) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 7) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (interval == 8) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 9) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 10) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 11) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 12) {
                    W5Green.setVisibility(View.VISIBLE);
                }

            }
            if (key == 3) {
                if (interval == 1) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 2) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (interval == 3) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (interval == 4) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 5) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 6) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 7) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
                if (interval == 8) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 9) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 10) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 11) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 12) {
                    BL5Green.setVisibility(View.VISIBLE);
                }

            }
            if (key == 4) {
                if (interval == 1) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (interval == 2) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 3) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 4) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 5) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 6) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
                if (interval == 7) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (interval == 8) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 9) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 10) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 11) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 12) {
                    W5Green.setVisibility(View.VISIBLE);
                }

            }
            if (key == 5) {
                if (interval == 1) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 2) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (interval == 3) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (interval == 4) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 5) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 6) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 7) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
                if (interval == 8) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 9) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 10) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 11) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 12) {
                    BL5Green.setVisibility(View.VISIBLE);
                }

            }
            if (key == 6) {
                if (interval == 1) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 2) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (interval == 3) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (interval == 4) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 5) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 6) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 7) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 8) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 9) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 10) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 11) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 12) {
                    W4Green.setVisibility(View.VISIBLE);
                }

            }
            if (key == 7) {
                if (interval == 1) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 2) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 3) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 4) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 5) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 6) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 7) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (interval == 8) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 9) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 10) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 11) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 12) {
                    W5Green.setVisibility(View.VISIBLE);
                }

            }
            if (key == 8) {
                if (interval == 1) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 2) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (interval == 3) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (interval == 4) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 5) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 6) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 7) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
                if (interval == 8) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 9) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 10) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 11) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 12) {
                    BL5Green.setVisibility(View.VISIBLE);
                }

            }
            if (key == 9) {
                if (interval == 1) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (interval == 2) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 3) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 4) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 5) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 6) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
                if (interval == 7) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (interval == 8) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 9) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 10) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 11) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 12) {
                    W5Green.setVisibility(View.VISIBLE);
                }

            }
            if (key == 10) {
                if (interval == 1) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 2) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (interval == 3) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (interval == 4) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 5) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 6) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 7) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
                if (interval == 8) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 9) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 10) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 11) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 12) {
                    BL5Green.setVisibility(View.VISIBLE);
                }

            }
            if (key == 11) {
                if (interval == 1) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (interval == 2) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 3) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 4) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 5) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 6) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
                if (interval == 7) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (interval == 8) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 9) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 10) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 11) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 12) {
                    W5Green.setVisibility(View.VISIBLE);
                }

            }
            if (key == 12) {
                if (interval == 1) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 2) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 3) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (interval == 4) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (interval == 5) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 6) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (interval == 7) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
                if (interval == 8) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 9) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (interval == 10) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (interval == 11) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (interval == 12) {
                    W5Green.setVisibility(View.VISIBLE);
                }

            }


        }

    }





    private void setBoard() {
        Button BL1Button = (Button) findViewById(R.id.BL1Button);
        Button BL2Button = (Button) findViewById(R.id.BL2Button);
        Button BL3Button = (Button) findViewById(R.id.BL3Button);
        Button BL4Button = (Button) findViewById(R.id.BL4Button);
        Button BL5Button = (Button) findViewById(R.id.BL5Button);
        Button BL6Button = (Button) findViewById(R.id.BL6Button);
        Button BL7Button = (Button) findViewById(R.id.BL7Button);
        Button BL8Button = (Button) findViewById(R.id.BL8Button);
        Button BL9Button = (Button) findViewById(R.id.BL9Button);
        Button BL10Button = (Button) findViewById(R.id.BL10Button);

        ImageView BL1Green = (ImageView) findViewById(R.id.BL1Green);
        ImageView BL2Green = (ImageView) findViewById(R.id.BL2Green);
        ImageView BL3Green = (ImageView) findViewById(R.id.BL3Green);
        ImageView BL4Green = (ImageView) findViewById(R.id.BL4Green);
        ImageView BL5Green = (ImageView) findViewById(R.id.BL5Green);
        ImageView BL6Green = (ImageView) findViewById(R.id.BL6Green);
        ImageView BL7Green = (ImageView) findViewById(R.id.BL7Green);
        ImageView BL8Green = (ImageView) findViewById(R.id.BL8Green);
        ImageView BL9Green = (ImageView) findViewById(R.id.BL9Green);
        ImageView BL10Green = (ImageView) findViewById(R.id.BL10Green);

        BL1Button.setVisibility(View.VISIBLE);
        BL1Button.setEnabled(true);


        BL2Button.setVisibility(View.VISIBLE);
        BL2Button.setEnabled(true);


        BL3Button.setVisibility(View.VISIBLE);
        BL3Button.setEnabled(true);


        BL4Button.setVisibility(View.VISIBLE);
        BL4Button.setEnabled(true);


        BL5Button.setVisibility(View.VISIBLE);
        BL5Button.setEnabled(true);


        BL6Button.setVisibility(View.VISIBLE);
        BL6Button.setEnabled(true);


        BL7Button.setVisibility(View.VISIBLE);
        BL7Button.setEnabled(true);


        BL8Button.setVisibility(View.VISIBLE);
        BL8Button.setEnabled(true);


        BL9Button.setVisibility(View.VISIBLE);
        BL9Button.setEnabled(true);


        BL10Button.setVisibility(View.VISIBLE);
        BL10Button.setEnabled(true);




        if (key == 1) {

            BL1Green.setVisibility(View.INVISIBLE);
            BL1Button.setVisibility(View.INVISIBLE);
            BL1Button.setEnabled(false);

            BL4Green.setVisibility(View.INVISIBLE);
            BL4Button.setVisibility(View.INVISIBLE);
            BL4Button.setEnabled(false);

            BL8Green.setVisibility(View.INVISIBLE);
            BL8Button.setVisibility(View.INVISIBLE);
            BL8Button.setEnabled(false);

        }

        if (key == 2) {

            BL1Green.setVisibility(View.INVISIBLE);
            BL1Button.setVisibility(View.INVISIBLE);
            BL1Button.setEnabled(false);

            BL4Green.setVisibility(View.INVISIBLE);
            BL4Button.setVisibility(View.INVISIBLE);
            BL4Button.setEnabled(false);

            BL8Green.setVisibility(View.INVISIBLE);
            BL8Button.setVisibility(View.INVISIBLE);
            BL8Button.setEnabled(false);


        }

        if (key == 3) {

            BL3Green.setVisibility(View.INVISIBLE);
            BL3Button.setVisibility(View.INVISIBLE);
            BL3Button.setEnabled(false);

            BL7Green.setVisibility(View.INVISIBLE);
            BL7Button.setVisibility(View.INVISIBLE);
            BL7Button.setEnabled(false);

            BL10Green.setVisibility(View.INVISIBLE);
            BL10Button.setVisibility(View.INVISIBLE);
            BL10Button.setEnabled(false);


        }

        if (key == 4) {

            BL3Green.setVisibility(View.INVISIBLE);
            BL3Button.setVisibility(View.INVISIBLE);
            BL3Button.setEnabled(false);

            BL7Green.setVisibility(View.INVISIBLE);
            BL7Button.setVisibility(View.INVISIBLE);
            BL7Button.setEnabled(false);

            BL10Green.setVisibility(View.INVISIBLE);
            BL10Button.setVisibility(View.INVISIBLE);
            BL10Button.setEnabled(false);


        }

        if (key == 5) {

            BL2Green.setVisibility(View.INVISIBLE);
            BL2Button.setVisibility(View.INVISIBLE);
            BL2Button.setEnabled(false);

            BL6Green.setVisibility(View.INVISIBLE);
            BL6Button.setVisibility(View.INVISIBLE);
            BL6Button.setEnabled(false);

            BL9Green.setVisibility(View.INVISIBLE);
            BL9Button.setVisibility(View.INVISIBLE);
            BL9Button.setEnabled(false);


        }

        if (key == 6) {

            BL1Green.setVisibility(View.INVISIBLE);
            BL1Button.setVisibility(View.INVISIBLE);
            BL1Button.setEnabled(false);

            BL5Green.setVisibility(View.INVISIBLE);
            BL5Button.setVisibility(View.INVISIBLE);
            BL5Button.setEnabled(false);

            BL8Green.setVisibility(View.INVISIBLE);
            BL8Button.setVisibility(View.INVISIBLE);
            BL8Button.setEnabled(false);


        }

        if (key == 7) {

            BL1Green.setVisibility(View.INVISIBLE);
            BL1Button.setVisibility(View.INVISIBLE);
            BL1Button.setEnabled(false);

            BL5Green.setVisibility(View.INVISIBLE);
            BL5Button.setVisibility(View.INVISIBLE);
            BL5Button.setEnabled(false);

            BL8Green.setVisibility(View.INVISIBLE);
            BL8Button.setVisibility(View.INVISIBLE);
            BL8Button.setEnabled(false);


        }

        if (key == 8) {

            BL4Green.setVisibility(View.INVISIBLE);
            BL4Button.setVisibility(View.INVISIBLE);
            BL4Button.setEnabled(false);

            BL7Green.setVisibility(View.INVISIBLE);
            BL7Button.setVisibility(View.INVISIBLE);
            BL7Button.setEnabled(false);


        }

        if (key == 9) {

            BL4Green.setVisibility(View.INVISIBLE);
            BL4Button.setVisibility(View.INVISIBLE);
            BL4Button.setEnabled(false);

            BL7Green.setVisibility(View.INVISIBLE);
            BL7Button.setVisibility(View.INVISIBLE);
            BL7Button.setEnabled(false);


        }


        if (key == 10) {

            BL3Green.setVisibility(View.INVISIBLE);
            BL3Button.setVisibility(View.INVISIBLE);
            BL3Button.setEnabled(false);

            BL6Green.setVisibility(View.INVISIBLE);
            BL6Button.setVisibility(View.INVISIBLE);
            BL6Button.setEnabled(false);

            BL10Green.setVisibility(View.INVISIBLE);
            BL10Button.setVisibility(View.INVISIBLE);
            BL10Button.setEnabled(false);
        }

        if (key == 11) {

            BL3Green.setVisibility(View.INVISIBLE);
            BL3Button.setVisibility(View.INVISIBLE);
            BL3Button.setEnabled(false);

            BL6Green.setVisibility(View.INVISIBLE);
            BL6Button.setVisibility(View.INVISIBLE);
            BL6Button.setEnabled(false);

            BL10Green.setVisibility(View.INVISIBLE);
            BL10Button.setVisibility(View.INVISIBLE);
            BL10Button.setEnabled(false);
        }

        if (key == 12) {

            BL2Green.setVisibility(View.INVISIBLE);
            BL2Button.setVisibility(View.INVISIBLE);
            BL2Button.setEnabled(false);

            BL5Green.setVisibility(View.INVISIBLE);
            BL5Button.setVisibility(View.INVISIBLE);
            BL5Button.setEnabled(false);

            BL9Green.setVisibility(View.INVISIBLE);
            BL9Button.setVisibility(View.INVISIBLE);
            BL9Button.setEnabled(false);
        }


    }



    private void whatIsNote2() {
        if (intervalDirection == 1) {
            if (key == 1) {
                if (interval == 1) {
                    W5 = true;
                }
                if (interval == 2) {
                    W4 = true;
                }
                if (interval == 3) {
                    W8 = true;
                }
                if (interval == 4) {
                    W3 = true;
                }
                if (interval == 5) {
                    BL3 = true;
                }
                if (interval == 6) {
                    W2 = true;
                }
                if (interval == 7) {
                    BL2 = true;
                }
                if (interval == 8) {
                    W6 = true;
                }
                if (interval == 9) {
                    BL6 = true;
                }
                if (interval == 10) {
                    BL7 = true;
                }
                if (interval == 11) {
                    W7 = true;
                }
                if (interval == 12) {
                    BL5 = true;
                }

            }
            if (key == 2) {
                if (interval == 1) {
                    BL6 = true;
                }
                if (interval == 2) {
                    BL5 = true;
                }
                if (interval == 3) {
                    BL9 = true;
                }
                if (interval == 4) {
                    W4 = true;
                }
                if (interval == 5) {
                    W3 = true;
                }
                if (interval == 6) {
                    BL3 = true;
                }
                if (interval == 7) {
                    W2 = true;
                }
                if (interval == 8) {
                    BL7 = true;
                }
                if (interval == 9) {
                    W6 = true;
                }
                if (interval == 10) {
                    W7 = true;
                }
                if (interval == 11) {
                    W8 = true;
                }
                if (interval == 12) {
                    W5 = true;
                }

            }
            if (key == 3) {
                if (interval == 1) {
                    W5 = true;
                }
                if (interval == 2) {
                    W4 = true;
                }
                if (interval == 3) {
                    W8 = true;
                }
                if (interval == 4) {
                    BL4 = true;
                }
                if (interval == 5) {
                    W3 = true;
                }
                if (interval == 6) {
                    W2 = true;
                }
                if (interval == 7) {
                    BL2 = true;
                }
                if (interval == 8) {
                    W6 = true;
                }
                if (interval == 9) {
                    BL6 = true;
                }
                if (interval == 10) {
                    W7 = true;
                }
                if (interval == 11) {
                    BL8 = true;
                }
                if (interval == 12) {
                    BL5 = true;
                }

            }
            if (key == 4) {
                if (interval == 1) {
                    BL6 = true;
                }
                if (interval == 2) {
                    BL5 = true;
                }
                if (interval == 3) {
                    BL9 = true;
                }
                if (interval == 4) {
                    W4 = true;
                }
                if (interval == 5) {
                    BL4 = true;
                }
                if (interval == 6) {
                    W3 = true;
                }
                if (interval == 7) {
                    W2 = true;
                }
                if (interval == 8) {
                    W7 = true;
                }
                if (interval == 9) {
                    W6 = true;
                }
                if (interval == 10) {
                    BL8 = true;
                }
                if (interval == 11) {
                    W8 = true;
                }
                if (interval == 12) {
                    W5 = true;
                }

            }
            if (key == 5) {
                if (interval == 1) {
                    W5 = true;
                }
                if (interval == 2) {
                    W4 = true;
                }
                if (interval == 3) {
                    W8 = true;
                }
                if (interval == 4) {
                    BL4 = true;
                }
                if (interval == 5) {
                    W3 = true;
                }
                if (interval == 6) {
                    BL3 = true;
                }
                if (interval == 7) {
                    W2 = true;
                }
                if (interval == 8) {
                    BL7 = true;
                }
                if (interval == 9) {
                    W6 = true;
                }
                if (interval == 10) {
                    W7 = true;
                }
                if (interval == 11) {
                    BL8 = true;
                }
                if (interval == 12) {
                    BL5 = true;
                }

            }
            if (key == 6) {
                if (interval == 1) {
                    W5 = true;
                }
                if (interval == 2) {
                    BL4 = true;
                }
                if (interval == 3) {
                    W8 = true;
                }
                if (interval == 4) {
                    W3 = true;
                }
                if (interval == 5) {
                    BL3 = true;
                }
                if (interval == 6) {
                    W2 = true;
                }
                if (interval == 7) {
                    BL2 = true;
                }
                if (interval == 8) {
                    W6 = true;
                }
                if (interval == 9) {
                    BL6 = true;
                }
                if (interval == 10) {
                    BL7 = true;
                }
                if (interval == 11) {
                    W7 = true;
                }
                if (interval == 12) {
                    W4 = true;
                }

            }
            if (key == 7) {
                if (interval == 1) {
                    BL6 = true;
                }
                if (interval == 2) {
                    W4 = true;
                }
                if (interval == 3) {
                    BL9 = true;
                }
                if (interval == 4) {
                    BL4 = true;
                }
                if (interval == 5) {
                    W3 = true;
                }
                if (interval == 6) {
                    BL3 = true;
                }
                if (interval == 7) {
                    W2 = true;
                }
                if (interval == 8) {
                    BL7 = true;
                }
                if (interval == 9) {
                    W6 = true;
                }
                if (interval == 10) {
                    W7 = true;
                }
                if (interval == 11) {
                    W8 = true;
                }
                if (interval == 12) {
                    W5 = true;
                }

            }
            if (key == 8) {
                if (interval == 1) {
                    W5 = true;
                }
                if (interval == 2) {
                    W4 = true;
                }
                if (interval == 3) {
                    W8 = true;
                }
                if (interval == 4) {
                    W3 = true;
                }
                if (interval == 5) {
                    BL3 = true;
                }
                if (interval == 6) {
                    W2 = true;
                }
                if (interval == 7) {
                    BL2 = true;
                }
                if (interval == 8) {
                    W6 = true;
                }
                if (interval == 9) {
                    BL6 = true;
                }
                if (interval == 10) {
                    W7 = true;
                }
                if (interval == 11) {
                    BL8 = true;
                }
                if (interval == 12) {
                    BL5 = true;
                }

            }
            if (key == 9) {
                if (interval == 1) {
                    BL6 = true;
                }
                if (interval == 2) {
                    BL5 = true;
                }
                if (interval == 3) {
                    BL9 = true;
                }
                if (interval == 4) {
                    W4 = true;
                }
                if (interval == 5) {
                    W3 = true;
                }
                if (interval == 6) {
                    BL3 = true;
                }
                if (interval == 7) {
                    W2 = true;
                }
                if (interval == 8) {
                    W7 = true;
                }
                if (interval == 9) {
                    W6 = true;
                }
                if (interval == 10) {
                    BL8 = true;
                }
                if (interval == 11) {
                    W8 = true;
                }
                if (interval == 12) {
                    W5 = true;
                }

            }
            if (key == 10) {
                if (interval == 1) {
                    W5 = true;
                }
                if (interval == 2) {
                    W4 = true;
                }
                if (interval == 3) {
                    W8 = true;
                }
                if (interval == 4) {
                    BL4 = true;
                }
                if (interval == 5) {
                    W3 = true;
                }
                if (interval == 6) {
                    W2 = true;
                }
                if (interval == 7) {
                    BL2 = true;
                }
                if (interval == 8) {
                    BL7 = true;
                }
                if (interval == 9) {
                    W6 = true;
                }
                if (interval == 10) {
                    W7 = true;
                }
                if (interval == 11) {
                    BL8 = true;
                }
                if (interval == 12) {
                    BL5 = true;
                }

            }
            if (key == 11) {
                if (interval == 1) {
                    W6 = true;
                }
                if (interval == 2) {
                    BL5 = true;
                }
                if (interval == 3) {
                    BL9 = true;
                }
                if (interval == 4) {
                    W4 = true;
                }
                if (interval == 5) {
                    BL4 = true;
                }
                if (interval == 6) {
                    W3 = true;
                }
                if (interval == 7) {
                    W2 = true;
                }
                if (interval == 8) {
                    W7 = true;
                }
                if (interval == 9) {
                    BL7 = true;
                }
                if (interval == 10) {
                    BL8 = true;
                }
                if (interval == 11) {
                    W8 = true;
                }
                if (interval == 12) {
                    W5 = true;
                }

            }
            if (key == 12) {
                if (interval == 1) {
                    BL6 = true;
                }
                if (interval == 2) {
                    W4 = true;
                }
                if (interval == 3) {
                    W8 = true;
                }
                if (interval == 4) {
                    BL4 = true;
                }
                if (interval == 5) {
                    W3 = true;
                }
                if (interval == 6) {
                    BL3 = true;
                }
                if (interval == 7) {
                    W2 = true;
                }
                if (interval == 8) {
                    BL7 = true;
                }
                if (interval == 9) {
                    W6 = true;
                }
                if (interval == 10) {
                    W7 = true;
                }
                if (interval == 11) {
                    BL8 = true;
                }
                if (interval == 12) {
                    W5 = true;
                }

            }

        }
        if (intervalDirection == 2) {
            if (key == 1) {
                if (interval == 1) {
                    W4 = true;
                }
                if (interval == 2) {
                    W5 = true;

                }
                if (interval == 3) {
                    W1 = true;
                }
                if (interval == 4) {
                    BL6 = true;
                }
                if (interval == 5) {
                    W6 = true;
                }
                if (interval == 6) {
                    BL7 = true;
                }
                if (interval == 7) {
                    W7 = true;
                }
                if (interval == 8) {
                    BL3 = true;
                }
                if (interval == 9) {
                    W3 = true;
                }
                if (interval == 10) {
                    W2 = true;
                }
                if (interval == 11) {
                    BL2 = true;
                }
                if (interval == 12) {
                    BL5 = true;
                }

            }
            if (key == 2) {
                if (interval == 1) {
                    BL5 = true;
                }
                if (interval == 2) {
                    BL6 = true;
                }
                if (interval == 3) {
                    BL2 = true;
                }
                if (interval == 4) {
                    W6 = true;
                }
                if (interval == 5) {
                    BL7 = true;
                }
                if (interval == 6) {
                    W7 = true;
                }
                if (interval == 7) {
                    W8 = true;
                }
                if (interval == 8) {
                    W3 = true;
                }
                if (interval == 9) {
                    W4 = true;
                }
                if (interval == 10) {
                    BL3 = true;
                }
                if (interval == 11) {
                    W2 = true;
                }
                if (interval == 12) {
                    W5 = true;
                }

            }
            if (key == 3) {
                if (interval == 1) {
                    W4 = true;
                }
                if (interval == 2) {
                    W5 = true;
                }
                if (interval == 3) {
                    W1 = true;
                }
                if (interval == 4) {
                    BL6 = true;
                }
                if (interval == 5) {
                    W6 = true;
                }
                if (interval == 6) {
                    W7 = true;
                }
                if (interval == 7) {
                    BL8 = true;
                }
                if (interval == 8) {
                    W3 = true;
                }
                if (interval == 9) {
                    BL4 = true;
                }
                if (interval == 10) {
                    W2 = true;
                }
                if (interval == 11) {
                    BL2 = true;
                }
                if (interval == 12) {
                    BL5 = true;
                }

            }
            if (key == 4) {
                if (interval == 1) {
                    BL5 = true;
                }
                if (interval == 2) {
                    BL6 = true;
                }
                if (interval == 3) {
                    BL2 = true;
                }
                if (interval == 4) {
                    W6 = true;
                }
                if (interval == 5) {
                    W7 = true;
                }
                if (interval == 6) {
                    BL8 = true;
                }
                if (interval == 7) {
                    W8 = true;
                }
                if (interval == 8) {
                    BL4 = true;
                }
                if (interval == 9) {
                    W4 = true;
                }
                if (interval == 10) {
                    W3 = true;
                }
                if (interval == 11) {
                    W2 = true;
                }
                if (interval == 12) {
                    W5 = true;
                }

            }
            if (key == 5) {
                if (interval == 1) {
                    W4 = true;
                }
                if (interval == 2) {
                    W5 = true;
                }
                if (interval == 3) {
                    W1 = true;
                }
                if (interval == 4) {
                    W6 = true;
                }
                if (interval == 5) {
                    BL7 = true;
                }
                if (interval == 6) {
                    W7 = true;
                }
                if (interval == 7) {
                    BL8 = true;
                }
                if (interval == 8) {
                    W3 = true;
                }
                if (interval == 9) {
                    BL4 = true;
                }
                if (interval == 10) {
                    BL3 = true;
                }
                if (interval == 11) {
                    W2 = true;
                }
                if (interval == 12) {
                    BL5 = true;
                }

            }
            if (key == 6) {
                if (interval == 1) {
                    BL4 = true;
                }
                if (interval == 2) {
                    W5 = true;
                }
                if (interval == 3) {
                    W1 = true;
                }
                if (interval == 4) {
                    BL6 = true;
                }
                if (interval == 5) {
                    W6 = true;
                }
                if (interval == 6) {
                    BL7 = true;
                }
                if (interval == 7) {
                    W7 = true;
                }
                if (interval == 8) {
                    BL3 = true;
                }
                if (interval == 9) {
                    W3 = true;
                }
                if (interval == 10) {
                    W2 = true;
                }
                if (interval == 11) {
                    BL2 = true;
                }
                if (interval == 12) {
                    W4 = true;
                }

            }
            if (key == 7) {
                if (interval == 1) {
                    W4 = true;
                }
                if (interval == 2) {
                    BL6 = true;
                }
                if (interval == 3) {
                    BL2 = true;
                }
                if (interval == 4) {
                    W6 = true;
                }
                if (interval == 5) {
                    BL7 = true;
                }
                if (interval == 6) {
                    W7 = true;
                }
                if (interval == 7) {
                    W8 = true;
                }
                if (interval == 8) {
                    W3 = true;
                }
                if (interval == 9) {
                    BL4 = true;
                }
                if (interval == 10) {
                    BL3 = true;
                }
                if (interval == 11) {
                    W2 = true;
                }
                if (interval == 12) {
                    W5 = true;
                }

            }
            if (key == 8) {
                if (interval == 1) {
                    W4 = true;
                }
                if (interval == 2) {
                    W5 = true;
                }
                if (interval == 3) {
                    W1 = true;
                }
                if (interval == 4) {
                    BL6 = true;
                }
                if (interval == 5) {
                    W6 = true;
                }
                if (interval == 6) {
                    W7 = true;
                }
                if (interval == 7) {
                    BL8 = true;
                }
                if (interval == 8) {
                    BL3 = true;
                }
                if (interval == 9) {
                    W3 = true;
                }
                if (interval == 10) {
                    W2 = true;
                }
                if (interval == 11) {
                    BL2 = true;
                }
                if (interval == 12) {
                    BL5 = true;
                }

            }
            if (key == 9) {
                if (interval == 1) {
                    BL5 = true;
                }
                if (interval == 2) {
                    BL6 = true;
                }
                if (interval == 3) {
                    BL9 = true;
                }
                if (interval == 4) {
                    W6 = true;
                }
                if (interval == 5) {
                    W7 = true;
                }
                if (interval == 6) {
                    BL8 = true;
                }
                if (interval == 7) {
                    W8 = true;
                }
                if (interval == 8) {
                    W3 = true;
                }
                if (interval == 9) {
                    W4 = true;
                }
                if (interval == 10) {
                    BL3 = true;
                }
                if (interval == 11) {
                    W2 = true;
                }
                if (interval == 12) {
                    W5 = true;
                }

            }
            if (key == 10) {
                if (interval == 1) {
                    W4 = true;
                }
                if (interval == 2) {
                    W5 = true;
                }
                if (interval == 3) {
                    W1 = true;
                }
                if (interval == 4) {
                    W6 = true;
                }
                if (interval == 5) {
                    BL7 = true;
                }
                if (interval == 6) {
                    W7 = true;
                }
                if (interval == 7) {
                    BL8 = true;
                }
                if (interval == 8) {
                    W3 = true;
                }
                if (interval == 9) {
                    BL4 = true;
                }
                if (interval == 10) {
                    W2 = true;
                }
                if (interval == 11) {
                    BL2 = true;
                }
                if (interval == 12) {
                    BL5 = true;
                }

            }
            if (key == 11) {
                if (interval == 1) {
                    BL5 = true;
                }
                if (interval == 2) {
                    W6 = true;
                }
                if (interval == 3) {
                    BL2 = true;
                }
                if (interval == 4) {
                    BL7 = true;
                }
                if (interval == 5) {
                    W7 = true;
                }
                if (interval == 6) {
                    BL8 = true;
                }
                if (interval == 7) {
                    W8 = true;
                }
                if (interval == 8) {
                    BL4 = true;
                }
                if (interval == 9) {
                    W4 = true;
                }
                if (interval == 10) {
                    W3 = true;
                }
                if (interval == 11) {
                    W2 = true;
                }
                if (interval == 12) {
                    W5 = true;
                }

            }
            if (key == 12) {
                if (interval == 1) {
                    W4 = true;
                }
                if (interval == 2) {
                    BL6 = true;
                }
                if (interval == 3) {
                    W1 = true;
                }
                if (interval == 4) {
                    W6 = true;
                }
                if (interval == 5) {
                    BL7 = true;

                }
                if (interval == 6) {
                    W7 = true;
                }
                if (interval == 7) {
                    BL8 = true;
                }
                if (interval == 8) {
                    W3 = true;
                }
                if (interval == 9) {
                    BL4 = true;
                }
                if (interval == 10) {
                    BL3 = true;
                }
                if (interval == 11) {
                    W2 = true;
                }
                if (interval == 12) {
                    W5 = true;
                }

            }


        }

    }



    private void correctNotes() {


        if (intervalDirection == 1) {
            correctNote1 = (12 * (octave - 1)) + (key);


            if (interval == 1) {
                correctNote2 = correctNote1 + 7;
            }
            if (interval == 2) {
                correctNote2 = correctNote1 + 5;
            }
            if (interval == 3) {
                correctNote2 = correctNote1 + 12;
            }
            if (interval == 4) {
                correctNote2 = correctNote1 + 4;
            }
            if (interval == 5) {
                correctNote2 = correctNote1 + 3;
            }
            if (interval == 6) {
                correctNote2 = correctNote1 + 2;
            }
            if (interval == 7) {
                correctNote2 = correctNote1 + 1;
            }
            if (interval == 8) {
                correctNote2 = correctNote1 + 9;
            }
            if (interval == 9) {
                correctNote2 = correctNote1 + 8;
            }
            if (interval == 10) {
                correctNote2 = correctNote1 + 10;
            }
            if (interval == 11) {
                correctNote2 = correctNote1 + 11;
            }
            if (interval == 12) {
                correctNote2 = correctNote1 + 6;
            }


        }

        if (intervalDirection == 2) {
            correctNote1 = (12 * (octave - 1) + (key) + 12);


            if (interval == 1) {
                correctNote2 = correctNote1 - 7;
            }
            if (interval == 2) {
                correctNote2 = correctNote1 - 5;
            }
            if (interval == 3) {
                correctNote2 = correctNote1 - 12;
            }
            if (interval == 4) {
                correctNote2 = correctNote1 - 4;
            }
            if (interval == 5) {
                correctNote2 = correctNote1 - 3;
            }
            if (interval == 6) {
                correctNote2 = correctNote1 - 2;
            }
            if (interval == 7) {
                correctNote2 = correctNote1 - 1;
            }
            if (interval == 8) {
                correctNote2 = correctNote1 - 9;
            }
            if (interval == 9) {
                correctNote2 = correctNote1 - 8;
            }
            if (interval == 10) {
                correctNote2 = correctNote1 - 10;
            }
            if (interval == 11) {
                correctNote2 = correctNote1 - 11;
            }
            if (interval == 12) {
                correctNote2 = correctNote1 - 6;
            }

        }

    }



    private void setNote1 () {



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
            note1 = "c6" + instrumentName;
        }




    }


    private void setNote2 () {



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
            note2 = "c6" + instrumentName;
        }


    }

    private void setInterval() {
        final Random rand = new Random();
        interval = rand.nextInt(level) + 1;

        final Random rand1 = new Random();
        intervalDirection = rand1.nextInt(2) + 1;


    }



    private void playAnswer() {
        setLevel();

        if (correctNote1 == 0 && correctNote2 == 0) {
            setKey();
            setBoard();
            setInterval();
            final Random rand2 = new Random();
            octave = rand2.nextInt(4) + 1;
            final Random rand4 = new Random();
            delay = rand4.nextInt(500) + 500;
            resetNotes();
            correctNotes();
            setNote1();
            setNote2();
            whatIsNote2();
            resetColor();
        }

        play1(note1);

        countDown2();

        firstNotePressed = false;
        secondNotePressed = false;
        playPressed = true;

        ImageView BL2Green = (ImageView) findViewById(R.id.BL2Green);
        ImageView W1Green = (ImageView) findViewById(R.id.W1Green);
        ImageView BL9Green = (ImageView) findViewById(R.id.BL9Green);
        ImageView W8Green = (ImageView) findViewById(R.id.W8Green);

        if (key == 2 || key == 4 || key == 7 || key == 9 || key == 11) {
            BL2Green.setVisibility(View.VISIBLE);
            BL9Green.setVisibility(View.VISIBLE);
        } else {
            W1Green.setVisibility(View.VISIBLE);
            W8Green.setVisibility(View.VISIBLE);
        }


    }




    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
