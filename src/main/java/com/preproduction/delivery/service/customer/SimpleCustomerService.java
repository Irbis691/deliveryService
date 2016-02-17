package com.preproduction.delivery.service.customer;

import com.preproduction.delivery.domain.Customer;
import org.springframework.stereotype.Service;

/**
 *
 * @author Irbis
 */
@Service
public class SimpleCustomerService implements CustomerService{

    public Customer createCustomer() {
        return new Customer();
    }

    public Customer saveCustomer(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
