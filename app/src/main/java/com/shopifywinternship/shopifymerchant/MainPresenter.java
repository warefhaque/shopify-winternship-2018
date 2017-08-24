package com.shopifywinternship.shopifymerchant;

/**
 * Created by warefhaque on 8/23/17.
 */

public class MainPresenter implements MainContract.Presenter {

  private MainContract.View view;
  private OrderService orderService;

  public MainPresenter(MainContract.View view,
                       OrderService orderService) {
    this.view = view;
    this.orderService = orderService;
  }

  @Override
  public void fetchOrders() {

  }
}
