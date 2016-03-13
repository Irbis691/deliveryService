package com.preproduction.delivery.web;

import com.preproduction.delivery.domain.Pizza;
import com.preproduction.delivery.service.pizza.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Irbis
 */
@Controller
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @RequestMapping(value = "/pizzas", method = RequestMethod.GET)
    public String view(Model model) {
        model.addAttribute("pizzas", pizzaService.findAll());        
        return "pizzas";
    }
   
    @RequestMapping(value = {"pizza/create", "pizza/edit"}, method = RequestMethod.POST)
    public String createAndEdit(Model model) {
        model.addAttribute("pizzaType", Pizza.PizzaType.values());
        return "newpizza";
    }

    @RequestMapping(value = "pizza/delete", method = RequestMethod.GET)
    public String delete(@ModelAttribute Pizza pizza) {
        pizzaService.delete(pizza);
        return "redirect:pizzas";
    }

    @RequestMapping(value = "pizza/addnew", method = RequestMethod.POST)
    public String add(@ModelAttribute Pizza pizza) {
        pizzaService.saveOrUpdate(pizza);
        return "redirect:pizzas";
    }

    @ModelAttribute("pizza")
    public Pizza findPizza(@RequestParam(value = "pizzaId", required = false) Pizza pizza) {
        return pizza;
    }

}
