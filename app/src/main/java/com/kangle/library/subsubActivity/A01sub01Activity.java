package com.kangle.library.subsubActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kangle.library.R;

import kangle.CircleTextImage.CircleTextImage;

public class A01sub01Activity extends AppCompatActivity {


    private CircleTextImage circleTextImage1;
    private CircleTextImage circleTextImage2;
    private CircleTextImage circleTextImage3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a01sub01);

        circleTextImage1 = (CircleTextImage) findViewById(R.id.ctView);
        circleTextImage2 = (CircleTextImage) findViewById(R.id.ctView2);
        circleTextImage3 = (CircleTextImage) findViewById(R.id.ctView3);

        circleTextImage1.setText4CircleImage("Android");
        circleTextImage2.setText4CircleImage("Apple");
        circleTextImage3.setText4CircleImage("Hi");
    }
}
