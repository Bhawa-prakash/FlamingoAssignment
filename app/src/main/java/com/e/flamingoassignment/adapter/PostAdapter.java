package com.e.flamingoassignment.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.e.flamingoassignment.R;
import com.e.flamingoassignment.model.Article;
import com.e.flamingoassignment.model.ModelResponse;
import com.squareup.picasso.Picasso;

import java.util.List;


public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {


    List<Article> modelResponseList;
    Context context;
    private int recycler_item;




    @NonNull
    @Override
    public PostAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_item, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    public PostAdapter(List<Article> modelResponseList, int recycler_item, Context applicationContext) {
        this.context = applicationContext;
        this.modelResponseList = modelResponseList;
        this.recycler_item = recycler_item;

    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.MyViewHolder myViewHolder, int position) {
       Article modelResponse = modelResponseList.get(position);

        myViewHolder.description.setText(modelResponse.getDescription());
        myViewHolder.title.setText(modelResponse.getTitle());
        myViewHolder.authorName.setText(modelResponse.getAuthor());
        Picasso.with(context).load(modelResponse.getUrlToImage())
                .into(myViewHolder.imageView);



    }

    @Override
    public int getItemCount() {
        return modelResponseList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView authorName,date,description,title;
        private ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            authorName = itemView.findViewById(R.id.AuthorName);
            date = itemView.findViewById(R.id.Date);
            description = itemView.findViewById(R.id.Description);
            title = itemView.findViewById(R.id.Title);
            imageView = itemView.findViewById(R.id.image_view);


        }
    }
}
