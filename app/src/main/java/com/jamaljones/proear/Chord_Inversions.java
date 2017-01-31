package com.jamaljones.proear;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
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

public class Chord_Inversions extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    private ProgressBar progressBar;
    private Button playButton;
    private int progressStatus = 0;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chord__inversions);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Chord Inversions");

        spinner= (Spinner) findViewById(R.id.spinner);
        progressBar= (ProgressBar) findViewById(R.id.progressBar);
        textView = (TextView) findViewById(R.id.progressTextView);
        progressBar.getProgressDrawable().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);

        ArrayAdapter adapter=ArrayAdapter.createFromResource(this,R.array.inversionlevels,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);



        setMenuButton();
        setPlayButton();
        setRootButton();
        setFirstButton();
        setSecondButton();
        setThirdButton();
        progressBar.setProgress(0);
    }

    private void setMenuButton() {
        Button menuButton = (Button) findViewById(R.id.menuButton);
        menuButton.setTransformationMethod(null);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Chord_Inversions.this, MainActivity.class));
            }
        });

    }

    private void setPlayButton() {
        Button playButton = (Button) findViewById(R.id.playButton);
        playButton.setTransformationMethod(null);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressStatus++;
                updateProgress();

            }
        });

    }

    private void setRootButton() {
        Button rootButton = (Button) findViewById(R.id.rootButton);
        rootButton.setTransformationMethod(null);
        rootButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressStatus++;
                updateProgress();

            }
        });

    }

    private void setFirstButton() {
        Button firstButton = (Button) findViewById(R.id.firstButton);
        firstButton.setTransformationMethod(null);
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressStatus++;
                updateProgress();

            }
        });

    }

    private void setSecondButton() {
        Button secondButton = (Button) findViewById(R.id.secondButton);
        secondButton.setTransformationMethod(null);
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressStatus++;
                updateProgress();

            }
        });

    }

    private void setThirdButton() {
        Button thirdButton = (Button) findViewById(R.id.thirdButton);
        thirdButton.setTransformationMethod(null);
        thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressStatus++;
                updateProgress();

            }
        });

    }

    private void updateProgress() {

        progressBar.setProgress(progressStatus);
        textView.setText("Progress: " + progressStatus);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView myText= (TextView) view;
        String levelNum = String.valueOf(position + 1);
        Toast.makeText(this, "Level:" + levelNum, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
