package com.preproduction.delivery.repository.pizza;

import com.preproduction.delivery.domain.Pizza;
import java.util.List;

/**
 *
 * @author Irbis
 */
public interface PizzaRepository {    
    
    Pizza findById(Integer id);
    Pizza save(Pizza pizza);
    public List<Pizza> findAll();
}
