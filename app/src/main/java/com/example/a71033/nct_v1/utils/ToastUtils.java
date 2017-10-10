package com.example.a71033.nct_v1.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Author ： DasonYu
 * Date ： 2017/10/10
 * Email Address : 15764240573@163.com
 */

public class ToastUtils {
    private static ToastUtils mShowToastUtils = null;
    private Context context;

    private ToastUtils(Context context) {
        this.context = context;
    }

    public static ToastUtils getInstance(Context context) {
        if (mShowToastUtils == null) {
            synchronized (ToastUtils.class) {
                if (mShowToastUtils == null) {
                    mShowToastUtils = new ToastUtils(context);
                }
            }
        }
        return mShowToastUtils;
    }

    public void showToastOnlyString(String message, int time) {
        Toast.makeText(context, message, time).show();
    }

    public void showToastOnlyString(int resourceId, int time) {
        Toast.makeText(context, context.getResources().getText(resourceId), time).show();
    }
}