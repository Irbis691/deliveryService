/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery.domain;

import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Irbis
 */
@Component
public class PriceCalculator {

    private static final int ORDER_SIZE_THRESHOLD = 4;
    private static final double DISCOUNT_FOR_MOST_EXPENSIVE_PIZZA = 0.3;
    private static final double UPPER_BOUND_FOR_BONUSCARD_DISCOUNT = 0.3;
    
    public PriceCalculator() {
    }
    
    public Double calculatePrice(Order order) {        
        Double result;
        result = calcMostExpensPizzaDisc(order);
        result = calcDiscountFromBonusCard(order, result);
        return result;
    }
    
    private Double calcMostExpensPizzaDisc(Order order) {
        List<Pizza> pizzas = order.getPizzas();
        if (pizzas.size() > ORDER_SIZE_THRESHOLD) {
            Double maxPrice = 0d;
            for (Pizza p : pizzas) {
                Double pizzaPrice = p.getPrice();
                if(pizzaPrice > maxPrice) {
                    maxPrice = pizzaPrice;
                }
            }
            return order.getPurePizzasPrice() - maxPrice * 
                    DISCOUNT_FOR_MOST_EXPENSIVE_PIZZA;
        } else {
            return order.getPurePizzasPrice();
        }
    }
    
    private Double calcDiscountFromBonusCard(Order order, Double currPrice) {
        Double bonusSize = order.getCustomer().getBonusCard().getBonusSize();
        if(bonusSize < currPrice * UPPER_BOUND_FOR_BONUSCARD_DISCOUNT) {
            return currPrice - bonusSize;
        } else {
            return currPrice * UPPER_BOUND_FOR_BONUSCARD_DISCOUNT;
        }
    }
    
}
