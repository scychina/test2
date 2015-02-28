package com.scychina.animation;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;

/**
 * Created by pengxu on 15-2-28.
 */
public class AnimationView extends View implements SurfaceHolder.Callback2 {

    public AnimationView(Context context){
       super(context);
    }
    @Override
    public void surfaceRedrawNeeded(SurfaceHolder holder) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
