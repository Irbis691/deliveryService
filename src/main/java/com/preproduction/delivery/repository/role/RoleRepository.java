/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery.repository.role;

import com.preproduction.delivery.domain.Role;
import com.preproduction.delivery.repository.GenericRepository;

/**
 *
 * @author Irbis
 */
public interface RoleRepository extends GenericRepository<Role> {

    Role findByName(String name);
}
