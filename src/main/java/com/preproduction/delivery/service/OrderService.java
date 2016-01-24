package com.preproduction.delivery.service;

import com.preproduction.delivery.domain.Customer;
import com.preproduction.delivery.domain.Order;

/**
 * Created by Mantixop on 1/21/16.
 */
public interface OrderService {
    public Order placeNewOrder(Customer customer, Integer ... pizzasID);
}
