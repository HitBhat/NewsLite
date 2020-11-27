package com.example.woolwerin_test;

import android.util.Base64;

import com.example.woolwerin_test.model.Feed;

import org.w3c.dom.Text;

import okio.ByteString;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface API {
    String baseurl = "https://api.prokerala.com/v1/astrology/kundli-matching/";
    String token="e56769488793cea2c47c14d37a27b539af3f1710ea5b9efeec9c8c145dd59230";

    @Headers({"Content-Type:application/json","Authorization :Bearer "+ token,"Accept : application/json"})
    @GET("v1/astrology/kundli-matching")
    Call<Feed> listRepos();
}
