package com.pos.user.tabqy.adapter;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pos.user.tabqy.R;

import java.util.ArrayList;

public class AdapterWalkinDraggedItems extends RecyclerView.Adapter<AdapterWalkinDraggedItems.MyViewHolder> {


    private int size;
    public AdapterWalkinDraggedItems(int size){

        Log.d("MySize", size + "");
        this.size = size;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{


        public MyViewHolder(View view) {
            super(view);

        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_walkin_list_dragged_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return size;
    }

}