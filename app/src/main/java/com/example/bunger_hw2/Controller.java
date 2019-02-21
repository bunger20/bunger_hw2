package com.example.bunger_hw2;

import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import static android.graphics.Color.red;
import static android.graphics.Color.green;
import static android.graphics.Color.blue;
import static android.graphics.Color.rgb;

public class Controller implements SeekBar.OnSeekBarChangeListener, View.OnTouchListener{

    private TextView redVal;
    private TextView greenVal;
    private TextView blueVal;
    private TextView selection;

    private SeekBar seekBarRed;
    private SeekBar seekBarGreen;
    private SeekBar seekBarBlue;

    private Shapes picture;

    private CustomElement element = null;

    int red;
    int green;
    int blue;

    public Controller(Shapes display, SeekBar barRed, SeekBar barGreen, SeekBar barBlue,
        TextView selected, TextView rVal, TextView gVal, TextView bVal){

        //setting each instance var to the params coming in
        picture = display;
        seekBarRed = barRed;
        seekBarBlue = barBlue;
        seekBarGreen = barGreen;
        selection = selected;
        redVal = rVal;
        greenVal = gVal;
        blueVal = bVal;

        //set the listeners for each
        picture.setOnTouchListener(this);
        seekBarRed.setOnSeekBarChangeListener(this);
        seekBarGreen.setOnSeekBarChangeListener(this);
        seekBarBlue.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(element != null){
            if(fromUser == true){
                if(seekBar == seekBarRed) {
                    red = progress;
                    element.setColor(rgb(red, green, blue));
                    redVal.setText("" + progress);
                }

                if(seekBar == seekBarGreen) {
                    green = progress;
                    element.setColor(rgb(red, green, blue));
                    greenVal.setText("" + progress);
                }

                if(seekBar == seekBarBlue) {
                    blue = progress;
                    element.setColor(rgb(red, green, blue));
                    blueVal.setText("" + progress);
                }

                //forcing redraw with new colors
                picture.invalidate();
            }
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


    @Override
    public boolean onTouch(View v, MotionEvent event) {

        int xTouch = (int) event.getX();
        int yTouch = (int) event.getY();


        //determining if touch was where an element is
        element = picture.findElement(xTouch, yTouch);

        //handling the case when no element is selected
        if(element == null){
            selection.setText("None");
            return false;
        }

        //get the color of each element
        red = red(element.getColor());
        green = green(element.getColor());
        blue = blue(element.getColor());

        //updating the value of each seek bar and its corresponding text to match the rgb
        //values of the shape
        selection.setText(element.getName());

        redVal.setText(""+ red);
        seekBarRed.setProgress(red);

        greenVal.setText(""+ green);
        seekBarGreen.setProgress(green);

        blueVal.setText(""+ blue);
        seekBarBlue.setProgress(blue);

        return true;

    }
}
