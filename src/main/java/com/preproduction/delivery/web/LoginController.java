/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Irbis
 */

@Controller
public class LoginController {
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String viewLogin() {
        return "login";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET, params = "error")
    public String viewLoginWithError(Model model) {
        model.addAttribute("error", true);
        return "login";
    }
    
}
