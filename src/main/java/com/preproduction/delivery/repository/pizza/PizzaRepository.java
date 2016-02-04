package com.preproduction.delivery.repository.pizza;

import com.preproduction.delivery.domain.Pizza;

/**
 *
 * @author Irbis
 */
public interface PizzaRepository {    
    
    Pizza findById(Integer id);
}
