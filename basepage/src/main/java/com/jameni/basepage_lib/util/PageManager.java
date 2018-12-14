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


    public static void exit() {
        if (lstActivity.size() > 0) {
            for (Activity activity : lstActivity) {
                activity.getLocalClassName();
                activity.finish();
            }
        }
        Process.killProcess(Process.myPid());
    }


}
