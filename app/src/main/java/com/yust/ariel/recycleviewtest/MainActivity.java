package com.yust.ariel.recycleviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yust.ariel.recycleviewtest.WebApi.GitHubService;
import com.yust.ariel.recycleviewtest.WebApi.WebApiDailyForecast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRvForecast;
    ForecastAdapter mRvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Timber.plant(new Timber.DebugTree());
        testRetrofit();

        mRvForecast = (RecyclerView) findViewById(R.id.rvContacts);
        mRvAdapter = new ForecastAdapter(this);
        mRvForecast.setAdapter(mRvAdapter);
        mRvForecast.setLayoutManager(new LinearLayoutManager(this));
    }

    private void testRetrofit() {
        Gson gson = new GsonBuilder()//.registerTypeAdapter(null)
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://samples.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
        Call<WebApiDailyForecast> call = service.getDailyForecast(524901, "b1b15e88fa797225412429c1c50c122a1");
        call.enqueue(new Callback<WebApiDailyForecast>() {
            @Override
            public void onResponse(Call<WebApiDailyForecast> call, Response<WebApiDailyForecast> response) {
                Timber.d("onResponse", String.valueOf(response.body()));
                mRvAdapter.setForecast(response.body().getList());
                mRvForecast.scrollToPosition(mRvAdapter.getItemCount()-1);
            }

            @Override
            public void onFailure(Call<WebApiDailyForecast> call, Throwable t) {
                Timber.d("onFailure"+ String.valueOf(call));
                Timber.d("onFailure"+ String.valueOf(t));
            }
        });
    }
}
