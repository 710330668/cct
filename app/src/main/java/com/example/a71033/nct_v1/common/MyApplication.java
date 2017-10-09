package com.example.a71033.nct_v1.common;

import android.support.multidex.MultiDexApplication;

/**
 * Created by 71033 on 2017/10/9.
 */

public class MyApplication extends MultiDexApplication {

    //是否输出log
    public static boolean isDebug = true;

    public static String APP_NAME = "nongcuntao" ;

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
