package com.shopifywinternship.shopifymerchant;

/**
 * Contract between MainActivity and MainPresenter
 */

public interface MainContract {
  interface View {
    /**
     * @param combinedResults - contains the total sales by Napoleon && total number of Awesome
     *                        Bronze Bags sold
     */
    void showTotals(MainPresenter.CombinedResults combinedResults);

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
