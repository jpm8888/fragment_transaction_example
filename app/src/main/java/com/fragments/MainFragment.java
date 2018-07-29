package com.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adapter.ProductDashBoardAdapter;
import com.demo.MainActivity;
import com.demo.R;
import com.models.Product;

import java.util.List;


public class MainFragment extends Fragment {
    private static MainFragment instance = null;
    private ProductDashBoardAdapter adapter;
    private RecyclerView recyclerView;

    public static MainFragment getInstance() {
        if (instance == null) instance = new MainFragment();
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewList);
        initViews();
        return view;
    }

    private void initViews() {
        List<Product> items = ((MainActivity) getActivity()).getItems();
        if (items == null) return;
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ProductDashBoardAdapter((MainActivity) getActivity(), items);
        recyclerView.setAdapter(adapter);
    }
}
