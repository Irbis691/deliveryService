package com.preproduction.delivery.repository;

import com.preproduction.delivery.domain.Pizza;

import java.util.HashMap;
import java.util.Map;
import com.preproduction.delivery.infrastructure.Benchmark;
import com.preproduction.delivery.infrastructure.PostCreate;

/**
 * Created by Mantixop on 1/21/16.
 */
public class InMemPizzaRepository implements PizzaRepository {

    private static final Map<Integer, Pizza> pizzasDB = new HashMap<Integer, Pizza>();

    @PostCreate
    public void init() {
        pizzasDB.put(1, new Pizza(1,"Sea",20,Pizza.PizzaTipe.Sea));
        pizzasDB.put(2, new Pizza(2,"Meat",10,Pizza.PizzaTipe.Meat));
        pizzasDB.put(3, new Pizza(3,"Vegetarian",30,Pizza.PizzaTipe.Vegetarian));
        pizzasDB.put(4, new Pizza(4,"Americana",40,Pizza.PizzaTipe.Americana));
        pizzasDB.put(5, new Pizza(5,"Hawaiian",50,Pizza.PizzaTipe.Hawaiian));
    }

    @Benchmark
    public Pizza findById(Integer id) {
        return pizzasDB.get(id);
    }
}
