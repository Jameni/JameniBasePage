package com.jameni.basepage_lib.baseactivity;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.jameni.basepage_lib.util.PageManager;


/**
 * Created by Administrator on 2017/5/3.
 */

public abstract class FinalActivity extends AppCompatActivity {

    private Gson gson;
    protected Context context;
    protected boolean isPageFinish;
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        context = this;
        PageManager.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        isPageFinish = true;
        super.onDestroy();
        PageManager.removeActivity(this);
    }








}
