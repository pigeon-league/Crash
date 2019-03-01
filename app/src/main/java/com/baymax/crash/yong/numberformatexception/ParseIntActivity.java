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

public class ParseIntActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_text);

        TextView describe = findViewById(R.id.tv_describe);
        describe.setText("Integer.parseInt(\"1a\"), 参数需要是纯数字");

        TextView log = findViewById(R.id.tv_log);

        try {
            String numString = "1a";
            Integer.parseInt(numString);
        }catch (NumberFormatException e){
            log.setText(Log.getStackTraceString(e.fillInStackTrace()));
        }

    }
}
