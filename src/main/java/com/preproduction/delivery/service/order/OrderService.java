package com.preproduction.delivery.service.order;

import com.preproduction.delivery.domain.Customer;
import com.preproduction.delivery.domain.Order;
import com.preproduction.delivery.domain.Pizza;
import java.util.List;

/**
 *
 * @author Irbis
 */
public interface OrderService {

    void addPizzaToOrder(Order order, Pizza pizza);
    Order saveOrUpdate(Order order);
    public List<Order> findByCustomer(Customer customer);

}
