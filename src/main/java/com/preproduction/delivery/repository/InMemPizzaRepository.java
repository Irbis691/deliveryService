package com.preproduction.delivery.repository;

import com.preproduction.delivery.domain.Pizza;

import java.util.Map;
import com.preproduction.delivery.infrastructure.Benchmark;
import com.preproduction.delivery.infrastructure.PostCreate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Created by Mantixop on 1/21/16.
 */
@Repository
//@Qualifier()
public class InMemPizzaRepository implements PizzaRepository {

    private Map<Integer, Pizza> pizzasDB;

    @PostCreate
    public void init() {
        pizzasDB.put(1, new Pizza(1, "Sea", 10, Pizza.PizzaType.Meat));
        pizzasDB.put(2, new Pizza(2, "Meat", 20, Pizza.PizzaType.Meat));
        pizzasDB.put(3, new Pizza(3, "Veg", 30, Pizza.PizzaType.Meat));
    }

    public Map<Integer, Pizza> getPizzasDB() {
        return pizzasDB;
    }

    public void setPizzasDB(Map<Integer, Pizza> pizzasDB) {
        this.pizzasDB = pizzasDB;
    }        

    @Benchmark
    public Pizza findById(Integer id) {
        return pizzasDB.get(id);
    }
}
