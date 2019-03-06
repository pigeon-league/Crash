package com.baymax.crash.yong.stackoverflow;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.baymax.crash.R;

/**
 * Created by cugyong on 2019/3/6.
 */

public class MutualReferenceActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_text);

        TextView describe = findViewById(R.id.tv_describe);
        describe.setText("当对象之间相互引用且循环实例化，会导致堆栈溢出。");

        TextView log = findViewById(R.id.tv_log);

        try {
            A obj = new A();
        }catch (StackOverflowError e){
            log.setText(Log.getStackTraceString(e.fillInStackTrace()));
        }

    }

    class A {
        private int aValue;
        private B bInstance = null;

        public A() {
            aValue = 0;
            bInstance = new B();
        }

        @Override
        public String toString() {
            return "";
        }
    }

    class B {
        private int bValue;
        private A aInstance = null;

        public B() {
            bValue = 10;
            aInstance = new A();
        }

        @Override
        public String toString() {
            return "";
        }
    }
}
