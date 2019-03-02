package com.baymax.crash.yong.classformaterror;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.baymax.crash.R;

/**
 * Created by cugyong on 2019/3/1.
 */

public class ClassFormatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_text);

        TextView describe = findViewById(R.id.tv_describe);
        describe.setText("ClassFormatError 当Java虚拟机试图读取类文件(.class)" +
                "并确定该文件存在格式错误或无法解释为类文件时,抛出该错误。");

        TextView log = findViewById(R.id.tv_log);
    }
}
