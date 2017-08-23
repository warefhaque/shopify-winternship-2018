package com.shopifywinternship.shopifymerchant.dagger.component;

import com.google.gson.Gson;
import com.shopifywinternship.shopifymerchant.dagger.module.AppModule;
import com.shopifywinternship.shopifymerchant.dagger.module.NetModule;
import javax.inject.Singleton;
import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by warefhaque on 8/23/17.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
  Retrofit retrofit();
  Gson gson();
}
