package com.preproduction.delivery.repository;

import com.preproduction.delivery.domain.Pizza;

/**
 * Created by Mantixop on 1/21/16.
 */
public interface PizzaRepository {
    Pizza findById(Integer id);
}