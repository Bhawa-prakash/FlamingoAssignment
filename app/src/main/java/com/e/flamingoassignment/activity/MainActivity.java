package com.e.flamingoassignment.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;

import com.e.flamingoassignment.R;
import com.e.flamingoassignment.adapter.PostAdapter;
import com.e.flamingoassignment.model.Article;
import com.e.flamingoassignment.model.ModelResponse;
import com.e.flamingoassignment.retrofit.RestClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class MainActivity extends AppCompatActivity {
    String sources = "techcrunch";
    String apiKey = "f27d3df679f64c3385dbdb7dd7969f90";
    PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RestClient.getAllDetails(sources, apiKey, new Callback<ModelResponse>() {
            @Override
            public void onResponse(Call<ModelResponse> call, Response<ModelResponse> response) {

                if(response != null){
                    if(response.body().getArticles() != null){
                        final List<Article>articles = response.body().getArticles();




                            postAdapter= new PostAdapter(articles, R.layout.recycler_item, getApplicationContext());
                            postAdapter.setSellingListInterface(new PostAdapter.SellingListInterface() {
                                @Override
                                public void sellinglistitem(String id) {
                                    Intent i = new Intent(MainActivity.this,MainActivity2.class);
                                    i.addFlags(FLAG_ACTIVITY_NEW_TASK);
                                    for(int j = 0; j<=10;j++)
                                    i.putExtra("author", articles.get(0).getAuthor());
                                    i.putExtra("des", articles.get(0).getDescription());
                                    i.putExtra("title", articles.get(0).getTitle());
                                    i.putExtra("image", articles.get(0).getUrlToImage());
                                    startActivity(i);

                                }

                                @Override
                                public void sellinglistitemSeeAll(String id) {
                                    Intent i = new Intent(MainActivity.this,MainActivity2.class);
                                    i.addFlags(FLAG_ACTIVITY_NEW_TASK);
                                    i.putExtra("author", articles.get(0).getAuthor());
                                    i.putExtra("des", articles.get(0).getDescription());
                                    i.putExtra("title", articles.get(0).getTitle());
                                    i.putExtra("image", articles.get(0).getUrlToImage());
                                    startActivity(i);
                                }
                            });

                        recyclerView.setAdapter(postAdapter);

                    }


                }

            }

            @Override
            public void onFailure(Call<ModelResponse> call, Throwable t) {

            }
        });
    }
}
