package com.preproduction.delivery.service.order;

import com.preproduction.delivery.domain.Customer;
import com.preproduction.delivery.domain.Order;

/**
 *
 * @author Irbis
 */
public interface OrderService {
    public Order placeNewOrder(Customer customer, Integer ... pizzasID);
}
