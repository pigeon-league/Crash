package com.baymax.crash.bay;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.baymax.crash.R;

import java.io.File;

public class FileUriExposedExceptionActivity extends AppCompatActivity {

    private TextView exceptionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        exceptionText = findViewById(R.id.exceptionText);

        initCrash();
    }

    private void initCrash() {
        try{
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); //调用系统相机
            Uri imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(),"image.jpg"));
            //指定照片保存路径（SD卡），image.jpg为一个临时文件，每次拍照后这个图片都会被替换
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
            startActivity(intent);

            //If your targetSdkVersion is 24 or higher, we have to use FileProvider class to give access to the particular file or folder to make them accessible for other apps. We create our own class inheriting FileProvider in order to make sure our FileProvider doesn't conflict with FileProviders declared in imported dependencies as described here.
        }catch (Exception e){
            exceptionText.setText(Log.getStackTraceString(e.fillInStackTrace()));
            e.printStackTrace();
        }
    }

}