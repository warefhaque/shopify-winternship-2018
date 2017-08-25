package com.shopifywinternship.shopifymerchant.api;

import com.shopifywinternship.shopifymerchant.model.AllOrders;
import com.shopifywinternship.shopifymerchant.model.Order;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

public interface OrderService {
  // TODO: 8/24/17 make the page and access token variables

  /**
   * Interface created by the Retrofit class that makes a GET request to the endpoint:
   * https://shopicruit.myshopify.com/admin/orders.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6
   * @return - Observable of AllOrders. AllOrders only contains a List of Orders.
   */
  @GET ("orders.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6")
  Observable<AllOrders> getAllOrders();
}
