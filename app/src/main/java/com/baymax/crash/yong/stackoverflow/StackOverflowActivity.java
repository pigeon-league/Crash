package com.baymax.crash.yong.stackoverflow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.baymax.crash.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cugyong on 2019/3/6.
 */

public class StackOverflowActivity extends AppCompatActivity {

    List<String> DATA_NAME = new ArrayList<>(Arrays.asList("RecursionActivity",
            "MutualReferenceActivity", "MutualReference2Activity"));
    List<Class<?>> DATA_CLASS = new ArrayList<Class<?>>(Arrays.asList(
            RecursionActivity.class, MutualReferenceActivity.class, MutualReference2Activity.class));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yong);

        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, DATA_NAME));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(StackOverflowActivity.this,
                        DATA_CLASS.get(position));
                startActivity(intent);
            }
        });
    }
}
