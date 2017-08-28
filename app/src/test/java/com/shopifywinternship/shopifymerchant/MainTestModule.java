package com.shopifywinternship.shopifymerchant;

import android.app.Application;

import com.shopifywinternship.shopifymerchant.api.OrderService;

import org.robolectric.RuntimeEnvironment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by warefhaque on 8/27/17.
 */

@Module
public class MainTestModule {

  private MainContract.View view;

  public MainTestModule(MainContract.View view) {
    this.view = view;
  }

  @Provides
  @Singleton
  OrderGenerator providesOrderGenerator() {
    return new OrderGenerator();
  }

  @Provides
  @Singleton
  Application provideApplication() {
    return RuntimeEnvironment.application;
  }

  @Provides
  @Singleton
  OrderService providesOrderService(OrderGenerator orderGenerator) {
    return new FakeOrderService(orderGenerator);
  }

  @Provides
  @Singleton
  MainContract.View providesView() {
    return view;
  }

  @Provides
  @Singleton
  MainContract.Presenter providesPresenter(OrderService orderService) {
    return new MainPresenter(view, orderService);
  }
}
