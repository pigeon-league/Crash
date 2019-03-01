package com.baymax.crash.yong.numberformatexception;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.baymax.crash.R;

/**
 * Created by cugyong on 2019/2/28.
 */

public class ParseIntActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_text);

        TextView describe = findViewById(R.id.tv_describe);
        describe.setText("Integer.parseInt(\"2147483648\")，" +
                "参数2147483648超过了int能够表示的最大值2147483647，需要使用Long.parseLong(\"2147483648\")");

        TextView log = findViewById(R.id.tv_log);

        try {
            Long.parseLong("2147483648");
            Integer.parseInt("2147483648");
        }catch (NumberFormatException e){
            log.setText(Log.getStackTraceString(e.fillInStackTrace()));
        }

    }
}
