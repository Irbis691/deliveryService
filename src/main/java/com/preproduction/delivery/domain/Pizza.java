package com.preproduction.delivery.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 *
 * @author Irbis
 */
@Entity
@Table(name = "pizza")
public class Pizza {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pizza_id")
    private Integer id;
    @Column(name = "pizza_name")
    private String name;
    @Column(name = "pizza_price")
    private Integer price;
    @Enumerated(EnumType.STRING)
    private PizzaType pizzaType;  

    @Version
    private Long  version;
    
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public enum PizzaType {
        Vegetarian, Sea, Meat, Americana, Hawaiian
    }

    public PizzaType getPizzaType() {
        return pizzaType;
    }        

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", pizzaType=" + pizzaType +
                '}';
    }
}
