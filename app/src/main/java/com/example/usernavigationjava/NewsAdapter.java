package com.example.usernavigationjava;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private List<ShowNewsRecyclerView> showNewsRecyclerViews;
    private Context context;
    private AdView adView;
    private String adid = "ca-app-pub-1951128652454740~4273630544";

    public NewsAdapter(List<ShowNewsRecyclerView> showNewsRecyclerViews, Context context) {
        this.showNewsRecyclerViews = showNewsRecyclerViews;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_shown,parent,false);
        adView = view.findViewById(R.id.adView);
        MobileAds.initialize(context,adid);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

       ShowNewsRecyclerView showNewsRecyclerView = showNewsRecyclerViews.get(position);
        Glide.with(context).asBitmap().load(showNewsRecyclerView.news_image_url).into(holder.news_image);
        //holder.news_content.setText(showNewsRecyclerView.news_content);
        holder.news_pub.setText(showNewsRecyclerView.news_pub);
        holder.news_description.setText(showNewsRecyclerView.news_description);
        holder.news_content.setOnClickListener(view -> {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(showNewsRecyclerView.news_url));
                context.startActivity(intent);
        });
        holder.news_content.setText(showNewsRecyclerView.news_url);
        holder.news_title.setText(showNewsRecyclerView.news_title);
        holder.news_author.setText(showNewsRecyclerView.news_author);
    }

    @Override
    public int getItemCount() {
        return showNewsRecyclerViews.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView news_author;
        TextView  news_title;
        TextView news_description;
        TextView news_pub;
        TextView news_content;
        ImageView news_image;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            news_author = itemView.findViewById(R.id.news_author);
            news_title = itemView.findViewById(R.id.news_title);
            news_description = itemView.findViewById(R.id.news_description);
            news_pub = itemView.findViewById(R.id.news_pub);
            news_content = itemView.findViewById(R.id.news_content);
            news_image = itemView.findViewById(R.id.news_image);



        }
    }
}
