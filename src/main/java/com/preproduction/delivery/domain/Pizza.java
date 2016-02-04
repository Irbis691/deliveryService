package com.preproduction.delivery.domain;

/**
 *
 * @author Irbis
 */
public class Pizza {
    private Integer id;
    private String name;
    private Integer price;
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
