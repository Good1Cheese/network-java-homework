package org.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller implements Callback<News> {

    static final String BASE_URL = "https://newsapi.org/";

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        NewsApiService NewsApiService = retrofit.create(NewsApiService.class);

        Call<News> call = NewsApiService.load("us", "API_KEY");
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<News> call, Response<News> response) {
        if (!response.isSuccessful()) {
            System.out.println(response.errorBody());
            return;
        }

        var list = response.body();
        for (Article article : list.getArticles()) {
            System.out.println(article.toString());
        }
    }

    @Override
    public void onFailure(Call<News> call, Throwable t) {
        t.printStackTrace();
    }
}