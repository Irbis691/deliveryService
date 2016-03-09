/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery.domain;

import org.springframework.stereotype.Component;

/**
 *
 * @author Irbis
 */
//@Component
public class OrderDetails {
    
    private Pizza pizza;
    private Double pizzaPrice;
    private Integer quantity;

    public OrderDetails(Pizza pizza, Double pizzaPrice, Integer quantity) {
        this.pizza = pizza;
        this.pizzaPrice = pizzaPrice;
        this.quantity = quantity;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Double getPizzaPrice() {
        return pizzaPrice;
    }

    public void setPizzaPrice(Double pizzaPrice) {
        this.pizzaPrice = pizzaPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderDetails{" + "pizza=" + pizza + ", pizzaPrice=" + pizzaPrice + ", quantity=" + quantity + '}';
    }        
    
}
