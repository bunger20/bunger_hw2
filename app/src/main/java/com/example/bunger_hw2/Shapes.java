/**
 * @author: Sarah Bunger
 */

package com.example.bunger_hw2;

import android.content.Context;
import android.view.SurfaceView;
import android.graphics.Canvas;
import android.util.AttributeSet;

import java.util.ArrayList;

/**
 * <!-- class Shapes -->
 *
 * This class defines the series of CustomElements that make up a drawing.
 *
 * @author Sarah Bunger
 * @version 20 Feb 2019
 *
 */
public class Shapes extends SurfaceView {

    ArrayList<CustomElement> picture;

    /**
     * Constructor for Shapes objects.
     */
    public Shapes(Context context) {

        super(context);
        init();
    }

    /**
     * Constructor for Shapes objects.
     */
    public Shapes(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * Constructor for Shapes objects.
     */
    public Shapes(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    /**
     * A helper method for use in the constructors that creates the six shapes as well as the array the will be in.
     */
    private void init() {

        setWillNotDraw(false);

        picture = new ArrayList<CustomElement>();

        CustomRect background = new CustomRect("background", 0xFF0000FF, 0, 0, 2000, 2000);
        picture.add(background);

        CustomCircle face = new CustomCircle("face", 0xFFFFA500, 625, 450, 425);
        picture.add(face);

        CustomCircle rightEye = new CustomCircle("right eye", 0xFF008080, 775, 325, 50);
        picture.add(rightEye);

        CustomCircle leftEye = new CustomCircle("left eye", 0xFF008080, 500, 325, 50);
        picture.add(leftEye);

        CustomCircle mouth = new CustomCircle("mouth", 0xFFFF0000, 625, 650, 100);
        picture.add(mouth);

        CustomRect nose = new CustomRect("nose", 0xFFFF00FF, 630, 375, 675, 450);
        picture.add(nose);
    }

    /**
     * Overrides SurfaceView's onDraw method, drawing each element in the array of CustomElement objects.
     * @param: Canvas  The Canvas object to draw on.
     */
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(0xFFFFFFFF);

        for(CustomElement i : picture){

            i.drawMe(canvas);
        }

    }

    /**
     *
     * @param: x  The x coordinate to use to check if there's an official shape there.
     * @param: y  The y coordinate to use to check if there's an official shape there.
     *
     * @return: touched  Returns the CustomElement object that contains the point with  coordinates passed into function.
     */
    public CustomElement findElement(int x, int y){
        ArrayList<CustomElement> checkList = new ArrayList<CustomElement>();

        for(CustomElement i : picture){
            if(i.containsPoint(x,y)){
                checkList.add(i);
            }
        }

        CustomElement touched = null;
        for(CustomElement i : checkList){
            if(i.containsPoint(x,y)){
                touched = i;
            }
        }

        return touched;
    }

}
