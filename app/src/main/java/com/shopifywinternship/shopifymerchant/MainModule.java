package com.shopifywinternship.shopifymerchant;

import com.shopifywinternship.shopifymerchant.dagger.CustomScope;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by warefhaque on 8/23/17.
 */

@Module
public class MainModule {
  private MainContract.View view;

  public MainModule(MainContract.View view) {
    this.view = view;
  }

  @Provides
  @CustomScope
  OrderService providesPaymentService(Retrofit retrofit) {
    return retrofit.create(OrderService.class);
  }

  @Provides
  @CustomScope
  MainContract.View providesMainPaymentView() {
    return view;
  }

  @Provides
  @CustomScope
  MainContract.Presenter providesPresenter(MainContract.View view,
                                           OrderService orderService ) {
    return new MainPresenter(view,orderService);
  }
}
