/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery.service.customer;

import com.preproduction.delivery.domain.Account;
import com.preproduction.delivery.domain.Customer;

/**
 *
 * @author Irbis
 */
public interface CustomerService {    
    
    Customer saveOrUpdate(Customer customer);   
    Customer findByMail(String login);
    Customer registerCustomer(Account account);
    void setLoginFromEmail(Customer customer);
            
}
