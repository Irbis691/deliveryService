package com.preproduction.delivery.service.order;

import com.preproduction.delivery.domain.Customer;
import com.preproduction.delivery.domain.Order;
import com.preproduction.delivery.domain.Pizza;
import com.preproduction.delivery.domain.PriceCalculator;
import com.preproduction.delivery.repository.order.OrderRepository;
import com.preproduction.delivery.service.customer.CustomerService;
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
                              PriceCalculator priceCalculator) {
        this.orderRepository = orderRepository;        
        this.priceCalculator = priceCalculator;        
    }
    
    @Override
    public void addPizzaToOrder(Order order, Pizza pizza) {
        order.addPizza(pizza);
        order.setOrderPrice(getOrderPrice(order));
    }        
    
    private Double getOrderPrice(Order order) {
        return priceCalculator.calculatePrice(order);
    }
    
    public void setOrderStatus(Order order, Order.OrderStatus newStatus) {
        if(newStatus.equals(Order.OrderStatus.DONE)) {
            order.getCustomer().getBonusCard().increaseBonusSize(getOrderPrice(order));
        }
        order.setOrderStatus(newStatus);
    }

    @Override
    @Transactional
    public Order saveOrUpdate(Order order) {
        return orderRepository.saveOrUpdate(order);
    }
    
    @Override
    @Transactional
    public List<Order> findByCustomer(Customer customer) {        
        return orderRepository.findByCustomer(customer);
    }        

}