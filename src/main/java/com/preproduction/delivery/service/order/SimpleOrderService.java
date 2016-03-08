package com.preproduction.delivery.service.order;

import com.preproduction.delivery.domain.Customer;
import com.preproduction.delivery.domain.Order;
import com.preproduction.delivery.domain.Pizza;
import com.preproduction.delivery.domain.PriceCalculator;
import com.preproduction.delivery.repository.order.OrderRepository;
import com.preproduction.delivery.service.customer.CustomerService;
import com.preproduction.delivery.service.pizza.PizzaService;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Irbis
 */
@Service
public class SimpleOrderService implements OrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private PriceCalculator priceCalculator;
    @Autowired
    private CustomerService customerService;

    public SimpleOrderService() {
    }
    
    public SimpleOrderService(OrderRepository orderRepository,                              
                              PriceCalculator priceCalculator,
                              CustomerService customerService) {
        this.orderRepository = orderRepository;        
        this.priceCalculator = priceCalculator;
        this.customerService = customerService;
    }
    
    @Override
    public void updateOrder(Order order, Pizza pizza) {
        order.addPizza(pizza);
    }
        
    @Override
    @Transactional
    public Order placeNewOrder(Order order) {
        Customer customer = customerService.findByLogin(SecurityContextHolder.
                getContext().getAuthentication().getName());        
        order.setCustomer(customer);
        order.setOrderStatus(Order.OrderStatus.NEW);
        order.setOrderPrice(getOrderPrice(order));
        saveOrder(order);
        return order;
    }     
    
    public Double getOrderPrice(Order order) {
        return priceCalculator.calculatePrice(order);
    }
    
    public void setOrderStatus(Order order, Order.OrderStatus newStatus) {
        if(newStatus.equals(Order.OrderStatus.DONE)) {
            order.getCustomer().getBonusCard().increaseBonusSize(getOrderPrice(order));
        }
        order.setOrderStatus(newStatus);
    }

    @Transactional
    private void saveOrder(Order order) {
        orderRepository.saveOrUpdate(order);
    }

}