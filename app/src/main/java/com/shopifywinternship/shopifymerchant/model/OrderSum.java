package com.shopifywinternship.shopifymerchant.model;

/**
 * Created by warefhaque on 8/24/17.
 */

public class OrderSum {
  private int favCustomeSum;
  private int totalBags;
  private Order order;

  public OrderSum() {
  }

  public int getFavCustomeSum() {
    return favCustomeSum;
  }

  public OrderSum setFavCustomeSum(int favCustomeSum) {
    this.favCustomeSum = favCustomeSum;
    return this;
  }

  public int getTotalBags() {
    return totalBags;
  }

  public OrderSum setTotalBags(int totalBags) {
    this.totalBags = totalBags;
    return this;
  }

  public Order getOrder() {
    return order;
  }

  public OrderSum setOrder(Order order) {
    this.order = order;
    return this;
  }
}
