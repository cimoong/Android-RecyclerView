package com.example.myrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    
    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mTitles = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");
        
        initImageBitmaps();
    }
    
    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/Presiden_Sukarno.jpg/418px-Presiden_Sukarno.jpg");
        mNames.add("Soekarno");
        mTitles.add("Presiden Pertama RI");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/President_Suharto%2C_1993.jpg/468px-President_Suharto%2C_1993.jpg");
        mNames.add("Soeharto");
        mTitles.add("Presiden Kedua RI");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/9/95/Foto_Presiden_Habibie_1998.jpg/491px-Foto_Presiden_Habibie_1998.jpg");
        mNames.add("Bacharuddin Jusuf Habibie");
        mTitles.add("Presiden Ketiga RI");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/President_Abdurrahman_Wahid_-_Indonesia.jpg/486px-President_Abdurrahman_Wahid_-_Indonesia.jpg");
        mNames.add("Abdurrahman Wahid");
        mTitles.add("Presiden Keempat RI");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/President_Megawati_Sukarnoputri_-_Indonesia.jpg/540px-President_Megawati_Sukarnoputri_-_Indonesia.jpg");
        mNames.add("Megawati Soekarnoputri");
        mTitles.add("Presiden Kelima RI");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/5/58/Presiden_Susilo_Bambang_Yudhoyono.png");
        mNames.add("Susilo Bambang Yudhoyono");
        mTitles.add("Presiden Keenam RI");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/Joko_Widodo_2014_official_portrait.jpg/478px-Joko_Widodo_2014_official_portrait.jpg");
        mNames.add("Joko Widodo");
        mTitles.add("Presiden Ketujuh RI");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mImageUrls, mNames, mTitles);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
