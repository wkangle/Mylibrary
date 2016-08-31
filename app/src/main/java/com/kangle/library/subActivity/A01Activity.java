package com.kangle.library.subActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.kangle.library.R;
import com.kangle.library.subsubActivity.A01sub01Activity;

public class A01Activity extends BaseActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a01);
    }


    /**
     *
     * @param view
     */
    public void bt01(View view){
        Intent intent = new Intent(A01Activity.this, A01sub01Activity.class);
        startActivity(intent);
    }
}
