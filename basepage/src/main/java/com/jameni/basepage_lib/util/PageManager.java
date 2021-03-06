package com.jameni.basepage_lib.util;

import android.app.Activity;
import android.os.Process;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zero on 2017/1/6.
 */

public class PageManager {
    private static List<Activity> lstActivity = new ArrayList<>();

    public static void addActivity(Activity activity) {
        lstActivity.add(activity);
    }

    public static void removeActivity(Activity activity) {
        lstActivity.remove(activity);
    }

    public static List<Activity> getLstActivity() {
        return lstActivity;
    }

    public static void closeAllActivity() {
        if (lstActivity != null && lstActivity.size() > 0) {
            for (Activity activity : lstActivity) {
                activity.finish();
            }
        }
    }

    public static void exit() {
        closeAllActivity();
        Process.killProcess(Process.myPid());
    }

    //关闭所有其他activity
//    public static void closeOtherActivity(Class<?> cls) {
//
//        if (cls != null && lstActivity != null && lstActivity.size() > 0) {
//            for (Activity activity : lstActivity) {
//
//                if (!activity.getClass().equals(cls)) {
//                    activity.finish();
//                }
//            }
//        }
//    }

    //关闭所有其他activity
    public static void closeOtherActivity(Activity ac) {

        if (ac != null && lstActivity != null && lstActivity.size() > 0) {
            for (Activity activity : lstActivity) {

                if (activity != ac) {
                    activity.finish();
                }
            }
        }
    }
}
