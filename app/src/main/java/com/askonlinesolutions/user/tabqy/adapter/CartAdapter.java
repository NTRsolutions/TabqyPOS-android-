package com.askonlinesolutions.user.tabqy.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.askonlinesolutions.user.tabqy.R;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ProductViewHolder> {
    Activity mContext;

    public CartAdapter(Activity mCtx) {
        this.mContext = mCtx;
    }

    @NonNull
    @Override
    public CartAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.row_cartitem, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ProductViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        public ProductViewHolder(View itemView) {
            super(itemView);
        }
    }
}
