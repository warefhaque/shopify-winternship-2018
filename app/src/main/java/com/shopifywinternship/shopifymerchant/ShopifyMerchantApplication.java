package com.shopifywinternship.shopifymerchant;

import android.app.Application;

import com.shopifywinternship.shopifymerchant.dagger.component.DaggerNetComponent;
import com.shopifywinternship.shopifymerchant.dagger.component.NetComponent;
import com.shopifywinternship.shopifymerchant.dagger.module.AppModule;
import com.shopifywinternship.shopifymerchant.dagger.module.NetModule;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by warefhaque on 8/23/17.
 */

public class ShopifyMerchantApplication extends Application{
  private NetComponent netComponent;
  public static final String DEFAULT_FONT = "fonts/Nunito-Regular.ttf";

  @Override
  public void onCreate() {
    super.onCreate();

    this.netComponent = DaggerNetComponent.builder()
        .appModule(new AppModule(this))
        .netModule(new NetModule())
        .build();

    CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
        .setDefaultFontPath(DEFAULT_FONT)
        .setFontAttrId(R.attr.fontPath)
        .build());

  }

  public NetComponent getNetComponent() {
    return netComponent;
  }
}
