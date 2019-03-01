package com.baymax.crash.yong.numberformatexception;

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
        describe.setText("NumberFormatException出现的原因可能如下：\n" +
                "1、Integer类的成员方法parseInt(String s)，如果像这样Integer.parseInt(\"1a\")调用，因为1a不是纯数字，所以就会报NumberFormatException；\n" +
                "2、Integer类的成员方法parseInt(String s)，如果像这样Integer.parseInt(\"2147483648\")调用，因为2147483648超过了int能够表示的最大值2147483647，所以就会报Resources.NotFoundException，需要使用Long.parseLong(\"2147483648\")；\n" +
                "通常这个异常出现在客户端将字符串类型参数解析成int或者long类型时，所以开发者应该在这些情况中加上try-catch来防护。");
    }
}
