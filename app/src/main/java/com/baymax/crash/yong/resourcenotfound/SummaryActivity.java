package com.baymax.crash.yong.resourcenotfound;

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
        describe.setText("Resources.NotFoundException出现的原因是：\n在需要资源id作为参数" +
                "的地方传入了一个错误的id。比如：\n" +
                "1、TextView类的成员方法setText(@StringRes int resid)，如果像这样TextView tv = new TextView(this);\n" +
                " tv.setText(24);调用，因为24不是资源id，所以就会报Resources.NotFoundException；\n" +
                "2、LayoutInflater类的成员方法inflate(@LayoutRes int resource, @Nullable ViewGroup root, boolean attachToRoot)，" +
                "如果像这样LayoutInflater.from(this).inflate(R.id.listview, null, false)调用，因为R.id.listview不是R.layout资源id，所以就会报Resources.NotFoundException；\n" +
                "通常这种情况下，编译器会在设置参数的代码处给出警告，" +
                "开发者多加注意，同时点击进入方法源代码看看参数具体需要什么资源Id,可以避免该类错误发生。");
    }
}
