package com.baymax.crash.yong.stackoverflow;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.baymax.crash.R;

/**
 * Created by cugyong on 2019/3/6.
 */

public class RecursionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_text);

        TextView describe = findViewById(R.id.tv_describe);
        describe.setText("当递归调用方法时，如果递归调用次数过多，就会导致堆栈溢出。");

        TextView log = findViewById(R.id.tv_log);

        try {
            plus(10000);
        }catch (StackOverflowError e){
            log.setText(Log.getStackTraceString(e.fillInStackTrace()));
        }
    }

    int plus(int a){
        if (a <= 0){
            return 0;
        }else {
            return 1 + plus(a - 1);
        }
    }
}
