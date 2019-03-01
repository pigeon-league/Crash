package com.baymax.crash.yong.illegalaccessexception;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.baymax.crash.R;

import java.lang.reflect.Field;

/**
 * Created by cugyong on 2019/2/28.
 */

public class IllegalAccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_text);

        TextView describe = findViewById(R.id.tv_describe);
        describe.setText("IllegalAccessException异常一般是由于在反射时调用了私有成员所导致的, 比如：" +
                "BeanModel类有一个私有成员变量data，然后通过反射直接获取该BeanModel类的data变量时会报" +
                "IllegalAccessException异常。解决方式是在通过反射使用对象的私有成员之前调用私有成员的setAccessible(true)方法，" +
                "使得对象有权限可以访问该私有成员。");

        TextView log = findViewById(R.id.tv_log);

        try {
            String path = "com.baymax.crash.yong.illegalaccessexception.BeanModel";
            Class<?> reflectClass = Class.forName(path);
            Field field = reflectClass.getDeclaredField("data");
            String data = (String) field.get(reflectClass.newInstance());
        }catch (ClassNotFoundException e){
            log.setText(Log.getStackTraceString(e.fillInStackTrace()));
        }catch (IllegalAccessException e){
            log.setText(Log.getStackTraceString(e.fillInStackTrace()));
        }catch (InstantiationException e){
            log.setText(Log.getStackTraceString(e.fillInStackTrace()));
        }catch (NoSuchFieldException e){
            log.setText(Log.getStackTraceString(e.fillInStackTrace()));
        }

    }
}

class BeanModel {
    private String data;
}
