package com.example.bunger_hw2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceView;
import android.content.Context;

public class Shapes extends SurfaceView {

    public Shapes(Context context) {
        super(context);
        init();
    }

    private void init() {
        setWillNotDraw(false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(0xFFFFFFFF);

        Paint purplePaint = new Paint();
        purplePaint.setColor(0xFF6C3483);
        purplePaint.setStyle(Paint.Style.STROKE);
        purplePaint.setStrokeWidth(5.0f);
        canvas.drawCircle(100.0f, 100.0f, 100.0f, purplePaint);

        Paint greenPaint = new Paint();
        greenPaint.setColor(0xFF005900);
        canvas.drawRect(500.0f, 500.0f, 1000.0f, 1000.0f, greenPaint);

        //drawRoundRect(50, 100, 150, 200, 75, 25, greenPaint);

    }
}
