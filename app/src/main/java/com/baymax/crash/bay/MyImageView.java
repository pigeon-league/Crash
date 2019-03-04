package com.baymax.crash.bay;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

public class MyImageView extends ImageView {


    public MyImageView(Context context) {
        super(context);
    }

    public MyImageView(Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    public MyImageView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyImageView(Context context,  AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        canvas.save();
        canvas.rotate(45, 0, 0);
        super.onDraw(canvas);
        canvas.restore();
    }
}
