package com.scychina.demos;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class ListViewActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {



    private String[] titleArray = {"姓名", "性别", "年龄", "居住地", "邮箱"};
    private String[] contentArray = {"scy", "男", "22", "连云港", "222225000"};

    final ArrayList<HashMap<String, Object>> studentName2 = new ArrayList<HashMap<String, Object>>();

    public ArrayList<HashMap<String, Object>> getStudentNames() {
        for (int i = 0; i < titleArray.length; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("logo", R.drawable.logo);
            map.put("title", titleArray[i]);
            map.put("text", contentArray[i]);
            studentName2.add(map);
        }
        return studentName2;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        setView();
        //test
    }

    private void setView() {
        android.widget.ListView listView = (android.widget.ListView) findViewById(R.id.listView1);
//        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.student_item, getStudentNames());
        //listView.setAdapter(arrayAdapter);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, getStudentNames(), R.layout.student_item, new String[]{"logo", "title", "text"}, new int[]{R.id.imageView1, R.id.textview1, R.id.textview2});
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_view, menu);
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
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Toast.makeText(this, titleArray[position] + "：" + contentArray[position], Toast.LENGTH_SHORT).show();
        Log.i("TAG", titleArray[position] + "：" + contentArray[position]);
    }
}
