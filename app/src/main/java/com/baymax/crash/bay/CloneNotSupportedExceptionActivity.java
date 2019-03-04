package com.baymax.crash.bay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.baymax.crash.R;

public class CloneNotSupportedExceptionActivity extends AppCompatActivity implements Cloneable{

    private TextView exceptionText;
    private String content = "无论目标类是否实现了Cloneable接口，只要调用到了Object.clone()，比如通过super.clone()，那么就必须处理或者抛出CloneNotSupportedException，因为Object.clone()有throws这个异常，有抛的就必然有接的。" +
            "Object.clone()按照如下步骤执行：\n" +
            "  (1) 检查执行此方法的当前类有没有应用Clonable接口，如果没有，抛出CloneNotSupportedException异常。\n" +
            "  (2) 如果当前类有应用Clonable接口，则为当前类创建一个新对象，并将原对象中的所有字段进行一次浅层拷贝（通过赋值进行）。所以如果一个目标类应用了Clonable接口但并未重写clone()方法，它“看起来”仍然可以克隆。为什么是“看起来”下面会解释。\n" +
            "\n" +
            "3） 为什么应用了Cloneable接口的类通常还必须重写一个public的clone()方法？这里有两个原因：\n" +
            "  (1) 如果不重写，由于Object.clone()是proteced属性，所以这个clone()方法将无法在外部被调用，更精确地说，无法在目标类之外的任何地方调用。这样就使得克隆失去了用武之地。\n" +
            "  (2) Object.clone()毕竟只是提供了浅层拷贝，对于基本类型的字段，可以说它成功克隆了。但对于对象型字段，它并没有实现克隆的功能，仅仅做了一个赋值。\n\n";

    public CloneNotSupportedExceptionActivity cloned() {
        try {
            return (CloneNotSupportedExceptionActivity) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        exceptionText = findViewById(R.id.exceptionText);

        initCrash();
    }

    private void initCrash() {
        DemoThread t = new DemoThread();
        t.cloned();
        exceptionText.setText(content + t.getStackTraceString());
    }

}

class DemoThread extends Thread implements Cloneable {
    private String stackTraceString;

    public DemoThread cloned() {
        try {
            return (DemoThread) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            stackTraceString = Log.getStackTraceString(e.fillInStackTrace());
        }
        return null;
    }

    public String getStackTraceString() {
        return stackTraceString;
    }
}