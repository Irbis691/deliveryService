/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery;

import com.preproduction.delivery.domain.Address;
import com.preproduction.delivery.domain.Customer;
import com.preproduction.delivery.domain.Order;
import com.preproduction.delivery.domain.Pizza;

import com.preproduction.delivery.repository.PizzaRepository;
import com.preproduction.delivery.service.OrderService;
import com.preproduction.delivery.service.SimpleOrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
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
        
        ApplicationContext parent = applicationContext.getParent();
        
        System.out.println("Parent: " + parent);
        
        Customer customer1 = applicationContext.getBean("newCustomer", Customer.class);

        System.out.println(customer1);

        PizzaRepository pizzaRepository = (PizzaRepository) applicationContext.getBean("pizzaRepo");        
        System.out.println(pizzaRepository.findById(1));                

        for(String s: applicationContext.getBeanDefinitionNames()) {
            System.out.println(s);
        }
        
//        applicationContext.publishEvent(new ApplicationEvent(applicationContext){});
        
        OrderService orderService = (OrderService) applicationContext.getBean(OrderService.class);
        Order order = orderService.placeNewOrder(new Customer("Customer"), 1, 2, 3);

        System.out.println(order);
        
        
        
//        Pizza pizza = (Pizza) applicationContext.getBean("pizzaFactoryBean");
//        System.out.println(pizza);
        
        applicationContext.close();
        repositoryContext.close();
    }
    
}
