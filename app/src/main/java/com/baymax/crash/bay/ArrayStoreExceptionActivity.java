package com.baymax.crash.bay;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.baymax.crash.R;

public class ArrayStoreExceptionActivity extends AppCompatActivity {

    private TextView exceptionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        exceptionText = findViewById(R.id.exceptionText);
        initCrash();
    }

    private void initCrash() {
        final Handler handler = new Handler();
        try{
            String[] array = {"a","b"};
            Object[] o = array;
            System.out.println(o.getClass());
            o[0] = new Object();
        }catch (Exception e){
            e.printStackTrace();
            final String error = Log.getStackTraceString(new Throwable(e));
            final String errorDetail = "这是数组存储异常，当试图将类型不兼容类型的对象存入一个Object[]数组时将引发异常";
            handler.post(new Runnable() {
                @Override
                public void run() {
                    exceptionText.setText(errorDetail + "\n" + error);
                }
            });
        }
    }

}