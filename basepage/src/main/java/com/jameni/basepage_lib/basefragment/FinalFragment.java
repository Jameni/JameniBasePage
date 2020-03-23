package com.jameni.basepage_lib.basefragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.jameni.allutillib.common.CommonUtil;
import com.jameni.allutillib.common.PrintUtil;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Jameni on 2017/5/4.
 */

public abstract class FinalFragment extends Fragment {

    private Gson gson;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void tip(String str) {
        if (isNotNull(getContext()) && isNotNull(str)) {
            CommonUtil.tip(getContext(), str);
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

    public int getListSize(Object obj) {
        return CommonUtil.getListSize(obj);
    }

    public <T> T castObject(Object obj) {
        return (T) obj;
    }


    public JSONArray getArray(JSONObject obj, String key) {
        return CommonUtil.getJSONArray(obj, key);
    }

    public JSONObject getJsonArrayItem(JSONArray array, int i) {
        return CommonUtil.getJSONArrayItem(array, i);
    }

    public JSONObject makeJson(Object obj) {
        if (obj instanceof String) {
            return CommonUtil.makeJSON((String) obj);
        } else {
            return CommonUtil.makeJSON("");
        }
    }

    public String getJsonValue(JSONObject obj, String key) {
        return CommonUtil.getJsonValue(obj, key);
    }

    public JSONObject getJsonObj(JSONObject obj, String key) {
        return CommonUtil.getJSONObject(obj, key);
    }

    public String getText(Object obj) {
        String result = "";

        if (isNotNull(obj)) {
            if (obj instanceof TextView) {
                TextView textView = castObject(obj);
                result = textView.getText().toString();
            } else if (obj instanceof EditText) {
                EditText editText = castObject(obj);
                result = editText.getText().toString();
            }
        }
        return result;
    }
}
