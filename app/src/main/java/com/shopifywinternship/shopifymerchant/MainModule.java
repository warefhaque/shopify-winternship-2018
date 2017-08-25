package com.shopifywinternship.shopifymerchant;

import com.shopifywinternship.shopifymerchant.api.OrderService;
import com.shopifywinternship.shopifymerchant.dagger.CustomScope;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * This is a Module class that provides Objects to be injected into other classes.
 * Each method annotated with @Provides provides objects to any other class that uses this Module.
 * In our case it is the MainActivity that uses this Module.
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
