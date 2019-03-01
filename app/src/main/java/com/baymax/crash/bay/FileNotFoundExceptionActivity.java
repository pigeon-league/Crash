package com.baymax.crash.bay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.baymax.crash.R;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileNotFoundExceptionActivity extends AppCompatActivity {

    private TextView exceptionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        exceptionText = findViewById(R.id.exceptionText);

        initCrash();
    }

    private void initCrash() {
//1.<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
//              //2.文件名正确
//                2019-02-28 19:05:38.614 3259-3259/com.baymax.crash W/System.err: java.io.FileNotFoundException: demo.text (Read-only file system)
//                2019-02-28 19:05:38.614 3259-3259/com.baymax.crash W/System.err:     at java.io.FileOutputStream.open(Native Method)
//                2019-02-28 19:05:38.614 3259-3259/com.baymax.crash W/System.err:     at java.io.FileOutputStream.<init>(FileOutputStream.java:221)
//                2019-02-28 19:05:38.615 3259-3259/com.baymax.crash W/System.err:     at java.io.FileOutputStream.<init>(FileOutputStream.java:108)
//                2019-02-28 19:05:38.615 3259-3259/com.baymax.crash W/System.err:     at java.io.FileWriter.<init>(FileWriter.java:63)
//                2019-02-28 19:05:38.615 3259-3259/com.baymax.crash W/System.err:     at com.baymax.crash.MainActivity.onClick(MainActivity.java:162)
//                2019-02-28 19:05:38.615 3259-3259/com.baymax.crash W/System.err:     at android.view.View.performClick(View.java:6213)
//                2019-02-28 19:05:38.615 3259-3259/com.baymax.crash W/System.err:     at android.widget.TextView.performClick(TextView.java:11074)
//                2019-02-28 19:05:38.615 3259-3259/com.baymax.crash W/System.err:     at android.view.View$PerformClick.run(View.java:23645)
//                2019-02-28 19:05:38.615 3259-3259/com.baymax.crash W/System.err:     at android.os.Handler.handleCallback(Handler.java:751)
//                2019-02-28 19:05:38.615 3259-3259/com.baymax.crash W/System.err:     at android.os.Handler.dispatchMessage(Handler.java:95)
//                2019-02-28 19:05:38.615 3259-3259/com.baymax.crash W/System.err:     at android.os.Looper.loop(Looper.java:154)
//                2019-02-28 19:05:38.615 3259-3259/com.baymax.crash W/System.err:     at android.app.ActivityThread.main(ActivityThread.java:6692)
//                2019-02-28 19:05:38.615 3259-3259/com.baymax.crash W/System.err:     at java.lang.reflect.Method.invoke(Native Method)
//                2019-02-28 19:05:38.615 3259-3259/com.baymax.crash W/System.err:     at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1468)
//                2019-02-28 19:05:38.615 3259-3259/com.baymax.crash W/System.err:     at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1358)
//                try {
//                    String path = Environment.getExternalStorageDirectory().getPath() + this.getPackageName() +  "/Autoliste.csv";
//                    BufferedReader reader = new BufferedReader(new FileReader(path));
//                    String line = reader.readLine();
//                    while (line != null) {
//                        line = reader.readLine();
//                    }
//                    reader.close();
//                } catch (IOException e) {
//                    System.out.println("Error reading file");
//                } catch (IndexOutOfBoundsException e) {
//                    System.out.println("Error IndexOutOfBoundsException");
//                }

        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter("demo.text"));
            bufferedWriter.append(' ');
        } catch (IOException ex) {
            exceptionText.setText(Log.getStackTraceString(ex.fillInStackTrace()));
            ex.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                }
            } catch (IOException ex) {
                exceptionText.setText(Log.getStackTraceString(ex.fillInStackTrace()));
                ex.printStackTrace();
            }
        }
    }

}
