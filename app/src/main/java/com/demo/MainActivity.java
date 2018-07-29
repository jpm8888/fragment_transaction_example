package com.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.api.RestClientApi;
import com.fragments.MainFragment;
import com.models.ModelProducts;
import com.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends BaseActivity {


    private List<Product> items = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        hitApi();
    }

    public List<Product> getItems() {
        return items;
    }

    private void hitApi() {
        mProgressDialog.show();

        new RestClientApi().getApiService(this).getProducts().enqueue(new Callback<ModelProducts>() {
            @Override
            public void onResponse(Call<ModelProducts> call, Response<ModelProducts> response) {
                mProgressDialog.dismiss();
                ModelProducts modelProducts = response.body();
                if (modelProducts == null) return;
                items = response.body().getProducts();


                MainFragment mainFragment = MainFragment.getInstance();
                addFragment(R.id.fragment_container, mainFragment, false);
            }

            @Override
            public void onFailure(Call<ModelProducts> call, Throwable t) {
                mProgressDialog.dismiss();
            }
        });
    }


    public void addFragment(int containerViewId, Fragment fragment, boolean addTobackstack) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(containerViewId, fragment);
        if (addTobackstack) ft.addToBackStack(null);
        ft.commit();
    }

    public void removeFragment(int containerViewId) {
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(containerViewId);
        FragmentTransaction ft = fm.beginTransaction();
        ft.remove(fragment);
        ft.commit();
    }

    public void replaceFragment(int containerViewId, Fragment fragment, boolean addTobackstack) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        if (addTobackstack) ft.addToBackStack(null);
        ft.replace(containerViewId, fragment);
        ft.commit();
    }

}