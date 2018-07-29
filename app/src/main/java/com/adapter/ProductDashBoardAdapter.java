package com.adapter;


import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.MainActivity;
import com.demo.R;
import com.fragments.DetailFragment;
import com.models.Product;
import com.squareup.picasso.Picasso;

import java.util.List;


public class ProductDashBoardAdapter extends RecyclerView.Adapter<ProductDashBoardAdapter.ViewHolder> {
    private List<Product> item;
    private MainActivity activity;

    public ProductDashBoardAdapter(MainActivity activity, List<Product> data) {
        this.item = data;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_dashboard, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        Product p = item.get(i);
        viewHolder.textViewTitle.setText(p.getArticleName());
        Picasso.get().load(p.getImage()).into(viewHolder.imageViewLogo);
        viewHolder.linearLayoutParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailFragment fragment = DetailFragment.getInstance();
                Bundle args = new Bundle();
                args.putInt(DetailFragment.ARGS_PRODUCT_INDEX, i);
                fragment.setArguments(args);
                activity.replaceFragment(R.id.fragment_container, fragment, true);
            }
        });


    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private LinearLayout linearLayoutParent;
        private ImageView imageViewLogo;

        public ViewHolder(View view) {
            super(view);
            textViewTitle = view.findViewById(R.id.textViewTitle);
            linearLayoutParent = view.findViewById(R.id.linearLayoutParent);
            imageViewLogo = view.findViewById(R.id.image);

        }
    }

}