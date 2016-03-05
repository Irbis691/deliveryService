package com.preproduction.delivery.service.customer;

import com.preproduction.delivery.domain.Account;
import com.preproduction.delivery.domain.Customer;
import com.preproduction.delivery.repository.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Irbis
 */
@Service
public class SimpleCustomerService implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveOrUpdate(Customer customer) {
        return customerRepository.saveOrUpdate(customer);
    }

    @Override
    public Customer findByMail(String login) {
        return customerRepository.findByAccountMail(login);
    }

    @Override
    public void setLoginFromEmail(Customer customer) {
        Account account = customer.getAccount();
        String email = account.getMail();
        String login = email.substring(0, email.lastIndexOf("@"));
        account.setLogin(login);
        customer.setAccount(account);
    }

    @Override
    public Customer registerCustomer(Account account) {
        Customer customer = new Customer();
        customer.setAccount(account);
        setLoginFromEmail(customer);
        return saveOrUpdate(customer);
    }

}
