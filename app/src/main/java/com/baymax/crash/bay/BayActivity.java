package com.baymax.crash.bay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
                switch (position){
                    case 0:
                        startActivity(new Intent(BayActivity.this, DataFormatExceptionActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(BayActivity.this, EnumConstantNotPresentExceptionActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(BayActivity.this, FileNotFoundExceptionActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(BayActivity.this, CloneNotSupportedExceptionActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(BayActivity.this, InflateExceptionActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(BayActivity.this, BufferOverflowExceptionActivity.class));
                        break;
                    case 6:
                        startActivity(new Intent(BayActivity.this, NoSuchMethodExceptionActivity.class));
                        break;
                    case 7:
                        startActivity(new Intent(BayActivity.this, FileUriExposedExceptionActivity.class));
                        break;
                    case 8:
                        startActivity(new Intent(BayActivity.this, FormatExceptionActivity.class));
                        break;
                    case 9:
                        startActivity(new Intent(BayActivity.this, IllegalAccessErrorActivity.class));
                        break;
                    case 10:
                        startActivity(new Intent(BayActivity.this, InterruptedExceptionActivity.class));
                        break;
                    case 11:
                        startActivity(new Intent(BayActivity.this, TimeoutExceptionActivity.class));
                        break;

                }
            }
        });
        recyclerView.setAdapter(mAdapter);
    }

}
