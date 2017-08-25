package com.shopifywinternship.shopifymerchant;

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
    Observable<AllOrders> allOrdersObservable = orderService.getAllOrders();
    Observable<List<Order>> listOrderObservable = allOrdersObservable
        .map(new Func1<AllOrders, List<Order>>() {
      @Override
      public List<Order> call(AllOrders allOrders) {
        return allOrders.getOrders();
      }
    });

//    subscription = getTotalSalesForFavouriteCustomer(listOrderObservable)
//        .subscribeOn(Schedulers.io())
//        .observeOn(AndroidSchedulers.mainThread())
//        .subscribe(new Subscriber<Double>() {
//          @Override
//          public void onCompleted() {
//
//          }
//
//          @Override
//          public void onError(Throwable e) {
//
//          }
//
//          @Override
//          public void onNext(Double aDouble) {
//            Log.d(TAG, String.valueOf(aDouble));
//          }
//        });

    subscription = Observable.zip(
        getTotalSalesForFavouriteCustomer(listOrderObservable),
        getTotalBronzeBags(listOrderObservable),
        new Func2<Double, Integer, CombinedResults>() {
          @Override
          public CombinedResults call(Double aDouble, Integer aDouble2) {
            return new CombinedResults(aDouble, aDouble2);
          }
        }

    )
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe(new Subscriber<CombinedResults>() {
      @Override
      public void onCompleted() {

      }

      @Override
      public void onError(Throwable e) {
        Log.e(TAG, e.getLocalizedMessage());
      }

      @Override
      public void onNext(CombinedResults combinedResults) {
        Log.d(TAG,
            "NAPOLEON " + combinedResults.totalSalesFromFavouriteCustomer +
            "BRONZE: " + combinedResults.totalBronzeBags);
      }
    });

  }

  private Observable<Double> getTotalSalesForFavouriteCustomer(Observable<List<Order>> orders) {
    return orders.flatMap(new Func1<List<Order>, Observable<Order>>() {
      @Override
      public Observable<Order> call(List<Order> orders) {
        return Observable.from(orders);
      }
    }).filter(new Func1<Order, Boolean>() {
      @Override
      public Boolean call(Order order) {
        return (order.getCustomer() != null
            && order.getCustomer().getFirstName() != null
            && order.getCustomer().getLastName() != null);
      }
    }).filter(new Func1<Order, Boolean>() {
      @Override
      public Boolean call(Order order) {
        return (order.getCustomer().getFirstName().equals("Napoleon")
            && order.getCustomer().getLastName().equals("Batz"));
      }
    }).map(new Func1<Order, Double>() {
      @Override
      public Double call(Order order) {
        return order.getTotalLineItemsPrice();
      }
    }).reduce(new Func2<Double, Double, Double>() {
      @Override
      public Double call(Double integer, Double integer2) {
        return integer + integer2;
      }
    });
  }

  private Observable<Integer> getTotalBronzeBags(Observable<List<Order>> orders) {
    return orders.flatMap(new Func1<List<Order>, Observable<Order>>() {
      @Override
      public Observable<Order> call(List<Order> orders) {
        return Observable.from(orders);
      }
    }).filter(new Func1<Order, Boolean>() {
      @Override
      public Boolean call(Order order) {
        return (order.getLineItems() != null && order.getLineItems().size() > 0);
      }
    }).flatMap(new Func1<Order, Observable<LineItem>>() {
      @Override
      public Observable<LineItem> call(Order order) {
        return Observable.from(order.getLineItems());
      }
    }).filter(new Func1<LineItem, Boolean>() {
      @Override
      public Boolean call(LineItem lineItem) {
        return (lineItem!=null);
      }
    }).filter(new Func1<LineItem, Boolean>() {
      @Override
      public Boolean call(LineItem lineItem) {
        return lineItem.getTitle().equals("Awesome Bronze Bag");
      }
    }).map(new Func1<LineItem, Integer>() {
      @Override
      public Integer call(LineItem lineItem) {
        return lineItem.getQuantity();
      }
    }).reduce(new Func2<Integer, Integer, Integer>() {
      @Override
      public Integer call(Integer integer, Integer integer2) {
        return integer + integer2;
      }
    });
  }

  @Override
  public void unsubscribe() {
    subscription.unsubscribe();
  }

  class CombinedResults {
    public double totalSalesFromFavouriteCustomer;
    public int totalBronzeBags;

    public CombinedResults(double totalSalesFromFavouriteCustomer, int totalBronzeBags) {
      this.totalSalesFromFavouriteCustomer = totalSalesFromFavouriteCustomer;
      this.totalBronzeBags = totalBronzeBags;
    }
  }
}
