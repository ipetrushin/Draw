package com.example.it.draw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

public class MyDraw extends View
{
    float x = 100, y = 100; // координаты центра круга
    Random rnd = new Random();
    public MyDraw(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
        canvas.drawColor((int) 4279308561L);
        canvas.drawCircle(x, y, 100 + rnd.nextInt(50), paint);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = event.getX();
        y = event.getY();

        invalidate();
        return true;
    }

}

