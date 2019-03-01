package com.baymax.crash.yong.resourcenotfound;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.baymax.crash.R;

/**
 * Created by cugyong on 2019/2/28.
 */

public class Layout2IdActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout2id);

        TextView describe = findViewById(R.id.tv_describe);
        describe.setText("LayoutInflater.from(this).inflate(R.id.listview, null, false)。应该使用R.layout, 误使用R.id。编译期会在代码中提示警告。");

        TextView log = findViewById(R.id.tv_log);

        try {
            LayoutInflater.from(this).inflate(R.id.listview, null, false);
        }catch (Resources.NotFoundException e){
            log.setText(Log.getStackTraceString(e.fillInStackTrace()));
        }
    }
}
