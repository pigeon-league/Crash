package com.baymax.crash.bay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.baymax.crash.R;

public class EnumConstantNotPresentExceptionActivity extends AppCompatActivity {

    private TextView exceptionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        exceptionText = findViewById(R.id.exceptionText);

        initCrash();
    }

    private void initCrash() {
//      当应用程序尝试按名称访问枚举常量并且枚举类型不包含具有指定名称的常量时抛出。
//      类似地，如果注释中的枚举常量不再出现在枚举类型中，则尝试读取枚举值成员将导致EnumConstantNotPresentException。
        MyEnum.valueOf("");
    }

}

enum MyEnum {
    A, B, C;
}
