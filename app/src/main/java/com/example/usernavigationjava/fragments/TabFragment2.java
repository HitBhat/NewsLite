package com.example.usernavigationjava.fragments;


import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.usernavigationjava.IndiaNewsAdapter;
import com.example.usernavigationjava.NewsAdapter;
import com.example.usernavigationjava.R;
import com.example.usernavigationjava.ShowIndiaRecyclerView;
import com.example.usernavigationjava.ShowNewsRecyclerView;
import com.example.usernavigationjava.RESTinterfaces.JsonPlaceHolderIndia;
import com.example.usernavigationjava.apihelper.getnewsfromartilcesarrayinjson.articles;
import com.example.usernavigationjava.apihelper.numberofobjects.News;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment2 extends Fragment {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    private List<ShowIndiaRecyclerView> showIndiaRecyclerViews;
    private static String adid = "ca-app-pub-1951128652454740~4273630544";
    private AdView adView;


    public TabFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment\
        View myview  = LayoutInflater.from(getContext()).inflate(R.layout.tab_fragment2,container,false).getRootView();
        showIndiaRecyclerViews = new ArrayList<>();
        recyclerView = myview.findViewById(R.id.news_india);
        recyclerView.setHasFixedSize(true);
        ConnectivityManager connectivityManager = (ConnectivityManager) Objects.requireNonNull(getContext()).getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo == null || !networkInfo.isConnected() || !networkInfo.isAvailable()){
            Toast.makeText(getContext(),"No Internet Connection" +"\n" +"Please Reset Internet Connection" +"\n"+"And Restart Application",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getContext(),"Internet Connection is live",Toast.LENGTH_SHORT).show();
            fillthelayout();
            adView = myview.findViewById(R.id.adView);
            MobileAds.initialize(getContext(),adid);
            AdRequest adRequest = new AdRequest.Builder().build();
            adView.loadAd(adRequest);
        }
        return myview;
    }

    private void fillthelayout() {
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading News");
        progressDialog.show();
        progressDialog.setCancelable(false);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://newsapi.org/").addConverterFactory(GsonConverterFactory.create()).build();
        JsonPlaceHolderIndia jsonPlaceHolderIndia = retrofit.create(JsonPlaceHolderIndia.class);
        Call<News> newsCall = jsonPlaceHolderIndia.getnewsforindia();
        newsCall.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                Log.d("for india",response.body().toString());
                ArrayList<articles> articles = response.body().getArticlesArrayList();
                for(int i=0; i< articles.size(); i++) {
                    ShowIndiaRecyclerView showNewsRecyclerView = new ShowIndiaRecyclerView(articles.get(i).getAuthor(), articles.get(i).getTitle(),
                            articles.get(i).getDescription(), articles.get(i).getPublishedAt(), articles.get(i).getContent(), articles.get(i).getUrlToImage(), articles.get(i).getUrl());
                    showIndiaRecyclerViews.add(showNewsRecyclerView);
                }
                adapter = new IndiaNewsAdapter(showIndiaRecyclerViews,getContext());
                recyclerView.setAdapter(adapter);
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Log.d("checkforfailure",t.getLocalizedMessage());
            }
        });


    }

}
