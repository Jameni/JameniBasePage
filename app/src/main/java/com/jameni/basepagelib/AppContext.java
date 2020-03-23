package com.jameni.basepagelib;

import com.jameni.basepage_lib.core.BaseAppContext;

import java.util.HashMap;

public class AppContext extends BaseAppContext{

    private static AppContext instance;

    @Override
    public void onCreate() {
        super.onCreate();

        System.out.println("ddddddddddddddddddddddddddd");


    }

    public static AppContext getInstance() {
        if (instance == null) {
            instance = new AppContext();

        }
        return instance;
    }
}
