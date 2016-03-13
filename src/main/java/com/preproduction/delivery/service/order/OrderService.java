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

    void deletePizzaFomrOrder(Order order, Pizza pizza);
    void addPizzaToOrder(Order order, Pizza pizza);
    Order saveOrUpdate(Order order);
    Order findById(Integer id);
    List<Order> findAll();
    List<Order> findByCustomer(Customer customer);
    void setOrderStatus(Order order, Order.OrderStatus newStatus);
    void deleteOrder(Order order);
}
