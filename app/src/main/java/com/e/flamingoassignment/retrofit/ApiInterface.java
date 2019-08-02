package com.e.flamingoassignment.retrofit;


import com.e.flamingoassignment.model.ModelResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("https://newsapi.org/v2/top-headlines?sources&apiKey")
    Call<ModelResponse> getALLDetails(@Query("techcrunch") String techcrunch, @Query("f27d3df679f64c3385dbdb7dd7969f90") String key);


}