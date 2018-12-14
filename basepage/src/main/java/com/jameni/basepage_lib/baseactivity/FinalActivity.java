package com.jameni.basepage_lib.baseactivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.gson.Gson;
import com.jameni.allutillib.common.CommonUtil;
import com.jameni.allutillib.common.PrintUtil;


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
    }

    public void tip(String str) {
        if (isNotNull(context) && isNotNull(str)) {
            CommonUtil.tip(context, str);
        }
    }


    public void print(Object obj) {
        if (isNotNull(obj)) {
            if (obj instanceof String) {
                PrintUtil.printMsg((String) obj);
                return;
            } else {
                PrintUtil.printMsg(getGson().toJson(obj));
            }
        }
    }

    protected Gson getGson() {

        if (!isNotNull(gson)) {
            gson = new Gson();
        }
        return gson;
    }

    public String getIntentValue(Intent intent, String key) {
        return CommonUtil.getIntentValue(key, intent);
    }

    public int getIntentValue_Integer(Intent intent, String key) {
        return CommonUtil.getIntentValue_Integer(key, intent);
    }

    public boolean isNotEmpty(String msg) {
        return CommonUtil.isNotEmpty(msg);
    }

    public boolean isNotNull(Object obj) {
        return CommonUtil.isNotNull(obj);
    }

    public String getSelfValue(String obj) {
        return CommonUtil.getSelfValue(obj);
    }

    public boolean matchList(Object obj) {
        return CommonUtil.matchList(obj);
    }


    public <T> T castObject(Object obj) {
        return (T) obj;
    }
}
