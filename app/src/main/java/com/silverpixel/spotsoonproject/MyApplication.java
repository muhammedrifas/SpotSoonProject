package com.silverpixel.spotsoonproject;

import android.app.Application;
import android.util.Log;

/**
 * Created by Rifas on 3/7/2017.
 */

public class MyApplication extends Application {
    static boolean videosdisplayed=false;


    private Thread.UncaughtExceptionHandler defaultUEH;
    public Thread.UncaughtExceptionHandler uncaughtExceptionHandler=new Thread.UncaughtExceptionHandler(){

        @Override
        public void uncaughtException(Thread thread, Throwable throwable) {
            Log.d("rifas",throwable.getMessage());
            Log.e("rifas2",throwable.getMessage());
        }
    };
    public MyApplication(){
        defaultUEH=Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);



       // hashMap=new HashMap<View,String>();

    }


}
