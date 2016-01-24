package com.preproduction.delivery.repository;

import com.preproduction.delivery.domain.Order;

/**
 * Created by Mantixop on 1/21/16.
 */
public interface OrderRepository {
    Order save(Order order);
}
