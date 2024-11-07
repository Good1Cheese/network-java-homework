package org.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class News {
    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("totalResult")
    @Expose
    private String totalResult;

    @SerializedName("articles")
    @Expose
    private List<Article> articles;

    public String getStatus() {
        return status;
    }

    public String getTotalResult() {
        return totalResult;
    }

    public List<Article> getArticles() {
        return articles;
    }
}
