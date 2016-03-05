/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery.validator;

import com.preproduction.delivery.domain.Account;
import com.preproduction.delivery.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Irbis
 */
@Component
public class AccountValidator implements Validator {

    @Autowired
    EmailValidator emailValidator;

    @Autowired
    CustomerService customerService;
    
    @Override
    public boolean supports(Class<?> type) {
        return Account.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {

        Account account = (Account) o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mail", "NotEmpty.registration.mail");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.registration.password");
        
        if(customerService.findByMail(account.getMail()) != null) {
            errors.rejectValue("mail", "Existed.mail");
        }
        
        if(!emailValidator.validate(account.getMail())) {
            errors.rejectValue("mail", "Pattern.registration.mail");
        }
        
    }

}
