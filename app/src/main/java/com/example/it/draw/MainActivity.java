package com.example.it.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.concurrent.TimeUnit;



public class MainActivity extends AppCompatActivity {

    MyDraw draw;
    boolean Interferes (int x1, int y1, double r1, int x2, int y2, double r2)
    {
        return false;
        // возвращает true, если круги с заданными координатами пересекаются
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        draw = (MyDraw) findViewById(R.id.view);
        draw.invalidate();
        draw.angle += 1;


        //setContentView(new MyDraw(this));
        //setContentView(new Card(this, 100, 100, Color.RED, 1, 3, true));

        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
    }

    public void onClick(View v)
    {
      MyTask mt = new MyTask();  mt.execute(); }

    class MyTask extends AsyncTask<Void, Void, Void>
    {
        int seconds = 0;
        @Override
        protected Void doInBackground(Void... params) {
            seconds = 0; // добавить задержку
            while (seconds < 1000) {
                // ждем 1 секунду
                try {
                    TimeUnit.MILLISECONDS.sleep(20);
                } catch (InterruptedException e) {}
                seconds++;
                publishProgress(); // вызов этой функции обеспечит вызом onProgressUpdate
            }
            return null;
        }
        protected void onProgressUpdate(Void... progress)
        {
            draw.x += 10;
            draw.earth.angle += .05;
            draw.moon.angle += 0.05*Math.PI;
            draw.moon.color = Color.RED;
            draw.shots.add(new Point(draw.moon));
            //moon = new Planet(6, 50, 0, moon.angle, Color.GRAY, earth);
            Log.d("my", "size = " + draw.shots.size());
            draw.invalidate();
        }

    }
}

