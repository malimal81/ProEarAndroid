package com.jamaljones.proear;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
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

import java.util.Random;

public class Melody_Playback extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    MediaPlayer audio;
    MediaPlayer audio1;
    MediaPlayer audio2;
    MediaPlayer audio3;
    MediaPlayer audio4;
    MediaPlayer audio5;
    MediaPlayer audio6;
    MediaPlayer audio7;
    MediaPlayer audio8;
    private ProgressBar progressBar;
    private Button playButton;
    private int progressStatus = 0;
    private TextView textView;
    private int correctNote1 = 0;
    private int correctNote2 = 0;
    private int correctNote3 = 0;
    private int correctNote4 = 0;
    private int correctNote5 = 0;
    private int correctNote6 = 0;
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
    private int delay3 = 0;
    private int delay4 = 0;
    private int interval = 0;
    private int intervalDirection = 0;
    private int key = 1;
    private int instrument = 1;
    private int harmonic = 0;
    private String note = "c3piano";
    private String note1 = "c3piano";
    private String note2 = "g3piano";
    private String note3 = "c3piano";
    private String note4 = "c3piano";
    private String note5 = "g3piano";
    private boolean running = true;
    private CountDownTimer timer;
    private CountDownTimer timer1;
    private CountDownTimer timer2;
    private CountDownTimer timer3;
    private CountDownTimer timer4;
    private CountDownTimer timer5;
    private CountDownTimer timer6;
    private CountDownTimer timer7;
    private int sharp = 0;
    private int major = 0;
    private boolean firstNotePressed = false;
    private boolean secondNotePressed = false;
    private boolean thirdNotePressed = false;
    private boolean fourthNotePressed = false;
    private boolean fifthNotePressed = false;
    private boolean playPressed = false;
    private boolean noteOneCorrect = false;
    private boolean noteTwoCorrect = false;
    private boolean noteThreeCorrect = false;
    private boolean noteFourCorrect = false;
    private boolean noteFiveCorrect = false;
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
    private int scale1 = 0;
    private int scale2 = 0;
    private int scale3 = 0;
    private int scale4 = 0;
    private int scale5 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_melody__playback);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle("Melody Playback");

        spinner= (Spinner) findViewById(R.id.spinner);
        progressBar= (ProgressBar) findViewById(R.id.progressBar);
        textView = (TextView) findViewById(R.id.progressTextView);
        progressBar.getProgressDrawable().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);

        ArrayAdapter adapter=ArrayAdapter.createFromResource(this,R.array.melodylevels,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

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
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                stop();
                startActivity(new Intent(Melody_Playback.this, MainActivity.class));
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
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();
                stop();
                playAnswer();
                playPressed = true;
                levelChanged = false;

            }
        });

    }

    private void setMelody() {
        final Random rand1 = new Random();
        scale1 = rand1.nextInt(level+1) + 1;

        final Random rand2 = new Random();
        scale2 = rand2.nextInt(level + 1) + 1;

        final Random rand3 = new Random();
        scale3 = rand3.nextInt(level + 1) + 1;

        final Random rand4 = new Random();
        scale4 = rand4.nextInt(level + 1) + 1;

        if (level == 1) {
            final Random rand5 = new Random();
            scale5 = rand5.nextInt(2) + 1;
        } else {
            final Random rand6 = new Random();
            scale5 = rand6.nextInt(3) + 1;
        }
    }

    private void playAnswer() {
        stop();
        cancelTimer();
        cancelTimer1();
        cancelTimer2();
        cancelTimer3();
        cancelTimer4();
        cancelTimer5();
        setLevel();
        if (correctNote1 == 0)  {
            setKey();
            final Random rand = new Random();
            major = rand.nextInt(2);
            setBoard();
            setMelody();
            resetNotes();
            correctNotes();
            setNote1();
            setNote2();
            setNote3();
            setNote4();
            setNote5();
            resetColor();
            isCorrect = true;
            final Random rand1 = new Random();
            delay1 = rand1.nextInt(500) + 1500;
            final Random rand2 = new Random();
            delay2 = rand2.nextInt(500) + 2250;
            final Random rand3 = new Random();
            delay3 = rand3.nextInt(500) + 3000;
            final Random rand4 = new Random();
            delay4 = rand4.nextInt(500) + 3750;

        }

        countDown();
        countDown1();
        countDown2();
        countDown3();
        countDown4();

    }

    private void play(String sound) {
        int resID = getResources().getIdentifier(sound, "raw", getPackageName());
        MediaPlayer audio = MediaPlayer.create(Melody_Playback.this, resID);
        audio.start();
        audio.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio) {
                audio.release();

            }


        });
    }

    private void play1(String sound) {
        int resID1 = getResources().getIdentifier(sound, "raw", getPackageName());
        MediaPlayer audio1 = MediaPlayer.create(Melody_Playback.this, resID1);
        audio1.start();
        audio1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio1) {
                audio1.release();

            }


        });
    }


    private void play2(String sound) {
        int resID2 = getResources().getIdentifier(sound, "raw", getPackageName());
        MediaPlayer audio2 = MediaPlayer.create(Melody_Playback.this, resID2);
        audio2.start();
        audio2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio2) {
                audio2.release();

            }


        });
    }


    private void play3(String sound) {
        int resID3 = getResources().getIdentifier(sound, "raw", getPackageName());
        MediaPlayer audio3 = MediaPlayer.create(Melody_Playback.this, resID3);
        audio3.start();
        audio3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio3) {
                audio3.release();

            }


        });
    }

    private void play4(String sound) {
        int resID4 = getResources().getIdentifier(sound, "raw", getPackageName());
        MediaPlayer audio4 = MediaPlayer.create(Melody_Playback.this, resID4);
        audio4.start();
        audio4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio4) {
                audio4.release();

            }


        });
    }


    private void play5(String sound) {
        int resID5 = getResources().getIdentifier(sound, "raw", getPackageName());
        MediaPlayer audio5 = MediaPlayer.create(Melody_Playback.this, resID5);
        audio5.start();
        audio5.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio5) {
                audio5.release();

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
        if (audio3 != null && audio3.isPlaying()) {
            audio3.stop();
        }
        if (audio4 != null && audio4.isPlaying()) {
            audio4.stop();
        }
        if (audio5 != null && audio5.isPlaying()) {
            audio5.stop();
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
    private void cancelTimer3() {
        if(timer3 != null) {
            timer3.cancel();
            timer3 = null;
        }

    }
    private void cancelTimer4() {
        if(timer4 != null) {
            timer4.cancel();
            timer4 = null;
        }

    }
    private void cancelTimer5() {
        if(timer5 != null) {
            timer5.cancel();
            timer5 = null;
        }

    }


    private void countDown() {
        timer = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                displayNote1();
                play1(note1);
                cancelTimer();

            }
        }.start();
    }

    private void countDown1() {
        timer1 = new CountDownTimer(delay1, delay1) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                if (!isCorrect) {
                    resetColor();
                    displayNote2();

                }
                play2(note2);
                cancelTimer1();

            }
        }.start();
    }

    private void countDown2() {
        timer2 = new CountDownTimer(delay2, delay2) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                if (!isCorrect) {
                    resetColor();
                    displayNote3();
                }
                play3(note3);

                cancelTimer2();

            }
        }.start();
    }

    private void countDown3() {
        timer3 = new CountDownTimer(delay3, delay3) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                if (!isCorrect) {
                    resetColor();
                    displayNote4();
                }
                play4(note4);
                cancelTimer3();

            }
        }.start();
    }

    private void countDown4() {
        timer4 = new CountDownTimer(delay4, delay4) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                if (!isCorrect) {
                    resetColor();
                    displayNote5();
                    correctNote1 = 0;
                }
                play5(note5);
                cancelTimer4();

            }
        }.start();
    }

    private void countDown5() {
        timer5 = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                displayNote1();
                play1(note1);
                countDown1();
                countDown2();
                countDown3();
                countDown4();
                cancelTimer5();

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
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();

                if (key == 1) {

                    note = "c3" + instrumentName;
                }
                if (key == 2) {

                    note = "c3" + instrumentName;
                }
                if (key == 3) {

                    note = "d3" + instrumentName;
                }
                if (key == 4) {

                    note = "d3" + instrumentName;
                }
                if (key == 5) {

                    note = "e3" + instrumentName;
                }
                if (key == 6) {

                    note = "f3" + instrumentName;
                }
                if (key == 7) {

                    note = "f3" + instrumentName;
                }
                if (key == 8) {

                    note = "g3" + instrumentName;
                }
                if (key == 9) {

                    note = "g3" + instrumentName;
                }
                if (key == 10) {

                    note = "a3" + instrumentName;
                }
                if (key == 11) {

                    note = "a3" + instrumentName;
                }
                if (key == 12) {

                    note = "b3" + instrumentName;
                }

                play(note);

                if (fourthNotePressed ) {
                    if (scale5 == 1 && (key == 1 || key == 3 || key == 5 || key == 6 || key == 8 || key == 10 || key == 12) ) {
                        noteFiveCorrect = true;
                        fifthNotePressed = true;
                    } else {
                        noteFiveCorrect = false;
                        fifthNotePressed = true;
                    }
                    fourthNotePressed = false;
                }


                if (fifthNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect && noteThreeCorrect && noteFourCorrect && noteFiveCorrect) {
                        progressStatus++;
                        resetNotes();
                    } else {
                        progressStatus = 0;
                        isCorrect = false;
                        playAnswer();
                    }
                    fifthNotePressed = false;
                }


                if (thirdNotePressed ) {
                    if (scale4 == 1 && (key == 1 || key == 3 || key == 5 || key == 6 || key == 8 || key == 10 || key == 12) ) {
                        noteFourCorrect = true;
                        fourthNotePressed = true;
                    } else {
                        noteFourCorrect = false;
                        fourthNotePressed = true;
                    }
                    thirdNotePressed = false;
                }

                if (secondNotePressed ) {
                    if (scale3 == 1 && (key == 1 || key == 3 || key == 5 || key == 6 || key == 8 || key == 10 || key == 12) ) {
                        noteThreeCorrect = true;
                        thirdNotePressed = true;
                    } else {
                        noteThreeCorrect = false;
                        thirdNotePressed = true;
                    }
                    secondNotePressed = false;
                }

                if (firstNotePressed ) {
                    if (scale2 == 1 && (key == 1 || key == 3 || key == 5 || key == 6 || key == 8 || key == 10 || key == 12) ) {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                    firstNotePressed = false;
                }

                if (playPressed) {
                    if (key == 2 || key == 4 || key == 7 || key == 9 || key == 11) {
                        noteOneCorrect = false;

                    } else {
                        if (scale1 == 1) {
                            noteOneCorrect = true;

                        } else {
                            noteOneCorrect = false;

                        }
                    }
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 7) {
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
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();

                if (key == 1) {

                    note = "d3" + instrumentName;
                }
                if (key == 2) {

                    note = "d3" + instrumentName;
                }
                if (key == 3) {

                    note = "e3" + instrumentName;
                }
                if (key == 4) {

                    note = "e3" + instrumentName;
                }
                if (key == 5) {

                    note = "f3" + instrumentName;
                }
                if (key == 6) {

                    note = "g3" + instrumentName;
                }
                if (key == 7) {

                    note = "g3" + instrumentName;
                }
                if (key == 8) {

                    note = "a3" + instrumentName;
                }
                if (key == 9) {

                    note = "A3" + instrumentName;
                }
                if (key == 10) {

                    note = "b3" + instrumentName;
                }
                if (key == 11) {

                    note = "b3" + instrumentName;
                }
                if (key == 12) {

                    note = "c4" + instrumentName;
                }

                play(note);

                if (fourthNotePressed)  {
                    if (scale5 == 6 && (key == 1 || key == 3 || key == 6 || key == 8 || key == 10))  {
                        noteFiveCorrect = true;
                        fifthNotePressed = true;
                    } else {
                        noteFiveCorrect = false;
                        fifthNotePressed = true;
                    }
                    fourthNotePressed = false;
                }

                if (fifthNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect && noteThreeCorrect && noteFourCorrect && noteFiveCorrect) {
                        progressStatus++;
                        resetNotes();
                    } else {
                        progressStatus = 0;
                        isCorrect = false;
                        playAnswer();
                    }
                    fifthNotePressed = false;
                }

                if (thirdNotePressed)  {
                    if (scale4 == 6 && (key == 1 || key == 3 || key == 6 || key == 8 || key == 10))  {
                        noteFourCorrect = true;
                        fourthNotePressed = true;
                    } else {
                        noteFourCorrect = false;
                        fourthNotePressed = true;
                    }
                    thirdNotePressed = false;
                }

                if (secondNotePressed)  {
                    if (scale3 == 6 && (key == 1 || key == 3 || key == 6 || key == 8 || key == 10))  {
                        noteThreeCorrect = true;
                        thirdNotePressed = true;
                    } else {
                        noteThreeCorrect = false;
                        thirdNotePressed = true;
                    }
                    secondNotePressed = false;
                }


                if (firstNotePressed)  {
                    if (scale2 == 6 && (key == 1 || key == 3 || key == 6 || key == 8 || key == 10))  {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                    firstNotePressed = false;
                }



                if (playPressed) {
                    if (scale1 == 6 && (key == 1 || key == 3 || key == 6 || key == 8 || key == 10)) {
                        noteOneCorrect = true;

                    } else {
                        noteOneCorrect = false;
                    }
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 7) {
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
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();

                if (key == 1) {

                    note = "e3" + instrumentName;
                }
                if (key == 2) {

                    note = "e3" + instrumentName;
                }
                if (key == 3) {

                    note = "f3" + instrumentName;
                }
                if (key == 4) {

                    note = "f3" + instrumentName;
                }
                if (key == 5) {

                    note = "g3" + instrumentName;
                }
                if (key == 6) {

                    note = "a3" + instrumentName;
                }
                if (key == 7) {

                    note = "a3" + instrumentName;
                }
                if (key == 8) {

                    note = "b3" + instrumentName;
                }
                if (key == 9) {

                    note = "b3" + instrumentName;
                }
                if (key == 10) {

                    note = "c4" + instrumentName;
                }
                if (key == 11) {

                    note = "c4" + instrumentName;
                }
                if (key == 12) {

                    note = "d4" + instrumentName;
                }

                play(note);

                if (fourthNotePressed)  {
                    if ((scale5 == 2 && (key == 2 || key == 3 || key == 5 || key == 7 || key == 9 || key == 10 || key == 12) && major == 0) || (scale5 == 6 && (key == 4 || key == 11) && major == 0) || (scale5 == 2 && (key == 1 || key == 6 || key == 8) && major == 1) || (scale5 == 6 && (key == 4 || key == 11) && major == 1) )  {
                        noteFiveCorrect = true;
                        fifthNotePressed = true;
                    } else {
                        noteFiveCorrect = false;
                        fifthNotePressed = true;
                    }
                    fourthNotePressed = false;
                }
                if (fifthNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect && noteThreeCorrect && noteFourCorrect && noteFiveCorrect) {
                        progressStatus++;
                        resetNotes();
                    } else {
                        progressStatus = 0;
                        isCorrect = false;
                        playAnswer();
                    }
                    fifthNotePressed = false;
                }
                if (thirdNotePressed)  {
                    if ((scale4 == 2 && (key == 2 || key == 3 || key == 5 || key == 7 || key == 9 || key == 10 || key == 12) && major == 0) || (scale4 == 6 && (key == 4 || key == 11) && major == 0) || (scale4 == 2 && (key == 1 || key == 6 || key == 8) && major == 1) || (scale4 == 6 && (key == 4 || key == 11) && major == 1))   {
                        noteFourCorrect = true;
                        fourthNotePressed = true;
                    } else {
                        noteFourCorrect = false;
                        fourthNotePressed = true;
                    }
                    thirdNotePressed = false;
                }
                if (secondNotePressed)  {
                    if ((scale3 == 2 && (key == 2 || key == 3 || key == 5 || key == 7 || key == 9 || key == 10 || key == 12) && major == 0) || (scale3 == 6 && (key == 4 || key == 11) && major == 0) || (scale3 == 2 && (key == 1 || key == 6 || key == 8) && major == 1) || (scale3 == 6 && (key == 4 || key == 11) && major == 1))   {
                        noteThreeCorrect = true;
                        thirdNotePressed = true;
                    } else {
                        noteThreeCorrect = false;
                        thirdNotePressed = true;
                    }
                    secondNotePressed = false;
                }


                if (firstNotePressed)  {
                    if ((scale2 == 2 && (key == 2 || key == 3 || key == 5 || key == 7 || key == 9 || key == 10 || key == 12) && major == 0) || (scale2 == 6 && (key == 4 || key == 11) && major == 0) || (scale2 == 2 && (key == 1 || key == 6 || key == 8) && major == 1) || (scale2 == 6 && (key == 4 || key == 11) && major == 1))   {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                    firstNotePressed = false;
                }


                if (playPressed) {
                    if ((scale1 == 2 && (key == 2 || key == 3 || key == 5 || key == 7 || key == 9 || key == 10 || key == 12) && major == 0) || (scale1 == 6 && (key == 4 || key == 11) && major == 0) || (scale1 == 2 && (key == 1 || key == 6 || key == 8) && major == 1) || (scale1 == 6 && (key == 4 || key == 11) && major == 1)) {
                        noteOneCorrect = true;

                    } else {
                        noteOneCorrect = false;
                    }
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 7) {
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
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();

                if (key == 1) {

                    note = "f3" + instrumentName;
                }
                if (key == 2) {

                    note = "f3" + instrumentName;
                }
                if (key == 3) {

                    note = "g3" + instrumentName;
                }
                if (key == 4) {

                    note = "g3" + instrumentName;
                }
                if (key == 5) {

                    note = "a3" + instrumentName;
                }
                if (key == 6) {

                    note = "b3" + instrumentName;
                }
                if (key == 7) {

                    note = "b3" + instrumentName;
                }
                if (key == 8) {

                    note = "c4" + instrumentName;
                }
                if (key == 9) {

                    note = "c4" + instrumentName;
                }
                if (key == 10) {

                    note = "d4" + instrumentName;
                }
                if (key == 11) {

                    note = "d4" + instrumentName;
                }
                if (key == 12) {

                    note = "e4" + instrumentName;
                }

                play(note);

                if (fourthNotePressed ) {
                    if ((scale5 == 5 && (key == 3 || key == 5 || key == 7 || key == 8 || key == 10 || key == 12) && major == 0) || (scale5 == 5 && (key == 3 || key == 5 || key == 7 || key == 8 || key == 10 || key == 12) && major == 1) || (scale5 == 2 && (key == 4 || key == 9 || key == 11) && major == 1)  ) {
                        noteFiveCorrect = true;
                        fifthNotePressed = true;
                    } else {
                        noteFiveCorrect = false;
                        fifthNotePressed = true;
                    }
                    fourthNotePressed = false;
                }
                if (fifthNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect && noteThreeCorrect && noteFourCorrect && noteFiveCorrect) {
                        progressStatus++;
                        resetNotes();
                    } else {
                        progressStatus = 0;
                        isCorrect = false;
                        playAnswer();
                    }
                    fifthNotePressed = false;
                }
                if (thirdNotePressed ) {
                    if ((scale4 == 5 && (key == 3 || key == 5 || key == 7 || key == 8 || key == 10 || key == 12) && major == 0) || (scale4 == 5 && (key == 3 || key == 5 || key == 7 || key == 8 || key == 10 || key == 12) && major == 1) || (scale4 == 2 && (key == 4 || key == 9 || key == 11) && major == 1) ) {
                        noteFourCorrect = true;
                        fourthNotePressed = true;
                    } else {
                        noteFourCorrect = false;
                        fourthNotePressed = true;
                    }
                    thirdNotePressed = false;
                }
                if (secondNotePressed ) {
                    if ((scale3 == 5 && (key == 3 || key == 5 || key == 7 || key == 8 || key == 10 || key == 12) && major == 0) || (scale3 == 5 && (key == 3 || key == 5 || key == 7 || key == 8 || key == 10 || key == 12) && major == 1) || (scale3 == 2 && (key == 4 || key == 9 || key == 11) && major == 1)  ) {
                        noteThreeCorrect = true;
                        thirdNotePressed = true;
                    } else {
                        noteThreeCorrect = false;
                        thirdNotePressed = true;
                    }
                    secondNotePressed = false;
                }


                if (firstNotePressed ) {
                    if ((scale2 == 5 && (key == 3 || key == 5 || key == 7 || key == 8 || key == 10 || key == 12) && major == 0) || (scale2 == 5 && (key == 3 || key == 5 || key == 7 || key == 8 || key == 10 || key == 12) && major == 1) || (scale2 == 2 && (key == 4 || key == 9 || key == 11) && major == 1) ) {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                    firstNotePressed = false;
                }


                if (playPressed) {
                    if ((scale1 == 5 && (key == 3 || key == 5 || key == 7 || key == 8 || key == 10 || key == 12) && major == 0) || (scale1 == 5 && (key == 3 || key == 5 || key == 7 || key == 8 || key == 10 || key == 12) && major == 1) || (scale1 == 2 && (key == 4 || key == 9 || key == 11) && major == 1)) {
                        noteOneCorrect = true;

                    } else {
                        noteOneCorrect = false;
                    }
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 7) {
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
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();

                if (key == 1) {

                    note = "g3" + instrumentName;
                }
                if (key == 2) {

                    note = "g3" + instrumentName;
                }
                if (key == 3) {

                    note = "a3" + instrumentName;
                }
                if (key == 4) {

                    note = "a3" + instrumentName;
                }
                if (key == 5) {

                    note = "b3" + instrumentName;
                }
                if (key == 6) {

                    note = "c4" + instrumentName;
                }
                if (key == 7) {

                    note = "c4" + instrumentName;
                }
                if (key == 8) {

                    note = "d4" + instrumentName;
                }
                if (key == 9) {

                    note = "d4" + instrumentName;
                }
                if (key == 10) {

                    note = "e4" + instrumentName;
                }
                if (key == 11) {

                    note = "e4" + instrumentName;
                }
                if (key == 12) {

                    note = "f4" + instrumentName;
                }

                play(note);

                if (fourthNotePressed ) {
                    if ((scale5 == 3 && (key == 1 || key == 3 || key == 5 || key == 6 || key == 8 || key == 10)) ) {
                        noteFiveCorrect = true;
                        fifthNotePressed = true;
                    } else {
                        noteFiveCorrect = false;
                        fifthNotePressed = true;
                    }
                    fourthNotePressed = false;
                }
                if (fifthNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect && noteThreeCorrect && noteFourCorrect && noteFiveCorrect) {
                        progressStatus++;
                        resetNotes();
                    } else {
                        progressStatus = 0;
                        isCorrect = false;
                        playAnswer();
                    }
                    fifthNotePressed = false;
                }
                if (thirdNotePressed ) {
                    if ((scale4 == 3 && (key == 1 || key == 3 || key == 5 || key == 6 || key == 8 || key == 10)) ) {
                        noteFourCorrect = true;
                        fourthNotePressed = true;
                    } else {
                        noteFourCorrect = false;
                        fourthNotePressed = true;
                    }
                    thirdNotePressed = false;
                }
                if (secondNotePressed ) {
                    if ((scale3 == 3 && (key == 1 || key == 3 || key == 5 || key == 6 || key == 8 || key == 10))  ) {
                        noteThreeCorrect = true;
                        thirdNotePressed = true;
                    } else {
                        noteThreeCorrect = false;
                        thirdNotePressed = true;
                    }
                    secondNotePressed = false;
                }
                if (firstNotePressed ) {
                    if ((scale2 == 3 && (key == 1 || key == 3 || key == 5 || key == 6 || key == 8 || key == 10)) ) {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                    firstNotePressed = false;
                }


                if (playPressed) {
                    if ((scale1 == 3 && (key == 1 || key == 3 || key == 5 || key == 6 || key == 8 || key == 10))) {
                        noteOneCorrect = true;

                    } else {
                        noteOneCorrect = false;
                    }
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 7) {
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
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();

                if (key == 1) {

                    note = "a3" + instrumentName;
                }
                if (key == 2) {

                    note = "a3" + instrumentName;
                }
                if (key == 3) {

                    note = "b3" + instrumentName;
                }
                if (key == 4) {

                    note = "b3" + instrumentName;
                }
                if (key == 5) {

                    note = "c4" + instrumentName;
                }
                if (key == 6) {

                    note = "d4" + instrumentName;
                }
                if (key == 7) {

                    note = "d4" + instrumentName;
                }
                if (key == 8) {

                    note = "e4" + instrumentName;
                }
                if (key == 9) {

                    note = "e4" + instrumentName;
                }
                if (key == 10) {

                    note = "f4" + instrumentName;
                }
                if (key == 11) {

                    note = "f4" + instrumentName;
                }
                if (key == 12) {

                    note = "g4" + instrumentName;
                }

                play(note);

                if (fourthNotePressed ) {
                    if ((scale5 == 7 && (key == 2 || key == 4 || key == 5 || key == 7 || key == 9 || key == 10 || key == 12) && major == 0) || (scale5 == 3 && (key == 11) && major == 0) || (scale5 == 7 && (key == 1 || key == 3 || key == 6 || key == 8 || key == 11) && major == 1) ) {
                        noteFiveCorrect = true;
                        fifthNotePressed = true;
                    } else {
                        noteFiveCorrect = false;
                        fifthNotePressed = true;
                    }
                    fourthNotePressed = false;
                }
                if (fifthNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect && noteThreeCorrect && noteFourCorrect && noteFiveCorrect) {
                        progressStatus++;
                        resetNotes();
                    } else {
                        progressStatus = 0;
                        isCorrect = false;
                        playAnswer();
                    }
                    fifthNotePressed = false;
                }
                if (thirdNotePressed ) {
                    if ((scale4 == 7 && (key == 2 || key == 4 || key == 5 || key == 7 || key == 9 || key == 10 || key == 12) && major == 0) || (scale4 == 3 && (key == 11) && major == 0) || (scale4 == 7 && (key == 1 || key == 3 || key == 6 || key == 8 || key == 11) && major == 1)) {
                        noteFourCorrect = true;
                        fourthNotePressed = true;
                    } else {
                        noteFourCorrect = false;
                        fourthNotePressed = true;
                    }
                    thirdNotePressed = false;
                }
                if (secondNotePressed ) {
                    if ((scale3 == 7 && (key == 2 || key == 4 || key == 5 || key == 7 || key == 9 || key == 10 || key == 12) && major == 0) || (scale3 == 3 && (key == 11) && major == 0) || (scale3 == 7 && (key == 1 || key == 3 || key == 6 || key == 8 || key == 11) && major == 1)  ) {
                        noteThreeCorrect = true;
                        thirdNotePressed = true;
                    } else {
                        noteThreeCorrect = false;
                        thirdNotePressed = true;
                    }
                    secondNotePressed = false;
                }
                if (firstNotePressed ) {
                    if ((scale2 == 7 && (key == 2 || key == 4 || key == 5 || key == 7 || key == 9 || key == 10 || key == 12) && major == 0) || (scale2 == 3 && (key == 11) && major == 0) || (scale2 == 7 && (key == 1 || key == 3 || key == 6 || key == 8 || key == 11) && major == 1) ) {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                    firstNotePressed = false;
                }

                if (playPressed) {
                    if ((scale1 == 7 && (key == 2 || key == 4 || key == 5 || key == 7 || key == 9 || key == 10 || key == 12) && major == 0) || (scale1 == 3 && (key == 11) && major == 0) || (scale1 == 7 && (key == 1 || key == 3 || key == 6 || key == 8 || key == 11) && major == 1)) {
                        noteOneCorrect = true;

                    } else {
                        noteOneCorrect = false;
                    }
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 7) {
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
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();

                if (key == 1) {

                    note = "b3" + instrumentName;
                }
                if (key == 2) {

                    note = "b3" + instrumentName;
                }
                if (key == 3) {

                    note = "c4" + instrumentName;
                }
                if (key == 4) {

                    note = "c4" + instrumentName;
                }
                if (key == 5) {

                    note = "d4" + instrumentName;
                }
                if (key == 6) {

                    note = "e4" + instrumentName;
                }
                if (key == 7) {

                    note = "e4" + instrumentName;
                }
                if (key == 8) {

                    note = "f4" + instrumentName;
                }
                if (key == 9) {

                    note = "f4" + instrumentName;
                }
                if (key == 10) {

                    note = "g4" + instrumentName;
                }
                if (key == 11) {

                    note = "g4" + instrumentName;
                }
                if (key == 12) {

                    note = "a4" + instrumentName;
                }


                play(note);

                if (fourthNotePressed ) {
                    if ((scale5 == 8 && (key == 2 || key == 3 || key == 5 || key == 7 || key == 8 || key == 10 || key == 12) && major == 0) || (scale5 == 8 && (key == 1 || key == 6) && major == 1) || (scale5 == 7 && (key == 4 || key == 9 || key == 11) && major == 1) ) {
                        noteFiveCorrect = true;
                        fifthNotePressed = true;
                    } else {
                        noteFiveCorrect = false;
                        fifthNotePressed = true;
                    }
                    fourthNotePressed = false;
                }
                if (fifthNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect && noteThreeCorrect && noteFourCorrect && noteFiveCorrect) {
                        progressStatus++;
                        resetNotes();
                    } else {
                        progressStatus = 0;
                        isCorrect = false;
                        playAnswer();
                    }
                    firstNotePressed = false;
                }
                if (thirdNotePressed ) {
                    if ((scale4 == 8 && (key == 2 || key == 3 || key == 5 || key == 7 || key == 8 || key == 10 || key == 12) && major == 0) || (scale4 == 8 && (key == 1 || key == 6) && major == 1) || (scale4 == 7 && (key == 4 || key == 9 || key == 11) && major == 1)) {
                        noteFourCorrect = true;
                        fourthNotePressed = true;
                    } else {
                        noteFourCorrect = false;
                        fourthNotePressed = true;
                    }
                    thirdNotePressed = false;
                }
                if (secondNotePressed ) {
                    if ((scale3 == 8 && (key == 2 || key == 3 || key == 5 || key == 7 || key == 8 || key == 10 || key == 12) && major == 0) || (scale3 == 8 && (key == 1 || key == 6) && major == 1) || (scale3 == 7 && (key == 4 || key == 9 || key == 11) && major == 1)  ) {
                        noteThreeCorrect = true;
                        thirdNotePressed = true;
                    } else {
                        noteThreeCorrect = false;
                        thirdNotePressed = true;
                    }
                    secondNotePressed = false;
                }


                if (firstNotePressed ) {
                    if ((scale2 == 8 && (key == 2 || key == 3 || key == 5 || key == 7 || key == 8 || key == 10 || key == 12) && major == 0) || (scale2 == 8 && (key == 1 || key == 6) && major == 1) || (scale2 == 7 && (key == 4 || key == 9 || key == 11) && major == 1) ) {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                    firstNotePressed = false;
                }


                if (playPressed) {
                    if ((scale1 == 8 && (key == 2 || key == 3 || key == 5 || key == 7 || key == 8 || key == 10 || key == 12) && major == 0) || (scale1 == 8 && (key == 1 || key == 6) && major == 1) || (scale1 == 7 && (key == 4 || key == 9 || key == 11) && major == 1)) {
                        noteOneCorrect = true;

                    } else {
                        noteOneCorrect = false;
                    }
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 7) {
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
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();

                if (key == 1) {

                    note = "c4" + instrumentName;
                }
                if (key == 2) {

                    note = "c4" + instrumentName;
                }
                if (key == 3) {

                    note = "d4" + instrumentName;
                }
                if (key == 4) {

                    note = "d4" + instrumentName;
                }
                if (key == 5) {

                    note = "e4" + instrumentName;
                }
                if (key == 6) {

                    note = "f4" + instrumentName;
                }
                if (key == 7) {

                    note = "f4" + instrumentName;
                }
                if (key == 8) {

                    note = "g4" + instrumentName;
                }
                if (key == 9) {

                    note = "g4" + instrumentName;
                }
                if (key == 10) {

                    note = "a4" + instrumentName;
                }
                if (key == 11) {

                    note = "a4" + instrumentName;
                }
                if (key == 12) {

                    note = "b4" + instrumentName;
                }

                play(note);

                if (fourthNotePressed ) {
                    if ((scale5 == 4 && (key == 1 || key == 3 || key == 5 || key == 6 || key == 8 || key == 10 || key == 12) && major == 0) || (scale5 == 4 && (key == 1 || key == 3 || key == 5 || key == 6 || key == 8 || key == 10 || key == 12) && major == 1) || (scale5 == 8 && (key == 4 || key == 7 || key == 9 || key == 11) && major == 1)) {
                        noteFiveCorrect = true;
                        fifthNotePressed = true;
                    } else {
                        noteFiveCorrect = false;
                        fifthNotePressed = true;
                    }
                    fourthNotePressed = false;
                }
                if (fifthNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect && noteThreeCorrect && noteFourCorrect && noteFiveCorrect) {
                        progressStatus++;
                        resetNotes();
                    } else {
                        progressStatus = 0;
                        isCorrect = false;
                        playAnswer();
                    }
                    fifthNotePressed = false;
                }
                if (thirdNotePressed ) {
                    if ((scale4 == 4 && (key == 1 || key == 3 || key == 5 || key == 6 || key == 8 || key == 10 || key == 12) && major == 0) || (scale4 == 4 && (key == 1 || key == 3 || key == 5 || key == 6 || key == 8 || key == 10 || key == 12) && major == 1) || (scale4 == 8 && (key == 4 || key == 7 || key == 9 || key == 11) && major == 1)) {
                        noteFourCorrect = true;
                        fourthNotePressed = true;
                    } else {
                        noteFourCorrect = false;
                        fourthNotePressed = true;
                    }
                    thirdNotePressed = false;
                }
                if (secondNotePressed ) {
                    if ((scale3 == 4 && (key == 1 || key == 3 || key == 5 || key == 6 || key == 8 || key == 10 || key == 12) && major == 0) || (scale3 == 4 && (key == 1 || key == 3 || key == 5 || key == 6 || key == 8 || key == 10 || key == 12) && major == 1) || (scale3 == 8 && (key == 4 || key == 7 || key == 9 || key == 11) && major == 1)  ) {
                        noteThreeCorrect = true;
                        thirdNotePressed = true;
                    } else {
                        noteThreeCorrect = false;
                        thirdNotePressed = true;
                    }
                    secondNotePressed = false;
                }
                if (firstNotePressed ) {
                    if ((scale2 == 4 && (key == 1 || key == 3 || key == 5 || key == 6 || key == 8 || key == 10 || key == 12) && major == 0) || (scale2 == 4 && (key == 1 || key == 3 || key == 5 || key == 6 || key == 8 || key == 10 || key == 12) && major == 1) || (scale2 == 8 && (key == 4 || key == 7 || key == 9 || key == 11) && major == 1)) {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                    firstNotePressed = false;
                }


                if (playPressed) {
                    if ((scale1 == 4 && (key == 1 || key == 3 || key == 5 || key == 6 || key == 8 || key == 10 || key == 12) && major == 0) || (scale1 == 4 && (key == 1 || key == 3 || key == 5 || key == 6 || key == 8 || key == 10 || key == 12) && major == 1) || (scale1 == 8 && (key == 4 || key == 7 || key == 9 || key == 11) && major == 1)) {
                        noteOneCorrect = true;

                    } else {
                        noteOneCorrect = false;
                    }
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 7) {
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
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();

                if (key == 1) {

                    note = "d4" + instrumentName;
                }
                if (key == 2) {

                    note = "d4" + instrumentName;
                }
                if (key == 3) {

                    note = "e4" + instrumentName;
                }
                if (key == 4) {

                    note = "e4" + instrumentName;
                }
                if (key == 5) {

                    note = "f4" + instrumentName;
                }
                if (key == 6) {

                    note = "g4" + instrumentName;
                }
                if (key == 7) {

                    note = "g4" + instrumentName;
                }
                if (key == 8) {

                    note = "a4" + instrumentName;
                }
                if (key == 9) {

                    note = "a4" + instrumentName;
                }
                if (key == 10) {

                    note = "b4" + instrumentName;
                }
                if (key == 11) {

                    note = "b4" + instrumentName;
                }
                if (key == 12) {

                    note = "c5" + instrumentName;
                }

                play(note);

                if (fourthNotePressed ) {

                    noteFiveCorrect = false;
                    fifthNotePressed = true;
                    fourthNotePressed = false;

                }
                if (fifthNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect && noteThreeCorrect && noteFourCorrect && noteFiveCorrect) {
                        progressStatus++;
                        resetNotes();
                    } else {
                        progressStatus = 0;
                        isCorrect = false;
                        playAnswer();
                    }
                    fifthNotePressed = false;
                }
                if (thirdNotePressed ) {

                    noteFourCorrect = false;
                    fourthNotePressed = true;
                    thirdNotePressed = false;

                }
                if (secondNotePressed ) {

                    noteThreeCorrect = false;
                    thirdNotePressed = true;
                    secondNotePressed = false;

                }


                if (firstNotePressed ) {

                    noteTwoCorrect = false;
                    secondNotePressed = true;
                    firstNotePressed = false;

                }

                if (playPressed) {

                    noteOneCorrect = false;

                    firstNotePressed = true;

                }

                playPressed = false;
                if (progressStatus >= 20 && level < 7) {
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
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();

                if (key == 3) {

                    note = "cs3" + instrumentName;
                }
                if (key == 4) {

                    note = "cs3" + instrumentName;
                }
                if (key == 5) {

                    note = "ds3" + instrumentName;
                }
                if (key == 8) {

                    note = "fs3" + instrumentName;
                }
                if (key == 9) {

                    note = "fs3" + instrumentName;
                }
                if (key == 10) {

                    note = "gs3" + instrumentName;
                }
                if (key == 11) {

                    note = "gs3" + instrumentName;
                }
                if (key == 12) {

                    note = "as3" + instrumentName;
                }

                play(note);

                if (fourthNotePressed) {

                    noteFiveCorrect = false;
                    fifthNotePressed = true;
                    fourthNotePressed = false;

                }
                if (fifthNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect && noteThreeCorrect && noteFourCorrect && noteFiveCorrect) {
                        progressStatus++;
                        resetNotes();
                    } else {
                        progressStatus = 0;
                        isCorrect = false;
                        playAnswer();
                    }
                    fifthNotePressed = false;
                }
                if (thirdNotePressed) {

                    noteFourCorrect = false;
                    fourthNotePressed = true;
                    thirdNotePressed = false;

                }
                if (secondNotePressed) {

                    noteThreeCorrect = false;
                    thirdNotePressed = true;
                    secondNotePressed = false;

                }

                if (firstNotePressed) {

                    noteTwoCorrect = false;
                    secondNotePressed = true;
                    firstNotePressed = false;

                }


                if (playPressed) {

                    noteOneCorrect = false;

                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 7) {
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
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();

                if (key == 1) {

                    note = "cs3" + instrumentName;
                }
                if (key == 2) {

                    note = "cs3" + instrumentName;
                }
                if (key == 3) {

                    note = "ds3" + instrumentName;
                }
                if (key == 4) {

                    note = "ds3" + instrumentName;
                }
                if (key == 6) {

                    note = "fs3" + instrumentName;
                }


                if (key == 7) {

                    note = "fs3" + instrumentName;
                }
                if (key == 8) {

                    note = "gs3" + instrumentName;
                }
                if (key == 9) {

                    note = "gs3" + instrumentName;
                }
                if (key == 10) {

                    note = "as3" + instrumentName;
                }
                if (key == 11) {

                    note = "as3" + instrumentName;
                }

                play(note);

                if (fourthNotePressed ) {
                    if ((scale5 == 1 && (key == 2 || key == 4 || key == 7 || key == 9 || key == 11) && major == 0) || (scale5 == 1 && (key == 2 || key == 4 || key == 7 || key == 9 || key == 11)  && major == 1)) {
                        noteFiveCorrect = true;
                        fifthNotePressed = true;
                    } else {
                        noteFiveCorrect = false;
                        fifthNotePressed = true;
                    }
                    fourthNotePressed = false;
                }
                if (fifthNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect && noteThreeCorrect && noteFourCorrect && noteFiveCorrect) {
                        progressStatus++;
                        resetNotes();
                    } else {
                        progressStatus = 0;
                        isCorrect = false;
                        playAnswer();
                    }
                    fifthNotePressed = false;
                }
                if (thirdNotePressed ) {
                    if ((scale4 == 1 && (key == 2 || key == 4 || key == 7 || key == 9 || key == 11) && major == 0) || (scale4 == 1 && (key == 2 || key == 4 || key == 7 || key == 9 || key == 11)  && major == 1)) {
                        noteFourCorrect = true;
                        fourthNotePressed = true;
                    } else {
                        noteFourCorrect = false;
                        fourthNotePressed = true;
                    }
                    thirdNotePressed = false;
                }
                if (secondNotePressed ) {
                    if ((scale3 == 1 && (key == 2 || key == 4 || key == 7 || key == 9 || key == 11) && major == 0) || (scale3 == 1 && (key == 2 || key == 4 || key == 7 || key == 9 || key == 11)  && major == 1)  ) {
                        noteThreeCorrect = true;
                        thirdNotePressed = true;
                    } else {
                        noteThreeCorrect = false;
                        thirdNotePressed = true;
                    }
                    secondNotePressed = false;
                }
                if (firstNotePressed ) {
                    if ((scale2 == 1 && (key == 2 || key == 4 || key == 7 || key == 9 || key == 11) && major == 0) || (scale2 == 1 && (key == 2 || key == 4 || key == 7 || key == 9 || key == 11)  && major == 1)) {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                    firstNotePressed = false;
                }


                if (playPressed) {
                    if ((scale1 == 1 && (key == 2 || key == 4 || key == 7 || key == 9 || key == 11) && major == 0) || (scale1 == 1 && (key == 2 || key == 4 || key == 7 || key == 9 || key == 11)  && major == 1)) {
                        noteOneCorrect = true;

                    } else {
                        noteOneCorrect = false;
                    }
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 7) {
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
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();

                if (key == 1) {

                    note = "ds3" + instrumentName;
                }
                if (key == 2) {

                    note = "ds3" + instrumentName;
                }
                if (key == 5) {

                    note = "fs3" + instrumentName;
                }
                if (key == 6) {

                    note = "gs3" + instrumentName;
                }
                if (key == 7) {

                    note = "gs3" + instrumentName;
                }
                if (key == 8) {

                    note = "as3" + instrumentName;
                }
                if (key == 9) {

                    note = "as3" + instrumentName;
                }
                if (key == 12) {

                    note = "cs4" + instrumentName;
                }

                play(note);

                if (fourthNotePressed ) {
                    if ((scale5 == 2 && (key == 1 || key == 6 || key == 8) && major == 0) || (scale5 == 6 && (key == 2 || key == 5 || key == 7 || key == 9 || key == 12) && major == 0) || (scale5 == 6 && (key == 2 || key == 5 || key == 7 || key == 9 || key == 12) && major == 1)) {
                        noteFiveCorrect = true;
                        fifthNotePressed = true;
                    } else {
                        noteFiveCorrect = false;
                        fifthNotePressed = true;
                    }
                    fourthNotePressed = false;
                }
                if (fifthNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect && noteThreeCorrect && noteFourCorrect && noteFiveCorrect) {
                        progressStatus++;
                        resetNotes();
                    } else {
                        progressStatus = 0;
                        isCorrect = false;
                        playAnswer();
                    }
                    fifthNotePressed = false;
                }
                if (thirdNotePressed ) {
                    if ((scale4 == 2 && (key == 1 || key == 6 || key == 8) && major == 0) || (scale4 == 6 && (key == 2 || key == 5 || key == 7 || key == 9 || key == 12) && major == 0) || (scale4 == 6 && (key == 2 || key == 5 || key == 7 || key == 9 || key == 12) && major == 1)) {
                        noteFourCorrect = true;
                        fourthNotePressed = true;
                    } else {
                        noteFourCorrect = false;
                        fourthNotePressed = true;
                    }
                    thirdNotePressed = false;
                }
                if (secondNotePressed ) {
                    if ((scale3 == 2 && (key == 1 || key == 6 || key == 8) && major == 0) || (scale3 == 6 && (key == 2 || key == 5 || key == 7 || key == 9 || key == 12) && major == 0) || (scale3 == 6 && (key == 2 || key == 5 || key == 7 || key == 9 || key == 12) && major == 1)  ) {
                        noteThreeCorrect = true;
                        thirdNotePressed = true;
                    } else {
                        noteThreeCorrect = false;
                        thirdNotePressed = true;
                    }
                    secondNotePressed = false;
                }
                if (firstNotePressed ) {
                    if ((scale2 == 2 && (key == 1 || key == 6 || key == 8) && major == 0) || (scale2 == 6 && (key == 2 || key == 5 || key == 7 || key == 9 || key == 12) && major == 0) || (scale2 == 6 && (key == 2 || key == 5 || key == 7 || key == 9 || key == 12) && major == 1)) {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                    firstNotePressed = false;
                }

                if (playPressed) {
                    if ((scale1 == 2 && (key == 1 || key == 6 || key == 8) && major == 0) || (scale1 == 6 && (key == 2 || key == 5 || key == 7 || key == 9 || key == 12) && major == 0) || (scale1 == 6 && (key == 2 || key == 5 || key == 7 || key == 9 || key == 12) && major == 1)) {
                        noteOneCorrect = true;

                    } else {
                        noteOneCorrect = false;
                    }
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 7) {
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
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();

                if (key == 3) {

                    note = "fs3" + instrumentName;
                }
                if (key == 4) {

                    note = "fs3" + instrumentName;
                }
                if (key == 5) {

                    note = "gs3" + instrumentName;
                }
                if (key == 6) {

                    note = "as3" + instrumentName;
                }
                if (key == 7) {

                    note = "as3" + instrumentName;
                }
                if (key == 10) {

                    note = "cs4" + instrumentName;
                }
                if (key == 11) {

                    note = "cs4" + instrumentName;
                }
                if (key == 12) {

                    note = "ds4" + instrumentName;
                }

                play(note);

                if (fourthNotePressed ) {
                    if ((scale5 == 2 && (key == 4 || key == 11) && major == 0) || (scale5 == 5 && (key == 6) && major == 0) || (scale5 == 2 && (key == 3 || key == 5 || key == 7 || key == 10 || key == 12) && major == 1) || (scale5 == 5 && (key == 6) && major == 1)) {
                        noteFiveCorrect = true;
                        fifthNotePressed = true;
                    } else {
                        noteFiveCorrect = false;
                        fifthNotePressed = true;
                    }
                    fourthNotePressed = false;
                }
                if (fifthNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect && noteThreeCorrect && noteFourCorrect && noteFiveCorrect) {
                        progressStatus++;
                        resetNotes();
                    } else {
                        progressStatus = 0;
                        isCorrect = false;
                        playAnswer();
                    }
                    fifthNotePressed = false;
                }
                if (thirdNotePressed ) {
                    if ((scale4 == 2 && (key == 4 || key == 11) && major == 0) || (scale1 == 5 && (key == 6) && major == 0) || (scale4 == 2 && (key == 3 || key == 5 || key == 7 || key == 10 || key == 12) && major == 1) || (scale4 == 5 && (key == 6) && major == 1)) {
                        noteFourCorrect = true;
                        fourthNotePressed = true;
                    } else {
                        noteFourCorrect = false;
                        fourthNotePressed = true;
                    }
                    thirdNotePressed = false;
                }
                if (secondNotePressed ) {
                    if ((scale3 == 2 && (key == 4 || key == 11) && major == 0) || (scale1 == 5 && (key == 6) && major == 0) || (scale3 == 2 && (key == 3 || key == 5 || key == 7 || key == 10 || key == 12) && major == 1) || (scale3 == 5 && (key == 6) && major == 1)  ) {
                        noteThreeCorrect = true;
                        thirdNotePressed = true;
                    } else {
                        noteThreeCorrect = false;
                        thirdNotePressed = true;
                    }
                    secondNotePressed = false;
                }
                if (firstNotePressed ) {
                    if ((scale2 == 2 && (key == 4 || key == 11) && major == 0) || (scale1 == 5 && (key == 6) && major == 0) || (scale2 == 2 && (key == 3 || key == 5 || key == 7 || key == 10 || key == 12) && major == 1) || (scale2 == 5 && (key == 6) && major == 1)) {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                    firstNotePressed = false;
                }

                if (playPressed) {
                    if ((scale1 == 2 && (key == 4 || key == 11) && major == 0) || (scale1 == 5 && (key == 6) && major == 0) || (scale1 == 2 && (key == 3 || key == 5 || key == 7 || key == 10 || key == 12) && major == 1) || (scale1 == 5 && (key == 6) && major == 1)) {
                        noteOneCorrect = true;

                    } else {
                        noteOneCorrect = false;
                    }
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 7) {
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
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();

                if (key == 1) {

                    note = "fs3" + instrumentName;
                }
                if (key == 2) {

                    note = "fs3" + instrumentName;
                }
                if (key == 3) {

                    note = "gs3" + instrumentName;
                }
                if (key == 4) {

                    note = "gs3" + instrumentName;
                }
                if (key == 5) {

                    note = "as3" + instrumentName;
                }
                if (key == 8) {

                    note = "cs4" + instrumentName;
                }
                if (key == 9) {

                    note = "cs4" + instrumentName;
                }
                if (key == 10) {

                    note = "ds4" + instrumentName;
                }
                if (key == 11) {

                    note = "ds4" + instrumentName;
                }

                play(note);

                if (fourthNotePressed ) {
                    if ((scale5 == 5 && (key == 2 || key == 4 || key == 9 || key == 11))) {
                        noteFiveCorrect = true;
                        fifthNotePressed = true;
                    } else {
                        noteFiveCorrect = false;
                        fifthNotePressed = true;
                    }
                    fourthNotePressed = false;
                }
                if (fifthNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect && noteThreeCorrect && noteFourCorrect && noteFiveCorrect) {
                        progressStatus++;
                        resetNotes();
                    } else {
                        progressStatus = 0;
                        isCorrect = false;
                        playAnswer();
                    }
                    fifthNotePressed = false;
                }
                if (thirdNotePressed ) {
                    if ((scale4 == 5 && (key == 2 || key == 4 || key == 9 || key == 11))) {
                        noteFourCorrect = true;
                        fourthNotePressed = true;
                    } else {
                        noteFourCorrect = false;
                        fourthNotePressed = true;
                    }
                    thirdNotePressed = false;
                }
                if (secondNotePressed ) {
                    if ((scale3 == 5 && (key == 2 || key == 4 || key == 9 || key == 11))  ) {
                        noteThreeCorrect = true;
                        thirdNotePressed = true;
                    } else {
                        noteThreeCorrect = false;
                        thirdNotePressed = true;
                    }
                    secondNotePressed = false;
                }

                if (firstNotePressed ) {
                    if ((scale2 == 5 && (key == 2 || key == 4 || key == 9 || key == 11))) {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                    firstNotePressed = false;
                }

                if (playPressed) {
                    if ((scale1 == 5 && (key == 2 || key == 4 || key == 9 || key == 11))) {
                        noteOneCorrect = true;

                    } else {
                        noteOneCorrect = false;
                    }
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 7) {
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
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();

                if (key == 1) {

                    note = "gs3" + instrumentName;
                }
                if (key == 2) {

                    note = "gs3" + instrumentName;
                }
                if (key == 3) {

                    note = "as3" + instrumentName;
                }
                if (key == 4) {

                    note = "as3" + instrumentName;
                }
                if (key == 6) {

                    note = "cs4" + instrumentName;
                }
                if (key == 7) {

                    note = "cs4" + instrumentName;
                }
                if (key == 8) {

                    note = "ds4" + instrumentName;
                }
                if (key == 9) {

                    note = "ds4" + instrumentName;
                }
                if (key == 12) {

                    note = "fs4" + instrumentName;
                }

                play(note);

                if (fourthNotePressed ) {
                    if ((scale5 == 7 && (key == 1 || key == 6 || key == 8) && major == 0) || (scale5 == 3 && (key == 2 || key == 4 || key == 7 || key == 9 || key == 12) && major == 0) || (scale5 == 3 && (key == 2 || key == 4 || key == 7 || key == 9 || key == 12) && major == 1)) {
                        noteFiveCorrect = true;
                        fifthNotePressed = true;
                    } else {
                        noteFiveCorrect = false;
                        fifthNotePressed = true;
                    }
                    fourthNotePressed = false;
                }
                if (fifthNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect && noteThreeCorrect && noteFourCorrect && noteFiveCorrect) {
                        progressStatus++;
                        resetNotes();
                    } else {
                        progressStatus = 0;
                        isCorrect = false;
                        playAnswer();
                    }
                    fifthNotePressed = false;
                }
                if (thirdNotePressed ) {
                    if ((scale4 == 7 && (key == 1 || key == 6 || key == 8) && major == 0) || (scale4 == 3 && (key == 2 || key == 4 || key == 7 || key == 9 || key == 12) && major == 0) || (scale4 == 3 && (key == 2 || key == 4 || key == 7 || key == 9 || key == 12) && major == 1)) {
                        noteFourCorrect = true;
                        fourthNotePressed = true;
                    } else {
                        noteFourCorrect = false;
                        fourthNotePressed = true;
                    }
                    thirdNotePressed = false;
                }
                if (secondNotePressed ) {
                    if ((scale3 == 7 && (key == 1 || key == 6 || key == 8) && major == 0) || (scale3 == 3 && (key == 2 || key == 4 || key == 7 || key == 9 || key == 12) && major == 0) || (scale3 == 3 && (key == 2 || key == 4 || key == 7 || key == 9 || key == 12) && major == 1)  ) {
                        noteThreeCorrect = true;
                        thirdNotePressed = true;
                    } else {
                        noteThreeCorrect = false;
                        thirdNotePressed = true;
                    }
                    secondNotePressed = false;
                }

                if (firstNotePressed ) {
                    if ((scale2 == 7 && (key == 1 || key == 6 || key == 8) && major == 0) || (scale2 == 3 && (key == 2 || key == 4 || key == 7 || key == 9 || key == 12) && major == 0) || (scale2 == 3 && (key == 2 || key == 4 || key == 7 || key == 9 || key == 12) && major == 1)) {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                    firstNotePressed = false;
                }


                if (playPressed) {
                    if ((scale1 == 7 && (key == 1 || key == 6 || key == 8) && major == 0) || (scale1 == 3 && (key == 2 || key == 4 || key == 7 || key == 9 || key == 12) && major == 0) || (scale1 == 3 && (key == 2 || key == 4 || key == 7 || key == 9 || key == 12) && major == 1)) {
                        noteOneCorrect = true;

                    } else {
                        noteOneCorrect = false;
                    }
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 7) {
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
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();

                if (key == 1) {

                    note = "as3" + instrumentName;
                }
                if (key == 2) {

                    note = "as3" + instrumentName;
                }
                if (key == 5) {

                    note = "cs4" + instrumentName;
                }
                if (key == 6) {

                    note = "ds4" + instrumentName;
                }
                if (key == 7) {

                    note = "ds4" + instrumentName;
                }
                if (key == 10) {

                    note = "fs4" + instrumentName;
                }
                if (key == 11) {

                    note = "fs4" + instrumentName;
                }
                if (key == 12) {

                    note = "gs4" + instrumentName;
                }

                play(note);

                if (fourthNotePressed) {
                    if ((scale5 == 8 && (key == 1 || key == 6) && major == 0) || (scale5 == 7 && (key == 3 || key == 11) && major == 0) || (scale5 == 7 && (key == 2 || key == 5 || key == 7 || key == 10 || key == 12) && major == 1)) {
                        noteFiveCorrect = true;
                        fifthNotePressed = true;
                    } else {
                        noteFiveCorrect = false;
                        fifthNotePressed = true;
                    }
                    fourthNotePressed = false;
                }
                if (fifthNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect && noteThreeCorrect && noteFourCorrect && noteFiveCorrect) {
                        progressStatus++;
                        resetNotes();
                    } else {
                        progressStatus = 0;
                        isCorrect = false;
                        playAnswer();
                    }
                    fifthNotePressed = false;
                }
                if (thirdNotePressed) {
                    if ((scale4 == 8 && (key == 1 || key == 6) && major == 0) || (scale4 == 7 && (key == 3 || key == 11) && major == 0) || (scale4 == 7 && (key == 2 || key == 5 || key == 7 || key == 10 || key == 12) && major == 1)) {
                        noteFourCorrect = true;
                        fourthNotePressed = true;
                    } else {
                        noteFourCorrect = false;
                        fourthNotePressed = true;
                    }
                    thirdNotePressed = false;
                }
                if (secondNotePressed) {
                    if ((scale3 == 8 && (key == 1 || key == 6) && major == 0) || (scale3 == 7 && (key == 3 || key == 11) && major == 0) || (scale3 == 7 && (key == 2 || key == 5 || key == 7 || key == 10 || key == 12) && major == 1) ) {
                        noteThreeCorrect = true;
                        thirdNotePressed = true;
                    } else {
                        noteThreeCorrect = false;
                        thirdNotePressed = true;
                    }
                    secondNotePressed = false;
                }
                if (firstNotePressed) {
                    if ((scale2 == 8 && (key == 1 || key == 6) && major == 0) || (scale2 == 7 && (key == 3 || key == 11) && major == 0) || (scale2 == 7 && (key == 2 || key == 5 || key == 7 || key == 10 || key == 12) && major == 1)) {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                    firstNotePressed = false;
                }

                if (playPressed) {
                    if ((scale1 == 8 && (key == 1 || key == 6) && major == 0) || (scale1 == 7 && (key == 3 || key == 11) && major == 0) || (scale1 == 7 && (key == 2 || key == 5 || key == 7 || key == 10 || key == 12) && major == 1)) {
                        noteOneCorrect = true;

                    } else {
                        noteOneCorrect = false;
                    }
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 7) {
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
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();

                if (key == 3) {

                    note = "cs4" + instrumentName;
                }
                if (key == 4) {

                    note = "cs4" + instrumentName;
                }
                if (key == 5) {

                    note = "ds4" + instrumentName;
                }
                if (key == 8) {

                    note = "fs4" + instrumentName;
                }
                if (key == 9) {

                    note = "fs4" + instrumentName;
                }
                if (key == 10) {

                    note = "gs4" + instrumentName;
                }
                if (key == 11) {

                    note = "gs4" + instrumentName;
                }
                if (key == 12) {

                    note = "as4" + instrumentName;
                }

                play(note);

                if (fourthNotePressed ) {
                    if ((scale5 == 8 && (key == 4 || key == 9 || key == 11) && major == 0) || (scale5 == 8 && (key == 3 || key == 5 || key == 8 || key == 10 || key == 12) && major == 1)) {
                        noteFiveCorrect = true;
                        fifthNotePressed = true;
                    } else {
                        noteFiveCorrect = false;
                        fifthNotePressed = true;
                    }
                    fourthNotePressed = false;
                }
                if (fifthNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect && noteThreeCorrect && noteFourCorrect && noteFiveCorrect) {
                        progressStatus++;
                        resetNotes();
                    } else {
                        progressStatus = 0;
                        isCorrect = false;
                        playAnswer();
                    }
                    fifthNotePressed = false;
                }
                if (thirdNotePressed ) {
                    if ((scale4 == 8 && (key == 4 || key == 9 || key == 11) && major == 0) || (scale4 == 8 && (key == 3 || key == 5 || key == 8 || key == 10 || key == 12) && major == 1)) {
                        noteFourCorrect = true;
                        fourthNotePressed = true;
                    } else {
                        noteFourCorrect = false;
                        fourthNotePressed = true;
                    }
                    thirdNotePressed = false;
                }
                if (secondNotePressed ) {
                    if ((scale3 == 8 && (key == 4 || key == 9 || key == 11) && major == 0) || (scale3 == 8 && (key == 3 || key == 5 || key == 8 || key == 10 || key == 12) && major == 1)  ) {
                        noteThreeCorrect = true;
                        thirdNotePressed = true;
                    } else {
                        noteThreeCorrect = false;
                        thirdNotePressed = true;
                    }
                    secondNotePressed = false;
                }

                if (firstNotePressed ) {
                    if ((scale2 == 8 && (key == 4 || key == 9 || key == 11) && major == 0) || (scale2 == 8 && (key == 3 || key == 5 || key == 8 || key == 10 || key == 12) && major == 1)) {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                    firstNotePressed = false;
                }

                if (playPressed) {
                    if ((scale1 == 8 && (key == 4 || key == 9 || key == 11) && major == 0) || (scale1 == 8 && (key == 3 || key == 5 || key == 8 || key == 10 || key == 12) && major == 1)) {
                        noteOneCorrect = true;

                    } else {
                        noteOneCorrect = false;
                    }
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 7) {
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
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();

                if (key == 1) {

                    note = "cs4" + instrumentName;
                }
                if (key == 2) {

                    note = "cs4" + instrumentName;
                }
                if (key == 3) {

                    note = "ds4" + instrumentName;
                }
                if (key == 4) {

                    note = "ds4" + instrumentName;
                }
                if (key == 6) {

                    note = "fs4" + instrumentName;
                }
                if (key == 7) {

                    note = "fs4" + instrumentName;
                }
                if (key == 8) {

                    note = "gs4" + instrumentName;
                }
                if (key == 9) {

                    note = "gs4" + instrumentName;
                }
                if (key == 10) {

                    note = "as4" + instrumentName;
                }
                if (key == 11) {

                    note = "as4" + instrumentName;
                }

                play(note);

                if (fourthNotePressed ) {
                    if ((scale5 == 4 && (key == 2 || key == 4 || key == 7 || key == 9 || key == 11))) {
                        noteFiveCorrect = true;
                        fifthNotePressed = true;
                    } else {
                        noteFiveCorrect = false;
                        fifthNotePressed = true;
                    }
                    fourthNotePressed = false;
                }
                if (fifthNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect && noteThreeCorrect && noteFourCorrect && noteFiveCorrect) {
                        progressStatus++;
                        resetNotes();
                    } else {
                        progressStatus = 0;
                        isCorrect = false;
                        playAnswer();
                    }
                    fifthNotePressed = false;
                }
                if (thirdNotePressed ) {
                    if ((scale4 == 4 && (key == 2 || key == 4 || key == 7 || key == 9 || key == 11))) {
                        noteFourCorrect = true;
                        fourthNotePressed = true;
                    } else {
                        noteFourCorrect = false;
                        fourthNotePressed = true;
                    }
                    thirdNotePressed = false;
                }
                if (secondNotePressed ) {
                    if ((scale3 == 4 && (key == 2 || key == 4 || key == 7 || key == 9 || key == 11))  ) {
                        noteThreeCorrect = true;
                        thirdNotePressed = true;
                    } else {
                        noteThreeCorrect = false;
                        thirdNotePressed = true;
                    }
                    secondNotePressed = false;
                }
                if (firstNotePressed ) {
                    if ((scale2 == 4 && (key == 2 || key == 4 || key == 7 || key == 9 || key == 11))) {
                        noteTwoCorrect = true;
                        secondNotePressed = true;
                    } else {
                        noteTwoCorrect = false;
                        secondNotePressed = true;
                    }
                    fifthNotePressed = false;
                }


                if (playPressed) {
                    if ((scale1 == 4 && (key == 2 || key == 4 || key == 7 || key == 9 || key == 11))) {
                        noteOneCorrect = true;

                    } else {
                        noteOneCorrect = false;
                    }
                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 7) {
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
                stop();
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();
                cancelTimer4();
                cancelTimer5();

                if (key == 1) {

                    note = "ds4" + instrumentName;
                }
                if (key == 2) {

                    note = "ds4" + instrumentName;
                }
                if (key == 5) {

                    note = "fs4" + instrumentName;
                }
                if (key == 6) {

                    note = "gs4" + instrumentName;

                }
                if (key == 7) {

                    note = "gs4" + instrumentName;

                }
                if (key == 8) {

                    note = "as4" + instrumentName;
                }
                if (key == 9) {

                    note = "as4" + instrumentName;
                }
                if (key == 12) {

                    note = "cs5" + instrumentName;
                }

                play(note);

                if (fourthNotePressed ) {

                    noteFiveCorrect = false;
                    fifthNotePressed = true;
                    fourthNotePressed = false;

                }
                if (fifthNotePressed) {
                    if (noteOneCorrect && noteTwoCorrect && noteThreeCorrect && noteFourCorrect && noteFiveCorrect) {
                        progressStatus++;
                        resetNotes();
                    } else {
                        progressStatus = 0;
                        isCorrect = false;
                        playAnswer();
                    }
                    fifthNotePressed = false;
                }
                if (thirdNotePressed ) {

                    noteFourCorrect = false;
                    fourthNotePressed = true;
                    thirdNotePressed = false;

                }
                if (secondNotePressed ) {

                    noteThreeCorrect = false;
                    thirdNotePressed = true;
                    secondNotePressed = false;

                }


                if (firstNotePressed ) {

                    noteTwoCorrect = false;
                    secondNotePressed = true;
                    firstNotePressed = false;

                }


                if (playPressed) {

                    noteOneCorrect = false;

                    firstNotePressed = true;

                }

                playPressed = false;

                if (progressStatus >= 20 && level < 7) {
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
        correctNote3 = 0;
        correctNote4 = 0;
        correctNote5 = 0;

        firstNotePressed = false;
        secondNotePressed = false;
        thirdNotePressed = false;
        fourthNotePressed = false;
        fifthNotePressed = false;

        isCorrect = true;


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

        currentLevel = lvl;
        updateProgress();
        levelChanged = false;
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



    private void displayNote1() {

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

        if (major == 0) {
            if (key == 1) {
                if (scale1 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 2) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 5) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 7) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 8) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 2) {
                if (scale1 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 3) {
                if (scale1 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 4) {
                if (scale1 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 6) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 5) {
                if (scale1 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 6) {
                if (scale1 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 2) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 5) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 7) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 8) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 7) {
                if (scale1 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 8) {
                if (scale1 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 2) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 7) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 9) {
                if (scale1 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 10) {
                if (scale1 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 11) {
                if (scale1 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 3) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 6) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 12) {
                if (scale1 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
        }
        if (major == 1) {
            if (key == 1) {
                if (scale1 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 5) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 2) {
                if (scale1 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 2) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 8) {
                    W8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 3) {
                if (scale1 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 4) {
                if (scale1 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 2) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 6) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 7) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 8) {
                    W8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 5) {
                if (scale1 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 6) {
                if (scale1 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 5) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 7) {
                if (scale1 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 8) {
                    W8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 8) {
                if (scale1 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 9) {
                if (scale1 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 2) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 7) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 8) {
                    W8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 10) {
                if (scale1 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 11) {
                if (scale1 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 2) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 3) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 6) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 7) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 8) {
                    W8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 12) {
                if (scale1 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale1 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
        }



    }





    private void displayNote2() {

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

        if (major == 0) {
            if (key == 1) {
                if (scale2 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 2) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 5) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 7) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 8) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 2) {
                if (scale2 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 3) {
                if (scale2 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 4) {
                if (scale2 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 6) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 5) {
                if (scale2 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 6) {
                if (scale2 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 2) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 5) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 7) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 8) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 7) {
                if (scale2 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 8) {
                if (scale2 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 2) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 7) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 9) {
                if (scale2 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 10) {
                if (scale2 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 11) {
                if (scale2 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 3) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 6) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 12) {
                if (scale2 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
        }
        if (major == 1) {
            if (key == 1) {
                if (scale2 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 5) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 2) {
                if (scale2 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 2) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 8) {
                    W8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 3) {
                if (scale2 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 4) {
                if (scale2 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 2) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 6) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 7) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 8) {
                    W8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 5) {
                if (scale2 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 6) {
                if (scale2 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 5) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 7) {
                if (scale2 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 8) {
                    W8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 8) {
                if (scale2 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 9) {
                if (scale2 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 2) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 7) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 8) {
                    W8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 10) {
                if (scale2 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 11) {
                if (scale2 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 2) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 3) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 6) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 7) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 8) {
                    W8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 12) {
                if (scale2 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale2 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
        }



    }






    private void displayNote3() {

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

        if (major == 0) {
            if (key == 1) {
                if (scale3 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 2) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 5) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 7) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 8) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 2) {
                if (scale3 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 3) {
                if (scale3 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 4) {
                if (scale3 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 6) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 5) {
                if (scale3 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 6) {
                if (scale3 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 2) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 5) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 7) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 8) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 7) {
                if (scale3 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 8) {
                if (scale3 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 2) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 7) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 9) {
                if (scale3 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 10) {
                if (scale3 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 11) {
                if (scale3 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 3) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 6) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 12) {
                if (scale3 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
        }
        if (major == 1) {
            if (key == 1) {
                if (scale3 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 5) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 2) {
                if (scale3 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 2) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 8) {
                    W8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 3) {
                if (scale3 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 4) {
                if (scale3 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 2) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 6) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 7) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 8) {
                    W8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 5) {
                if (scale3 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 6) {
                if (scale3 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 5) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 7) {
                if (scale3 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 8) {
                    W8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 8) {
                if (scale3 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 9) {
                if (scale3 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 2) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 7) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 8) {
                    W8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 10) {
                if (scale3 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 11) {
                if (scale3 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 2) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 3) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 6) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 7) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 8) {
                    W8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 12) {
                if (scale3 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale3 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
        }



    }




    private void displayNote4() {

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

        if (major == 0) {
            if (key == 1) {
                if (scale4 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 2) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 5) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 7) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 8) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 2) {
                if (scale4 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 3) {
                if (scale4 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 4) {
                if (scale4 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 6) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 5) {
                if (scale4 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 6) {
                if (scale4 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 2) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 5) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 7) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 8) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 7) {
                if (scale4 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 8) {
                if (scale4 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 2) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 7) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 9) {
                if (scale4 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 10) {
                if (scale4 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 11) {
                if (scale4 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 3) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 6) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 12) {
                if (scale4 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
        }
        if (major == 1) {
            if (key == 1) {
                if (scale4 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 5) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 2) {
                if (scale4 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 2) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 8) {
                    W8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 3) {
                if (scale4 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 4) {
                if (scale4 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 2) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 6) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 7) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 8) {
                    W8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 5) {
                if (scale4 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 6) {
                if (scale4 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 5) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 7) {
                if (scale4 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 8) {
                    W8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 8) {
                if (scale4 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 9) {
                if (scale4 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 2) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 7) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 8) {
                    W8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 10) {
                if (scale4 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 11) {
                if (scale4 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 2) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 3) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 6) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 7) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 8) {
                    W8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 12) {
                if (scale4 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale4 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
        }



    }




    private void displayNote5() {

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

        if (major == 0) {
            if (key == 1) {
                if (scale5 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 2) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 5) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 7) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 8) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 2) {
                if (scale5 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 3) {
                if (scale5 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 4) {
                if (scale5 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 6) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 5) {
                if (scale5 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 6) {
                if (scale5 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 2) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 5) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 7) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 8) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 7) {
                if (scale5 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 8) {
                if (scale5 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 2) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 7) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 9) {
                if (scale5 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 10) {
                if (scale5 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 11) {
                if (scale5 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 3) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 6) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 12) {
                if (scale5 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
        }
        if (major == 1) {
            if (key == 1) {
                if (scale5 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 5) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 2) {
                if (scale5 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 2) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 8) {
                    W8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 3) {
                if (scale5 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 4) {
                if (scale5 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 2) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 6) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 7) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 8) {
                    W8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 5) {
                if (scale5 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 6) {
                if (scale5 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 5) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 8) {
                    W7Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 7) {
                if (scale5 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 8) {
                    W8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 8) {
                if (scale5 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 2) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 7) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 9) {
                if (scale5 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 2) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 7) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 8) {
                    W8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 10) {
                if (scale5 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 3) {
                    W5Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 6) {
                    W2Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 11) {
                if (scale5 == 1) {
                    BL2Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 2) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 3) {
                    W6Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 4) {
                    BL9Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 5) {
                    BL5Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 6) {
                    W3Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 7) {
                    W7Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 8) {
                    W8Green.setVisibility(View.VISIBLE);
                }
            }
            if (key == 12) {
                if (scale5 == 1) {
                    W1Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 2) {
                    BL4Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 3) {
                    BL6Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 4) {
                    W8Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 5) {
                    W4Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 6) {
                    BL3Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 7) {
                    BL7Green.setVisibility(View.VISIBLE);
                }
                if (scale5 == 8) {
                    BL8Green.setVisibility(View.VISIBLE);
                }
            }
        }

    }



    private void correctNotes() {
        if (major == 0) {

            if (scale1 == 1) {
                correctNote1 = key;
            }
            if (scale1 == 6) {
                correctNote1 = key + 2;
            }
            if (scale1 == 2) {
                correctNote1 = key + 3;
            }
            if (scale1 == 5) {
                correctNote1 = key + 5;
            }
            if (scale1 == 3) {
                correctNote1 = key + 7;
            }
            if (scale1 == 7) {
                correctNote1 = key + 8;
            }
            if (scale1 == 8) {
                correctNote1 = key + 10;
            }
            if (scale1 == 4) {
                correctNote1 = key + 12;
            }


            if (scale2 == 1) {
                correctNote2 = key;
            }
            if (scale2 == 6) {
                correctNote2 = key + 2;
            }
            if (scale2 == 2) {
                correctNote2 = key + 3;
            }
            if (scale2 == 5) {
                correctNote2 = key + 5;
            }
            if (scale2 == 3) {
                correctNote2 = key + 7;
            }
            if (scale2 == 7) {
                correctNote2 = key + 8;
            }
            if (scale2 == 8) {
                correctNote2 = key + 10;
            }
            if (scale2 == 4) {
                correctNote2 = key + 12;
            }



            if (scale3 == 1) {
                correctNote3 = key;
            }
            if (scale3 == 6) {
                correctNote3 = key + 2;
            }
            if (scale3 == 2) {
                correctNote3 = key + 3;
            }
            if (scale3 == 5) {
                correctNote3 = key + 5;
            }
            if (scale3 == 3) {
                correctNote3 = key + 7;
            }
            if (scale3 == 7) {
                correctNote3 = key + 8;
            }
            if (scale3 == 8) {
                correctNote3 = key + 10;
            }
            if (scale3 == 4) {
                correctNote3 = key + 12;
            }



            if (scale4 == 1) {
                correctNote4 = key;
            }
            if (scale4 == 6) {
                correctNote4 = key + 2;
            }
            if (scale4 == 2) {
                correctNote4 = key + 3;
            }
            if (scale4 == 5) {
                correctNote4 = key + 5;
            }
            if (scale4 == 3) {
                correctNote4 = key + 7;
            }
            if (scale4 == 7) {
                correctNote4 = key + 8;
            }
            if (scale4 == 8) {
                correctNote4 = key + 10;
            }
            if (scale4 == 4) {
                correctNote4 = key + 12;
            }



            if (scale5 == 1) {
                correctNote5 = key;
            }
            if (scale5 == 6) {
                correctNote5 = key + 2;
            }
            if (scale5 == 2) {
                correctNote5 = key + 3;
            }
            if (scale5 == 5) {
                correctNote5 = key + 5;
            }
            if (scale5 == 3) {
                correctNote5 = key + 7;
            }
            if (scale5 == 7) {
                correctNote5 = key + 8;
            }
            if (scale5 == 8) {
                correctNote5 = key + 10;
            }
            if (scale5 == 4) {
                correctNote5 = key + 12;
            }






        }
        if (major == 1) {

            if (scale1 == 1) {
                correctNote1 = key;
            }
            if (scale1 == 6) {
                correctNote1 = key + 2;
            }
            if (scale1 == 2) {
                correctNote1 = key + 4;
            }
            if (scale1 == 5) {
                correctNote1 = key + 5;
            }
            if (scale1 == 3) {
                correctNote1 = key + 7;
            }
            if (scale1 == 7) {
                correctNote1 = key + 9;
            }
            if (scale1 == 8) {
                correctNote1 = key + 11;
            }
            if (scale1 == 4) {
                correctNote1 = key + 12;
            }


            if (scale2 == 1) {
                correctNote2 = key;
            }
            if (scale2 == 6) {
                correctNote2 = key + 2;
            }
            if (scale2 == 2) {
                correctNote2 = key + 4;
            }
            if (scale2 == 5) {
                correctNote2 = key + 5;
            }
            if (scale2 == 3) {
                correctNote2 = key + 7;
            }
            if (scale2 == 7) {
                correctNote2 = key + 9;
            }
            if (scale2 == 8) {
                correctNote2 = key + 11;
            }
            if (scale2 == 4) {
                correctNote2 = key + 12;
            }



            if (scale3 == 1) {
                correctNote3 = key;
            }
            if (scale3 == 6) {
                correctNote3 = key + 2;
            }
            if (scale3 == 2) {
                correctNote3 = key + 4;
            }
            if (scale3 == 5) {
                correctNote3 = key + 5;
            }
            if (scale3 == 3) {
                correctNote3 = key + 7;
            }
            if (scale3 == 7) {
                correctNote3 = key + 9;
            }
            if (scale3 == 8) {
                correctNote3 = key + 11;
            }
            if (scale3 == 4) {
                correctNote3 = key + 12;
            }



            if (scale4 == 1) {
                correctNote4 = key;
            }
            if (scale4 == 6) {
                correctNote4 = key + 2;
            }
            if (scale4 == 2) {
                correctNote4 = key + 4;
            }
            if (scale4 == 5) {
                correctNote4 = key + 5;
            }
            if (scale4 == 3) {
                correctNote4 = key + 7;
            }
            if (scale4 == 7) {
                correctNote4 = key + 9;
            }
            if (scale4 == 8) {
                correctNote4 = key + 11;
            }
            if (scale4 == 4) {
                correctNote4 = key + 12;
            }



            if (scale5 == 1) {
                correctNote5 = key;
            }
            if (scale5 == 6) {
                correctNote5 = key + 2;
            }
            if (scale5 == 2) {
                correctNote5 = key + 4;
            }
            if (scale5 == 5) {
                correctNote5 = key + 5;
            }
            if (scale5 == 3) {
                correctNote5 = key + 7;
            }
            if (scale5 == 7) {
                correctNote5 = key + 9;
            }
            if (scale5 == 8) {
                correctNote5 = key + 11;
            }
            if (scale5 == 4) {
                correctNote5 = key + 12;
            }

        }
    }


    private void setNote1() {

        stop();

        if (correctNote1 == 1) {
            note1 = "c3" + instrumentName;
        }
        if (correctNote1 == 2) {
            note1 = "cs3" + instrumentName;
        }
        if (correctNote1 == 3) {
            note1 = "d3" + instrumentName;
        }
        if (correctNote1 == 4) {
            note1 = "ds3" + instrumentName;
        }
        if (correctNote1 == 5) {
            note1 = "e3" + instrumentName;
        }
        if (correctNote1 == 6) {
            note1 = "f3" + instrumentName;
        }
        if (correctNote1 == 7) {
            note1 = "fs3" + instrumentName;
        }
        if (correctNote1 == 8) {
            note1 = "g3" + instrumentName;
        }
        if (correctNote1 == 9) {
            note1 = "gs3" + instrumentName;
        }
        if (correctNote1 == 10) {
            note1 = "a3" + instrumentName;
        }
        if (correctNote1 == 11) {
            note1 = "as3" + instrumentName;
        }
        if (correctNote1 == 12) {
            note1 = "b3" + instrumentName;
        }


        if (correctNote1 == 13) {
            note1 = "c4" + instrumentName;
        }
        if (correctNote1 == 14) {
            note1 = "cs4" + instrumentName;
        }
        if (correctNote1 == 15) {
            note1 = "d4" + instrumentName;
        }
        if (correctNote1 == 16) {
            note1 = "ds4" + instrumentName;
        }
        if (correctNote1 == 17) {
            note1 = "e4" + instrumentName;
        }
        if (correctNote1 == 18) {
            note1 = "f4" + instrumentName;
        }
        if (correctNote1 == 19) {
            note1 = "fs4" + instrumentName;
        }
        if (correctNote1 == 20) {
            note1 = "g4" + instrumentName;
        }
        if (correctNote1 == 21) {
            note1 = "gs4" + instrumentName;
        }
        if (correctNote1 == 22) {
            note1 = "a4" + instrumentName;
        }
        if (correctNote1 == 23) {
            note1 = "as4" + instrumentName;
        }
        if (correctNote1 == 24) {
            note1 = "b4" + instrumentName;
        }


    }




    private void setNote2() {

        stop();

        if (correctNote2 == 1) {
            note2 = "c3" + instrumentName;
        }
        if (correctNote2 == 2) {
            note2 = "cs3" + instrumentName;
        }
        if (correctNote2 == 3) {
            note2 = "d3" + instrumentName;
        }
        if (correctNote2 == 4) {
            note2 = "ds3" + instrumentName;
        }
        if (correctNote2 == 5) {
            note2 = "e3" + instrumentName;
        }
        if (correctNote2 == 6) {
            note2 = "f3" + instrumentName;
        }
        if (correctNote2 == 7) {
            note2 = "fs3" + instrumentName;
        }
        if (correctNote2 == 8) {
            note2 = "g3" + instrumentName;
        }
        if (correctNote2 == 9) {
            note2 = "gs3" + instrumentName;
        }
        if (correctNote2 == 10) {
            note2 = "a3" + instrumentName;
        }
        if (correctNote2 == 11) {
            note2 = "as3" + instrumentName;
        }
        if (correctNote2 == 12) {
            note2 = "b3" + instrumentName;
        }


        if (correctNote2 == 13) {
            note2 = "c4" + instrumentName;
        }
        if (correctNote2 == 14) {
            note2 = "cs4" + instrumentName;
        }
        if (correctNote2 == 15) {
            note2 = "d4" + instrumentName;
        }
        if (correctNote2 == 16) {
            note2 = "ds4" + instrumentName;
        }
        if (correctNote2 == 17) {
            note2 = "e4" + instrumentName;
        }
        if (correctNote2 == 18) {
            note2 = "f4" + instrumentName;
        }
        if (correctNote2 == 19) {
            note2 = "fs4" + instrumentName;
        }
        if (correctNote2 == 20) {
            note2 = "g4" + instrumentName;
        }
        if (correctNote2 == 21) {
            note2 = "gs4" + instrumentName;
        }
        if (correctNote2 == 22) {
            note2 = "a4" + instrumentName;
        }
        if (correctNote2 == 23) {
            note2 = "as4" + instrumentName;
        }
        if (correctNote2 == 24) {
            note2 = "b4" + instrumentName;
        }


    }



    private void setNote3() {

        stop();

        if (correctNote3 == 1) {
            note3 = "c3" + instrumentName;
        }
        if (correctNote3 == 2) {
            note3 = "cs3" + instrumentName;
        }
        if (correctNote3 == 3) {
            note3 = "d3" + instrumentName;
        }
        if (correctNote3 == 4) {
            note3 = "ds3" + instrumentName;
        }
        if (correctNote3 == 5) {
            note3 = "e3" + instrumentName;
        }
        if (correctNote3 == 6) {
            note3 = "f3" + instrumentName;
        }
        if (correctNote3 == 7) {
            note3 = "fs3" + instrumentName;
        }
        if (correctNote3 == 8) {
            note3 = "g3" + instrumentName;
        }
        if (correctNote3 == 9) {
            note3 = "gs3" + instrumentName;
        }
        if (correctNote3 == 10) {
            note3 = "a3" + instrumentName;
        }
        if (correctNote3 == 11) {
            note3 = "as3" + instrumentName;
        }
        if (correctNote3 == 12) {
            note3 = "b3" + instrumentName;
        }


        if (correctNote3 == 13) {
            note3 = "c4" + instrumentName;
        }
        if (correctNote3 == 14) {
            note3 = "cs4" + instrumentName;
        }
        if (correctNote3 == 15) {
            note3 = "d4" + instrumentName;
        }
        if (correctNote3 == 16) {
            note3 = "ds4" + instrumentName;
        }
        if (correctNote3 == 17) {
            note3 = "e4" + instrumentName;
        }
        if (correctNote3 == 18) {
            note3 = "f4" + instrumentName;
        }
        if (correctNote3 == 19) {
            note3 = "fs4" + instrumentName;
        }
        if (correctNote3 == 20) {
            note3 = "g4" + instrumentName;
        }
        if (correctNote3 == 21) {
            note3 = "gs4" + instrumentName;
        }
        if (correctNote3 == 22) {
            note3 = "a4" + instrumentName;
        }
        if (correctNote3 == 23) {
            note3 = "as4" + instrumentName;
        }
        if (correctNote3 == 24) {
            note3 = "b4" + instrumentName;
        }


    }


    private void setNote4() {

        stop();

        if (correctNote4 == 1) {
            note4 = "c3" + instrumentName;
        }
        if (correctNote4 == 2) {
            note4 = "cs3" + instrumentName;
        }
        if (correctNote4 == 3) {
            note4 = "d3" + instrumentName;
        }
        if (correctNote4 == 4) {
            note4 = "ds3" + instrumentName;
        }
        if (correctNote4 == 5) {
            note4 = "e3" + instrumentName;
        }
        if (correctNote4 == 6) {
            note4 = "f3" + instrumentName;
        }
        if (correctNote4 == 7) {
            note4 = "fs3" + instrumentName;
        }
        if (correctNote4 == 8) {
            note4 = "g3" + instrumentName;
        }
        if (correctNote4 == 9) {
            note4 = "gs3" + instrumentName;
        }
        if (correctNote4 == 10) {
            note4 = "a3" + instrumentName;
        }
        if (correctNote4 == 11) {
            note4 = "as3" + instrumentName;
        }
        if (correctNote4 == 12) {
            note4 = "b3" + instrumentName;
        }


        if (correctNote4 == 13) {
            note4 = "c4" + instrumentName;
        }
        if (correctNote4 == 14) {
            note4 = "cs4" + instrumentName;
        }
        if (correctNote4 == 15) {
            note4 = "d4" + instrumentName;
        }
        if (correctNote4 == 16) {
            note4 = "ds4" + instrumentName;
        }
        if (correctNote4 == 17) {
            note4 = "e4" + instrumentName;
        }
        if (correctNote4 == 18) {
            note4 = "f4" + instrumentName;
        }
        if (correctNote4 == 19) {
            note4 = "fs4" + instrumentName;
        }
        if (correctNote4 == 20) {
            note4 = "g4" + instrumentName;
        }
        if (correctNote4 == 21) {
            note4 = "gs4" + instrumentName;
        }
        if (correctNote4 == 22) {
            note4 = "a4" + instrumentName;
        }
        if (correctNote4 == 23) {
            note4 = "as4" + instrumentName;
        }
        if (correctNote4 == 24) {
            note4 = "b4" + instrumentName;
        }


    }


    private void setNote5() {

        stop();

        if (correctNote5 == 1) {
            note5 = "c3" + instrumentName;
        }
        if (correctNote5 == 2) {
            note5 = "cs3" + instrumentName;
        }
        if (correctNote5 == 3) {
            note5 = "d3" + instrumentName;
        }
        if (correctNote5 == 4) {
            note5 = "ds3" + instrumentName;
        }
        if (correctNote5 == 5) {
            note5 = "e3" + instrumentName;
        }
        if (correctNote5 == 6) {
            note5 = "f3" + instrumentName;
        }
        if (correctNote5 == 7) {
            note5 = "fs3" + instrumentName;
        }
        if (correctNote5 == 8) {
            note5 = "g3" + instrumentName;
        }
        if (correctNote5 == 9) {
            note5 = "gs3" + instrumentName;
        }
        if (correctNote5 == 10) {
            note5 = "a3" + instrumentName;
        }
        if (correctNote5 == 11) {
            note5 = "as3" + instrumentName;
        }
        if (correctNote5 == 12) {
            note5 = "b3" + instrumentName;
        }


        if (correctNote5 == 13) {
            note5 = "c4" + instrumentName;
        }
        if (correctNote5 == 14) {
            note5 = "cs4" + instrumentName;
        }
        if (correctNote5 == 15) {
            note5 = "d4" + instrumentName;
        }
        if (correctNote5 == 16) {
            note5 = "ds4" + instrumentName;
        }
        if (correctNote5 == 17) {
            note5 = "e4" + instrumentName;
        }
        if (correctNote5 == 18) {
            note5 = "f4" + instrumentName;
        }
        if (correctNote5 == 19) {
            note5 = "fs4" + instrumentName;
        }
        if (correctNote5 == 20) {
            note5 = "g4" + instrumentName;
        }
        if (correctNote5 == 21) {
            note5 = "gs4" + instrumentName;
        }
        if (correctNote5 == 22) {
            note5 = "a4" + instrumentName;
        }
        if (correctNote5 == 23) {
            note5 = "as4" + instrumentName;
        }
        if (correctNote5 == 24) {
            note5 = "b4" + instrumentName;
        }


    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
