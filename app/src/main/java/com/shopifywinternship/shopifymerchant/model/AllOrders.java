package com.shopifywinternship.shopifymerchant.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by warefhaque on 8/24/17.
 */

public class AllOrders {
  @SerializedName("orders")
  @Expose
  private List<Order> orders;

  public List<Order> getOrders() {
    return orders;
  }

  public AllOrders setOrders(List<Order> orders) {
    this.orders = orders;
    return this;
  }
}
