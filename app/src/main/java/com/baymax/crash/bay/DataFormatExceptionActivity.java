package com.baymax.crash.bay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.baymax.crash.R;

import java.io.UnsupportedEncodingException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class DataFormatExceptionActivity extends AppCompatActivity {

    private TextView exceptionText;
    private String content = "压缩字符串时，在解压缩时实现会有异常，decompresser.inflate(), 需要注意解压缩时，解压数据的内容，防止数据内容不为Base64编码数据或者内容为空\n\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        exceptionText = findViewById(R.id.exceptionText);

        initCrash();
    }

    private void initCrash() {
        try {
            // Encode a String into bytes
            String inputString = "Pehla nasha Pehla khumaar Naya pyaar hai naya intezaar Kar loon main kya apna haal Aye dil-e-bekaraar Mere dil-e-bekaraar Tu hi bata Pehla nasha Pehla khumaar Udta hi firoon in hawaon mein kahin Ya main jhool jaoon in ghataon mein kahin Udta hi firoon in hawaon mein kahin Ya main jhool jaoon in ghataon mein kahin Ek kar doon aasmaan zameen Kaho yaaron kya karoon kya nahin Pehla nasha Pehla khumaar Naya pyaar hai naya intezaar Kar loon main kya apna haal Aye dil-e-bekaraar Mere dil-e-bekaraar Tu hi bata Pehla nasha Pehla khumaar Usne baat ki kuchh aise dhang se Sapne de gaya vo hazaaron range ke Usne baat ki kuchh aise dhang se Sapne de gaya vo hazaaron range ke Reh jaoon jaise main haar ke Aur choome vo mujhe pyaar se Pehla nasha Pehla khumaar Naya pyaar hai naya intezaar Kar loon main kya apna haal Aye dil-e-bekaraar Mere dil-e-bekaraar";
            byte[] input = inputString.getBytes("UTF-8");


            // Compress the bytes
            byte[] output1 = new byte[input.length];
            Deflater compresser = new Deflater();
            compresser.setInput(input);
            compresser.finish();
            int compressedDataLength = compresser.deflate(output1);
            compresser.end();
            Log.d("leroy", "Deflated String:" + new String(output1));

            String str = new String(output1);
            byte output2[] = str.getBytes("UTF-8");

            // Decompress the bytes
            Inflater decompresser = new Inflater();
            decompresser.setInput(output2);
            byte[] result = new byte[10000];
            int resultLength = decompresser.inflate(result);//注意 这里 解压缩实现会有异常
            decompresser.end();

            // Decode the bytes into a String
            String outputString = new String(result, 0, resultLength, "UTF-8");
            Log.d("leroy", "Deflated String:" + outputString);

//                    String inputString = "Pehla nasha Pehla khumaar Naya pyaar hai naya intezaar Kar loon main kya apna haal Aye dil-e-bekaraar Mere dil-e-bekaraar Tu hi bata Pehla nasha Pehla khumaar Udta hi firoon in hawaon mein kahin Ya main jhool jaoon in ghataon mein kahin Udta hi firoon in hawaon mein kahin Ya main jhool jaoon in ghataon mein kahin Ek kar doon aasmaan zameen Kaho yaaron kya karoon kya nahin Pehla nasha Pehla khumaar Naya pyaar hai naya intezaar Kar loon main kya apna haal Aye dil-e-bekaraar Mere dil-e-bekaraar Tu hi bata Pehla nasha Pehla khumaar Usne baat ki kuchh aise dhang se Sapne de gaya vo hazaaron range ke Usne baat ki kuchh aise dhang se Sapne de gaya vo hazaaron range ke Reh jaoon jaise main haar ke Aur choome vo mujhe pyaar se Pehla nasha Pehla khumaar Naya pyaar hai naya intezaar Kar loon main kya apna haal Aye dil-e-bekaraar Mere dil-e-bekaraar";
//                    byte[] input = inputString.getBytes("UTF-8");
//
//                    // Compress the bytes
//                    byte[] output1 = new byte[input.length];
//                    Deflater compresser = new Deflater();
//                    compresser.setInput(input);
//                    compresser.finish();
//                    int compressedDataLength = compresser.deflate(output1);
//                    compresser.end();
//
//                    String str = Base64.encode(output1);
//                    System.out.println("Deflated String:" + str);
//
//                    byte[] output2 = Base64.decode(str);
//
//                    // Decompress the bytes
//                    Inflater decompresser = new Inflater();
//                    decompresser.setInput(output2);
//                    byte[] result = str.getBytes();
//                    int resultLength = decompresser.inflate(result);
//                    decompresser.end();
//
//                    // Decode the bytes into a String
//                    String outputString = new String(result, 0, resultLength, "UTF-8");
//                    System.out.println("Deflated String:" + outputString);
        } catch (UnsupportedEncodingException e) {
            exceptionText.setText(content + Log.getStackTraceString(e.fillInStackTrace()));
            e.printStackTrace();
        } catch (java.util.zip.DataFormatException e) {
            exceptionText.setText(content + Log.getStackTraceString(e.fillInStackTrace()));
            e.printStackTrace();
        }
    }

}
