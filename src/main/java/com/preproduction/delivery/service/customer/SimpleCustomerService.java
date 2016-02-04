package com.preproduction.delivery.service.customer;

import com.preproduction.delivery.domain.Customer;
import org.springframework.stereotype.Service;

/**
 *
 * @author Irbis
 */
@Service
public class SimpleCustomerService {

    public Customer createCustomer() {
        return new Customer();
    }

}
