/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery.repository.role;

import com.preproduction.delivery.domain.Role;
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
public class JPARoleRepository implements RoleRepository{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Role findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Role saveOrUpdate(Role entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Role> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Role entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional(readOnly = true)
    public Role findByName(String name) {        
        TypedQuery<Role> query = em.createNamedQuery("Role.findByName", Role.class);
        query.setParameter("name", name);
        List<Role> roles = query.getResultList();
        return CollectionUtils.isEmpty(roles) ? null : roles.get(0);
    }
    
}
