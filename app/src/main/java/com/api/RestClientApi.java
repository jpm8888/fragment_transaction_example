package com.api;

import android.content.Context;

import com.demo.R;
import com.utils.CheckNetwork;
import com.utils.Constants;
import com.utils.DialogUtility;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RestClientApi {
    private static final String BASE_URL = Constants.BASE_URL;
    private InterfaceApi apiService;

    public RestClientApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(InterfaceApi.class);
    }

    public InterfaceApi getApiService(Context context) {
        if (!CheckNetwork.isNetworkAvailable(context)) {
            final String title = context.getString(R.string.error_title);
            final String msg = context.getString(R.string.error_no_network);
            DialogUtility.showDialog(title, msg, context);
            return apiService;
        }
        return apiService;
    }
}