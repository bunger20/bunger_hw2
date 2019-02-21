/**
 * @author: Sarah Bunger
 */

package com.example.bunger_hw2;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.graphics.Path;
import android.view.View;

import java.util.ArrayList;

public class Shapes extends SurfaceView {

    ArrayList<CustomElement> picture;

    public Shapes(Context context) {

        super(context);
        init();
    }

    public Shapes(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Shapes(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        setWillNotDraw(false);

        picture = new ArrayList<CustomElement>();

        CustomCircle orangeCircle = new CustomCircle("orange circle", 0xFFFFA500, 50, 50, 50);
        picture.add(orangeCircle);

        CustomCircle redCircle = new CustomCircle("red circle", 0xFFFF0000, 500, 500, 150);
        picture.add(redCircle);

        CustomCircle tealCircle = new CustomCircle("teal circle", 0xFF008080, 50, 500, 90);
        picture.add(tealCircle);

        CustomRect greenRect = new CustomRect("green rect", 0xFF00FF00, 200, 200, 250, 250);
        picture.add(greenRect);

        CustomRect blueRect = new CustomRect("blue rect", 0xFF0000FF, 300, 175, 350, 175);
        picture.add(blueRect);

        CustomRect purpleRect = new CustomRect("purple rect", 0xFFFF00FF, 400, 375, 450, 425);
        picture.add(purpleRect);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(0xFFFFFFFF);

        for(CustomElement i : picture){

            i.drawMe(canvas);
        }

    }

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
