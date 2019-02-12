package com.example.bunger_hw2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{

    TextView redVal = null;
    TextView greenVal = null;
    TextView blueVal = null;
    SeekBar seekBarRed = null;
    SeekBar seekBarGreen = null;
    SeekBar seekBarBlue= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //initialize the text views for the RGB values
        redVal = (TextView)findViewById(R.id.redVal);
        redVal.setText("0");

        greenVal = (TextView)findViewById(R.id.greenVal);
        greenVal.setText("0");

        blueVal = (TextView)findViewById(R.id.blueVal);
        blueVal.setText("0");

        //create seek bar objects and set their listeners
        seekBarRed = findViewById(R.id.seekBarRed);
        seekBarRed.setOnSeekBarChangeListener(this);

        seekBarGreen = findViewById(R.id.seekBarGreen);
        seekBarGreen.setOnSeekBarChangeListener(this);

        seekBarBlue = findViewById(R.id.seekBarBlue);
        seekBarBlue.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(seekBar == seekBarRed) {
            redVal.setText("" + progress);
        }

        if(seekBar == seekBarGreen) {
            greenVal.setText("" + progress);
        }

        if(seekBar == seekBarBlue) {
            blueVal.setText("" + progress);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //unused
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //unused
    }
}
