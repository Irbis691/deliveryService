package com.preproduction.delivery.service.pizza;

import com.preproduction.delivery.domain.Pizza;
import com.preproduction.delivery.repository.pizza.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Irbis
 */
@Service
public class SimplePizzaService implements PizzaService {
    
    @Autowired
    PizzaRepository pizzaRepository;

    public SimplePizzaService() {
    }

    public SimplePizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }
        
    public Pizza find(Integer id) {
        return pizzaRepository.findById(id);
    }
}
