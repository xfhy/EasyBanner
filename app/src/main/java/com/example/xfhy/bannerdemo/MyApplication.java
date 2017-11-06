package com.example.xfhy.bannerdemo;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * @author feiyang
 * @time create at 2017/11/6 8:55
 * description
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
