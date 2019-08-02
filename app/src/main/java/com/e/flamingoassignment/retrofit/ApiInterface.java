package com.e.flamingoassignment.retrofit;


import com.e.flamingoassignment.model.ModelResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("top-headlines")
    Call<ModelResponse> getALLDetails(@Query("sources") String techcrunch, @Query("apiKey") String key);


}