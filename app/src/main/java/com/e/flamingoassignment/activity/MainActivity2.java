package com.e.flamingoassignment.activity;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.e.flamingoassignment.R;

public class MainActivity2 extends AppCompatActivity {
    private TextView authorName1,date1,description1,title1;
    private ImageView imageView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        authorName1 = findViewById(R.id.AuthorName1);

        description1 = findViewById(R.id.Description1);
        title1 = findViewById(R.id.Title1);
        imageView1 = findViewById(R.id.image_view1);

        Bundle bundle = getIntent().getExtras();
        final String name = bundle.getString("author");
        String address = bundle.getString("des");
        String phone = bundle.getString("title");
        final String email = bundle.getString("image");

        authorName1.setText(name);
        description1.setText(address);
        title1.setText(phone);


    }
}
