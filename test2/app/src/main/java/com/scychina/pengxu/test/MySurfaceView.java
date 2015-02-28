package com.scychina.pengxu.test;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
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
    public void surfaceCreated(SurfaceHolder holder) {
//        thread = new Thread(r);
//        thread.start();
        drawGame();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = event.getX();
        y = event.getY();
        return true;
    }

    private void drawGame() {
        Canvas canvas = surfaceHolder.lockCanvas();

        try {
//        canvas.drawColor(Color.BLACK);
            if (canvas != null) {
                canvas.drawRGB(0, 0, 0);
                paint.setTextSize(35);



                Bitmap bitmap= BitmapFactory.decodeResource(this.getResources(),R.drawable.a1);
                Matrix matrix=new Matrix();//这个是针对单个位图的所以不需要save和restore
//                matrix.postRotate(30,bitmap.getWidth()/2,bitmap.getHeight()/2);
//                matrix.postTranslate(300,300);
                canvas.save();//保存当前状态  save和restore对位图旋转，位移，拉伸都要使用这个2个方法防止对其他的有影响
//                canvas.rotate(30, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
//                canvas.translate(300,300);
//                canvas.clipRect(0,0,20,20);
//                canvas.drawPoint(50,30,paint);
                Path path=new Path();
                path.addCircle(30,30,60, Path.Direction.CCW);
                canvas.clipPath(path);

                canvas.drawBitmap(bitmap, 0, 0, paint);
                canvas.restore();//返回到之前保存的状态
//                canvas.drawBitmap(bitmap, 0, 0, paint);
//                canvas.drawText("Game", x, y, paint);
//                canvas.drawRect(12,12,12,12,paint);
//                canvas.drawCircle(60,60,10,paint);

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
