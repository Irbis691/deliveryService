package com.preproduction.delivery.service.order;

import com.preproduction.delivery.domain.Order;
import com.preproduction.delivery.domain.Pizza;

/**
 *
 * @author Irbis
 */
public interface OrderService {

    void updateOrder(Order order, Pizza pizza);
    Order placeNewOrder(Order order);

}
