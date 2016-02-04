/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery.domain;

import java.util.List;

/**
 *
 * @author Irbis
 */
public class PriceCalculator {

    private static final int ORDER_SIZE_THRESHOLD = 4;
    private static final double DISCOUNT_FOR_MOST_EXPENSIVE_PIZZA = 0.3;
    private static final double UPPER_BOUND_FOR_BONUSCARD_DISCOUNT = 0.3;
    
    public PriceCalculator() {
    }
    
    public Integer calculatePrice(Order order) {
        int result;
        result = calcMostExpensPizzaDisc(order);
        result = calcDiscountFromBonusCard(order, result);
        return result;
    }
    
    private int calcMostExpensPizzaDisc(Order order) {
        List<Pizza> pizzas = order.getPizzas();
        if (pizzas.size() > ORDER_SIZE_THRESHOLD) {
            int maxPrice = 0;
            for (Pizza p : pizzas) {
                int pizzaPrice = p.getPrice();
                if(pizzaPrice > maxPrice) {
                    maxPrice = pizzaPrice;
                }
            }
            return order.getOrderPrice() - (int)(maxPrice * 
                    DISCOUNT_FOR_MOST_EXPENSIVE_PIZZA);
        } else {
            return order.getOrderPrice();
        }
    }
    
    private int calcDiscountFromBonusCard(Order order, int currPrice) {
        int bonusSize = order.getCustomer().getBonusCard().getBonusSize();
        if(bonusSize < currPrice * UPPER_BOUND_FOR_BONUSCARD_DISCOUNT) {
            return currPrice - bonusSize;
        } else {
            return (int)(currPrice * UPPER_BOUND_FOR_BONUSCARD_DISCOUNT);
        }
    }
    
}
