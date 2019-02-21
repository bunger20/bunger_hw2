/**
 * @author: Sarah Bunger
 */

package com.example.bunger_hw2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * <!-- class MainActivity -->
 *
 * This class defines the app itself.
 *
 * @author Sarah Bunger
 * @version 20 Feb 2019
 *
 */
public class MainActivity extends AppCompatActivity {

    Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //initialize the text views for the RGB values
        TextView redVal = (TextView)findViewById(R.id.redVal);

        TextView greenVal = (TextView)findViewById(R.id.greenVal);

        TextView blueVal = (TextView)findViewById(R.id.blueVal);

        TextView selected = findViewById(R.id.currentShape);

        SeekBar seekBarRed = findViewById(R.id.seekBarRed);
        SeekBar seekBarGreen = findViewById(R.id.seekBarGreen);
        SeekBar seekBarBlue = findViewById(R.id.seekBarBlue);

        Shapes display = findViewById(R.id.surfaceView);

        controller = new Controller(display, seekBarRed, seekBarGreen, seekBarBlue, selected, redVal, greenVal, blueVal);

    }

}
