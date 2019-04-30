package com.example.myrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    Context mContext;
    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImageTitles = new ArrayList<>();

    public RecyclerViewAdapter(Context mContext, ArrayList<String> mImages, ArrayList<String> mImageNames, ArrayList<String> mImageTitles) {
        this.mContext = mContext;
        this.mImages = mImages;
        this.mImageNames = mImageNames;
        this.mImageTitles = mImageTitles;
    }

    @Override
    public MViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem, viewGroup, false);
        MViewHolder holder = new MViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MViewHolder mViewHolder, final int i) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(i))
                .into(mViewHolder.image);

        mViewHolder.imageName.setText(mImageNames.get(i));
        mViewHolder.imageTitle.setText(mImageTitles.get(i));

        mViewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: "+mImageNames.get(i));

                Toast.makeText(mContext, mImageNames.get(i), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("image_url", mImages.get(i));
                intent.putExtra("image_name", mImageNames.get(i));
                intent.putExtra("image_title", mImageTitles.get(i));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    public class MViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView imageName;
        TextView imageTitle;
        LinearLayout parentLayout;

        public MViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            imageTitle = itemView.findViewById(R.id.image_title);
            parentLayout = itemView.findViewById(R.id.parent_layout);

        }
    }
}
