package com.preproduction.delivery.repository.order;

import com.preproduction.delivery.domain.Order;

/**
 *
 * @author Irbis
 */
public interface OrderRepository {
    Order save(Order order);
}
