package com.kangle.library.subActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {


    public String activityName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityName = getIntent().getStringExtra("name");
        setTitle(activityName);
    }
}
