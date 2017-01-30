package com.example.it.draw;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Sun extends Planet {
    float x, y;
    Sun(float radius, int color, float x, float y){
        super(radius, 0, 0, 0, color, null);
        this.x = x;
        this.y = y;
    }
    float getX() { return x; }; // возвращает текущее значение координаты X на канве
    float getY() { return y; }; // возвращает текущее значение координаты Y на канве
    void setX(float x) { this.x = x ;}
    void setY(float y) { this.y = y ;}
    public void Draw(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setColor(Color.YELLOW);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(2);

        canvas.drawColor(Color.TRANSPARENT);
        canvas.drawCircle(x, y, radius, paint);
    }
}
