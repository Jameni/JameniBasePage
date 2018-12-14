package com.jameni.basepagelib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jameni.basepage_lib.baseactivity.ModelActiviy;

public class MainActivity extends ModelActiviy {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        print("dddd");
        setPageTitle("abc");
    }
}
