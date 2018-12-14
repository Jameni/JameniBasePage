package com.jameni.basepage_lib.core;

import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import java.util.HashMap;

public class BaseAppContext extends MultiDexApplication {
    private static BaseAppContext instance;
    private HashMap<String, Object> hashMap;

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
    }


    public HashMap<String, Object> getHashMap() {
        if (hashMap == null) {
            hashMap = new HashMap<String, Object>();
        }
        return hashMap;
    }

    public static BaseAppContext getInstance() {
        if (instance == null) {
            instance = new BaseAppContext();

        }
        return instance;
    }
}
