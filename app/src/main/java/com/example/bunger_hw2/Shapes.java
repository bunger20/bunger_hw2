package com.example.bunger_hw2;

import android.content.Context;
import android.view.SurfaceView;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

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



    }
}
