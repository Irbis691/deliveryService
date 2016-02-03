package com.preproduction.delivery.repository;

import com.preproduction.delivery.domain.Order;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * Created by Mantixop on 1/21/16.
 */
@Repository
public class InMemOrderRepository implements OrderRepository {

    private final List<Order> orders = new ArrayList<Order>();

    public Order save(Order order) {
        setOrderId(order);
        orders.add(order);
        return order;
    }

    private void setOrderId(Order order) {
        order.setId(orders.size());
    }
}
