package com.kangle.library.subActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kangle.library.R;

import kangle.logutil.LogUtils;
import kangle.mydialog.CustomProgressDialog.DefineCustomProgressDialog;
import kangle.mydialog.MyToast.ToastUtils;

public class A00Activity extends BaseActivity implements View.OnClickListener {


    private Button button01;
    private Button button02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a00);
        button01 = (Button) findViewById(R.id.button1);
        button02 = (Button) findViewById(R.id.button2);

        button01.setOnClickListener(this);
        button02.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                LogUtils.d("加载对话框");
                DefineCustomProgressDialog dialog = DefineCustomProgressDialog.createDialog(this);
                dialog.setMessage("我是自定义加载对话框的信息！");
                dialog.show();
                break;

            case R.id.button2:
                LogUtils.d("自定义吐司");
                ToastUtils.showMessage("永远相信\n美好的事情即将发生",A00Activity.this);
                break;
        }
    }
}
