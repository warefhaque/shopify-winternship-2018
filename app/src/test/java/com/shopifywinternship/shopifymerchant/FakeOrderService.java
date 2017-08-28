package com.shopifywinternship.shopifymerchant;

import com.shopifywinternship.shopifymerchant.api.OrderService;
import com.shopifywinternship.shopifymerchant.model.AllOrders;
import com.shopifywinternship.shopifymerchant.model.LineItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by warefhaque on 8/27/17.
 */

public class FakeOrderService implements OrderService {

  private OrderGenerator orderGenerator;

  public FakeOrderService(OrderGenerator orderGenerator) {
    this.orderGenerator = orderGenerator;
  }

  @Override
  public Observable<AllOrders> getAllOrders(@Query("page") int pageNumber,
                                            @Query("access_token") String accessToken) {


    return Observable.just(new AllOrders(orderGenerator.generateOrder()));
  }
}
