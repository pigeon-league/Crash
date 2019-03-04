package com.baymax.crash.yong.jsonexception;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.baymax.crash.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by cugyong on 2019/3/4.
 */

public class JSONExceptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_text);

        TextView describe = findViewById(R.id.tv_describe);
        describe.setText("JSONException出错的原因是：因为JSON数据格式有问题" +
                "导致解析JSON数据出错。");

        TextView log = findViewById(R.id.tv_log);

        try {
            String json = "{\"status\":1,\"page\":1,\"perpage\":20,\"timeline\":[{\"msg\":\"Haha1\",\"phone_md5\":\"dasdasdbkas\",\"msgId\":\"1231234\"},{\"msg\":\"Haha8\",\"phone_md5\":\"dasdasdbkas\",\"msgId\":\"1231234\"}]}";
            JSONObject obj = new JSONObject(json);
            JSONArray msgJsonArray = obj.getJSONArray("items");
        }catch (JSONException e){
            log.setText(Log.getStackTraceString(e.fillInStackTrace()));
        }

    }
}
