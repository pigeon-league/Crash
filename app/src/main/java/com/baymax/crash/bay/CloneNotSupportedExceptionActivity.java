package com.baymax.crash.bay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.baymax.crash.R;

public class CloneNotSupportedExceptionActivity extends AppCompatActivity implements Cloneable{

    private TextView exceptionText;

    public CloneNotSupportedExceptionActivity cloned() {
        try {
            return (CloneNotSupportedExceptionActivity) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        exceptionText = findViewById(R.id.exceptionText);

        initCrash();
    }

    private void initCrash() {
        DemoThread t = new DemoThread();
        t.cloned();
        exceptionText.setText(t.getStackTraceString());
    }

}

class DemoThread extends Thread implements Cloneable {
    private String stackTraceString;

    public DemoThread cloned() {
        try {
            return (DemoThread) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            stackTraceString = Log.getStackTraceString(e.fillInStackTrace());
        }
        return null;
    }

    public String getStackTraceString() {
        return stackTraceString;
    }
}