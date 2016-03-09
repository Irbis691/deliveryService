/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery.web;

import com.preproduction.delivery.domain.Account;
import com.preproduction.delivery.domain.Customer;
import com.preproduction.delivery.service.account.AccountService;
import com.preproduction.delivery.service.customer.CustomerService;
import com.preproduction.delivery.validator.AccountValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Irbis
 */
@Controller
@RequestMapping(value = "/profile")
public class ProfileController {

    @Autowired
    AccountService accountService;
    
    @Autowired
    CustomerService customerService;

    @Autowired
    AccountValidator accountValidator;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView viewProfile() {
        Account account = accountService.findByLogin(SecurityContextHolder.
                getContext().getAuthentication().getName());
        ModelAndView modelAndView = new ModelAndView("profile", "account", account);
        Customer customer = customerService.findByAccount(account);       
        modelAndView.addObject("bonus", customer.getBonusCard().getBonusSize());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String editProfile(@ModelAttribute("account") @Validated Account account,
           BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:profile";
        } else {
            System.out.println(account);
            accountService.saveOrUpdate(account);
            return "redirect:profile";
        }
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(accountValidator);
    }
}
