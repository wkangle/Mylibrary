package com.kangle.library.subsubActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.kangle.library.R;

import java.util.ArrayList;
import java.util.List;

import kangle.pickerview.PickerView;

public class A02sub01Activity extends AppCompatActivity {

    private PickerView pickerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a02sub01);
        pickerView = (PickerView) findViewById(R.id.pickerView);
        List<String> data = new ArrayList<String>();
        for (int i = 1; i <= 100; i++) {
            String info = "测试数据：" + i;
            data.add(info);
        }
        pickerView.setData(data);
        pickerView.setSelected(50);
        pickerView.setOnSelectListener(new PickerView.onSelectListener() {
            @Override
            public void onSelect(String text) {
                Toast.makeText(A02sub01Activity.this, text, Toast.LENGTH_LONG).show();
            }
        });
    }
}
