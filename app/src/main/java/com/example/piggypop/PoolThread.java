package com.example.piggypop;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import java.util.Random;

public class PoolThread extends Thread{
    boolean running = true;
    SurfaceHolder holder;
    static float x = 200;
    static float y = 300;
    int w,h;

    public PoolThread(SurfaceHolder holder, int w, int h){
        this.holder = holder;
        this.w = w;
        this.h = h;
    }

    public void setRunning(boolean running){
        this.running = running;
    }

    public void run(){
        Canvas canvas = null;
        Paint backPaint = new Paint();
        backPaint.setColor(Color.GREEN);
        Paint forePaint = new Paint();
        forePaint.setColor(Color.WHITE);
        Paint borPaint = new Paint();
        borPaint.setColor(Color.BLACK);
        borPaint.setStyle(Paint.Style.STROKE);


        Random rand = new Random();
        long previousTime = System.currentTimeMillis();
        while(running){
            try{
                canvas = holder.lockCanvas(null);
                synchronized (holder){
                    long currentTime = System.currentTimeMillis();
                    double elapsedTime= currentTime - previousTime;
                    if(elapsedTime > 500){
                        previousTime = currentTime;
                        x = rand.nextInt(w);
                        y = rand.nextInt(h);
                        if(x == w-1){
                            x = -x;
                        }else if(y == h-1) {
                            y = -y;
                        }
                    }
                    canvas.drawRect(0,0,w,h,backPaint);
                    canvas.drawRect(0,0,w-1,h-1,borPaint);
                    canvas.drawCircle(x,y,40,forePaint);
                    Paint paint = new Paint();
                    paint.setStyle(Paint.Style.FILL_AND_STROKE);
                    paint.setColor(Color.MAGENTA);
                    canvas.drawCircle(x, y, 80, paint);
                    paint.setColor(Color.BLACK);
                    canvas.drawCircle(x - 10, y+35, 5, paint);
                    canvas.drawCircle(x + 10, y+35, 5, paint);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setColor(Color.BLACK);
                    canvas.drawCircle(x,y+35,25,paint);
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(Color.BLACK);
                    canvas.drawCircle(x+ 35, y, 10, paint);
                    canvas.drawCircle(x-35,y,10,paint);
                    float[] vertsL = {x-60,y-50,x-50,y-100, x-20,y-50};
                    float[] vertsR = {x+60,y-50,x+50,y-100, x+20,y-50};
                    int[] verticesColors ={Color.MAGENTA,Color.BLACK,Color.MAGENTA,Color.BLACK,Color.BLACK,Color.BLACK};
                    canvas.drawVertices(Canvas.VertexMode.TRIANGLES,vertsL.length, vertsL, 0, null,0, verticesColors,0, null,0,0, paint);
                    canvas.drawVertices(Canvas.VertexMode.TRIANGLES,vertsR.length, vertsR, 0, null,0, verticesColors,0, null,0,0, paint);
                }
            } finally{
                if(canvas != null){
                    holder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }

}
