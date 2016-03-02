package com.preproduction.delivery.repository.pizza;

import com.preproduction.delivery.domain.Pizza;

import java.util.Map;
import com.preproduction.delivery.infrastructure.Benchmark;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Irbis
 */
//@Repository
public class InMemPizzaRepository implements PizzaRepository {

    private Map<Integer, Pizza> pizzasDB;

    public InMemPizzaRepository() {
        this.pizzasDB = new HashMap<Integer, Pizza>();
    }        
//
//    @PostConstruct
//    public void init() {
//        pizzasDB.put(1, new Pizza(1, 10, Pizza.PizzaType.Sea));
//        pizzasDB.put(2, new Pizza(2, 20, Pizza.PizzaType.Meat));
//        pizzasDB.put(3, new Pizza(3, 30, Pizza.PizzaType.Vegetarian));
//    }

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

    public Pizza save(Pizza pizza) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pizza> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Pizza pizza) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
