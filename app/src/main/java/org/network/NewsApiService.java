package org.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApiService {

    @GET("v2/top-headlines")
    Call<News> load(@Query("country") String country, @Query("apiKey") String apiKey);
}