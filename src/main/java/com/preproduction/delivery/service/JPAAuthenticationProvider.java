/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery.service;

import com.preproduction.delivery.domain.Account;
import com.preproduction.delivery.domain.Role;
import com.preproduction.delivery.service.customer.CustomerService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

/**
 *
 * @author Irbis
 */
@Component("JPAAuthProvider")
public class JPAAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    CustomerService customerService;

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String login = auth.getName();
        String password = auth.getCredentials().toString();
        Account account = null;
        if (login != null && !"".equals(login)) {
            account = customerService.findByLogin(login).getAccount();
        }
        if (account != null && account.getPassword().equals(password)) {            
            List<GrantedAuthority> authorities = new ArrayList<>();
            for (Role r : account.getRoles()) {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + r.getName()));
            }
            return new UsernamePasswordAuthenticationToken(login, password,
                    authorities);
        }
        throw new BadCredentialsException("Bad Credentials");
    }

    @Override
    public boolean supports(Class<?> type) {
        return type.equals(UsernamePasswordAuthenticationToken.class);
    }

}
