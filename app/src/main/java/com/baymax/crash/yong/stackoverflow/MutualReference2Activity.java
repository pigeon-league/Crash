package com.baymax.crash.yong.stackoverflow;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.baymax.crash.R;

/**
 * Created by cugyong on 2019/3/6.
 */

public class MutualReference2Activity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_text);

        TextView describe = findViewById(R.id.tv_describe);
        describe.setText("当对象之间相互引用且输出对象时相互调用，会导致堆栈溢出。");

        TextView log = findViewById(R.id.tv_log);

        try {
            A objA = new A();
            B objB = new B();
            objA.setbInstance(objB);
            objB.setaInstance(objA);
            objA.toString();
        }catch (StackOverflowError e){
            log.setText(Log.getStackTraceString(e.fillInStackTrace()));
        }

    }

    class A {
        private int aValue;
        private B bInstance = null;

        public A() {
            aValue = 0;
        }

        public void setbInstance(B bInstance) {
            this.bInstance = bInstance;
        }

        @Override
        public String toString() {
            return aValue + " " + bInstance;
        }
    }

    class B {
        private int bValue;
        private A aInstance = null;

        public B() {
            bValue = 10;
        }

        public void setaInstance(A aInstance) {
            this.aInstance = aInstance;
        }

        @Override
        public String toString() {
            return bValue + " " + aInstance;
        }
    }
}
