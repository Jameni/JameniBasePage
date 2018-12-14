package com.jameni.basepagelib;

import android.os.Bundle;

import com.jameni.basepage_lib.baseactivity.ModelActiviy;

public class MainActivity extends ModelActiviy {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Test_Activity_.intent(context).start();
        finish();
    }
}
