package com.baymax.crash.yong.illegalargumentexception;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.baymax.crash.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cugyong on 2019/3/1.
 */

public class SimpleDataFormatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_text);

        TextView describe = findViewById(R.id.tv_describe);
        describe.setText("new SimpleDateFormat(\"yyyy-rr-dd\"), \"yyyy-rr-dd\"不是合法的模式");

        TextView log = findViewById(R.id.tv_log);

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-rr-dd");
            simpleDateFormat.format(new Date());
        }catch (IllegalArgumentException e){
            log.setText(Log.getStackTraceString(e.fillInStackTrace()));
        }

    }
}
