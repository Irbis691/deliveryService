/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery;

import com.preproduction.delivery.repository.PizzaRepository;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Irbis
 */
public class SpringDeliveryApp {
    
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("appContext.xml");
        PizzaRepository pizzaRepository = (PizzaRepository) applicationContext.getBean("pizzaRepo");        
        System.out.println(pizzaRepository.findById(1));
    }
    
}
