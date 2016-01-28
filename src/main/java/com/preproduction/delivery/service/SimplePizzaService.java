package com.preproduction.delivery.service;

import com.preproduction.delivery.domain.Pizza;
import com.preproduction.delivery.repository.PizzaRepository;

/**
 * Created by Mantixop on 1/21/16.
 */
public class SimplePizzaService implements PizzaService {
    
    PizzaRepository pizzaRepository;

    public SimplePizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }
        
    public Pizza find(Integer id) {
        return pizzaRepository.findById(id);
    }
}
