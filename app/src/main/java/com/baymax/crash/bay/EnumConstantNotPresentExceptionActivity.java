package com.baymax.crash.bay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.baymax.crash.R;

import java.lang.reflect.Method;

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
        try {
            // 1.得到枚举类对象
            Class<?> clz = ResultCode.class;
            // 2.得到所有枚举常量
            Object[] objects = clz.getEnumConstants();
            Method getCode = clz.getMethod("getCode");
            Method getName = clz.getMethod("getName");
            for (Object obj : objects) {
                // 3.调用对应方法，得到枚举常量中字段的值
                clz.getDeclaredField("");
                System.out.println("code=" + getCode.invoke(obj) + "; name=" + getName.invoke(obj));
            }
        } catch (Exception e1) {
            exceptionText.setText(Log.getStackTraceString(e1.fillInStackTrace()));
            e1.printStackTrace();
        }
    }

}

enum ResultCode {
    CODE_5200("8200", "认证失败"),
    CODE_5201("8201", "用户不存在"),
    CODE_5202("8202", "Token验证失败"),
    CODE_5203("8203", "Token刷新失败");
    private String code;
    private String name;

    private ResultCode(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}