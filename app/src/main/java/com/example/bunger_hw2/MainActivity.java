/**
 * @author: Sarah Bunger
 */

package com.example.bunger_hw2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //initialize the text views for the RGB values
        TextView redVal = (TextView)findViewById(R.id.redVal);
        //redVal.setText("0");

        TextView greenVal = (TextView)findViewById(R.id.greenVal);
        //greenVal.setText("0");

        TextView blueVal = (TextView)findViewById(R.id.blueVal);
        //blueVal.setText("0");

        TextView selected = findViewById(R.id.currentShape);

        SeekBar seekBarRed = findViewById(R.id.seekBarRed);
        SeekBar seekBarGreen = findViewById(R.id.seekBarGreen);
        SeekBar seekBarBlue = findViewById(R.id.seekBarBlue);

        Shapes display = findViewById(R.id.surfaceView);

        controller = new Controller(display, seekBarRed, seekBarGreen, seekBarBlue, selected, redVal, greenVal, blueVal);

    }

}
