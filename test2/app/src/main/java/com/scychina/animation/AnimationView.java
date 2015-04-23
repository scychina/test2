package com.scychina.animation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import com.scychina.pengxu.test.R;

/**
 * Created by pengxu on 15-2-28.
 */
public class AnimationView extends SurfaceView implements SurfaceHolder.Callback2 {
    private SurfaceHolder surfaceHolder;
    private Paint paint;
    private AlphaAnimation mAlphaAnimation;
    private ScaleAnimation mScaleAnimation;
    private TranslateAnimation mTranslateAnimation;
    private RotateAnimation mRotateAnimation;


    public AnimationView(Context context) {
        super(context);
        surfaceHolder = this.getHolder();
        surfaceHolder.addCallback(this);
        paint = new Paint();
        paint.setColor(Color.RED);
    }


    @Override
    public void surfaceRedrawNeeded(SurfaceHolder holder) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (canvas != null) {
            canvas.drawRGB(0, 0, 0);
            paint.setTextSize(35);
            Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.a1);
            canvas.drawBitmap(bitmap, 500, 500, paint);
        }
        if (canvas != null)
            surfaceHolder.unlockCanvasAndPost(canvas);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == event.KEYCODE_DPAD_UP) {
            mAlphaAnimation = new AlphaAnimation(0.1f, 1f);
            mAlphaAnimation.setDuration(5000);
            this.startAnimation(mAlphaAnimation);
        } else if (keyCode == event.KEYCODE_DPAD_DOWN) {
            mScaleAnimation = new ScaleAnimation(0f, 2f, 1.5f, 1.5f, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0f);
            mScaleAnimation.setDuration(3000);
            this.startAnimation(mScaleAnimation);
        } else if (keyCode == event.KEYCODE_DPAD_LEFT) {
            mTranslateAnimation = new TranslateAnimation(0, 100, 0, 100);
            mTranslateAnimation.setDuration(5000);
            this.startAnimation(mTranslateAnimation);
        } else if (keyCode == event.KEYCODE_DPAD_RIGHT) {
            mRotateAnimation = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            mRotateAnimation.setDuration(5000);
            this.startAnimation(mRotateAnimation);
        }
        return super.onKeyDown(keyCode, event);

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
