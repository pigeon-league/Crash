package com.baymax.crash.yong.charactercodingexception;

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
 * Created by cugyong on 2019/3/1.
 */

public class CharacterCodingActivity extends AppCompatActivity {

    List<String> DATA_NAME = new ArrayList<>(Arrays.asList("UTF8ToGBKActivity",
            "GBKToGB2312Activity"));
    List<Class<?>> DATA_CLASS = new ArrayList<Class<?>>(Arrays.asList(
            UTF8ToGBKActivity.class, GBKToGB2312Activity.class));

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
                Intent intent = new Intent(CharacterCodingActivity.this,
                        DATA_CLASS.get(position));
                startActivity(intent);
            }
        });
    }
}
