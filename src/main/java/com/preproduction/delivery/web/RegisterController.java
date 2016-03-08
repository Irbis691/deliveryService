/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery.web;

import com.preproduction.delivery.domain.Account;
import com.preproduction.delivery.service.customer.CustomerService;
import com.preproduction.delivery.validator.AccountValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping(value = "/registration")
public class RegisterController {

    @Autowired
    AccountValidator accountValidator;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView viewRegistration() {
        return new ModelAndView("registration", "account", new Account());
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("account") @Validated Account account,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registration";
        } else {
            customerService.registerCustomer(account);
//            model.addAttribute("customer", customerService.registerCustomer(account));
            return "registration";
        }

    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(accountValidator);
    }
}
