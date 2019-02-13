package com.example.bunger_hw2;

import android.content.Context;
import android.view.SurfaceView;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.graphics.Path;

public class Shapes extends SurfaceView {
    public Shapes(Context context) {
        super(context);
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
    }

    /**
     * External citation
     * Date: 12 Feb 2019
     * Problem: Wasn't sure how to use paths to make a different shape
     * Resource: https://kylewbanks.com/blog/drawing-triangles-rhombuses-and-other-shapes-on-android-canvas
     * Solution: I used the sample code from the post
     */
    public void triangle(Canvas canvas, Paint paint, int x, int y, int width) {
        int halfWidth = width / 2;

        Path path = new Path();
        path.moveTo(x, y - halfWidth); // Top
        path.lineTo(x - halfWidth, y + halfWidth); // Bottom left
        path.lineTo(x + halfWidth, y + halfWidth); // Bottom right
        path.lineTo(x, y - halfWidth); // Back to Top
        path.close();

        canvas.drawPath(path, paint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(0xFFFFFFFF);

        //paint colors
        Paint purplePaint = new Paint();
        purplePaint.setColor(0xFF6C3483);

        Paint greenPaint = new Paint();
        greenPaint.setColor(0xFF005900);

        Paint orange = new Paint();
        orange.setColor(0XFFFFA500);

        Paint blue = new Paint();
        blue.setColor(0XFF3FE0D0);

        Paint red = new Paint();
        red.setColor(0XFFFF0000);

        //drawing of the six shapes
        canvas.drawCircle(1100.0f, 100.0f, 100.0f, purplePaint);

        canvas.drawRect(500.0f, 500.0f, 1000.0f, 1000.0f, greenPaint);

        canvas.drawRect(400, 400, 70, 70, purplePaint);

        orange.setStyle(Paint.Style.STROKE);
        orange.setStrokeWidth(30.0f);
        canvas.drawCircle(440, 480, 40, orange);

        triangle(canvas, blue, 500, 165, 125);

        triangle(canvas, red, 100, 900, 125);


    }



}
