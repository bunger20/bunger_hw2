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
