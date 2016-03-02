package com.preproduction.delivery.service.pizza;

import com.preproduction.delivery.domain.Pizza;
import com.preproduction.delivery.repository.pizza.PizzaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Irbis
 */
@Service
@Transactional
public class SimplePizzaService implements PizzaService {
    
    @Autowired
    PizzaRepository pizzaRepository;

    public SimplePizzaService() {
    }

    public SimplePizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }
    
    @Override    
//    @Secured("ROLE_ADMIN")
    public Pizza save(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }
    
    @Override    
    public Pizza find(Integer id) {
        return pizzaRepository.findById(id);
    }
    
    @Override    
//    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public List<Pizza> findAll() {
        return  pizzaRepository.findAll();
    }

    @Override    
    public void delete(Pizza pizza) {
        pizzaRepository.delete(pizza);
    }
}
