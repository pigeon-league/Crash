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

public class UTF8ToGBKActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_text);

        TextView describe = findViewById(R.id.tv_describe);
        describe.setText("CharacterCodingException有两个子类：\n" +
                "1、MalformedInputException；\n 2、UnmappableCharacterException；\n" +
                "MalformedInputException是因为\"半个中文问题\"，UTF-8编码一个中文占3个字节，" +
                "而GBK编码一个中文占2个字节。当先用UTF-8把奇数个中文转换为字节数组时，" +
                "再使用GBK对该字节数组编码时，因为转换的中文字节个数不是2的倍数，" +
                "就会出现问题。所以代码中要保持编码一致。");

        TextView log = findViewById(R.id.tv_log);

        String str = "123汉";//测试报文为部分内容
        ByteBuffer byteBuffe = null;
        try {
            byteBuffe = ByteBuffer.wrap(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {

        }
        Charset charset = Charset.forName("GBK");
        // 创建解码器
        CharsetDecoder charsetDecoder = charset.newDecoder();
        // 将ByteBuffer的内容转码
        try {
            CharBuffer charBuffer = charsetDecoder.decode(byteBuffe);
        }catch (CharacterCodingException e){
            log.setText(Log.getStackTraceString(e.fillInStackTrace()));
        }
    }
}
