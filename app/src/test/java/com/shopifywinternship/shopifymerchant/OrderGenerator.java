package com.shopifywinternship.shopifymerchant;

import android.support.annotation.NonNull;

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

  public Customer generateCustomer (@NonNull String firstName,
                                    @NonNull String lastName) {
    return new Customer(firstName,lastName);
  }

  public List<Order> generateOrders() {

    List<Order> result = new ArrayList<>();

    Order order = new Order()
        .setLineItems(generateLineItems())
        .setCustomer(generateCustomer("Napoleon","Batz"))
        .setTotalPrice("500");


    Order order1 = new Order()
        .setLineItems(generateLineItems())
        .setCustomer(generateCustomer("Napoleon","Batz"))
        .setTotalPrice("700");

    Order order2 = new Order()
        .setLineItems(generateLineItems())
        .setCustomer(generateCustomer("Waref","Haque"))
        .setTotalPrice("700");

    result.add(order);
    result.add(order1);
    result.add(order2);

    return result;
  }
}
