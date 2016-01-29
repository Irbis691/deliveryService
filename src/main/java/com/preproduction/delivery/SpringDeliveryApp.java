/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery;

import com.preproduction.delivery.domain.Address;
import com.preproduction.delivery.domain.Customer;
import com.preproduction.delivery.domain.Order;
import com.preproduction.delivery.repository.PizzaRepository;
import com.preproduction.delivery.service.OrderService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Irbis
 */
public class SpringDeliveryApp {
    
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"appContext.xml", "repoContext.xml"});

        Customer customer = applicationContext.getBean("customer", Customer.class);

        PizzaRepository pizzaRepository = (PizzaRepository) applicationContext.getBean("pizzaRepo");        
        System.out.println(pizzaRepository.findById(1));

        OrderService orderService = (OrderService) applicationContext.getBean("orderService");
        Order order = orderService.placeNewOrder(new Customer(1, "Customer",
                new Address("Vyhurovskiy blvd", 3, 33)), 1, 2, 3, 4, 5);

        System.out.println(order);

        applicationContext.close();
    }
    
}
