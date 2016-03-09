package com.preproduction.delivery.repository.order;

import com.preproduction.delivery.domain.Customer;
import com.preproduction.delivery.domain.Order;
import com.preproduction.delivery.repository.GenericRepository;
import java.util.List;

/**
 *
 * @author Irbis
 */
public interface OrderRepository extends GenericRepository<Order> {
    
    List<Order> findByCustomer(Customer customer);
    
}
