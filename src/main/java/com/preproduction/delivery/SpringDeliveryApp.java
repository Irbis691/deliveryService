/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery;

import com.preproduction.delivery.domain.Address;
import com.preproduction.delivery.domain.BonusCard;
import com.preproduction.delivery.domain.Customer;
import com.preproduction.delivery.domain.Order;
import com.preproduction.delivery.service.order.OrderService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Irbis
 */
public class SpringDeliveryApp {
    
    public static void main(String[] args) {
        
        ConfigurableApplicationContext repositoryContext = new ClassPathXmlApplicationContext("repoContext.xml");
        
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"appContext.xml"}, repositoryContext);                

        for(String s: applicationContext.getBeanDefinitionNames()) {
            System.out.println(s);
        }        
        
        OrderService orderService = applicationContext.getBean("simpleOrderService", OrderService.class);
        Order order = orderService.placeNewOrder(new Customer(1, "Customer",
                new Address(1, "Vyhurovsky blvd.", 33, 33), new BonusCard()),
                1, 2, 3);

        System.out.println(order);
        
        applicationContext.close();
        repositoryContext.close();
    }
    
}
