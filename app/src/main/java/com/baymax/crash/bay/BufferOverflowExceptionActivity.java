package com.baymax.crash.bay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.baymax.crash.R;

import java.nio.ByteBuffer;

public class BufferOverflowExceptionActivity extends AppCompatActivity {

    private TextView exceptionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        exceptionText = findViewById(R.id.exceptionText);

        initCrash();
    }

    private void initCrash() {
        //写入的长度超出了允许的长度：
        try {
            byte arr[] = ByteBuffer.allocate(2).putInt(1).array();

//                    public abstract ByteBuffer putInt(int value)
//                    Relative put method for writing an int value  (optional operation).
//                    Writes four bytes containing the given int value, in the current byte order, into this buffer at the current position, and then increments the position by four.
//
//                    Parameters:
//                    value - The int value to be written
//                    Returns:
//                    This buffer
//                    Throws:
//                    BufferOverflowException - If there are fewer than four bytes remaining in this buffer
//                    ReadOnlyBufferException - If this buffer is read-only

//                    byte arr[] = ByteBuffer.allocate(4).putInt(1).array();
        } catch (Exception e1) {
            exceptionText.setText(Log.getStackTraceString(e1.fillInStackTrace()));
            e1.printStackTrace();
        }

    }

}