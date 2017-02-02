package com.example.it.draw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

public class MyDraw extends View
{


    Sun sun = new Sun(100, Color.YELLOW, 200, 200/2);
    Planet earth =  new Planet(20, 300, 2, 0, Color.GREEN, sun);
    Planet moon = new Planet(6, 70, 2, 0, Color.GRAY, earth);
    ArrayList<Point> shots = new ArrayList<>();
    ArrayList<Bubble> bubbles = new ArrayList<>();

    float x = 0, y = 0; // координаты центра круга
    float angle = getMeasuredHeight();
    Random rnd = new Random();
    public MyDraw(Context context, AttributeSet attributeSet)
    {
        super(context, attributeSet);
        for (int i = 0; i < 100; i++) {
            bubbles.add(new Bubble());
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        //canvas.drawColor(Color.GRAY);
        //sun = new Sun(200, Color.YELLOW, canvas.getWidth()/2, canvas.getHeight()/2);
        Paint p = new Paint();
        Random r = new Random();
        canvas.drawColor(Color.rgb(0,0,100));

        //canvas.drawCircle(r.nextFloat()*canvas.getWidth(),r.nextFloat()*canvas.getHeight(), 50, p);
        /*
        sun.Draw(canvas);
        earth.Draw(canvas);
        moon.Draw(canvas);
        Log.d("my", "size = " + shots.size());
        */
        float center_x = canvas.getWidth()/2;
        float center_y = canvas.getHeight()/2;

        p.setColor(Color.WHITE);
        for (Bubble b : bubbles)
        {
            canvas.drawCircle(b.getX()+ center_x, b.getY() + center_y, 5, p);
        }

    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = event.getX();
        y = event.getY();
        sun.setX(x); sun.setY(y);

        invalidate();
        return true;
    }


}

