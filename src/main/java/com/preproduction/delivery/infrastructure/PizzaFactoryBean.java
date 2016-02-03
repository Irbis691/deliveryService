/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery.infrastructure;

import com.preproduction.delivery.domain.Pizza;
import org.springframework.beans.factory.FactoryBean;

/**
 *
 * @author Irbis
 */
public class PizzaFactoryBean implements FactoryBean<Pizza>{

    private Integer id;
    private String name;
    private Pizza.PizzaType type;
    private Integer price;
    
    public Pizza getObject() throws Exception {
        return new Pizza(null, null, null, null);
    }

    public Class<?> getObjectType() {
        return Pizza.class;
    }

    public boolean isSingleton() {
        return true;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Pizza.PizzaType type) {
        this.type = type;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    
}
