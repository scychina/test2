package com.scychina.pengxu.test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by pengxu on 15-2-27.
 */
public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback2 {
    private SurfaceHolder surfaceHolder;
    private Paint paint;
    private float x = 150;
    private float y = 150;
    private Thread thread;
    private boolean flag;///判断线程是否结束

    public MySurfaceView(Context context) {
        super(context);
        surfaceHolder = this.getHolder();
        surfaceHolder.addCallback(this);
        flag = true;
        paint = new Paint();
        paint.setColor(Color.RED);



    }

    /**
     * 游戏业务逻辑
     */
    private void logic() {

    }

    Runnable r = new Runnable() {
        @Override
        public void run() {
            int i = 1;
            while (flag) {
                if (i == 200) {
                    flag = false;
                    break;
                }
                drawGame();
//                logic();
                try {
                    Thread.sleep(1000);
                    i=i+20;
                    x=x+i;
                    y=y+i;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    };


    @Override
    public void surfaceRedrawNeeded(SurfaceHolder holder) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = event.getX();
        y = event.getY();
        return true;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new Thread(r);
        thread.start();
    }

    private void drawGame() {
        Canvas canvas = surfaceHolder.lockCanvas();

        try {
//        canvas.drawColor(Color.BLACK);
            if (canvas != null) {
                canvas.drawRGB(0, 0, 0);
                paint.setTextSize(35);

                canvas.drawText("Game", x, y, paint);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (canvas!=null)
                surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        flag = false;
    }
}
