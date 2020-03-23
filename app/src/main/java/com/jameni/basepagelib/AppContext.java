package com.jameni.basepagelib;

import android.app.Application;

public class AppContext extends Application {

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
