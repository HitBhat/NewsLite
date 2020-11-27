package com.example.usernavigationjava.apihelper.numberofobjects;

import com.example.usernavigationjava.apihelper.getnewsfromartilcesarrayinjson.articles;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class News {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("totalResults")
    @Expose
    private String totalResults;
    @SerializedName("articles")
    @Expose
    private ArrayList<articles> articlesArrayList;

    @Override
    public String toString() {
        return "News{" +
                "status='" + status + '\'' +
                ", totalResults='" + totalResults + '\'' +
                ", articlesArrayList=" + articlesArrayList +
                '}';
    }

    public ArrayList<articles> getArticlesArrayList() {
        return articlesArrayList;
    }

    public void setArticlesArrayList(ArrayList<articles> articlesArrayList) {
        this.articlesArrayList = articlesArrayList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

//    private String author;
//    private String title;
//    private String description;
//    private String urlToImage;
//    private String publishedAt;
//    private String content;


//    public String getAuthor() {
//        return author;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//    public String getUrlToImage() {
//        return urlToImage;
//    }
//
//    public String getPublishedAt() {
//        return publishedAt;
//    }
//
//    public String getContent() {
//        return content;
//    }
}
