package com.preproduction.delivery.service;

import com.preproduction.delivery.domain.Customer;

/**
 * Created by Irbis on 29.01.2016.
 */
public class SimpleCustomerService {

    public Customer createCustomer() {
        return new Customer();
    }

}
