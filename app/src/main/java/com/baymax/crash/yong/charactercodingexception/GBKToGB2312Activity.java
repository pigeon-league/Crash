package com.baymax.crash.yong.charactercodingexception;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.baymax.crash.R;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * Created by cugyong on 2019/3/1.
 */

public class GBKToGB2312Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_text);

        TextView describe = findViewById(R.id.tv_describe);
        describe.setText("CharacterCodingException有两个子类：\n" +
                "1、MalformedInputException；\n 2、UnmappableCharacterException；\n" +
                "");

        TextView log = findViewById(R.id.tv_log);

        String str = "喆";//测试报文为部分内容
        ByteBuffer byteBuffer = null;
        CharBuffer charBuffer;
        Charset charset = Charset.forName("GBK");
        // 创建编码器
        CharsetEncoder charsetEncoder  = charset.newEncoder();
        try {
            charBuffer = CharBuffer.wrap(str.toCharArray());
            byteBuffer = charsetEncoder.encode(charBuffer);
        }catch (CharacterCodingException e){
            log.setText(Log.getStackTraceString(e.fillInStackTrace()));
        }

        charset = Charset.forName("GB2312");
        CharsetDecoder charsetDecoder  = charset.newDecoder();
        try {
            charBuffer = charsetDecoder.decode(byteBuffer);
        }catch (CharacterCodingException e){
            log.setText(Log.getStackTraceString(e.fillInStackTrace()));
        }
    }
}
