package com.example.myrecyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private static final String TAG = "DetailActivity";

    //vars
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Log.d(TAG, "onCreate: started.");

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intent.");

        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name") && getIntent().hasExtra("image_title")){
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");
            String imageTitle = getIntent().getStringExtra("image_title");

            bindData(imageUrl, imageName, imageTitle);
        }
    }

    private void bindData(String imageUrl, String imageName,String imageTitle){
        Log.d(TAG, "bindData: setting data to widgets.");

        ImageView image = findViewById(R.id.image);
        TextView name = findViewById(R.id.image_name);
        TextView title = findViewById(R.id.image_title);

        name.setText(imageName);
        title.setText(imageTitle);

        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);
    }
}
