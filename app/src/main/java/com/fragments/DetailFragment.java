package com.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.MainActivity;
import com.demo.R;
import com.models.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailFragment extends Fragment {

    public static final String ARGS_PRODUCT_INDEX = "args_prod_index";
    private static DetailFragment instance = null;
    private TextView article_name, price, short_desc;
    private ImageView imageView;

    private int productIndex = 0;


    public static DetailFragment getInstance() {
        if (instance == null) {
            instance = new DetailFragment();
        }
        return instance;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            productIndex = bundle.getInt(ARGS_PRODUCT_INDEX);

            List<Product> products = ((MainActivity) getActivity()).getItems();
            Product p = products.get(productIndex);

            article_name.setText(p.getArticleName());
            price.setText(p.getPrice());
            short_desc.setText(p.getShortDesc());
            Picasso.get().load(p.getImage()).into(imageView);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        article_name = (TextView) view.findViewById(R.id.article_name);
        price = (TextView) view.findViewById(R.id.price);
        short_desc = (TextView) view.findViewById(R.id.short_desc);
        imageView = (ImageView) view.findViewById(R.id.image);

        view.findViewById(R.id.addToCart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Add to Card clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


}
