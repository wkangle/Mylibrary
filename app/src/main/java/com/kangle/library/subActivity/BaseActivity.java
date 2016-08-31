package com.kangle.library.subActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kangle.library.R;

public class BaseActivity extends AppCompatActivity {


    public String activityName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityName = getIntent().getStringExtra("name");
        setTitle(activityName);
    }
}
