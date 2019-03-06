package com.baymax.crash.bay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.baymax.crash.R;

public class InflateExceptionActivity extends AppCompatActivity {

    private TextView exceptionText;
    private MyImageView myImageView;
    private String crashLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
            setContentView(R.layout.layout_image);
        } catch (Exception e){
            crashLog = Log.getStackTraceString(e.fillInStackTrace());
            e.printStackTrace();
        }

        exceptionText = findViewById(R.id.contentPanel);
        myImageView = findViewById(R.id.imageView);

        initCrash();
    }

    private void initCrash() {
        if(null != crashLog){
            Toast.makeText(this,crashLog,Toast.LENGTH_LONG).show();
        }
//        1)、路径不全、大小不正确
//        2)、名称的拼写错误、大小写错误
//        3)、属性引用错误、拼写错误

//        2019-03-04 13:52:56.155 17238-17238/com.baymax.crash E/AndroidRuntime: FATAL EXCEPTION: main
//        Process: com.baymax.crash, PID: 17238
//        java.lang.RuntimeException: Unable to start activity ComponentInfo{com.baymax.crash/com.baymax.crash.bay.InflateExceptionActivity}: android.view.InflateException: Binary XML file line #12: Binary XML file line #12: Error inflating class MyImageView
//        at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2924)
//        at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2985)
//        at android.app.ActivityThread.-wrap14(ActivityThread.java)
//        at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1635)
//        at android.os.Handler.dispatchMessage(Handler.java:102)
//        at android.os.Looper.loop(Looper.java:154)
//        at android.app.ActivityThread.main(ActivityThread.java:6692)
//        at java.lang.reflect.Method.invoke(Native Method)
//        at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1468)
//        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1358)
//        Caused by: android.view.InflateException: Binary XML file line #12: Binary XML file line #12: Error inflating class MyImageView
//     Caused by: android.view.InflateException: Binary XML file line #12: Error inflating class MyImageView
//     Caused by: java.lang.ClassNotFoundException: Didn't find class "android.view.MyImageView" on path: DexPathList[[zip file "/data/app/com.baymax.crash-2/base.apk"],nativeLibraryDirectories=[/data/app/com.baymax.crash-2/lib/arm64, /system/lib64, /vendor/lib64]]
//        at dalvik.system.BaseDexClassLoader.findClass(BaseDexClassLoader.java:56)
//        at java.lang.ClassLoader.loadClass(ClassLoader.java:380)
//        at java.lang.ClassLoader.loadClass(ClassLoader.java:312)
//        at android.view.LayoutInflater.createView(LayoutInflater.java:616)
//        at android.view.LayoutInflater.onCreateView(LayoutInflater.java:707)
//        at com.android.internal.policy.PhoneLayoutInflater.onCreateView(PhoneLayoutInflater.java:68)
//        at android.view.LayoutInflater.onCreateView(LayoutInflater.java:724)
//        at android.view.LayoutInflater.createViewFromTag(LayoutInflater.java:792)
//        at android.view.LayoutInflater.createViewFromTag(LayoutInflater.java:734)
//        at android.view.LayoutInflater.rInflate(LayoutInflater.java:865)
//        at android.view.LayoutInflater.rInflateChildren(LayoutInflater.java:828)
//        at android.view.LayoutInflater.inflate(LayoutInflater.java:525)
//        at android.view.LayoutInflater.inflate(LayoutInflater.java:427)
//        at android.view.LayoutInflater.inflate(LayoutInflater.java:378)
//        at android.support.v7.app.AppCompatDelegateImpl.setContentView(AppCompatDelegateImpl.java:469)
//        at android.support.v7.app.AppCompatActivity.setContentView(AppCompatActivity.java:140)
//        at com.baymax.crash.bay.InflateExceptionActivity.onCreate(InflateExceptionActivity.java:17)
//        at android.app.Activity.performCreate(Activity.java:6912)
//        at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1126)
//        at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2877)
//        at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2985)
//        at android.app.ActivityThread.-wrap14(ActivityThread.java)
//        at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1635)
//        at android.os.Handler.dispatchMessage(Handler.java:102)
//        at android.os.Looper.loop(Looper.java:154)
//        at android.app.ActivityThread.main(ActivityThread.java:6692)
//        at java.lang.reflect.Method.invoke(Native Method)
//        at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1468)
//        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1358)

    }

}