/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery.repository.pizza;

import com.preproduction.delivery.domain.Pizza;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Irbis
 */
@Repository
@Transactional
public class JpaPizzaRepository implements PizzaRepository {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public Pizza findById(Integer id) {
        return em.find(Pizza.class, id);
    }
    
    @Override    
    public Pizza saveOrUpdate(Pizza pizza) {
        if(pizza.getId() == null) {
            em.persist(pizza);
        } else {
            em.merge(pizza);
        }
        return pizza;
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Pizza> findAll() {
        List<Pizza> pizzas = em.createQuery("from Pizza", Pizza.class).getResultList();
        Collections.sort(pizzas);
        return pizzas;
    }

    @Override    
    public void delete(Pizza pizza) {
        Pizza p = em.merge(pizza);
        em.remove(p);
    }
    
}
