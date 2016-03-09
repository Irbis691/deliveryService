/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery.service.account;

import com.preproduction.delivery.domain.Account;
import com.preproduction.delivery.domain.Role;
import com.preproduction.delivery.repository.account.AccountRepository;
import com.preproduction.delivery.repository.role.RoleRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Irbis
 */
@Service
public class SimpleAccountService implements AccountService{
    
    private static final String ROLE_USER = "USER";

    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Override
    public Account saveOrUpdate(Account account) {
        return accountRepository.saveOrUpdate(account);
    }
    
    @Override
    @Transactional
    public Account findByMail(String mail) {
        return accountRepository.findByMail(mail);
    }
    
    @Override
    @Transactional
    public Account findByLogin(String login) {
        return accountRepository.findByLogin(login);
    }
    
    @Override
    public void setLoginFromEmail(Account account) {        
        String email = account.getMail();
        String login = email.substring(0, email.lastIndexOf("@"));
        account.setLogin(login);        
    }
    
    @Override
    public void setRole(Account account) {
        Role role = roleRepository.findByName(ROLE_USER);
        account.getRoles().add(role);
    }
    
}
