/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery.repository.pizza;

import com.preproduction.delivery.domain.Pizza;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Irbis
 */
@Repository
public class JpaPizzaRepository implements PizzaRepository{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public Pizza findById(Integer id) {
        return em.find(Pizza.class, id);
    }
    
    @Override
    @Transactional
    public Pizza save(Pizza pizza) {
        if(pizza.getId() == null) {            
            em.persist(pizza);
        } else {
            em.merge(pizza);
        }
        return pizza;
    }
}
