package com.scychina.demos;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class BaseAdapterListViewActivity extends ActionBarActivity {

    private ListAdapter adapter = null;
    private List<Video> videoList = null;
    private ListView listView = null;
    private EditText editText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter_list_view);
        listView = (ListView) findViewById(R.id.baseAdapterListView);
        editText = (EditText) findViewById(R.id.editText1);
        getAllVideo();
        setListViewByMyAdapter();

    }

    private void setListViewByMyAdapter() {


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_base_adapter_list_view, menu);
        return true;
    }

    public List<Video> getAllVideo() {
        List<Video> lists = new ArrayList<Video>();
        lists.add(new Video("变形金刚2", "2015-3-5", R.drawable.book, "12", 20));
        lists.add(new Video("速度与激情7", "2015-4-12", R.drawable.youtube, "12", 20));
        lists.add(new Video("天下第一", "2015-3-15", R.drawable.boom, "12", 20));
        lists.add(new Video("警察故事", "2015-3-36", R.drawable.bag, "12", 20));
        lists.add(new Video("死神来了7", "2015-3-9", R.drawable.tv, "12", 20));
        return lists;
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
