package com.example.usernavigationjava.RESTinterfaces;

import com.example.usernavigationjava.apihelper.numberofobjects.News;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderIndia {


    @GET("v2/top-headlines?country=in&apiKey=bb54a5170f6147cf9ce048a8602aff2f")
    Call<News> getnewsforindia();

}
