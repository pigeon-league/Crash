package com.baymax.crash.yong.resourcenotfound;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.baymax.crash.R;

/**
 * Created by cugyong on 2019/2/28.
 */

public class SetTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_text);

        TextView describe = findViewById(R.id.tv_describe);
        describe.setText("textView.setText(24)，应该使用资源id或者textView.setText(24 + \"\")。编译期会在代码中提示警告。");

        TextView log = findViewById(R.id.tv_log);

        try {
            TextView tv = new TextView(this);
            tv.setText(24);
        }catch (Resources.NotFoundException e){
            log.setText(Log.getStackTraceString(e.fillInStackTrace()));
        }

    }
}
