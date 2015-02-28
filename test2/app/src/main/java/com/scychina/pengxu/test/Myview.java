package com.scychina.pengxu.test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by pengxu on 15-2-27.
 */
public class Myview extends View {
    private float x=150;
    private float  y=150;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawText("testasdfasdfasdf",canvas);
        setFocusable(true);
    }

    private void drawText(String text,Canvas canvas) {
        Paint paint=new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(50);
        canvas.drawText(text,x,y,paint);
    }

    public Myview(Context context) {
        super(context);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_DPAD_UP){
            y-=2;
        }
        if (keyCode==KeyEvent.KEYCODE_DPAD_DOWN){
            y+=2;
        }
        if (keyCode==KeyEvent.KEYCODE_DPAD_LEFT){
            x-=2;
        }if (keyCode==KeyEvent.KEYCODE_DPAD_RIGHT){
            x+=2;
        }
//        invalidate();
        postInvalidate();
        return super.onKeyDown(keyCode, event);


    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return super.onKeyUp(keyCode, event);

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
      float _x=  event.getX();
        float _y=event.getY();
        if (event.getAction()==MotionEvent.ACTION_UP){
            x=_x;
            y=_y;
        } if (event.getAction()==MotionEvent.ACTION_MOVE){
            x=_x;
            y=_y;
        } if (event.getAction()==MotionEvent.ACTION_DOWN){
            x=_x;
            y=_y;
        }
        postInvalidate();
        return true;


    }
}
