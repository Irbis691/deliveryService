/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

/**
 *
 * @author Irbis
 */
@Component
@Entity
@Table(name = "order_details")
public class OrderDetails implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private Integer id;
    @OneToOne
    @JoinColumn(name = "pizza_id")
    private Pizza pizza;
    @Column(name = "pizza_quantity")
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public OrderDetails() {
    }

    public OrderDetails(Pizza pizza, Integer quantity) {
        this.pizza = pizza;
        this.quantity = quantity;
    }
    
    public OrderDetails(Integer id, Pizza pizza, Integer quantity, Order order) {
        this.id = id;
        this.pizza = pizza;
        this.quantity = quantity;
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }    

    @Override
    public String toString() {
        return "OrderDetails{" + "id=" + id + ", pizza=" + pizza + ", quantity=" + quantity + ", order=" + order + '}';
    }
    
}
