/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery.repository.order;

import com.preproduction.delivery.domain.Customer;
import com.preproduction.delivery.domain.Order;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 *
 * @author Irbis
 */
@Repository
@Transactional
public class JPAOrderRepository implements OrderRepository {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    @Transactional(readOnly = true)
    public Order findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order saveOrUpdate(Order order) {
        if(order.getId() == null) {
            em.persist(order);
        } else {
            em.merge(order);
        }
        return order;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Order entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Order> findByCustomer(Customer customer) {
        TypedQuery<Order> query = em.createNamedQuery("Order.findByCustomer", Order.class);
        query.setParameter("customer", customer);
        List<Order> orders = query.getResultList();
        return CollectionUtils.isEmpty(orders) ? null : orders;
    }
    
}
