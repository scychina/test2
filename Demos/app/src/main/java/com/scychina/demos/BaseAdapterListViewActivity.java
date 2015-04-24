package com.scychina.demos;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class BaseAdapterListViewActivity extends ActionBarActivity {

    private ListAdapter adapter = null;
    private List<Video> videoList = null;
    private List<Video> realList = null;
    private ListView listView = null;
    private EditText editText = null;
    private Button editButton = null;
    private static Integer selectLine = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter_list_view);
        listView = (ListView) findViewById(R.id.baseAdapterListView);
        editText = (EditText) findViewById(R.id.editText1);
        editButton = (Button) findViewById(R.id.editTextButton1);
        getAllVideo();
        setListViewByMyAdapter();
        initailListViewListener();

    }

    //    public void refreshAllData(View view){
//        videoList2=getAllVideo();
//        adapter=new MyAdapter(this,videoList2);
//        listView.setAdapter(adapter);
//        //数据元变化了 就用notifyDataSetInvalidated   换了数据元使用
//        ((BaseAdapter)adapter).notifyDataSetInvalidated();
//
//    }
    public void refreshAllData(View view) {
        List<Video> tempVideoList = getAllVideo();
        for (int i = 0; i < realList.size(); i++) {
            realList.get(i).filmName = tempVideoList.get(i).filmName;
        }
        //数据元变化了 就用notifyDataSetInvalidated   换了数据元使用
        //notifyDataSetChanged必须对本身的数据元进行恢复，要修改数据元里面的数据，而不是对数据元进行替换。（替换数据元可以是用notifyDataSetInvalidated）
        ((BaseAdapter) adapter).notifyDataSetChanged();

    }

    public void editLineData(View view) {
        String newName = editText.getText().toString();
        if (selectLine != null) {
            videoList.get(selectLine).filmName = newName;
            ((BaseAdapter) adapter).notifyDataSetChanged();
        } else {
            Toast.makeText(this, "选择要修改的行", Toast.LENGTH_SHORT).show();
        }
        Log.i("buttonClick", "true");
    }

    private void initailListViewListener() {

        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("activty内setOnItemSelectedListener单击的。。。电影名称为：", videoList.get(i).filmName);
                Toast.makeText(getApplicationContext(), "activty内setOnItemSelectedListener单击的。。。电影名称为：" + videoList.get(i).filmName, Toast.LENGTH_SHORT);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("activty内单击的。。。电影名称为：", videoList.get(i).filmName);
                Toast.makeText(getApplicationContext(), "activty内单击的。。。电影名称为：" + videoList.get(i).filmName, Toast.LENGTH_SHORT);

                selectLine = i;
            }
        });
    }

    private void setListViewByMyAdapter() {
        //this  可以作为context
        realList = getAllVideo();
        adapter = new MyAdapter(this, realList);
        listView.setAdapter(adapter);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_base_adapter_list_view, menu);
        return true;
    }

    public List<Video> getAllVideo() {
        videoList = new ArrayList<Video>();
        videoList.add(new Video("变形金刚2", "2015-3-5", R.drawable.book, "12", 20));
        videoList.add(new Video("速度与激情7", "2015-4-12", R.drawable.youtube, "12", 20));
        videoList.add(new Video("天下第一", "2015-3-15", R.drawable.boom, "12", 20));
        videoList.add(new Video("警察故事", "2015-3-36", R.drawable.bag, "12", 20));
        videoList.add(new Video("死神来了7", "2015-3-9", R.drawable.tv, "12", 20));
        return videoList;
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
