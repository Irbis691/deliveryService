package com.preproduction.delivery;

import com.preproduction.delivery.domain.Customer;
import com.preproduction.delivery.domain.Order;
import com.preproduction.delivery.infrastructure.ApplicationContext;
import com.preproduction.delivery.infrastructure.JavaConfig;
import com.preproduction.delivery.infrastructure.JavaConfigApplicationContext;
import com.preproduction.delivery.service.OrderService;

/**
 * Created by Mantixop on 1/21/16.
 */
public class DeliveryApp {
    public static void main(String[] args) {

        ApplicationContext context = new JavaConfigApplicationContext(new JavaConfig());
        
        OrderService orderService = null;
        try {
            orderService = (OrderService) context.getBean("orderService");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        Order order = orderService.placeNewOrder(new Customer(1, "Customer"), 1, 2, 3);
        
        System.out.println(order);
    }
}
