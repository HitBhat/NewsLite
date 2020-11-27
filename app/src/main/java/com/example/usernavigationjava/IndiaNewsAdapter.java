package com.example.usernavigationjava;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

public class IndiaNewsAdapter extends RecyclerView.Adapter<IndiaNewsAdapter.ViewHolderIndia> {

    private List<ShowIndiaRecyclerView> showIndiaRecyclerViewList;
    private Context context;
    private String adid = "ca-app-pub-1951128652454740~4273630544";


    public IndiaNewsAdapter(List<ShowIndiaRecyclerView> showIndiaRecyclerViews, Context context){
        this.showIndiaRecyclerViewList = showIndiaRecyclerViews;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolderIndia onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_for_india,parent,false);
        return new IndiaNewsAdapter.ViewHolderIndia(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderIndia holder, int position) {
        ShowIndiaRecyclerView showIndiaRecyclerView = showIndiaRecyclerViewList.get(position);
        Glide.with(context).asBitmap().load(showIndiaRecyclerView.news_image_url_india).into(holder.news_image_india);
        holder.news_pub_india.setText(showIndiaRecyclerView.news_pub_india);
        holder.news_description_india.setText(showIndiaRecyclerView.news_description_india);
        holder.news_content_india.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse(showIndiaRecyclerView.news_url_india));
            context.startActivity(intent);
        });
        holder.news_content_india.setText(showIndiaRecyclerView.news_url_india);
        holder.news_title_india.setText(showIndiaRecyclerView.news_title_india);
        holder.news_author_india.setText(showIndiaRecyclerView.news_author_india);
        MobileAds.initialize(context,adid);
        AdRequest adRequest = new AdRequest.Builder().build();
        holder.adView.loadAd(adRequest);



    }

    @Override
    public int getItemCount() {
        return showIndiaRecyclerViewList.size();
    }

    public class ViewHolderIndia extends RecyclerView.ViewHolder{
        TextView news_author_india;
        TextView  news_title_india;
        TextView news_description_india;
        TextView news_pub_india;
        TextView news_content_india;
        ImageView news_image_india;
        AdView adView;

        public ViewHolderIndia(@NonNull View itemView) {
            super(itemView);
            news_author_india = itemView.findViewById(R.id.news_author_india);
            news_title_india = itemView.findViewById(R.id.news_title_india);
            news_description_india = itemView.findViewById(R.id.news_description_india);
            news_pub_india = itemView.findViewById(R.id.news_pub_india);
            news_content_india = itemView.findViewById(R.id.news_content_india);
            news_image_india = itemView.findViewById(R.id.news_image_india);
            adView = itemView.findViewById(R.id.adView);


        }
    }





}
