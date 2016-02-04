package com.preproduction.delivery.service.order;

import com.preproduction.delivery.domain.Customer;
import com.preproduction.delivery.domain.Order;
import com.preproduction.delivery.domain.Pizza;
import com.preproduction.delivery.domain.PriceCalculator;
import com.preproduction.delivery.infrastructure.Benchmark;
import com.preproduction.delivery.repository.order.OrderRepository;
import com.preproduction.delivery.service.pizza.PizzaService;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Irbis
 */
@Service
public /*abstract*/ class SimpleOrderService implements OrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private PizzaService pizzaService;
    private PriceCalculator priceCalculator;

    public SimpleOrderService() {
    }

    
    public SimpleOrderService(OrderRepository orderRepository,
                              PizzaService pizzaService,
                              PriceCalculator priceCalculator) {
        this.orderRepository = orderRepository;
        this.pizzaService = pizzaService;
        this.priceCalculator = priceCalculator;
    }
    
    @Benchmark
    public Order placeNewOrder(Customer customer, Integer ... pizzasID) 
            throws IllegalArgumentException {        
        List<Pizza> pizzas = getListOfPizzasById(pizzasID);       
        Order order = new Order(1, customer, pizzas, Order.OrderStatus.NEW);
//        Order newOrder = createNewOrder();
        saveOrder(order);
        return order;
    }
    
    public void addMorePizzasToOrder(Order order, Integer ... pizzasID) 
            throws IllegalArgumentException {        
        List<Pizza> pizzas = getListOfPizzasById(pizzasID);
        order.addPizzas(pizzas);        
    }
    
//    abstract Order createNewOrder();
//        return new Order(customer, pizzas, orderPrice,
//                Order.OrderStatus.NEW);
//        return (Order) appContext.getBean("order");
    
    public int getOrderPrice(Order order) {
        return priceCalculator.calculatePrice(order);
    }
    
    public void setOrderStatus(Order order, Order.OrderStatus newStatus) {
        if(newStatus.equals(Order.OrderStatus.DONE)) {
            order.getCustomer().getBonusCard().increaseBonusSize(getOrderPrice(order));
        }
        order.setOrderStatus(newStatus);
    }
    
    private List<Pizza> getListOfPizzasById(Integer[] pizzasID) {
        List<Pizza> pizzas = new ArrayList<Pizza>();
        for(Integer id : pizzasID){
            pizzas.add(getPizzaByID(id));
        }
        return pizzas;
    }   

    private void saveOrder(Order newOrder) {
        orderRepository.save(newOrder);
    }

    private Pizza getPizzaByID(Integer id) {
        return pizzaService.find(id);
    }

//    public void setApplicationContext(ApplicationContext ac) throws BeansException {
//        this.appContext = ac;
//    }

}