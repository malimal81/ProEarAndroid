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
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.media.MediaPlayer;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import android.os.CountDownTimer;
import android.graphics.Color;

import java.util.Random;

public class Interval_Recognition extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    MediaPlayer audio1;
    MediaPlayer audio2;
    private ProgressBar progressBar;
    private Button playButton;
    private int progress = 0;
    private TextView textView;
    private int correctNote1 = 0;
    private int correctNote2 = 0;
    private int level = 0;
    private String instrumentName = "piano";
    private String answer;
    private String lvl;
    private String currentLevel;
    private boolean levelChanged = true;
    private Handler handler1;
    private Handler handler2;
    private Handler handler3;
    private Handler handler4;
    private boolean running1 = true;
    private boolean running2 = true;
    private boolean running3 = true;
    private boolean running4 = true;
    private boolean playPressed = false;
    private boolean isCorrect = false;
    private int octave = 3;
    private int delay = 0;
    private int interval = 0;
    private int intervalDirection = 0;
    private int key = 1;
    private int instrument = 1;
    private int harmonic = 0;
    private String note1 = "c3piano";
    private String note2 = "g3piano";
    private boolean running = true;
    private CountDownTimer timer;
    private CountDownTimer timer1;
    private CountDownTimer timer2;
    private CountDownTimer timer3;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interval__recognition);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Interval Recognition");
        spinner = (Spinner) findViewById(R.id.spinner);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        textView = (TextView) findViewById(R.id.progressTextView);
        progressBar.getProgressDrawable().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.intervallevels, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        setKey();
        setLevel();
        resetColor();
        setInstrument();

        setMenuButton();
        setPlayButton();
        setUnisonButton();
        setMinorSecondButton();
        setMajorSecondButton();
        setMajorThirdButton();
        setMinorThirdButton();
        setPerfectFourthButton();
        setTritoneButton();
        setPerfectFifthButton();
        setMinorSixthButton();
        setMajorSixthButton();
        setMajorSeventhButton();
        setMinorSeventhButton();
        setOctaveButton();
        progressBar.setProgress(0);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void setInstrument () {

        if (instrument == 1) {
            instrumentName = "piano";
        }
        if (instrument == 2) {
            instrumentName = "guitar";
        }
        if (instrument == 3) {
            instrumentName = "organ";
        }
        if (instrument == 4) {
            instrumentName = "sine";
        }
        if (instrument == 5) {
            instrumentName = "square";
        }
        if (instrument == 6) {
            instrumentName = "saw";
        }
        if (instrument == 7) {
            instrumentName = "triangle";
        }
        if (instrument == 8) {
            instrumentName = "strings";
        }
        if (instrument == 9) {
            instrumentName = "brass";
        }
        if (instrument == 10) {
            instrumentName = "bassoon";
        }

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
                stop();
                startActivity(new Intent(Interval_Recognition.this, MainActivity.class));
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
                stop();
                setLevel();
                resetNotes();
                setKey();
                setInterval();

                final Random rand = new Random();
                //instrument = rand.nextInt(10) + 1;

                if (instrument == 2) {
                    final Random rand1 = new Random();
                    octave = rand1.nextInt(2) + 2;

                } else {
                    final Random rand2 = new Random();
                    octave = rand2.nextInt(3) + 1;
                }
                final Random rand4 = new Random();
                delay = rand4.nextInt(600) + 400;

                setInstrument();
                correctNotes();
                setNote1();
                setNote2();
                resetColor();
                running = true;
                countDown();
                isCorrect = true;
                running3 = true;
                countDown3();

                if (harmonic == 2 || interval == 8) {
                    running1 = true;
                    countDown1();
                }
                playPressed = true;
                levelChanged = false;

            }
        });

    }


    private void setInterval() {
        final Random rand = new Random();
        interval = rand.nextInt(level + 1) + 1;

        final Random rand1 = new Random();
        intervalDirection = rand1.nextInt(2) + 1;

        final Random rand2 = new Random();
        harmonic = rand2.nextInt(2) + 1;

    }

    private void play1(String sound) {
        int resID1 = getResources().getIdentifier(sound, "raw", getPackageName());
        MediaPlayer audio1 = MediaPlayer.create(Interval_Recognition.this, resID1);
        audio1.start();
        audio1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer audio1) {
                audio1.release();

            }


        });
    }

    private void play2(String sound) {
        int resID2 = getResources().getIdentifier(sound, "raw", getPackageName());
        MediaPlayer audio2 = MediaPlayer.create(Interval_Recognition.this, resID2);
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

    private void countDown() {
        timer = new CountDownTimer(5000, 5000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

                    isCorrect = false;
                    progress = 0;
                    displayAnswer();
                    play1(note1);
                    playPressed = false;
                    updateProgress();
                    cancelTimer();
                    cancelTimer1();
                    cancelTimer3();
                    running2 = true;
                    countDown2();


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
                    cancelTimer1();

            }
        }.start();
    }

    private void countDown2() {
        timer2 = new CountDownTimer(900, 900) {
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

    private void countDown3() {
        timer3 = new CountDownTimer(500, 500) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

                    play1(note1);

                    if (harmonic == 1 && interval != 8 && isCorrect) {

                        play2(note2);
                    }
                    cancelTimer3();

            }
        }.start();
    }

    private void resetNotes() {
        correctNote1 = 0;
        correctNote2 = 0;
    }



    private void setLevel() {

        resetButtons();
        lvl = spinner.getSelectedItem().toString();

        if (!lvl.equals(currentLevel)) {
            levelChanged = true;
        }

        if (levelChanged) {
            resetNotes();
            progress = 0;
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

        resetColor();
        currentLevel = lvl;
        updateProgress();
        levelChanged = false;
    }


    private void setUnisonButton() {
        Button unisonButton = (Button) findViewById(R.id.unisonButton);
        unisonButton.setTransformationMethod(null);
        unisonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();

                if (playPressed) {
                    stop();
                    if (interval == 8) {
                        displayAnswer();
                        progress++;
                        resetNotes();
                        playPressed = false;

                    } else {
                        isCorrect = false;
                        running3 = true;
                        countDown3();
                        running2 = true;
                        countDown2();
                        progress = 0;
                        displayAnswer();

                    }

                }

                playPressed = false;

                if (progress >= 20 && level < 12) {
                    progress = 0;
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


    private void setMinorSecondButton() {
        Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
        minorSecondButton.setTransformationMethod(null);
        minorSecondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();

                if (playPressed) {
                    stop();
                    if (interval == 7) {
                        displayAnswer();
                        progress++;
                        resetNotes();
                        playPressed = false;

                    } else {
                        isCorrect = false;
                        running3 = true;
                        countDown3();
                        running2 = true;
                        countDown2();
                        progress = 0;
                        displayAnswer();

                    }

                }

                playPressed = false;

                if (progress >= 20 && level < 12) {
                    progress = 0;
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

    private void setMajorSecondButton() {
        Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
        majorSecondButton.setTransformationMethod(null);
        majorSecondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();

                if (playPressed) {
                    stop();
                    if (interval == 6) {
                        displayAnswer();
                        progress++;
                        resetNotes();
                        playPressed = false;

                    } else {
                        isCorrect = false;
                        running3 = true;
                        countDown3();
                        running2 = true;
                        countDown2();
                        progress = 0;
                        displayAnswer();

                    }

                }

                playPressed = false;

                if (progress >= 20 && level < 12) {
                    progress = 0;
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

    private void setMinorThirdButton() {
        Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
        minorThirdButton.setTransformationMethod(null);
        minorThirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();

                if (playPressed) {
                    stop();
                    if (interval == 5) {
                        displayAnswer();
                        progress++;
                        resetNotes();
                        playPressed = false;

                    } else {
                        isCorrect = false;
                        running3 = true;
                        countDown3();
                        running2 = true;
                        countDown2();
                        progress = 0;
                        displayAnswer();

                    }

                }

                playPressed = false;

                if (progress >= 20 && level < 12) {
                    progress = 0;
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

    private void setMajorThirdButton() {
        Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
        majorThirdButton.setTransformationMethod(null);
        majorThirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();

                if (playPressed) {
                    stop();
                    if (interval == 4) {
                        displayAnswer();
                        progress++;
                        resetNotes();
                        playPressed = false;

                    } else {
                        isCorrect = false;
                        running3 = true;
                        countDown3();
                        running2 = true;
                        countDown2();
                        progress = 0;
                        displayAnswer();

                    }

                }

                playPressed = false;

                if (progress >= 20 && level < 12) {
                    progress = 0;
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

    private void setPerfectFourthButton() {
        Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
        perfectFourthButton.setTransformationMethod(null);
        perfectFourthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();

                if (playPressed) {
                    stop();
                    if (interval == 2) {
                        displayAnswer();
                        progress++;
                        resetNotes();
                        playPressed = false;

                    } else {
                        isCorrect = false;
                        running3 = true;
                        countDown3();
                        running2 = true;
                        countDown2();
                        progress = 0;
                        displayAnswer();

                    }

                }

                playPressed = false;

                if (progress >= 20 && level < 12) {
                    progress = 0;
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

    private void setTritoneButton() {
        Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
        tritoneButton.setTransformationMethod(null);
        tritoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();

                if (playPressed) {
                    stop();
                    if (interval == 13) {
                        displayAnswer();
                        progress++;
                        resetNotes();
                        playPressed = false;

                    } else {
                        isCorrect = false;
                        running3 = true;
                        countDown3();
                        running2 = true;
                        countDown2();
                        progress = 0;
                        displayAnswer();

                    }

                }

                playPressed = false;

                if (progress >= 20 && level < 12) {
                    progress = 0;
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

    private void setPerfectFifthButton() {
        Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
        perfectFifthButton.setTransformationMethod(null);
        perfectFifthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();

                if (playPressed) {
                    stop();
                    if (interval == 1) {
                        displayAnswer();
                        progress++;
                        resetNotes();
                        playPressed = false;

                    } else {
                        isCorrect = false;
                        running3 = true;
                        countDown3();
                        running2 = true;
                        countDown2();
                        progress = 0;
                        displayAnswer();

                    }

                }

                playPressed = false;

                if (progress >= 20 && level < 12) {
                    progress = 0;
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

    private void setMinorSixthButton() {
        Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
        minorSixthButton.setTransformationMethod(null);
        minorSixthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();

                if (playPressed) {
                    stop();
                    if (interval == 10) {
                        displayAnswer();
                        progress++;
                        resetNotes();
                        playPressed = false;

                    } else {
                        isCorrect = false;
                        running3 = true;
                        countDown3();
                        running2 = true;
                        countDown2();
                        progress = 0;
                        displayAnswer();

                    }

                }

                playPressed = false;

                if (progress >= 20 && level < 12) {
                    progress = 0;
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

    private void setMajorSixthButton() {
        Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
        majorSixthButton.setTransformationMethod(null);
        majorSixthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();

                if (playPressed) {
                    stop();
                    if (interval == 9) {
                        displayAnswer();
                        progress++;
                        resetNotes();
                        playPressed = false;

                    } else {
                        isCorrect = false;
                        running3 = true;
                        countDown3();
                        running2 = true;
                        countDown2();
                        progress = 0;
                        displayAnswer();

                    }

                }

                playPressed = false;

                if (progress >= 20 && level < 12) {
                    progress = 0;
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

    private void setMinorSeventhButton() {
        Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
        minorSeventhButton.setTransformationMethod(null);
        minorSeventhButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();

                if (playPressed) {
                    stop();
                    if (interval == 11) {
                        displayAnswer();
                        progress++;
                        resetNotes();
                        playPressed = false;

                    } else {
                        isCorrect = false;
                        running3 = true;
                        countDown3();
                        running2 = true;
                        countDown2();
                        progress = 0;
                        displayAnswer();

                    }

                }

                playPressed = false;

                if (progress >= 20 && level < 12) {
                    progress = 0;
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

    private void setMajorSeventhButton() {
        Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
        majorSeventhButton.setTransformationMethod(null);
        majorSeventhButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();

                if (playPressed) {
                    stop();
                    if (interval == 12) {
                        displayAnswer();
                        progress++;
                        resetNotes();
                        playPressed = false;

                    } else {
                        isCorrect = false;
                        running3 = true;
                        countDown3();
                        running2 = true;
                        countDown2();
                        progress = 0;
                        displayAnswer();

                    }

                }

                playPressed = false;

                if (progress >= 20 && level < 12) {
                    progress = 0;
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

    private void setOctaveButton() {
        Button octaveButton = (Button) findViewById(R.id.octaveButton);
        octaveButton.setTransformationMethod(null);
        octaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                cancelTimer1();
                cancelTimer2();
                cancelTimer3();

                if (playPressed) {
                    stop();
                    if (interval == 3) {
                        displayAnswer();
                        progress++;
                        resetNotes();
                        playPressed = false;

                    } else {
                        isCorrect = false;
                        running3 = true;
                        countDown3();
                        running2 = true;
                        countDown2();
                        progress = 0;
                        displayAnswer();

                    }

                }

                playPressed = false;

                if (progress >= 20 && level < 12) {
                    progress = 0;
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

        progressBar.setProgress(progress);
        textView.setText("Progress: " + progress);
    }

    private void setKey () {
        final Random rand = new Random();
        key = rand.nextInt(12) + 1;
    }

    private void displayAnswer() {

        if (interval == 1) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setTextColor(Color.parseColor("#FF29C95D"));

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setTextColor(Color.parseColor("#E6AAAAAA"));

        }

        if (interval == 2) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setTextColor(Color.parseColor("#FF29C95D"));

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setTextColor(Color.parseColor("#E6AAAAAA"));

        }

        if (interval == 3) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setTextColor(Color.parseColor("#FF29C95D"));

        }

        if (interval == 4) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setTextColor(Color.parseColor("#FF29C95D"));

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setTextColor(Color.parseColor("#E6AAAAAA"));

        }

        if (interval == 5) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setTextColor(Color.parseColor("#FF29C95D"));

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setTextColor(Color.parseColor("#E6AAAAAA"));

        }

        if (interval == 6) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setTextColor(Color.parseColor("#FF29C95D"));

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setTextColor(Color.parseColor("#E6AAAAAA"));

        }

        if (interval == 7) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setTextColor(Color.parseColor("#FF29C95D"));

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setTextColor(Color.parseColor("#E6AAAAAA"));

        }

        if (interval == 8) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setTextColor(Color.parseColor("#FF29C95D"));

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setTextColor(Color.parseColor("#E6AAAAAA"));

        }

        if (interval == 9) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setTextColor(Color.parseColor("#FF29C95D"));

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setTextColor(Color.parseColor("#E6AAAAAA"));

        }

        if (interval == 10) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setTextColor(Color.parseColor("#FF29C95D"));

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setTextColor(Color.parseColor("#E6AAAAAA"));

        }

        if (interval == 11) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setTextColor(Color.parseColor("#FF29C95D"));

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setTextColor(Color.parseColor("#E6AAAAAA"));

        }

        if (interval == 12) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setTextColor(Color.parseColor("#FF29C95D"));

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setTextColor(Color.parseColor("#E6AAAAAA"));

        }

        if (interval == 13) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setTextColor(Color.parseColor("#FF29C95D"));

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setTextColor(Color.parseColor("#E6AAAAAA"));

        }


    }

    private void resetColor() {

        if (level == 1) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setTextColor(Color.parseColor("#E6AAAAAA"));

        }

        if (level == 2) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setTextColor(Color.parseColor("#FF007AFF"));

        }

        if (level == 3) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setTextColor(Color.parseColor("#FF007AFF"));

        }

        if (level == 4) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setTextColor(Color.parseColor("#FF007AFF"));

        }

        if (level == 5) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setTextColor(Color.parseColor("#FF007AFF"));

        }

        if (level == 6) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setTextColor(Color.parseColor("#FF007AFF"));

        }

        if (level == 7) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setTextColor(Color.parseColor("#FF007AFF"));

        }

        if (level == 8) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setTextColor(Color.parseColor("#FF007AFF"));

        }

        if (level == 9) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setTextColor(Color.parseColor("#FF007AFF"));

        }

        if (level == 10) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setTextColor(Color.parseColor("#FF007AFF"));

        }

        if (level == 11) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setTextColor(Color.parseColor("#E6AAAAAA"));

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setTextColor(Color.parseColor("#FF007AFF"));

        }

        if (level == 12) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setTextColor(Color.parseColor("#FF007AFF"));

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setTextColor(Color.parseColor("#FF007AFF"));

        }

    }

    private void resetButtons() {

        if (level == 1) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setEnabled(false);

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setEnabled(false);

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setEnabled(false);

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setEnabled(false);

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setEnabled(false);

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setEnabled(true);

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setEnabled(false);

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setEnabled(true);

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setEnabled(false);

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setEnabled(false);

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setEnabled(false);

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setEnabled(false);

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setEnabled(false);
        }

        if (level == 2) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setEnabled(false);

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setEnabled(false);

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setEnabled(false);

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setEnabled(false);

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setEnabled(false);

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setEnabled(true);

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setEnabled(false);

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setEnabled(true);

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setEnabled(false);

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setEnabled(false);

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setEnabled(false);

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setEnabled(false);

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setEnabled(true);
        }

        if (level == 3) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setEnabled(false);

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setEnabled(false);

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setEnabled(false);

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setEnabled(false);

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setEnabled(true);

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setEnabled(true);

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setEnabled(false);

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setEnabled(true);

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setEnabled(false);

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setEnabled(false);

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setEnabled(false);

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setEnabled(false);

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setEnabled(true);
        }

        if (level == 4) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setEnabled(false);

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setEnabled(false);

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setEnabled(false);

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setEnabled(true);

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setEnabled(true);

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setEnabled(true);

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setEnabled(false);

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setEnabled(true);

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setEnabled(false);

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setEnabled(false);

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setEnabled(false);

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setEnabled(false);

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setEnabled(true);
        }

        if (level == 5) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setEnabled(false);

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setEnabled(false);

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setEnabled(true);

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setEnabled(true);

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setEnabled(true);

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setEnabled(true);

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setEnabled(false);

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setEnabled(true);

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setEnabled(false);

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setEnabled(false);

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setEnabled(false);

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setEnabled(false);

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setEnabled(true);
        }

        if (level == 6) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setEnabled(false);

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setEnabled(true);

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setEnabled(true);

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setEnabled(true);

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setEnabled(true);

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setEnabled(true);

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setEnabled(false);

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setEnabled(true);

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setEnabled(false);

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setEnabled(false);

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setEnabled(false);

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setEnabled(false);

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setEnabled(true);
        }

        if (level == 7) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setEnabled(true);

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setEnabled(true);

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setEnabled(true);

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setEnabled(true);

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setEnabled(true);

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setEnabled(true);

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setEnabled(false);

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setEnabled(true);

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setEnabled(false);

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setEnabled(false);

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setEnabled(false);

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setEnabled(false);

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setEnabled(true);
        }

        if (level == 8) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setEnabled(true);

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setEnabled(true);

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setEnabled(true);

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setEnabled(true);

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setEnabled(true);

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setEnabled(true);

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setEnabled(false);

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setEnabled(true);

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setEnabled(false);

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setEnabled(true);

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setEnabled(false);

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setEnabled(false);

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setEnabled(true);
        }

        if (level == 9) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setEnabled(true);

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setEnabled(true);

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setEnabled(true);

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setEnabled(true);

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setEnabled(true);

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setEnabled(true);

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setEnabled(false);

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setEnabled(true);

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setEnabled(true);

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setEnabled(true);

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setEnabled(false);

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setEnabled(false);

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setEnabled(true);
        }

        if (level == 10) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setEnabled(true);

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setEnabled(true);

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setEnabled(true);

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setEnabled(true);

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setEnabled(true);

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setEnabled(true);

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setEnabled(false);

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setEnabled(true);

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setEnabled(true);

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setEnabled(true);

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setEnabled(true);

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setEnabled(false);

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setEnabled(true);
        }

        if (level == 11) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setEnabled(true);

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setEnabled(true);

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setEnabled(true);

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setEnabled(true);

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setEnabled(true);

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setEnabled(true);

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setEnabled(false);

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setEnabled(true);

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setEnabled(true);

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setEnabled(true);

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setEnabled(true);

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setEnabled(true);

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setEnabled(true);
        }

        if (level == 12) {
            Button unisonButton = (Button) findViewById(R.id.unisonButton);
            unisonButton.setEnabled(true);

            Button minorSecondButton = (Button) findViewById(R.id.minorSecondButton);
            minorSecondButton.setEnabled(true);

            Button majorSecondButton = (Button) findViewById(R.id.majorSecondButton);
            majorSecondButton.setEnabled(true);

            Button minorThirdButton = (Button) findViewById(R.id.minorThirdButton);
            minorThirdButton.setEnabled(true);

            Button majorThirdButton = (Button) findViewById(R.id.majorThirdButton);
            majorThirdButton.setEnabled(true);

            Button perfectFourthButton = (Button) findViewById(R.id.perfectFourthButton);
            perfectFourthButton.setEnabled(true);

            Button tritoneButton = (Button) findViewById(R.id.tritoneButton);
            tritoneButton.setEnabled(true);

            Button perfectFifthButton = (Button) findViewById(R.id.perfectFifthButton);
            perfectFifthButton.setEnabled(true);

            Button minorSixthButton = (Button) findViewById(R.id.minorSixthButton);
            minorSixthButton.setEnabled(true);

            Button majorSixthButton = (Button) findViewById(R.id.majorSixthButton);
            majorSixthButton.setEnabled(true);

            Button minorSeventhButton = (Button) findViewById(R.id.minorSeventhButton);
            minorSeventhButton.setEnabled(true);

            Button majorSeventhButton = (Button) findViewById(R.id.majorSeventhButton);
            majorSeventhButton.setEnabled(true);

            Button octaveButton = (Button) findViewById(R.id.octaveButton);
            octaveButton.setEnabled(true);
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
                correctNote2 = correctNote1;
            }

            if (interval == 9) {
                correctNote2 = correctNote1 + 9;
            }
            if (interval == 10) {
                correctNote2 = correctNote1 + 8;
            }
            if (interval == 11) {
                correctNote2 = correctNote1 + 10;
            }
            if (interval == 12) {
                correctNote2 = correctNote1 + 11;
            }
            if (interval == 13) {
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
                correctNote2 = correctNote1;
            }

            if (interval == 9) {
                correctNote2 = correctNote1 - 9;
            }
            if (interval == 10) {
                correctNote2 = correctNote1 - 8;
            }
            if (interval == 11) {
                correctNote2 = correctNote1 - 10;
            }
            if (interval == 12) {
                correctNote2 = correctNote1 - 11;
            }
            if (interval == 13) {
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
            note1 = "cs6" + instrumentName;
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
            note2 = "cs6" + instrumentName;
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
                "Interval_Recognition Page", // TODO: Define a title for the content shown.
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
                "Interval_Recognition Page", // TODO: Define a title for the content shown.
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
