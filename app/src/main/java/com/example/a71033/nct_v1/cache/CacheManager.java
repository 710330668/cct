package com.example.a71033.nct_v1.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;

import com.example.a71033.nct_v1.common.Const;
import com.example.a71033.nct_v1.common.MyApplication;

import java.io.File;

/**
 * Created by 71033 on 2017/10/9.
 */

public class CacheManager {

    public static CacheManager instance;
    public static String sdcardPath = Environment.getExternalStorageDirectory().getAbsolutePath()
            +File.separator+"CCT";

    public CacheManager(){
        createRootFile();
    }

    public static CacheManager getInstance(){
        if(instance == null){
            instance = new CacheManager();
        }
        return instance;
    }

    private void createRootFile() {
        File file = new File(sdcardPath);
        if(!file.exists()){
            file.mkdir();
        }
    }

    /**
     * 向SharedPreferences中存数据
     *
     * @param key
     * @param value
     */
    public void saveMsgToSharedPreferences(String key, String value) {
        SharedPreferences mSharedPreferences = MyApplication.appContext.getSharedPreferences(
                Const.tag, Context.MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.putString(key, value);
        mEditor.commit();
    }

    /**
     * 从SharedPreferences中取数据
     *
     * @param key
     * @return
     */
    public String getMsgFromSharedPreferences(String key) {
        SharedPreferences mSharedPreferences = MyApplication.appContext.getSharedPreferences(
                Const.tag, Context.MODE_PRIVATE);
        String result = mSharedPreferences.getString(key, "");
        if ("null".equals(result)) {
            result = "";
        }
        return result;
    }
    /**
     * 清空SharedPreferences中存放的数据
     */
    public static void clearSharedPreferences(){
        SharedPreferences mSharedPreferences = MyApplication.appContext.getSharedPreferences(
                Const.tag, Context.MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.clear();
        mEditor.commit();
    }


    /**
     * 移除SharedPreferences中某个数据
     * @param key
     */
    public static void removeMsg(String key){
        SharedPreferences mSharedPreferences = MyApplication.appContext.getSharedPreferences(
                Const.tag, Context.MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.remove(key);
        mEditor.commit();
    }


}
