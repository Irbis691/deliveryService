package com.preproduction.delivery.service;

import com.preproduction.delivery.domain.Pizza;
import com.preproduction.delivery.repository.PizzaRepository;
import com.preproduction.delivery.infrastructure.ServiceLocator;

/**
 * Created by Mantixop on 1/21/16.
 */
public class SimplePizzaService implements  PizzaService {

//    PizzaRepository repository = (PizzaRepository) ServiceLocator.getInstance().getService("pizzaRepository");
    
    PizzaRepository pizzaRepository;

    public SimplePizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }
        
    public Pizza find(Integer id) {
        return pizzaRepository.findById(id);
    }
}
