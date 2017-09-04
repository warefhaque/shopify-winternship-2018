package com.shopifywinternship.shopifymerchant;

import android.support.annotation.NonNull;

import com.annimon.stream.Stream;
import com.shopifywinternship.shopifymerchant.api.OrderService;
import com.shopifywinternship.shopifymerchant.model.AllOrders;
import com.shopifywinternship.shopifymerchant.model.LineItem;
import com.shopifywinternship.shopifymerchant.model.Order;

import java.util.List;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * This class deals with fetching and formatting the list of Orders from the API and calculates:
 * 1) The total amount in CAD spent by Napoleon Batz
 * 2) The total number of Awesome Bronze Bags sold
 */

public class MainPresenter implements MainContract.Presenter {

  private static final String TAG = MainPresenter.class.getSimpleName();
  private MainContract.View view;
  private OrderService orderService;
  private static final int PAGE_NUMBER = 1;
  private static final String ACCESS_TOKEN = "c32313df0d0ef512ca64d5b336a0d7c6";
  private CompositeSubscription compositeSubscription = new CompositeSubscription();;

  public MainPresenter(MainContract.View view, OrderService orderService) {
    this.view = view;
    this.orderService = orderService;
  }

  /**
   * Called by a view implementing the MainContract.View interface.
   * Share - Allows more than one subscriber to subscribe to the Observable WITHOUT making two
   * separate network requests
   */
  @Override
  public void fetchOrders(@NonNull String firstName,
                          @NonNull String lastName,
                          @NonNull String itemName) {

    Observable<List<Order>> orderObservable = orderService.getAllOrders(PAGE_NUMBER, ACCESS_TOKEN)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map(AllOrders::getOrders)
        .share();

    Subscription totalSaleSubscription = orderObservable.subscribe(
        orders -> view.showTotalSalesForCustomer(getTotalSalesForCustomer(orders, firstName, lastName)),
        throwable -> view.showErrors(throwable.getMessage()));
    compositeSubscription.add(totalSaleSubscription);

    Subscription totalQtySubscription = orderObservable.subscribe(
        orders -> view.showTotalQuantityForItem(getTotalItems(orders,itemName)),
        throwable -> view.showErrors(throwable.getMessage()));
    compositeSubscription.add(totalQtySubscription);
  }

  /**
   * Called by fetchOrders
   * 1. Stream - conveys elements in the list of orders through a pipeline of operations
   * 2. Filter - filters the Order objects conveyed by the stream to find the ones by the required customer
   * 3. MapToDouble & Sum- converts/maps filtered Order objects to just their total cost and adds them
   * @param orders - List of all orders from API
   * @return Total amount in sales by required customer
   */
  private Double getTotalSalesForCustomer(@NonNull List<Order> orders,
                                          @NonNull String firstName,
                                          @NonNull String lastName) {
    return Stream.of(orders)
        .filter(order -> order.getCustomer() != null
            && order.getCustomer().getFirstName().equals(firstName)
            && order.getCustomer().getLastName().equals(lastName))
        .mapToDouble(Order::getTotalLineItemsPrice)
        .sum();
  }

  /**
   * Called by fetchOrders
   * 1. Stream - conveys elements in the list of orders through a pipeline of operations
   * 2. FlatMap - converts the stream of Orders to a stream of LineItems
   * 3. Filter - find the desired line item
   * 4. MapToInt & Sum - converts/maps filtered LineItem objects to just their total qty and adds them
   * @param orders - List of all orders from API
   * @return - Total amount of items in all orders
   */
  private Integer getTotalItems(@NonNull List<Order>orders,
                                @NonNull String itemTitle) {
    return Stream.of(orders)
        .flatMap(order -> Stream.of(order.getLineItems()))
        .filter(lineItem -> lineItem != null && lineItem.getTitle().equals(itemTitle))
        .mapToInt(LineItem::getQuantity)
        .sum();
  }

  /**
   * Called in onPause of view implementing MainContract.View
   * Unsubscribe from all the observables
   */
  @Override
  public void unsubscribe() {
    compositeSubscription.unsubscribe();
  }
}
