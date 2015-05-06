package com.scychina.demos;

import android.app.ActionBar;
import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;


public class ActionBarActivityTest extends ActionBarActivity implements MenuItem.OnMenuItemClickListener {
    ActionBar bar;
    MenuItem add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_activity_test);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);

        add = menu.add(Menu.NONE, Menu.FIRST, 0, "添加");
        add.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Log.i("Menu", "you click add menuItem");
                return true;
            }
        });
        add.setIcon(R.drawable.bag);
        add.setChecked(false);
//        add.setEnabled(false);
        MenuItem delete = menu.add(Menu.NONE, Menu.FIRST + 1, 1, "删除");
        delete.setIcon(R.drawable.book);
        MenuItem open = menu.add(Menu.NONE, Menu.FIRST + 2, 2, "打开");
        open.setIcon(R.drawable.boom);
        MenuItem close = menu.add(Menu.NONE, Menu.FIRST + 3, 3, "关闭");
        close.setIcon(R.drawable.logo);
        add.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
        delete.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
        open.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
        close.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
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
        switch (menuItem.getItemId()) {
            case Menu.FIRST + 1:
                Log.i("MenuItem", "you click delete menuItem");
                break;
            case Menu.FIRST + 2:
                Log.i("MenuItem", "you click open menuItem");
                break;
            case Menu.FIRST + 3:
                Log.i("MenuItem", "you click close menuItem");
                break;
        }
        return true;
    }
}
