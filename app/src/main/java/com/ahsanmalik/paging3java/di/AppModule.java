package com.ahsanmalik.paging3java.di;


import com.ahsanmalik.paging3java.data.ApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.guava.GuavaCallAdapterFactory;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    static final String url = "https://api.stackexchange.com/2.2/";

    @Provides
    @Singleton
    public static ApiService provideApiService(){
        return new Retrofit.Builder().baseUrl(url)
                .client(new OkHttpClient.Builder().addInterceptor(
                        new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build())
                .addCallAdapterFactory(GuavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(ApiService.class);
    }

}
