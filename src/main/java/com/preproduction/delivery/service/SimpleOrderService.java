package com.preproduction.delivery.service;

import com.preproduction.delivery.domain.Customer;
import com.preproduction.delivery.domain.Order;
import com.preproduction.delivery.domain.Pizza;
import com.preproduction.delivery.repository.OrderRepository;
import com.preproduction.delivery.infrastructure.ServiceLocator;
import com.preproduction.delivery.repository.InMemOrderRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mantixop on 1/21/16.
 */
public class SimpleOrderService implements OrderService{

    private OrderRepository orderRepository;
    private PizzaService pizzaService;

    public SimpleOrderService(OrderRepository orderRepository, 
            PizzaService pizzaService) {
        this.orderRepository = orderRepository;
        this.pizzaService = pizzaService;
    }    
    
    public Order placeNewOrder(Customer customer, Integer ... pizzasID) {
        List<Pizza> pizzas = new ArrayList<Pizza>();

        for(Integer id : pizzasID){
            pizzas.add(getPizzaByID(id));
        }

        Order newOrder = new Order(1, customer, pizzas);

        saveOrder(newOrder);
        return newOrder;
    }

    private void saveOrder(Order newOrder) {
        orderRepository.save(newOrder);
    }

    private Pizza getPizzaByID(Integer id) {
        return pizzaService.find(id);
    }

}