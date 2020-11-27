package com.example.usernavigationjava;

import android.widget.TextView;

public class ShowNewsRecyclerView {

    String news_author;
    String  news_title;
    String news_description;
    String news_pub;
    String news_content;
    String news_image_url;
    String news_url;

    public ShowNewsRecyclerView(String news_author, String news_title, String news_description, String news_pub, String news_content,String news_image_url,String news_url) {
        this.news_author = news_author;
        this.news_title = news_title;
        this.news_description = news_description;
        this.news_pub = news_pub;
        this.news_content = news_content;
        this.news_image_url = news_image_url;
        this.news_url = news_url;
    }

    public String getNews_author() {
        return news_author;
    }

    public String getNews_title() {
        return news_title;
    }

    public String getNews_description() {
        return news_description;
    }

    public String getNews_pub() {
        return news_pub;
    }

    public String getNews_content() {
        return news_content;
    }

    public String getNews_image_url() {
        return news_image_url;
    }
}
