package com.preproduction.delivery.service.pizza;

import com.preproduction.delivery.domain.Pizza;
import java.util.List;

/**
 *
 * @author Irbis
 */
public interface PizzaService {
    Pizza find(Integer id);
    Pizza save(Pizza pizza);
    List<Pizza> findAll();
    void delete(Pizza pizza);
}
