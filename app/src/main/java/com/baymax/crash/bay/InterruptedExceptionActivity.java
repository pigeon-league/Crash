package com.baymax.crash.bay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.baymax.crash.R;

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
        WorkerThread t = new WorkerThread();
        t.start();
        synchronized (this)
        {
            try
            {
                wait(1000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

}

class WorkerThread extends Thread
{
    public void run()
    {
//        externalLibrary.heavyComputation();
    }
}