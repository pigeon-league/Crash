package com.baymax.crash.yong.illegalargumentexception;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.baymax.crash.R;

/**
 * Created by cugyong on 2019/2/28.
 */

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_text);

        TextView describe = findViewById(R.id.tv_describe);
        describe.setText("IllegalArgumentException是因为传入的方法参数不合法导致的。以下是关于避免该异常的几点建议：\n" +
                "1、当使用不熟悉的API方法时，点击进入API源码，看看API注释中是否说明会抛出异常，如果会，建议try-catch这些异常；\n" +
                "2、当开发者传入给API方法的参数是后台或者前端返的时，尤其要注意try-catch这些API方法的异常。");
    }
}
