package com.example.bunger_hw2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{

    TextView redVal = null;
    SeekBar seekBarRed = null;
    SeekBar seekBarGreen = null;
    SeekBar seekBarBlue= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redVal = (TextView)findViewById(R.id.redVal);
        redVal.setText("0");

        seekBarRed = findViewById(R.id.seekBarRed);
        seekBarRed.setOnSeekBarChangeListener(this);

        seekBarGreen = findViewById(R.id.seekBarGreen);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int redProgress, boolean fromUser) {
        //if(seekBar == seekBarRed) {
            redVal.setText("" + redProgress);
        //}
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
