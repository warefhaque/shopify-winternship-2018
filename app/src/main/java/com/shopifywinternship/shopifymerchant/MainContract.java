package com.shopifywinternship.shopifymerchant;

/**
 * Created by warefhaque on 8/23/17.
 */

public interface MainContract {
  interface View {
    void showTotals();
  }

  interface Presenter {
    void fetchOrders();
    void unsubscribe();
  }
}
