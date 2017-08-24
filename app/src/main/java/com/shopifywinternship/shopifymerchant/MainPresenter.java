package com.shopifywinternship.shopifymerchant;

import android.util.Log;

import com.shopifywinternship.shopifymerchant.api.OrderService;
import com.shopifywinternship.shopifymerchant.model.AllOrders;
import com.shopifywinternship.shopifymerchant.model.Order;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by warefhaque on 8/23/17.
 */

public class MainPresenter implements MainContract.Presenter {

  private static final String TAG = MainPresenter.class.getSimpleName();
  private MainContract.View view;
  private OrderService orderService;
  private Subscription subscription;

  public MainPresenter(MainContract.View view,
                       OrderService orderService) {
    this.view = view;
    this.orderService = orderService;
  }

  @Override
  public void fetchOrders() {
     subscription = orderService.getAllOrders()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<AllOrders>() {
          @Override
          public void onCompleted() {
            Log.d(TAG, "Completed");
          }

          @Override
          public void onError(Throwable e) {
            Log.e(TAG, e.getLocalizedMessage());
          }

          @Override
          public void onNext(AllOrders orders) {
            Log.d(TAG, orders.getOrders().get(0).getName());
          }
        });
  }

  @Override
  public void unsubscribe() {

  }
}
