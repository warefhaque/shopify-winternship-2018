package com.shopifywinternship.shopifymerchant.api;

import com.shopifywinternship.shopifymerchant.model.AllOrders;
import com.shopifywinternship.shopifymerchant.model.Order;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by warefhaque on 8/23/17.
 */

public interface OrderService {
  // TODO: 8/24/17 make the page and access token variables
  @GET ("orders.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6")
  Observable<AllOrders> getAllOrders();
}
