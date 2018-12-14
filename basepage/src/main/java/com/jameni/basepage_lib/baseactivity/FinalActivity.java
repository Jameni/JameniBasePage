package com.jameni.basepage_lib.baseactivity;

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

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        //管理activity
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


//    public JSONArray getArray(JSONObject obj, String key) {
//        return AllUtil.getJsonArrayValue(obj, key);
//    }
//
//    public JSONObject getJsonArrayItem(JSONArray array, int i) {
//        return AllUtil.getJsonArrayItem(array, i);
//    }
//
//    public JSONObject makeJson(Object obj) {
//        if (obj instanceof String) {
//            return AllUtil.makeJson((String) obj);
//        } else {
//            return AllUtil.makeJson("");
//        }
//    }
//
//
//    public int getJsonArraySize(JSONArray array) {
//        return AllUtil.getJsonArraySize(array);
//    }
//
//    public String getJsonValue(JSONObject obj, String key) {
//        return AllUtil.getJsonValue(obj, key);
//    }
//
//    public JSONObject getJsonObj(JSONObject obj, String key) {
//        return AllUtil.getJsonObject(obj, key);
//    }
//
//    public JSONArray getBackArray(JSONObject obj) {
//        return AllUtil.getJsonArrayValue(obj, "dataList");
//    }


    //设置全屏
    public void setFullPage() {
        View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;//状态栏会遮住Activity
        decorView.setSystemUiVisibility(option);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);//这句话可以style设置
        }
    }


//    public void addParmas(String key, Object obj) {
//        AppContext.getInstance().getHashMap().put(getSelfValue(key), obj);
//    }
//
//    public <T> T getParmas(String key) {
//        return (T) AppContext.getInstance().getHashMap().get(getSelfValue(key));
//    }
//
//    public void clearParmas() {
//        AppContext.getInstance().getHashMap().clear();
//    }


}
