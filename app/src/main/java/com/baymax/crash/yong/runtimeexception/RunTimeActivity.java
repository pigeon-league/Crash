package com.baymax.crash.yong.runtimeexception;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.baymax.crash.R;

/**
 * Created by cugyong on 2019/3/6.
 */

public class RunTimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_run_time);
        }catch (Exception e){
            setContentView(R.layout.activity_set_text);
            TextView describe = findViewById(R.id.tv_describe);
            describe.setText("java.lang.RuntimeException: Unable to start activity ComponentInfo{com.baymax.crash/com.baymax.crash.yong.runtimeexception.RunTimeActivity}: android.view.InflateException: Binary XML file line #6: Attempt to invoke virtual method 'boolean java.lang.String.equals(java.lang.Object)' on a null object reference\n" +
                    " at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:3320)\n" +
                    " at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:3416)\n" +
                    " at android.app.ActivityThread.access$1100(ActivityThread.java:229)\n" +
                    " at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1821)\n" +
                    " at android.os.Handler.dispatchMessage(Handler.java:102)\n" +
                    " at android.os.Looper.loop(Looper.java:148)\n" +
                    " at android.app.ActivityThread.main(ActivityThread.java:7326)\n" +
                    " Caused by: android.view.InflateException: Binary XML file line #6: Attempt to invoke virtual method 'boolean java.lang.String.equals(java.lang.Object)' on a null object reference\n" +
                    " at android.view.LayoutInflater.inflate(LayoutInflater.java:551)\n" +
                    " at android.view.LayoutInflater.inflate(LayoutInflater.java:429)\n" +
                    " at android.view.LayoutInflater.inflate(LayoutInflater.java:380)\n" +
                    " at android.support.v7.app.AppCompatDelegateImpl.setContentView(AppCompatDelegateImpl.java:469)\n" +
                    " at android.support.v7.app.AppCompatActivity.setContentView(AppCompatActivity.java:140)\n" +
                    " at com.baymax.crash.yong.runtimeexception.RunTimeActivity.onCreate(RunTimeActivity.java:21)\n" +
                    " at android.app.Activity.performCreate(Activity.java:6904)\n" +
                    " at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1136)\n" +
                    " at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:3267)\n" +
                    " Caused by: java.lang.NullPointerException: Attempt to invoke virtual method 'boolean java.lang.String.equals(java.lang.Object)' on a null object reference\n" +
                    " at android.view.LayoutInflater.createViewFromTag(LayoutInflater.java:750)\n" +
                    " at android.view.LayoutInflater.createViewFromTag(LayoutInflater.java:716)\n" +
                    " at android.view.LayoutInflater.rInflate(LayoutInflater.java:847)\n" +
                    " at android.view.LayoutInflater.rInflateChildren(LayoutInflater.java:810)\n" +
                    " at android.view.LayoutInflater.inflate(LayoutInflater.java:527)\n" +
                    " at android.view.LayoutInflater.inflate(LayoutInflater.java:429) \n" +
                    " at android.view.LayoutInflater.inflate(LayoutInflater.java:380) \n" +
                    " at android.support.v7.app.AppCompatDelegateImpl.setContentView(AppCompatDelegateImpl.java:469) \n" +
                    " at android.support.v7.app.AppCompatActivity.setContentView(AppCompatActivity.java:140) \n" +
                    " at com.baymax.crash.yong.runtimeexception.RunTimeActivity.onCreate(RunTimeActivity.java:21) \n" +
                    " at android.app.Activity.performCreate(Activity.java:6904) \n" +
                    " at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1136) \n" +
                    " at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:3267) \n");


            TextView log = findViewById(R.id.tv_log);
            //log.setText(Log.getStackTraceString(e.fillInStackTrace()));

            try {
                throw new RuntimeException("测试", new NullPointerException("测试空"));
            }catch (RuntimeException e1){
                e1.printStackTrace();
            }
        }
    }
}
