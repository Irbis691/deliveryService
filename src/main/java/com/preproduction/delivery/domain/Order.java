package com.preproduction.delivery.domain;

import com.preproduction.delivery.infrastructure.MyComponent;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * Created by Mantixop on 1/21/16.
 */
@Component
@MyComponent
public class Order {        
    
    private Integer id;
    private Customer customer;
    private List<Pizza> pizzas;
    private Integer orderPrice;
    private OrderStatus OrderStatus;

    public Order() {
    }

    public Order(Customer customer, List<Pizza> pizzas, Integer orderPrice,
                 OrderStatus orderStatus) {
        this.customer = customer;
        this.pizzas = pizzas;
        this.orderPrice = orderPrice;
        this.OrderStatus = orderStatus;
    } 
    
    public Order(Integer id, Customer customer, List<Pizza> pizzas, 
            Integer orderPrice, OrderStatus orderStatus) {
        this.id = id;
        this.customer = customer;
        this.pizzas = pizzas;
        this.orderPrice = orderPrice;
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

    public enum OrderStatus {
        DONE(),
        CANCELED(),
        IN_PROGRES(CANCELED, DONE),
        NEW(IN_PROGRES, CANCELED, DONE);
        
        private final OrderStatus[] validTransitionStatuses;

        private OrderStatus(OrderStatus ... validTransitionStatuses) {
            this.validTransitionStatuses = validTransitionStatuses;
        }

        public OrderStatus[] getValidTransitionStatuses() {
            return validTransitionStatuses;
        }
                
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(OrderStatus orderType) {
        this.OrderStatus = orderType;
    }        

    public Integer getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Integer orderPrice) {
        this.orderPrice = orderPrice;
    }        

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", customer=" + customer +
                ", pizzas=" + pizzas + ", orderPrice=" + orderPrice +
                ", OrderStatus=" + OrderStatus + '}';
    }        
    
}
