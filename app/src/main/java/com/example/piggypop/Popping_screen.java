package com.example.piggypop;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.RequiresApi;

import java.util.Random;

public class Popping_screen extends View {
    float tx = 200;
    float ty = 300;
    static float x = 200;
    static float y = 300;
    int w,h;
    boolean running = true;
    public Popping_screen(Context context) { super(context); }
    public Popping_screen(Context context, AttributeSet attrs){ super(context,attrs); }
    public Popping_screen(Context context, AttributeSet attrs, int def){ super(context,attrs,def); }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        Paint backPaint = new Paint();
        backPaint.setColor(Color.GREEN);
        Paint forePaint = new Paint();
        forePaint.setColor(Color.WHITE);
        Paint borPaint = new Paint();
        borPaint.setColor(Color.BLACK);
        borPaint.setStyle(Paint.Style.STROKE);
        while(running){
            Random rand = new Random();
            long previousTime = System.currentTimeMillis();
            long currentTime = System.currentTimeMillis();
            double elapsedTime= currentTime - previousTime;
            if(elapsedTime > 500){
                x = rand.nextInt(w);
                y = rand.nextInt(h);
                if(x == w-1){
                    x = -x;
                }else if(y == h-1) {
                    y = -y;
                }
            }
        }

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.MAGENTA);
        canvas.drawCircle(tx, ty, 80, paint);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(tx - 10, ty+35, 5, paint);
        canvas.drawCircle(tx + 10, ty+35, 5, paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(tx,ty+35,25,paint);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(tx+ 35, ty, 10, paint);
        canvas.drawCircle(tx-35,ty,10,paint);
        float[] vertsL = {tx-60,ty-50,tx-50,ty-100, tx-20,ty-50};
        float[] vertsR = {tx+60,ty-50,tx+50,ty-100, tx+20,ty-50};
        int[] verticesColors ={Color.MAGENTA,Color.BLACK,Color.MAGENTA,Color.BLACK,Color.BLACK,Color.BLACK};
        canvas.drawVertices(Canvas.VertexMode.TRIANGLES,vertsL.length, vertsL, 0, null,0, verticesColors,0, null,0,0, paint);
        canvas.drawVertices(Canvas.VertexMode.TRIANGLES,vertsR.length, vertsR, 0, null,0, verticesColors,0, null,0,0, paint);

}}
