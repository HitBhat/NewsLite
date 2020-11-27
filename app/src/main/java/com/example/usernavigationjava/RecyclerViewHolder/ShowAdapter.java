package com.example.usernavigationjava.RecyclerViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.usernavigationjava.R;

public class ShowAdapter extends RecyclerView.ViewHolder {
    TextView news_author;
    TextView news_title;
    TextView news_description;
    TextView news_pub;
    TextView news_content;


    public ShowAdapter(@NonNull View itemView) {
        super(itemView);
        news_author = itemView.findViewById(R.id.news_author);
        news_title = itemView.findViewById(R.id.news_title);
        news_description = itemView.findViewById(R.id.news_description);
        news_pub = itemView.findViewById(R.id.news_pub);
        news_content = itemView.findViewById(R.id.news_content);
    }
}
