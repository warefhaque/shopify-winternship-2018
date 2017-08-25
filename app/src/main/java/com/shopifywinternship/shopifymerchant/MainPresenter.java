package com.shopifywinternship.shopifymerchant;

import android.support.annotation.NonNull;

import com.shopifywinternship.shopifymerchant.api.OrderService;
import com.shopifywinternship.shopifymerchant.model.AllOrders;
import com.shopifywinternship.shopifymerchant.model.LineItem;
import com.shopifywinternship.shopifymerchant.model.Order;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * This class deals with fetching and formatting the list of Orders from the API and calculates:
 * 1) The total amount in CAD spent by Napoleon Batz
 * 2) The total number of Awesome Bronze Bags sold
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

  /**
   * Called by a view implementing the MainContract.View interface.
   * Functionality:
   * 1. Calls getListObservable() to get the list of all Orders from the API endpoint
   * 2. Passes the list of Orders to BOTH getTotalSalesForFavouriteCustomer && getTotalBronzeBags
   * where the lists are processed and TWO numbers corresponding to the total sales of Napoleon and
   * the total number of Bronze Bags are returned
   * 3. Uses ZIP to COMBINE these results into an object (CombinedReesults)
   * 4. Passes the CombinedResults Object to MainActivity
   */
  @Override
  public void fetchOrders() {
    subscription = Observable.zip(
        getTotalSalesForFavouriteCustomer(getListObservable()),
        getTotalBronzeBags(getListObservable()),
        CombinedResults::new)
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

  /**
   * Called by fetchOrders()
   * Functionality:
   * 1. Uses Retrofit to get all the orders
   * 2. Uses MAP to convert the object returned by the API endpoint to a List of orders
   * @return Observable<List<Order>>: A list of Orders for merchant
   */
  @NonNull
  private Observable<List<Order>> getListObservable() {
    Observable<AllOrders> allOrdersObservable = orderService.getAllOrders();
    return allOrdersObservable.map(AllOrders::getOrders);
  }

  /**
   * Called by fetchOrders()
   * Functionality:
   * 1. Uses FLATMAP to convert an Observable emitting a List of Orders (Observable<List<Order>>) to
   * a STREAM of Observables emitting EACH individual Order (Observable<Order> from the list passed in.
   * 2. Uses FILTER to make null checks and avoid vad data from API endpoint
   * 3. Uses FILTER to ONLY process Orders by Napoleon Batz
   * 4. Uses MAP to convert the Observable from type Order to type Double AND only contain the
   * total price of that Order
   * 5. Uses REDUCE to sum the totals of all the orders Passed in by MAP
   * @param orders - An Observable containing the List of Orders provided by the API endpoint
   * @return An Observable that contains the TOTAL amount in sales spent by Napoleon Batz
   */
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

  /**
   * Called by fetchOrders()
   * Functionality:
   * 1. Uses FLATMAP to convert an Observable emitting a List of Orders (Observable<List<Order>>) to
   * a STREAM of Observables emitting EACH individual Order (Observable<Order> from the list passed in.
   * 2. Uses FILTER to make null checks and avoid vad data from API endpoint
   * 3. Uses FLATMAP to convert an Observable emitting EACH individual Order (Observable<Order>
   * to a STREAM of Observables emitting EACH LineItem (Observable<LineItem>)
   * 4. Uses FIlTER to make null checks on LineItem
   * 5. Uses FILTER to make sure we only process Awesome Bronze Bags
   * 6. Uses MAP to convert an Obervable containing a LineItem to an  Observable containing the Price
   * of that LineItem
   * 7. Uses REDUCE to sum the total Awesome Bronze Bags in each order passed in by MAP
   * @param orders - An Observable containing the List of Orders provided by the API endpoint
   * @return - An Observable that contains the TOTAL amount of Awesome Bronze Bags sold.
   */
  private Observable<Integer> getTotalBronzeBags(Observable<List<Order>> orders) {
    return orders
        .flatMap(Observable::from)
        .filter(order -> (order.getLineItems() != null && order.getLineItems().size() > 0))
        .flatMap(order -> Observable.from(order.getLineItems()))
        .filter(lineItem -> (lineItem != null))
        .filter(lineItem -> lineItem.getTitle().equals("Awesome Bronze Bag"))
        .map(LineItem::getQuantity)
        .reduce((integer, integer2) -> integer + integer2);
  }

  /**
   * Called in onPause of view implementing MainContract.View
   * Unsubscribe from all the observables. Would use CompositeSubscription if there were more
   * subscriptions
   */
  @Override
  public void unsubscribe() {
    subscription.unsubscribe();
  }

  /**
   * Helper class to group Total sales by Napoleon && Total Awesome Bronze Bags Sold when using ZIP
   */
  public class CombinedResults {
    public double totalSalesFromFavouriteCustomer;
    public int totalBronzeBags;

    public CombinedResults(double totalSalesFromFavouriteCustomer, int totalBronzeBags) {
      this.totalSalesFromFavouriteCustomer = totalSalesFromFavouriteCustomer;
      this.totalBronzeBags = totalBronzeBags;
    }
  }
}
