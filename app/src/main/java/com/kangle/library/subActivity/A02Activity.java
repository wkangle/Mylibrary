package com.kangle.library.subActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.kangle.library.Activity.MainActivity;
import com.kangle.library.R;
import com.kangle.library.subsubActivity.A02sub01Activity;

import java.util.ArrayList;
import java.util.List;

import kangle.pickerview.PickerView;
import kangle.wheelview.WheelView;

public class A02Activity extends BaseActivity {


    String selectData = "";//待赋值数据


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a02);
    }


    public void bt01(View view){
        Intent intent = new Intent(A02Activity.this, A02sub01Activity.class);
        startActivity(intent);
    }


    public void bt02(View view){
        List<String> YearMonthDate = new ArrayList<String>();
        //给list赋值
        for (int i = 0; i < 50; i++) {
            String testData = "测试数据" + i;
            YearMonthDate.add(testData);
        }
        //先将布局文件转换成View对象
        View outerView = View.inflate(A02Activity.this, R.layout.activity_a02sub01, null);
        PickerView pickerView = (PickerView) outerView.findViewById(R.id.pickerView);
        pickerView.setData(YearMonthDate);
        pickerView.setSelected(25);
        pickerView.setOnSelectListener(new PickerView.onSelectListener() {
            @Override
            public void onSelect(String text) {
                selectData = text;
            }
        });
        //下面是对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请选择:");//设置对话框标题
        builder.setView(outerView);//设置对话框的view，也就是上面我们转换成的view
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(A02Activity.this,selectData,Toast.LENGTH_LONG).show();
                //这里我们可以写自己的逻辑，wheelView在滚动的时候在不断调用onSelected 接口，此时selectData 已经被赋值为item所对应的数据
                //我们就达到了选择数据的目的
            }
        });
        builder.setNegativeButton("取消", null);
        builder.show();

    }


    public void bt03(View view){
        List<String> YearMonthDate = new ArrayList<String>();
        //给list赋值
        for (int i = 0; i < 50; i++) {
            String testData = "测试数据" + i;
            YearMonthDate.add(testData);
        }
        //先将布局文件转换成View对象
        View outerView = View.inflate(A02Activity.this, R.layout.wheel_view, null);
        final WheelView wv = (WheelView) outerView.findViewById(R.id.wheel_view_wv);
        wv.setOffset(1);//设置上下的候选个数
        wv.setItems(YearMonthDate);//设置数据
        wv.setSeletion(YearMonthDate.size());//设置初始位置
        wv.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
            @Override
            public void onSelected(int selectedIndex, String item) {
                //item即为选中的条目的数据 ， selectedIndex 为当前选中的条目在集合中的索引
                selectData = item;

            }
        });
        //下面是对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请选择:");//设置对话框标题
        builder.setView(outerView);//设置对话框的view，也就是上面我们转换成的view
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(A02Activity.this,selectData,Toast.LENGTH_LONG).show();
                //这里我们可以写自己的逻辑，wheelView在滚动的时候在不断调用onSelected 接口，此时selectData 已经被赋值为item所对应的数据
                //我们就达到了选择数据的目的
            }
        });
        builder.setNegativeButton("取消", null);
        builder.show();
    }
}
