package com.shopifywinternship.shopifymerchant.dagger.module;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by warefhaque on 8/23/17.
 */

@Module
public class NetModule {

  String mBaseUrl = "https://shopicruit.myshopify.com/admin/";

  @Provides
  @Singleton
  Gson providesGson() {
    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
    return gsonBuilder.create();
  }

  @Provides
  @Singleton
  OkHttpClient providesOkHttpClient() {
    return new OkHttpClient();
  }

  @Provides
  @Singleton
  Retrofit providesRetrofit(Gson gson, OkHttpClient okHttpClient) {
    return new Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .baseUrl(mBaseUrl)
        .client(okHttpClient)
        .build();
  }
}
