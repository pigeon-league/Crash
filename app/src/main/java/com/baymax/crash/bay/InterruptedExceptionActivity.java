package com.baymax.crash.bay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    }

}

//class TaskRunner implements Runnable {
//    private BlockingQueue<Task> queue;
//
//    public TaskRunner(BlockingQueue<Task> queue) {
//        this.queue = queue;
//    }
//
//    public void run() {
//        try {
//            while (true) {
//                Task task = queue.take(10, TimeUnit.SECONDS);
//                task.execute();
//            }
//        }
//        catch (InterruptedException e) {
//            // Restore the interrupted status
//            Thread.currentThread().interrupt();
//        }
//    }
//}