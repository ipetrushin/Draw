package com.example.it.draw;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

class Planet {
    float radius, distance, angle, avelocity;
    int color;
    Planet parent; // относительно какого объекта вращается
    Planet(float radius, float distance, float avelocity, float angle, int color, Planet parent)
    {
        this.radius = radius;
        this.distance = distance;
        this.avelocity =avelocity;
        this.angle =angle;
        this.color =color;
        this.parent = parent;
    }
    public void Draw(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawCircle(getX(), getY(), radius, paint);
    }
    // нужно реализовать методы
    float getX() {
        return  parent.getX() + (float)(distance*Math.cos(angle));
    }; // возвращает текущее значение координаты X на канве
    float getY(){

        return  parent.getY() + (float)(distance*Math.sin(angle));
    }; // возвращает текущее значение координаты Y на канве
}