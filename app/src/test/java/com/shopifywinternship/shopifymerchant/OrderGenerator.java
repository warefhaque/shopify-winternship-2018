package com.shopifywinternship.shopifymerchant;

import com.shopifywinternship.shopifymerchant.model.Customer;
import com.shopifywinternship.shopifymerchant.model.LineItem;
import com.shopifywinternship.shopifymerchant.model.Order;

import org.apache.tools.ant.taskdefs.condition.Or;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by warefhaque on 8/28/17.
 */

public class OrderGenerator {

  public List<LineItem> generateLineItems() {
    List<LineItem> result = new ArrayList<>();

    result.add(new LineItem("Awesome Bronze Bag", 2));
    result.add(new LineItem("Random Item", 2));

    return result;
  }

  public Customer generateCustomer (String firstName, String lastName) {
    return new Customer(firstName,lastName);
  }

  public List<Order> generateOrder () {

    List<Order> result = new ArrayList<>();

    Order order = new Order();
    order.setLineItems(generateLineItems());
    order.setCustomer(generateCustomer("Napoleon","Batz"));
    order.setTotalLineItemsPrice("500");

    Order order1 = new Order();
    order1.setLineItems(generateLineItems());
    order1.setCustomer(generateCustomer("Napoleon","Batz"));
    order1.setTotalLineItemsPrice("");

    result.add(order);
    result.add(order1);

    return result;
  }
}
