package com.baymax.crash.bay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.baymax.crash.R;

/**
 * Created by cugyong on 2019/2/28.
 */

public class BayActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private String[] myDataset = {"DataFormatException", "EnumConstantNotPresentException", "FileNotFoundException",
                "CloneNotSupportedException", "InflateException", "BufferOverflowException",
                "NoSuchMethodException", "FileUriExposedException", "FormatException",
                "IllegalAccessError", "InterruptedException", "TimeoutException",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bay);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mAdapter = new recyclerAdapter(myDataset);
        ((recyclerAdapter) mAdapter).setOnItemClickListener(new recyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.d("leroy", position+"");
            }
        });
        recyclerView.setAdapter(mAdapter);
    }

}
