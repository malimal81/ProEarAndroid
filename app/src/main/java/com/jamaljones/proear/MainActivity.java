package com.jamaljones.proear;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setIntervalButton();
        setPitchButton();
        setIntervalPlayButton();
        setMelodyButton();
        setChordButton();
        setInversionButton();
    }

    private void setIntervalButton() {
        Button intervalButton = (Button) findViewById(R.id.intervalButton);
        intervalButton.setTransformationMethod(null);
        intervalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Interval_Recognition.class));
            }
        });

    }

    private void setPitchButton() {
        Button pitchButton = (Button) findViewById(R.id.pitchButton);
        pitchButton.setTransformationMethod(null);
        pitchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Pitch_Recognition.class));
            }
        });

    }

    private void setIntervalPlayButton() {
        Button intervalPlayButton = (Button) findViewById(R.id.intervalPlayButton);
        intervalPlayButton.setTransformationMethod(null);
        intervalPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Interval_Playback.class));
            }
        });

    }

    private void setMelodyButton() {
        Button melodyButton = (Button) findViewById(R.id.melodyButton);
        melodyButton.setTransformationMethod(null);
        melodyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Melody_Playback.class));
            }
        });

    }

    private void setChordButton() {
        Button chordButton = (Button) findViewById(R.id.chordButton);
        chordButton.setTransformationMethod(null);
        chordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Chord_Recognition.class));
            }
        });

    }

    private void setInversionButton() {
        Button inversionButton = (Button) findViewById(R.id.inversionButton);
        inversionButton.setTransformationMethod(null);
        inversionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Chord_Inversions.class));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
