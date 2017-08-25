package com.shopifywinternship.shopifymerchant;

import android.support.annotation.NonNull;
import android.util.Log;

import com.shopifywinternship.shopifymerchant.api.OrderService;
import com.shopifywinternship.shopifymerchant.model.AllOrders;
import com.shopifywinternship.shopifymerchant.model.LineItem;
import com.shopifywinternship.shopifymerchant.model.Order;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

/**
 * Created by warefhaque on 8/23/17.
 */

public class MainPresenter implements MainContract.Presenter {

  private static final String TAG = MainPresenter.class.getSimpleName();
  private MainContract.View view;
  private OrderService orderService;
  private Subscription subscription;

  public MainPresenter(MainContract.View view, OrderService orderService) {
    this.view = view;
    this.orderService = orderService;
  }

  @Override
  public void fetchOrders() {
    subscription = Observable.zip(
        getTotalSalesForFavouriteCustomer(getListObservable()),
        getTotalBronzeBags(getListObservable()), CombinedResults::new)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<CombinedResults>() {
      @Override
      public void onCompleted() {
      }

      @Override
      public void onError(Throwable e) {
        view.showErrors(e.getMessage());
      }

      @Override
      public void onNext(CombinedResults combinedResults) {
        view.showTotals(combinedResults);
      }
    });

  }

  @NonNull
  private Observable<List<Order>> getListObservable() {
    Observable<AllOrders> allOrdersObservable = orderService.getAllOrders();
    return allOrdersObservable.map(AllOrders::getOrders);
  }

  private Observable<Double> getTotalSalesForFavouriteCustomer(Observable<List<Order>> orders) {
    return orders
        .flatMap(Observable::from)
        .filter(order -> (order.getCustomer() != null
                && order.getCustomer().getFirstName() != null
                && order.getCustomer().getLastName() != null))
        .filter(order -> (order.getCustomer().getFirstName().equals("Napoleon")
            && order.getCustomer().getLastName().equals("Batz")))
        .map(Order::getTotalLineItemsPrice)
        .reduce((integer, integer2) -> integer + integer2);
  }

  private Observable<Integer> getTotalBronzeBags(Observable<List<Order>> orders) {
    return orders.flatMap(Observable::from)
        .filter(order -> (order.getLineItems() != null && order.getLineItems().size() > 0))
        .flatMap(order -> Observable.from(order.getLineItems()))
        .filter(lineItem -> (lineItem != null))
        .filter(lineItem -> lineItem.getTitle().equals("Awesome Bronze Bag"))
        .map(LineItem::getQuantity)
        .reduce((integer, integer2) -> integer + integer2);
  }

  @Override
  public void unsubscribe() {
    subscription.unsubscribe();
  }

  public class CombinedResults {
    public double totalSalesFromFavouriteCustomer;
    public int totalBronzeBags;

    public CombinedResults(double totalSalesFromFavouriteCustomer, int totalBronzeBags) {
      this.totalSalesFromFavouriteCustomer = totalSalesFromFavouriteCustomer;
      this.totalBronzeBags = totalBronzeBags;
    }
  }
}
