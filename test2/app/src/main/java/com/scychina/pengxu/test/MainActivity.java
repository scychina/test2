package com.scychina.pengxu.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;


public class MainActivity extends Activity {
    RadioButton rd1;
    RadioButton rd2;
    RadioButton rd3;
    RadioGroup rg;
    String name="";
    SeekBar seekBar;
    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setContentView(new Myview(this));
        rd1 = (RadioButton) findViewById(R.id.android_select1);
        rd2 = (RadioButton) findViewById(R.id.android_select2);
        rd3 = (RadioButton) findViewById(R.id.android_select3);
        rg = (RadioGroup) findViewById(R.id.select_group);
//        scychina

        rg.setOnCheckedChangeListener(new CheckedChangeListener());


        seekBar= (SeekBar)  findViewById(R.id.seek_bar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                showTip("滚动条当前进度："+progress+"%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                showTip("进度条开始滑动");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                showTip("进度条停止滑动");
            }
        });

    }
    public class CheckedChangeListener implements  RadioGroup.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (group == rg) {

                if (checkedId==rd1.getId()){
                    name=rd1.getText().toString();
                }
                if (checkedId==rd2.getId()){
                    name=rd2.getText().toString();
                }
                if (checkedId==rd3.getId()){
                    name=rd3.getText().toString();
                }
                showTip( "您现在选择的是：" + name);


            }
        }


    }


    private void showTip(String showText) {
        Toast.makeText(MainActivity.this, showText,Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
