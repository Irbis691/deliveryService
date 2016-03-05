package com.preproduction.delivery.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Irbis
 */
@Entity
@Table(name = "pizza")
public class Pizza implements Comparable<Pizza>, Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pizza_id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Integer price;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private PizzaType pizzaType;
    
    public Pizza() {        
    }        

    public Pizza(Integer id, String name, Integer price, PizzaType pizzaType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pizzaType = pizzaType;
    }        

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    

    @Override
    public int compareTo(Pizza pizza) {
        if(this.getId() < pizza.getId()) {
            return -1;
        } else if (this.getId() > pizza.getId()){
            return 1;
        }
        return 0;
        
    }        
    
    public enum PizzaType {
        SEA, MEAT, VEGETARIAN, AMERICAN, HAWAIIAN;
    }

    public PizzaType getPizzaType() {
        return pizzaType;
    }
    
    public void setPizzaType(PizzaType pizzaType) {
        this.pizzaType = pizzaType;
    }

    @Override
    public String toString() {
        return "Pizza{" + "id=" + id + ", name=" + name + ", price=" + price +
                ", pizzaType=" + pizzaType + '}';
    }
}
