package com.scychina.demos;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ListViewActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {


    final String[] studentName = new String[]{"小强", "小名", "小孙"};


    public ArrayList<HashMap<String, String>> getStudentNames() {
        final ArrayList<HashMap<String, String>> studentName2 = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("1", "小花");
        map.put("2", "肖剑");
        map.put("3", "一眉道长");
        studentName2.add(map);
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
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.student_item, getStudentNames());
        listView.setAdapter(arrayAdapter);
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
        Toast.makeText(this, "这个学生的名字：" + getStudentNames().get(position), Toast.LENGTH_SHORT).show();
        Log.i("TAG", "这个学生的名字：" + getStudentNames().get(position));
    }
}
