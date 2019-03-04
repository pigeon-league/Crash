package com.baymax.crash.bay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.baymax.crash.R;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class NoSuchMethodExceptionActivity extends AppCompatActivity {

    private TextView exceptionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        exceptionText = findViewById(R.id.exceptionText);
        initCrash();
    }

    private void initCrash() {
        executeMethod1();

//        //getMethod只能调用public声明的方法，而getDeclaredMethod基本可以调用任何类型声明的方法
//        try {
//            executeMethod(Math.class, "max", new Integer[]{1, 2}, // Cannot be int array, but we have auto unboxing.
//                    new Class[]{Integer.class, Integer.class});
//
////            Math.max对int，long，float和double有4个重载。所有这些都是原始类型。例如，如果要获取int重载，则需要使用int.class而不是Integer.class，否则会得到NoSuchMethodException，因为签名不匹配。
////            executeMethod(Math.class, "max", new Integer[]{1, 2}, // Cannot be int array, but we have auto unboxing.
////                    new Class[]{int.class, int.class});
//        } catch (Exception e1) {
//            exceptionText.setText(Log.getStackTraceString(e1.fillInStackTrace()));
//            e1.printStackTrace();
//        }
    }

    private void executeMethod(Class cls, String methodName, Object[] params, Class[] paramTypes) throws NoSuchMethodException {
        Method m = cls.getDeclaredMethod(methodName, paramTypes);
        try {
            m.invoke(null, params);
        } catch (IllegalAccessException | InvocationTargetException e) {
            exceptionText.setText(Log.getStackTraceString(e.fillInStackTrace()));
            e.printStackTrace();
        }
    }

    private void executeMethod1(){
        try {
            Class<client> clz=client.class;
            client obj=(client)clz.newInstance();
            Method target = clz.getMethod("say", String.class);
            target.setAccessible(true);
            target.invoke(obj, "I am Caomr");
        } catch (Exception e1) {
            exceptionText.setText(Log.getStackTraceString(e1.fillInStackTrace()));
            e1.printStackTrace();
        }
    }

}

class client{

    @SuppressWarnings("unused")
    private String say(String Content){
        return "hi," + Content;
    }

    public String show(String Content){
        return "hi," + Content;
    }
}
