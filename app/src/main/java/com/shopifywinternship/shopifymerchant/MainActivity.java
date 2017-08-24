package com.shopifywinternship.shopifymerchant;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

/**
 * Created by warefhaque on 8/23/17.
 */

public class MainActivity extends AppCompatActivity implements MainContract.View{

  @Inject MainContract.Presenter mMainPresenter;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setUpDagger();
  }

  private void setUpDagger() {
    DaggerMainComponent.builder().netComponent(
        ((ShopifyMerchantApplication) getApplication())
            .getNetComponent())
        .mainModule(new MainModule(this))
        .build()
        .inject(this);
  }

  @Override
  protected void onResume() {
    super.onResume();
    mMainPresenter.fetchOrders();
  }

  @Override
  protected void onPause() {
    super.onPause();
    mMainPresenter.unsubscribe();
  }

  @Override
  public void showTotals() {

  }
}
