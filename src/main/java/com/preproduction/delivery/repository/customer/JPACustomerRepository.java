/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery.repository.customer;

import com.preproduction.delivery.domain.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 *
 * @author Irbis
 */
@Repository
@Transactional
public class JPACustomerRepository implements CustomerRepository{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    @Transactional(readOnly = true)
    public Customer findById(Integer id) {
        return em.find(Customer.class, id);
    }

    @Override
    public Customer saveOrUpdate(Customer customer) {
        if(customer.getId() == null) {
            em.persist(customer);
        } else {
            em.merge(customer);
        }
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer findByAccountMail(String mail) {
        TypedQuery<Customer> query = em.createNamedQuery("Customer.findByAccountMail", Customer.class);
        query.setParameter("mail", mail);
        List<Customer> customers = query.getResultList();
        return CollectionUtils.isEmpty(customers) ? null : customers.get(0);
    }
    
}
