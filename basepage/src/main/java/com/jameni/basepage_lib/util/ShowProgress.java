package com.jameni.basepage_lib.util;

import android.content.Context;
import android.content.Intent;

import com.jameni.basepage_lib.baseactivity.ModelActiviy;


/**
 * @author 显示广播
 */
public class ShowProgress {

    public static void showLoadingProgressDialog(Context context) {
        sendBroadcast(true, context);
    }

    public static void dismissProgressDialog(Context context) {
        sendBroadcast(false, context);
    }

    private static void sendBroadcast(boolean state, Context context) {
        Intent intent = new Intent();
        intent.setAction(ModelActiviy.PROGRESS);
        intent.putExtra("state", state);
        context.sendBroadcast(intent);
    }

}
