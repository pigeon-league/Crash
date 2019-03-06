package com.baymax.crash.bay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.baymax.crash.R;

public class IllegalAccessErrorActivity extends AppCompatActivity {

    private TextView exceptionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        exceptionText = findViewById(R.id.exceptionText);
        initCrash();
    }

    private void initCrash() {

    }

}

class employee{

    @SuppressWarnings("unused")
    private String sayHi(String Content){
        return "hi," + Content;
    }

    protected String sayBye(String Content){
        return "hi," + Content;
    }
}