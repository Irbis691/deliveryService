package com.preproduction.delivery.locator;

import com.preproduction.delivery.repository.InMemPizzaRepository;
import com.preproduction.delivery.repository.InMemOrderRepository;
import com.preproduction.delivery.service.SimpleOrderService;
import com.preproduction.delivery.service.SimplePizzaService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mantixop on 1/22/16.
 */
public class JavaConfig implements Config {
    private Map<String,Class<?>> ifc2Class = new HashMap<String, Class<?>>();

    public JavaConfig() {
        ifc2Class.put("pizzaRepository", InMemPizzaRepository.class);
        ifc2Class.put("orderRepository", InMemOrderRepository.class);
        ifc2Class.put("orderService", SimpleOrderService.class);
        ifc2Class.put("pizzaService", SimplePizzaService.class);
    }


    public <T> Class<T> getImpl(String ifc) {
        return (Class<T>) ifc2Class.get(ifc);
    }
}
