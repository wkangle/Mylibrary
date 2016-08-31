package com.kangle.library.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.system.Os;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.kangle.library.R;
import com.kangle.library.subActivity.A00Activity;

import kangle.logutil.LogUtils;

public class MainActivity extends AppCompatActivity {


    private ListView listView;

    private Class[] As = new Class[]{A00Activity.class};
    private String[] nameS = new String[]{"A00_自定义对话框及吐司"};


    private Context mContext = MainActivity.this;
    private ArrayAdapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv);
        adapter = new ArrayAdapter(mContext,android.R.layout.simple_expandable_list_item_1);
        for (String name : nameS){
            adapter.add(name);
        }
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String ActivityName = nameS[position];
                LogUtils.d("select item name :" + ActivityName);
                Intent intent = new Intent(mContext,As[position]);
                intent.putExtra("name",ActivityName);
                startActivity(intent);
            }
        });
    }





}
