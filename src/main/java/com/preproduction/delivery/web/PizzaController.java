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
import org.springframework.web.bind.annotation.ResponseBody;


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

    @RequestMapping(value = "/pizza", method = RequestMethod.GET)
    @ResponseBody
    public String viewById(@RequestParam("pizzaId") Integer pizzaId,  Model model) {
        Pizza pizza = pizzaService.find(pizzaId);       
        return pizza.toString();
    }
    
    @RequestMapping(value ={"/create", "/edit"}, method = RequestMethod.POST)
    public String createAndEdit(Model model) {
        model.addAttribute("pizzaType", Pizza.PizzaType.values());
        return "newpizza";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@ModelAttribute Pizza pizza) {
        pizzaService.delete(pizza);
        return "redirect:pizzas";
    }
    
    @RequestMapping(value = "/addnew", method = RequestMethod.POST)
    public String add(@ModelAttribute Pizza pizza) {
        pizzaService.save(pizza);
        return "redirect:pizzas";
    }
    
//    @RequestMapping(value = "/edit", method = RequestMethod.POST)
//    public String edit() {
//        return "newpizza";
//    }
    
    @ModelAttribute("pizza")
    public Pizza findPizza(@RequestParam(value = "pizzaId", required = false)
            Pizza pizza) {
        return pizza;
    }
    
//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        binder.registerCustomEditor(Pizza.class, new PropertyEditorSupport() {
//            @Override
//            public void setAsText(String pizzaId) throws IllegalArgumentException {
//                Pizza pizza;
//                if ((pizzaId == null) || pizzaId.isEmpty()) {
//                    pizza = new Pizza();
//                } else {
//                    pizza = pizzaService.find(Integer.valueOf(pizzaId));
//                }
//                setValue(pizza);
//            }
//        });
//    }
}