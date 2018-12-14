package com.jameni.basepage_lib.basefragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.google.gson.Gson;
import com.jameni.allutillib.common.CommonUtil;
import com.jameni.allutillib.common.PrintUtil;

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

    public String getSelfValue(String obj) {
        return CommonUtil.getSelfValue(obj);
    }

    public boolean isNotNull(Object obj) {
        return CommonUtil.isNotNull(obj);
    }
}
