package com.scychina.demos;

import android.app.ActionBar;
import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;


public class ActionBarActivityTest extends ActionBarActivity implements MenuItem.OnMenuItemClickListener {
    ActionBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_activity_test);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
        MenuItem add = menu.add(0, 1, 0, "添加");
        MenuItem delete = menu.add(0, 2, 1, "删除");
        MenuItem open = menu.add(0, 2, 2, "打开");
        MenuItem close = menu.add(0, 2, 3, "关闭");
        add.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        delete.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        open.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        close.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
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

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return true;
    }
}
