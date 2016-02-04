package com.preproduction.delivery;

import com.preproduction.delivery.infrastructure.ApplicationContext;
import com.preproduction.delivery.infrastructure.JavaConfig;
import com.preproduction.delivery.infrastructure.JavaConfigApplicationContext;
import com.preproduction.delivery.service.order.OrderService;

/**
 *
 * @author Irbis
 */
public class DeliveryApp {
    
    public static int recFact(int n) {
        if(n < 0) {
            throw new IllegalArgumentException();
        } else if(n < 2) {
            return 1;
        } else {
            return n * recFact(n - 1);
        }
    }
    
    public static int iterFact(int n) {
        int res = 1;
        if(n < 0) {
            throw new IllegalArgumentException();
        } else if(n < 2) {
            return res;
        }        
        for(int i = n; i > 0; i--) {
            res *= i;
        }
        return res;
    }
    
    public static void main(String[] args) {
        
//        System.out.println(iterFact(5));

        ApplicationContext context = new JavaConfigApplicationContext(new JavaConfig());
        
        OrderService orderService = null;
        try {
            orderService = (OrderService) context.getBean("orderService");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
//        Order order = orderService.placeNewOrder(new Customer(1, "Customer",
//                new Address("Vyhurovskiy blvd", 3, 33)), 1, 2, 3, 4, 5);
        
//        System.out.println(order);
    }
}
