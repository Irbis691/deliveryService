/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery.web;

import com.preproduction.delivery.domain.Account;
import com.preproduction.delivery.domain.Customer;
import com.preproduction.delivery.domain.Order;
import com.preproduction.delivery.domain.Pizza;
import com.preproduction.delivery.domain.Role;
import com.preproduction.delivery.service.account.AccountService;
import com.preproduction.delivery.service.customer.CustomerService;
import com.preproduction.delivery.service.order.OrderService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Irbis
 */
@Controller
@SessionAttributes("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/order/add", method = RequestMethod.POST)
    public String addPizzaToOrder(@ModelAttribute Pizza pizza,
            @ModelAttribute Order order) {
        orderService.addPizzaToOrder(order, pizza);
        return "redirect:pizzas";
    }

    @RequestMapping(value = "/placeOrder", method = RequestMethod.POST)
    public String placeOrder(@ModelAttribute Order order) {
        if (!order.getOrderPrice().equals(0)) {
            orderService.saveOrUpdate(order);
            order.getPizzas().clear();
            order.setId(null);
            order.setOrderPrice(null);
            order.setOrderSize(null);
        }
        return "redirect:pizzas";
    }

    @RequestMapping(value = "/order/delete/part", method = RequestMethod.POST)
    public String deletePizzaFromOrder(@ModelAttribute Pizza pizza,
            @ModelAttribute Order order) {
        orderService.deletePizzaFomrOrder(order, pizza);
        return "redirect:/app/pizzas";
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String getOrders(Model model) {
        Account account = accountService.findByLogin(SecurityContextHolder.
                getContext().getAuthentication().getName());        
        Set<Role> roles = account.getRoles();
        for (Role r : roles) {
            if (r.getName().equals("USER")) {
                Customer customer = customerService.findByAccount(account);
                model.addAttribute("orders", orderService.findByCustomer(customer));
                return "orders";
            }
        }
        model.addAttribute("orders", orderService.findAll());
        return "orders";
    }
    
    @RequestMapping(value = "/order/status", method = RequestMethod.POST)
    public String setOrderStatus(@RequestParam(value = "orderId") Integer id,
            @RequestParam(value = "status") Order.OrderStatus orderStatus) {    
        Order order = orderService.findById(id);
        orderService.setOrderStatus(order, orderStatus);
        return "redirect:/app/orders";
    }

    @ModelAttribute("order")
    public Order createOrder() {
        Account account = accountService.findByLogin(SecurityContextHolder.
                getContext().getAuthentication().getName());
        Customer customer = customerService.findByAccount(account);
        Order order = new Order(customer, Order.OrderStatus.NEW, 0);
        return order;
    }

    @ModelAttribute("pizza")
    public Pizza findPizza(@RequestParam(value = "pizzaId", required = false) Pizza pizza) {
        return pizza;
    }

}
