package com.baymax.crash.bay;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baymax.crash.R;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> implements View.OnClickListener{
    private String[] mDataset;

    private OnItemClickListener mOnItemClickListener = null;

    //define interface
    public static interface OnItemClickListener {
        void onItemClick(View view , int position);
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public MyViewHolder(View v) {
            super(v);
            textView = (TextView) v.findViewById(R.id.text);
        }
    }

    public recyclerAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text_view, parent, false);
        view.setOnClickListener(this);//将创建的View注册点击事件
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(mDataset[position]);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
