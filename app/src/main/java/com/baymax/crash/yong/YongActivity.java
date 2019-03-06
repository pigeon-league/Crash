package com.baymax.crash.yong;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.baymax.crash.R;
import com.baymax.crash.yong.cameraaccessexception.CameraAccessActivity;
import com.baymax.crash.yong.charactercodingexception.CharacterCodingActivity;
import com.baymax.crash.yong.classformaterror.ClassFormatActivity;
import com.baymax.crash.yong.classnotfound.ClassNotFoundActivity;
import com.baymax.crash.yong.illegalaccessexception.IllegalAccessActivity;
import com.baymax.crash.yong.illegalargumentexception.IllegalArgActivity;
import com.baymax.crash.yong.invalidclassexception.InvalidClassActivity;
import com.baymax.crash.yong.jsonexception.JSONExceptionActivity;
import com.baymax.crash.yong.numberformatexception.NumberFormatActivity;
import com.baymax.crash.yong.resourcenotfound.ResourceNotFoundActivity;
import com.baymax.crash.yong.runtimeexception.RunTimeActivity;
import com.baymax.crash.yong.stackoverflow.StackOverflowActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cugyong on 2019/2/28.
 */

public class YongActivity extends AppCompatActivity {

    List<String> DATA_NAME = new ArrayList<>(Arrays.asList("Resources.NotFoundException",
            "InvalidClassException", "NumberFormatException", "IllegalAccessException",
            "IllegalArgumentException", "ClassNotFoundException", "CameraAccessException",
            "CharacterCodingException", "ClassFormatError", "JSONException", "RuntimeException",
            "StackOverflowError"));
    List<Class<?>> DATA_CLASS = new ArrayList<Class<?>>(Arrays.asList(
            ResourceNotFoundActivity.class, InvalidClassActivity.class, NumberFormatActivity.class,
            IllegalAccessActivity.class, IllegalArgActivity.class, ClassNotFoundActivity.class,
            CameraAccessActivity.class, CharacterCodingActivity.class, ClassFormatActivity.class,
            JSONExceptionActivity.class, RunTimeActivity.class, StackOverflowActivity.class));

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
                Intent intent = new Intent(YongActivity.this,
                        DATA_CLASS.get(position));
                startActivity(intent);
            }
        });
    }
}
