package com.baymax.crash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.baymax.crash.bay.BayActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> DATA_NAME = new ArrayList<>(Arrays.asList("BayActivity"));
    List<Class<?>> DATA_CLASS = new ArrayList<Class<?>>(Arrays.asList(BayActivity.class));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, DATA_NAME));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,
                        DATA_CLASS.get(position));
                startActivity(intent);
            }
        });
    }
}
