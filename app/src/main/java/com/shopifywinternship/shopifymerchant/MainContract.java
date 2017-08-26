package com.shopifywinternship.shopifymerchant;

/**
 * Contract between MainActivity and MainPresenter
 */

public interface MainContract {
  interface View {

    /**
     * @param itemQuantity total number of required items in list of orders
     */
    void showTotalQuantityForItem(int itemQuantity);

    /**
     * @param saleForCustomer total sales of required customer
     */

    void showTotalSalesForCustomer(double saleForCustomer);
    /**
     * @param error - error when processing data or Fetching data from API enpoint
     */
    void showErrors(String error);
  }

  interface Presenter {
    /**
     * Calls API endpoint and processes data to compute total sales by Naploleon and
     * total Awesome Bronze Bags sold
     */
    void fetchOrders();

    /**
     * Unsubscribe from all Observables
     */
    void unsubscribe();
  }
}
