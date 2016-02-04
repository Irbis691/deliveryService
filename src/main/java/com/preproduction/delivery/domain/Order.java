package com.preproduction.delivery.domain;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Irbis
 */
@Component
public class Order {
    
    private static final int MAX_ORDER_SIZE = 10;

    private Integer id;
    private Customer customer;
    private List<Pizza> pizzas;
    private OrderStatus OrderStatus;

    public Order() {
    }

    public Order(Integer id, Customer customer, List<Pizza> pizzas,
            OrderStatus orderStatus) {
        this.id = id;
        this.customer = customer;
        this.pizzas = pizzas;
        this.OrderStatus = orderStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(OrderStatus orderType) {
        this.OrderStatus = orderType;
    }

    public int getOrderPrice() {
        int price = 0;
        for (Pizza p : pizzas) {
            price += p.getPrice();
        }
        return price;
    }
    
    public void addPizzas(List<Pizza> newPizzas) {
        for(Pizza p: newPizzas) {
            if(this.pizzas.size() >= MAX_ORDER_SIZE) {
                break;
            }
            pizzas.add(p);
        }
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", customer=" + customer
                + ", pizzas=" + pizzas + ", OrderStatus=" + OrderStatus + '}';
    }

    public enum OrderStatus {
        DONE(),
        CANCELED(),
        IN_PROGRES(CANCELED, DONE),
        NEW(IN_PROGRES, CANCELED);

        private final OrderStatus[] validTransitionStatuses;

        private OrderStatus(OrderStatus... validTransitionStatuses) {
            this.validTransitionStatuses = validTransitionStatuses;
        }

        public OrderStatus[] getValidTransitionStatuses() {
            return validTransitionStatuses;
        }

    }

    public void changeOrderStatus(OrderStatus orderStatus) { 
        OrderStatus currStatus = getOrderStatus();
        if (Arrays.asList(currStatus.getValidTransitionStatuses()).contains(orderStatus)) {
            setOrderStatus(orderStatus);
        } else {
            throw new IllegalArgumentException("Not valid transition status");
        }
    }
}
