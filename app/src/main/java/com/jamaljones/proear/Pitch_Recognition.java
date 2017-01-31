package com.jamaljones.proear;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
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
import android.content.res.AssetFileDescriptor;
import android.os.Handler;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Pitch_Recognition extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    MediaPlayer audio1;
    MediaPlayer audio2;
    private ProgressBar progressBar;
    private Button playButton;
    private int progressStatus = 0;
    private TextView textView;
    private ImageView cGreen;
    private ImageView cSGreen;
    private ImageView dGreen;
    private ImageView dSGreen;
    private ImageView eGreen;
    private ImageView fGreen;
    private ImageView fSGreen;
    private ImageView gGreen;
    private ImageView gSGreen;
    private ImageView aGreen;
    private ImageView aSGreen;
    private ImageView bGreen;
    private String note;
    private String note1;
    private int octave = 3;
    private int correctNote = 0;
    private int level = 0;
    private String instrumentName = "piano";
    private String answer;
    private String lvl;
    private String currentLevel;
    private boolean levelChanged = true;
    private Handler handler;
    private boolean running = true;
    private CountDownTimer timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pitch__recognition);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Pitch Recognition");

        spinner= (Spinner) findViewById(R.id.spinner);
        progressBar= (ProgressBar) findViewById(R.id.progressBar);
        textView = (TextView) findViewById(R.id.progressTextView);
        progressBar.getProgressDrawable().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);
        currentLevel = lvl;

        ArrayAdapter adapter=ArrayAdapter.createFromResource(this,R.array.pitchlevels,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        setMenuButton();
        setPlayButton();
        setCButton();
        setCSButton();
        setDButton();
        setDSButton();
        setEButton();
        setFButton();
        setFSButton();
        setGButton();
        setgSButton();
        setAButton();
        setASButton();
        setBButton();
        progressBar.setProgress(0);
    }

    private void setMenuButton() {
        Button menuButton = (Button) findViewById(R.id.menuButton);
        menuButton.setTransformationMethod(null);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                stop();
                startActivity(new Intent(Pitch_Recognition.this, MainActivity.class));
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
                stop();
                setLevel();
                setAnswer();
                playAnswer(answer);
                levelChanged = false;

            }
        });

    }

    private void play(String sound) {
        int resID1 = getResources().getIdentifier(sound, "raw", getPackageName());
        MediaPlayer audio1 = MediaPlayer.create(Pitch_Recognition.this, resID1);
        audio1.start();
        audio1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio1) {
                audio1.release();

            }


        });
    }

    private void playAnswer(String sound) {
        int resID2 = getResources().getIdentifier(sound, "raw", getPackageName());
        MediaPlayer audio2 = MediaPlayer.create(Pitch_Recognition.this, resID2);
        audio2.start();
        audio2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio2) {
                audio2.release();

            }


        });
    }

    private void stop() {
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

    private void countdown() {
        timer = new CountDownTimer(1500, 1500) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                if (running) {
                    stop();
                    displayAnswer();
                    playAnswer(answer);
                    resetNote();
                }
            }
        }.start();
    }

    private void resetNote() {
        correctNote = 0;
    }

    private void setLevel() {

        lvl = spinner.getSelectedItem().toString();

        if (!lvl.equals(currentLevel)) {
            levelChanged = true;
        }

        if (levelChanged) {
            resetNote();
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

        currentLevel = lvl;
        updateProgress();
        levelChanged = false;
    }

    private void displayAnswer() {

        if (correctNote == 1) {
            cGreen = (ImageView) findViewById(R.id.cGreen);
            cGreen.setVisibility(View.VISIBLE);
        }

        if (correctNote == 2) {
            gGreen = (ImageView) findViewById(R.id.gGreen);
            gGreen.setVisibility(View.VISIBLE);
        }

        if (correctNote == 3) {
            eGreen = (ImageView) findViewById(R.id.eGreen);
            eGreen.setVisibility(View.VISIBLE);
        }

        if (correctNote == 4) {
            fGreen = (ImageView) findViewById(R.id.fGreen);
            fGreen.setVisibility(View.VISIBLE);
        }

        if (correctNote == 5) {
            dGreen = (ImageView) findViewById(R.id.dGreen);
            dGreen.setVisibility(View.VISIBLE);
        }

        if (correctNote == 6) {
            aGreen = (ImageView) findViewById(R.id.aGreen);
            aGreen.setVisibility(View.VISIBLE);
        }

        if (correctNote == 7) {
            bGreen = (ImageView) findViewById(R.id.bGreen);
            bGreen.setVisibility(View.VISIBLE);
        }

        if (correctNote == 8) {
            cSGreen = (ImageView) findViewById(R.id.cSGreen);
            cSGreen.setVisibility(View.VISIBLE);
        }

        if (correctNote == 9) {
            dSGreen = (ImageView) findViewById(R.id.dSGreen);
            dSGreen.setVisibility(View.VISIBLE);
        }

        if (correctNote == 10) {
            fSGreen = (ImageView) findViewById(R.id.fSGreen);
            fSGreen.setVisibility(View.VISIBLE);
        }

        if (correctNote == 11) {
            gSGreen = (ImageView) findViewById(R.id.gSGreen);
            gSGreen.setVisibility(View.VISIBLE);
        }

        if (correctNote == 12) {
            aSGreen = (ImageView) findViewById(R.id.aSGreen);
            aSGreen.setVisibility(View.VISIBLE);
        }

    }

    private void resetColor() {
        cGreen = (ImageView) findViewById(R.id.cGreen);
        cGreen.setVisibility(View.INVISIBLE);

        gGreen = (ImageView) findViewById(R.id.gGreen);
        gGreen.setVisibility(View.INVISIBLE);

        eGreen = (ImageView) findViewById(R.id.eGreen);
        eGreen.setVisibility(View.INVISIBLE);

        fGreen = (ImageView) findViewById(R.id.fGreen);
        fGreen.setVisibility(View.INVISIBLE);

        dGreen = (ImageView) findViewById(R.id.dGreen);
        dGreen.setVisibility(View.INVISIBLE);

        aGreen = (ImageView) findViewById(R.id.aGreen);
        aGreen.setVisibility(View.INVISIBLE);

        bGreen = (ImageView) findViewById(R.id.bGreen);
        bGreen.setVisibility(View.INVISIBLE);

        cSGreen = (ImageView) findViewById(R.id.cSGreen);
        cSGreen.setVisibility(View.INVISIBLE);

        dSGreen = (ImageView) findViewById(R.id.dSGreen);
        dSGreen.setVisibility(View.INVISIBLE);

        fSGreen = (ImageView) findViewById(R.id.fSGreen);
        fSGreen.setVisibility(View.INVISIBLE);

        gSGreen = (ImageView) findViewById(R.id.gSGreen);
        gSGreen.setVisibility(View.INVISIBLE);

        aSGreen = (ImageView) findViewById(R.id.aSGreen);
        aSGreen.setVisibility(View.INVISIBLE);

    }


    private void setCButton() {
        Button cButton = (Button) findViewById(R.id.cButton);
        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
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
                if (octave == 5) {
                    note = "c5" + instrumentName;
                }

                play(note);

                if (correctNote != 0 && correctNote != 1) {
                    progressStatus = 0;
                    running = true;
                    countdown();
                }

                if (correctNote == 1) {
                    displayAnswer();
                    progressStatus++;
                    resetNote();

                }

                if (progressStatus >= 20 && level < 11) {
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

    private void setCSButton() {
        Button cSButton = (Button) findViewById(R.id.cSButton);
        cSButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
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
                if (octave == 5) {
                    note = "cs5" + instrumentName;
                }

                play(note);

                if (correctNote != 0 && correctNote != 8) {
                    progressStatus = 0;
                    running = true;
                    countdown();
                }

                if (correctNote == 8) {
                    displayAnswer();
                    progressStatus++;
                    resetNote();

                }

                if (progressStatus >= 20 && level < 11) {
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

    private void setDButton() {
        Button dButton = (Button) findViewById(R.id.dButton);
        dButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
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
                if (octave == 5) {
                    note = "d5" + instrumentName;
                }

                play(note);

                if (correctNote != 0 && correctNote != 5) {
                    progressStatus = 0;
                    running = true;
                    countdown();
                }

                if (correctNote == 5) {
                    displayAnswer();
                    progressStatus++;
                    resetNote();

                }

                if (progressStatus >= 20 && level < 11) {
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

    private void setDSButton() {
        Button dSButton = (Button) findViewById(R.id.dSButton);
        dSButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
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
                if (octave == 5) {
                    note = "ds5" + instrumentName;
                }

                play(note);

                if (correctNote != 0 && correctNote != 9) {
                    progressStatus = 0;
                    running = true;
                    countdown();
                }

                if (correctNote == 9) {
                    displayAnswer();
                    progressStatus++;
                    resetNote();

                }

                if (progressStatus >= 20 && level < 11) {
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

    private void setEButton() {
        Button eButton = (Button) findViewById(R.id.eButton);
        eButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
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
                if (octave == 5) {
                    note = "e5" + instrumentName;
                }

                play(note);

                if (correctNote != 0 && correctNote != 3) {
                    progressStatus = 0;
                    running = true;
                    countdown();
                }

                if (correctNote == 3) {
                    displayAnswer();
                    progressStatus++;
                    resetNote();

                }

                if (progressStatus >= 20 && level < 11) {
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

    private void setFButton() {
        Button fButton = (Button) findViewById(R.id.fButton);
        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
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
                if (octave == 5) {
                    note = "f5" + instrumentName;
                }

                play(note);

                if (correctNote != 0 && correctNote != 4) {
                    progressStatus = 0;
                    running = true;
                    countdown();
                }

                if (correctNote == 4) {
                    displayAnswer();
                    progressStatus++;
                    resetNote();

                }

                if (progressStatus >= 20 && level < 11) {
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

    private void setFSButton() {
        Button fSButton = (Button) findViewById(R.id.fSButton);
        fSButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
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
                if (octave == 5) {
                    note = "fs5" + instrumentName;
                }

                play(note);

                if (correctNote != 0 && correctNote != 10) {
                    progressStatus = 0;
                    running = true;
                    countdown();
                }

                if (correctNote == 10) {
                    displayAnswer();
                    progressStatus++;
                    resetNote();

                }

                if (progressStatus >= 20 && level < 11) {
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

    private void setGButton() {
        Button gButton = (Button) findViewById(R.id.gButton);
        gButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
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
                if (octave == 5) {
                    note = "g5" + instrumentName;
                }

                play(note);

                if (correctNote != 0 && correctNote != 2) {
                    progressStatus = 0;
                    running = true;
                    countdown();
                }

                if (correctNote == 2) {
                    displayAnswer();
                    progressStatus++;
                    resetNote();

                }

                if (progressStatus >= 20 && level < 11) {
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

    private void setgSButton() {
        Button gSButton = (Button) findViewById(R.id.gSButton);
        gSButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
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
                if (octave == 5) {
                    note = "gs5" + instrumentName;
                }

                play(note);

                if (correctNote != 0 && correctNote != 11) {
                    progressStatus = 0;
                    running = true;
                    countdown();
                }

                if (correctNote == 11) {
                    displayAnswer();
                    progressStatus++;
                    resetNote();

                }

                if (progressStatus >= 20 && level < 11) {
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

    private void setAButton() {
        Button aButton = (Button) findViewById(R.id.aButton);
        aButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
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
                if (octave == 5) {
                    note = "a5" + instrumentName;
                }

                play(note);

                if (correctNote != 0 && correctNote != 6) {
                    progressStatus = 0;
                    running = true;
                    countdown();
                }

                if (correctNote == 6) {
                    displayAnswer();
                    progressStatus++;
                    resetNote();

                }

                if (progressStatus >= 20 && level < 11) {
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

    private void setASButton() {
        Button aSButton = (Button) findViewById(R.id.aSButton);
        aSButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
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
                if (octave == 5) {
                    note = "as5" + instrumentName;
                }

                play(note);

                if (correctNote != 0 && correctNote != 12) {
                    progressStatus = 0;
                    running = true;
                    countdown();
                }

                if (correctNote == 12) {
                    displayAnswer();
                    progressStatus++;
                    resetNote();

                }

                if (progressStatus >= 20 && level < 11) {
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

    private void setBButton() {
        Button bButton = (Button) findViewById(R.id.bButton);
        bButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
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
                if (octave == 5) {
                    note = "b5" + instrumentName;
                }

                play(note);

                if (correctNote != 0 && correctNote != 7) {
                    progressStatus = 0;
                    running = true;
                    countdown();
                }

                if (correctNote == 7) {
                    displayAnswer();
                    progressStatus++;
                    resetNote();

                }

                if (progressStatus >= 20 && level < 11) {
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

    private void setAnswer() {
        if (correctNote == 0) {
            resetColor();
            final Random rand = new Random();
            octave = rand.nextInt(5) + 1;
            final Random rand1 = new Random();
            correctNote = rand1.nextInt(level + 1) + 1;
        }

        if (octave == 1 && correctNote == 1) {
            answer = "c1" + instrumentName;;
        }
        if (octave == 1 && correctNote == 2) {
            answer = "g1" + instrumentName;
        }

        if (octave == 1 && correctNote == 3) {
            answer = "e1" + instrumentName;
        }
        if (octave == 1 && correctNote == 4) {
            answer = "f1" + instrumentName;
        }
        if (octave == 1 && correctNote == 5) {
            answer = "d1" + instrumentName;
        }
        if (octave == 1 && correctNote == 6) {
            answer = "a1" + instrumentName;
        }

        if (octave == 1 && correctNote == 7) {
            answer = "b1" + instrumentName;

        }
        if (octave == 1 && correctNote == 8) {
            answer = "cs1" + instrumentName;
        }

        if (octave == 1 && correctNote == 9) {
            answer = "ds1" + instrumentName;
        }

        if (octave == 1 && correctNote == 10) {
            answer = "fs1" + instrumentName;
        }
        if (octave == 1 && correctNote == 11) {
            answer = "gs1" + instrumentName;
        }

        if (octave == 1 && correctNote == 12) {
            answer = "as1" + instrumentName;

        }



        if (octave == 2 && correctNote == 1) {
            answer = "c2" + instrumentName;
        }
        if (octave == 2 && correctNote == 2) {
            answer = "g2" + instrumentName;
        }

        if (octave == 2 && correctNote == 3) {
            answer = "e2" + instrumentName;
        }
        if (octave == 2 && correctNote == 4) {
            answer = "f2" + instrumentName;
        }
        if (octave == 2 && correctNote == 5) {
            answer = "d2" + instrumentName;
        }
        if (octave == 2 && correctNote == 6) {
            answer = "a2" + instrumentName;
        }

        if (octave == 2 && correctNote == 7) {
            answer = "b2" + instrumentName;
        }
        if (octave == 2 && correctNote == 8) {
            answer = "cs2" + instrumentName;
        }

        if (octave == 2 && correctNote == 9) {
            answer = "ds2" + instrumentName;
        }

        if (octave == 2 && correctNote == 10) {
            answer = "fs2" + instrumentName;
        }
        if (octave == 2 && correctNote == 11) {
            answer = "gs2" + instrumentName;
        }

        if (octave == 2 && correctNote == 12) {
            answer = "as2" + instrumentName;
        }




        if (octave == 3 && correctNote == 1) {
            answer = "c3" + instrumentName;
        }
        if (octave == 3 && correctNote == 2) {
            answer = "g3" + instrumentName;
        }

        if (octave == 3 && correctNote == 3) {
            answer = "e3" + instrumentName;
        }
        if (octave == 3 && correctNote == 4) {
            answer = "f3" + instrumentName;
        }
        if (octave == 3 && correctNote == 5) {
            answer = "d3" + instrumentName;
        }
        if (octave == 3 && correctNote == 6) {
            answer = "a3" + instrumentName;
        }

        if (octave == 3 && correctNote == 7) {
            answer = "b3" + instrumentName;
        }
        if (octave == 3 && correctNote == 8) {
            answer = "cs3" + instrumentName;
        }

        if (octave == 3 && correctNote == 9) {
            answer = "ds3" + instrumentName;
        }

        if (octave == 3 && correctNote == 10) {
            answer = "fs3" + instrumentName;
        }
        if (octave == 3 && correctNote == 11) {
            answer = "gs3" + instrumentName;
        }

        if (octave == 3 && correctNote == 12) {
            answer = "as3" + instrumentName;
        }





        if (octave == 4 && correctNote == 1) {
            answer = "c4" + instrumentName;
        }
        if (octave == 4 && correctNote == 2) {
            answer = "g4" + instrumentName;
        }

        if (octave == 4 && correctNote == 3) {
            answer = "e4" + instrumentName;
        }
        if (octave == 4 && correctNote == 4) {
            answer = "f4" + instrumentName;
        }
        if (octave == 4 && correctNote == 5) {
            answer = "d4" + instrumentName;
        }
        if (octave == 4 && correctNote == 6) {
            answer = "a4" + instrumentName;
        }

        if (octave == 4 && correctNote == 7) {
            answer = "b4" + instrumentName;
        }
        if (octave == 4 && correctNote == 8) {
            answer = "cs4" + instrumentName;
        }

        if (octave == 4 && correctNote == 9) {
            answer = "ds4" + instrumentName;
        }

        if (octave == 4 && correctNote == 10) {
            answer = "fs4" + instrumentName;
        }
        if (octave == 4 && correctNote == 11) {
            answer = "gs4" + instrumentName;
        }

        if (octave == 4 && correctNote == 12) {
            answer = "as4" + instrumentName;
        }




        if (octave == 5 && correctNote == 1) {
            answer = "c5" + instrumentName;
        }
        if (octave == 5 && correctNote == 2) {
            answer = "g5" + instrumentName;
        }

        if (octave == 5 && correctNote == 3) {
            answer = "e5" + instrumentName;
        }
        if (octave == 5 && correctNote == 4) {
            answer = "f5" + instrumentName;
        }
        if (octave == 5 && correctNote == 5) {
            answer = "d5" + instrumentName;
        }
        if (octave == 5 && correctNote == 6) {
            answer = "a5" + instrumentName;
        }

        if (octave == 5 && correctNote == 7) {
            answer = "b5" + instrumentName;
        }
        if (octave == 5 && correctNote == 8) {
            answer = "cs5" + instrumentName;
        }

        if (octave == 5 && correctNote == 9) {
            answer = "ds5" + instrumentName;
        }

        if (octave == 5 && correctNote == 10) {
            answer = "fs5" + instrumentName;
        }
        if (octave == 5 && correctNote == 11) {
            answer = "gs5" + instrumentName;
        }

        if (octave == 5 && correctNote == 12) {
            answer = "as5" + instrumentName;
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
