package com.example.bunger_hw2;

import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import static android.graphics.Color.red;
import static android.graphics.Color.green;
import static android.graphics.Color.blue;
import static android.graphics.Color.rgb;

/**
 * <!-- class Controller -->
 *
 * This class handles all of the event listeners and communicates with the view and model.
 *
 * @author Sarah Bunger
 * @version 20 Feb 2019
 *
 */
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

    /**
     * Constructor for Controller objects.
     *
     * @param: display  The object on which the image will be drawn on.
     * @param: barRed  The seekBar that controls the red part of color.
     * @param: barGreen  The seekBar that controls the green part of color.
     * @param: barBlue  The seekBar that controls the blue part of color.
     * @param: selected  The TextView that indicates the currently selected shape.
     * @param: rVal  The TextView that indicates the current value of the red seekBar.
     * @param: gVal  The TextView that indicates the current value of the green seekBar.
     * @param: bVal  The TextView that indicates the current value of the blue seekBar.
     */
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

    /**
     * Overrides the SurfaceView class' onProgressChanged, changing one of the three color-coded
     * seekBars based on which was touched.
     *
     * @param: seekBar  The seekBar whose progress changed.
     * @param: progress  Where the indicator ended up on the
     * @param: fromUser  Indicates if change was from user or not.
     */
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

    /**
     * Overrides the SurfaceView class' onTouch method, changing the seekBars to the RGB colors of the
     * selected element, also changing the name of the shape displayed accordingly.
     *
     * @param: v  The View object that experienced the touch.
     * @param: event  The type of event (swipe, pinch, tap, etc.).
     */
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
