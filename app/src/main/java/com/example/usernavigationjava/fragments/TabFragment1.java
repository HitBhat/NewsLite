package com.example.usernavigationjava.fragments;


import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.usernavigationjava.NewsAdapter;
import com.example.usernavigationjava.ShowNewsRecyclerView;
import com.example.usernavigationjava.RESTinterfaces.JSONPlaceHolder;
import com.example.usernavigationjava.apihelper.numberofobjects.News;
import com.example.usernavigationjava.R;
import com.example.usernavigationjava.apihelper.getnewsfromartilcesarrayinjson.articles;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
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
public class TabFragment1 extends Fragment {
    private List<ShowNewsRecyclerView> showNewsRecyclerViews;
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    private static String adid = "ca-app-pub-1951128652454740~4273630544";
    private AdView adView;

    private TextView checkcon ;
    public TabFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myview  = LayoutInflater.from(getContext()).inflate(R.layout.tab_fragment1,container,false).getRootView();
        System.out.println("inside");
        //checkcon = myview.findViewById(R.id.checkingtheconnection);
        recyclerView = myview.findViewById(R.id.recycler_shownews);
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
            adView.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    Log.d("onadloaded","googto");
                }
                @Override
                public void onAdFailedToLoad(int errorCode) {
                    Log.d("onadfailed","errorcode"+errorCode);
                }
            });
        }




//        recyclerView.setAdapter(adapter);
//        Call<List<News>> call = jsonPlaceHolder.getnews();
//        System.out.println("call"+call);
//        call.enqueue(new Callback<List<News>>() {
//            @SuppressLint("SetTextI18n")
//            @Override
//            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
//                if(!response.isSuccessful()){
//                    checkcon.setText("code"+response.code());
//                }
//                else{
//
//                    System.out.println("news"+response.raw());
//                    List<News> news = response.body();
//                    System.out.println("news"+news.size());
//                    for (News news1 :news){
//                        String content = "";
//                        content += "Author" + news1.getAuthor() + "\n"+ "DESCRIPTION"+news1.getDescription()+"\n"+"TITLE"+news1.getTitle()+"\n"+"URLTOIMAGE"+news1.getUrlToImage()
//                                +"\n"+"PUBLISHED AT"+news1.getPublishedAt()+"\n"+"CONTENT"+news1.getContent()+"\n\n";
//                        checkcon.append(content);
//                    }
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<List<News>> call, Throwable t) {
//                checkcon.setText(t.getLocalizedMessage());
//            }
//        });
        return myview;

    }



    private void fillthelayout() {
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading News");
        progressDialog.show();
        progressDialog.setCancelable(false);
        showNewsRecyclerViews = new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://newsapi.org/").addConverterFactory(GsonConverterFactory.create()).build();
        JSONPlaceHolder jsonPlaceHolder= retrofit.create(JSONPlaceHolder.class);
        Call<News> call = jsonPlaceHolder.getnews();
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                Log.d("received info",response.body().toString());
                ArrayList<articles> articles = response.body().getArticlesArrayList();
                for(int i=0; i< articles.size(); i++){
                    ShowNewsRecyclerView newsRecyclerView = new ShowNewsRecyclerView(articles.get(i).getAuthor(),articles.get(i).getTitle(),
                            articles.get(i).getDescription(),articles.get(i).getPublishedAt(),articles.get(i).getContent(),articles.get(i).getUrlToImage(),articles.get(i).getUrl());
                    showNewsRecyclerViews.add(newsRecyclerView);
//                    String content = "";
//
//                        content += "Author" + articles.get(i).getAuthor() + "\n"+ "DESCRIPTION"+articles.get(i).getDescription()+"\n"+"TITLE"+articles.get(i).getTitle()+"\n"+"URLTOIMAGE"+articles.get(i).getUrlToImage()
//                                +"\n"+"PUBLISHED AT"+articles.get(i).getPublishedAt()+"\n"+"CONTENT"+articles.get(i).getContent()
//                                +"----------------------------------------------------------------"
//                                +"\n\n\n";
//
//                       checkcon.append(content);
                }
                adapter = new NewsAdapter(showNewsRecyclerViews,getContext());
                recyclerView.setAdapter(adapter);
                progressDialog.dismiss();

            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                checkcon.setText(t.getLocalizedMessage());
            }
        });
//
    }



}
