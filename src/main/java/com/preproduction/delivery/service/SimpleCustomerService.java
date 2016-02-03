package com.preproduction.delivery.service;

import com.preproduction.delivery.domain.Customer;
import org.springframework.stereotype.Service;

/**
 * Created by Irbis on 29.01.2016.
 */
@Service
public class SimpleCustomerService {

    public Customer createCustomer() {
        return new Customer();
    }

}
