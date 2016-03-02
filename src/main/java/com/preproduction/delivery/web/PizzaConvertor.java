/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery.web;

import com.preproduction.delivery.domain.Pizza;
import com.preproduction.delivery.service.pizza.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 *
 * @author Irbis
 */
public class PizzaConvertor implements Converter<String, Pizza> {

    @Autowired
    PizzaService pizzaService;

    @Override
    public Pizza convert(String pizzaId) {
        Pizza pizza;
        if ((pizzaId == null) || pizzaId.isEmpty()) {
            pizza = new Pizza();
        } else {
            int id = Integer.valueOf(pizzaId);
            if(id <= 0) {
                throw new IllegalArgumentException();
            }
            pizza = pizzaService.find(id);
        }
        return pizza;
    }
    
}
