package com.preproduction.delivery.domain;

/**
 * Created by Mantixop on 1/21/16.
 */
public class Pizza {
    private Integer id;
    private String name;
    private Integer price;
    private PizzaType pizzaTipe;  

    public Pizza() {        
    }        
    
    public Pizza(Integer id, String name, Integer price, PizzaType pizzaTipe) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pizzaTipe = pizzaTipe;
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

    public PizzaType getPizzaTipe() {
        return pizzaTipe;
    }        

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", pizzaTipe=" + pizzaTipe +
                '}';
    }
}
