package com.preproduction.delivery.service;

import com.preproduction.delivery.domain.BonusCard;
import com.preproduction.delivery.domain.Customer;
import com.preproduction.delivery.domain.Order;
import com.preproduction.delivery.domain.Pizza;
import com.preproduction.delivery.infrastructure.Benchmark;
import com.preproduction.delivery.repository.OrderRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mantixop on 1/21/16.
 */
@Service
public abstract class SimpleOrderService implements OrderService { //, ApplicationContextAware{
    
    private static final double DISCOUNT_FOR_BIG_SIZE_ORDER = 0.7;
    private static final int ORDER_SIZE_THRESHOLD = 4;
    private static final double UPPER_BOUND_FOR_BONUS = 0.3;
            
    private OrderRepository orderRepository;
    private PizzaService pizzaService;
//    private ApplicationContext appContext;

    public SimpleOrderService() {
    }

    @Autowired
    public SimpleOrderService(OrderRepository orderRepository,
                              PizzaService pizzaService) {
        this.orderRepository = orderRepository;
        this.pizzaService = pizzaService;
    }
    
    @Benchmark
    public Order placeNewOrder(Customer customer, Integer ... pizzasID) 
            throws IllegalArgumentException {
        checkPizzasNumber(pizzasID.length);
        List<Pizza> pizzas = getListOfPizzasById(pizzasID);       
        Integer orderPrice = countOrderPrice(pizzas, customer);
        Order newOrder = createNewOrder();
        saveOrder(newOrder);
        return newOrder;
    }
    
    abstract Order createNewOrder();
//        return new Order(customer, pizzas, orderPrice,
//                Order.OrderStatus.NEW);
//        return (Order) appContext.getBean("order");
    
    
    public void addMorePizzasToOrder(Order order, Integer ... pizzasID) 
            throws IllegalArgumentException {
        List<Pizza> pizzasFromOrder = order.getPizzas();
        checkPizzasNumber(pizzasFromOrder.size() + pizzasID.length);
        List<Pizza> pizzas = getListOfPizzasById(pizzasID);
        pizzasFromOrder.addAll(pizzas);
        int orderPrice = countOrderPrice(pizzasFromOrder, order.getCustomer());
        order.setPizzas(pizzasFromOrder);
        order.setOrderPrice(orderPrice);        
    } 
    
    private void checkPizzasNumber(int pizzasNumber) throws IllegalArgumentException {
        if(pizzasNumber > 10) {
            throw new IllegalArgumentException("No more than 10 pizzas in one order");
        }
    }
    
    private List<Pizza> getListOfPizzasById(Integer[] pizzasID) {
        List<Pizza> pizzas = new ArrayList<Pizza>();
        for(Integer id : pizzasID){
            pizzas.add(getPizzaByID(id));
        }
        return pizzas;
    }        
    
    private Integer countOrderPrice(List<Pizza> pizzas, Customer customer) {
        grantDiscountForBigSizeOrder(pizzas);
        Integer price = 0;
        for (Pizza p : pizzas) {            
            price += p.getPrice();
        }
        BonusCard bonusCard = customer.getBonusCard();
        price = grantDiscountForBonuses(bonusCard, price);
        return price;
    }

    private void grantDiscountForBigSizeOrder(List<Pizza> pizzas) {
        if (pizzas.size() > ORDER_SIZE_THRESHOLD) {
            Pizza mostExpensivePizza = pizzas.get(0);
            for (Pizza p : pizzas) {
                if(p.getPrice() > mostExpensivePizza.getPrice()) {
                    mostExpensivePizza = p;
                }
            }
            mostExpensivePizza.setPrice((int)(mostExpensivePizza.getPrice() *
                    DISCOUNT_FOR_BIG_SIZE_ORDER));
        }
    }
    
    private Integer grantDiscountForBonuses(BonusCard bonusCard, Integer price) {
        if(bonusCard != null) {
            Integer bonusSize = bonusCard.getBonusSize();
            if(price - bonusSize < price * UPPER_BOUND_FOR_BONUS) {
                price -= bonusSize;
            } else {
                price = (int)(price * (1 - UPPER_BOUND_FOR_BONUS));
            }
        }
        return price;
    }
    
    public void changeOrderStatus(Order order, Order.OrderStatus orderStatus) {
        Order.OrderStatus type = order.getOrderStatus();
        if(Arrays.asList(type.getValidTransitionStatuses()).contains(orderStatus)) {
            order.setOrderStatus(orderStatus);
        } else {
            throw new IllegalArgumentException("Not valid transition status");
        }
        if(orderStatus.equals(Order.OrderStatus.DONE)) {
            increaseBonuses(order);
        }
    }

    private void increaseBonuses(Order order) {
        order.getCustomer().getBonusCard().increaseBonusSize(order.getOrderPrice());
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