/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery.repository.account;

import com.preproduction.delivery.domain.Account;
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
public class JPAAccountRepository implements AccountRepository{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Account findById(Integer id) {
        return em.find(Account.class, id);
    }

    @Override
    public Account saveOrUpdate(Account account) {
        if(account.getId() == null) {
            em.persist(account);
        } else {
            em.merge(account);
        }
        return account;
    }

    @Override
    public List<Account> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Account entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    @Transactional(readOnly = true)
    public Account findByMail(String mail) {
        TypedQuery<Account> query = em.createNamedQuery("Account.findByMail", Account.class);
        query.setParameter("mail", mail);
        List<Account> accounts = query.getResultList();
        return CollectionUtils.isEmpty(accounts) ? null : accounts.get(0);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Account findByLogin(String login) {
        TypedQuery<Account> query = em.createNamedQuery("Account.findByLogin", Account.class);
        query.setParameter("login", login);
        List<Account> accounts = query.getResultList();
        return CollectionUtils.isEmpty(accounts) ? null : accounts.get(0);
    }
    
}
