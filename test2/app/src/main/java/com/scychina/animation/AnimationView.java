package com.scychina.animation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.scychina.pengxu.test.R;

/**
 * Created by pengxu on 15-2-28.
 */
public class AnimationView extends SurfaceView implements SurfaceHolder.Callback2 {
    private SurfaceHolder surfaceHolder;
    private Paint paint;

    public AnimationView(Context context){
       super(context);
        surfaceHolder=this.getHolder();
        surfaceHolder.addCallback(this);
        paint=new Paint();
        paint.setColor(Color.RED);
    }


    @Override
    public void surfaceRedrawNeeded(SurfaceHolder holder) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        drawAnimation();
    }

    private void drawAnimation() {
        Canvas canvas=surfaceHolder.lockCanvas();
        try {
            if (canvas!=null){
                canvas.drawRGB(0,0,0);
                paint.setTextSize(35);
                Bitmap bitmap= BitmapFactory.decodeResource(this.getResources(), R.drawable.a1);
                Matrix matrix=new Matrix();//这个是针对单个位图的所以不需要save和restore
               canvas.drawBitmap(bitmap,0,0,paint);

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
