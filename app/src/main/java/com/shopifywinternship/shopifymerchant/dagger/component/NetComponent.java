package com.shopifywinternship.shopifymerchant.dagger.component;

import com.google.gson.Gson;
import com.shopifywinternship.shopifymerchant.dagger.module.AppModule;
import com.shopifywinternship.shopifymerchant.dagger.module.NetModule;
import javax.inject.Singleton;

import agency.tango.android.avatarview.IImageLoader;
import agency.tango.android.avatarview.loader.PicassoLoader;
import dagger.Component;
import retrofit2.Retrofit;

/**
 * This Component class is a parent Component to the MainComponent class and
 * exposes the dependencies which the MainComponent and MainModule can use.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
  Retrofit retrofit();
  IImageLoader picassoLoader();
}
