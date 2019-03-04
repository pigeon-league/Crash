package com.baymax.crash.bay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.baymax.crash.R;

import java.util.concurrent.TimeUnit;

public class InterruptedExceptionActivity extends AppCompatActivity {

    private TextView exceptionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        exceptionText = findViewById(R.id.exceptionText);

        initCrash();
    }

    private void initCrash() {
        Thread thread = new Thread(){
            public void run(){
                System.out.println(Thread.currentThread().getName()+ "线程开始了~");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    exceptionText.setText(Log.getStackTraceString(e.fillInStackTrace()));
                    System.out.println(Thread.currentThread().getName()+"抛出了InterruptedException");
                    System.out.println("2" + isInterrupted());
                }
                System.out.println(Thread.currentThread().getName()+ "线程结束了~");
            }
        };
        thread.start();
        System.out.println("1" + thread.isInterrupted());
        thread.interrupt();

        System.out.println("测试结束");
    }

}

/**
 * 没有阻塞操作的线程
 */
class NonBlockedRunnable implements Runnable {
    @Override
    public void run() {
        while (!Thread.interrupted()) {
            System.out.println("线程执行中...");
        }
    }

}