package com.preproduction.delivery.repository;

import com.preproduction.delivery.domain.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mantixop on 1/21/16.
 */
public class InMemOrderRepository implements OrderRepository {

    private final List<Order> orders = new ArrayList<Order>();

    public Order save(Order order) {
        orders.add(order);
        return order;
    }
}
