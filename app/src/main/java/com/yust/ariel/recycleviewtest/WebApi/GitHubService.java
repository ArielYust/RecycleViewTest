package com.yust.ariel.recycleviewtest.WebApi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ariel Yust on 24-Feb-17.
 */

public interface GitHubService {
    @GET("forecast/daily")
    Call<WebApiDailyForecast> getDailyForecast(@Query("id") int id, @Query("appid") String appId);
}
