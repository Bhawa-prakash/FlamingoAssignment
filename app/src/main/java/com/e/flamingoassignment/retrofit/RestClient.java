package com.e.flamingoassignment.retrofit;

import com.e.flamingoassignment.model.ModelResponse;

import retrofit2.Callback;

public class RestClient {
    private static final String TAG = "RestClient";

    public static void getAllDetails(String techcrunch, String key, Callback<ModelResponse> callback) {
        RetrofitClient.getClient().getALLDetails(techcrunch, key).enqueue(callback);
    }


}