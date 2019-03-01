package com.baymax.crash.yong.classnotfound;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.baymax.crash.R;
import com.baymax.crash.yong.resourcenotfound.Layout2IdActivity;
import com.baymax.crash.yong.resourcenotfound.ResourceNotFoundActivity;
import com.baymax.crash.yong.resourcenotfound.SetTextActivity;
import com.baymax.crash.yong.resourcenotfound.SummaryActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cugyong on 2019/2/28.
 */

public class ClassNotFoundActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_text);

        TextView describe = findViewById(R.id.tv_describe);
        describe.setText("ClassNotFoundException表示指定的类找不到，比如：\n" +
                "Class<?> refectClass = Class.forName(\"ABC\")，因为类ABC不存在，所以会报" +
                "ClassNotFoundException异常。");

        TextView log = findViewById(R.id.tv_log);

        try {
            Class<?> refectClass = Class.forName("ABC");
        }catch (ClassNotFoundException e){
            log.setText(Log.getStackTraceString(e.fillInStackTrace()));
        }

    }
}
