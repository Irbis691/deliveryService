package com.preproduction.delivery.service.customer;

import com.preproduction.delivery.domain.Account;
import com.preproduction.delivery.domain.BonusCard;
import com.preproduction.delivery.domain.Customer;
import com.preproduction.delivery.repository.customer.CustomerRepository;
import com.preproduction.delivery.service.account.AccountService;
import javax.transaction.Transactional;
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
    
    @Autowired
    private AccountService accountService;

    @Override
    @Transactional
    public Customer saveOrUpdate(Customer customer) {
        return customerRepository.saveOrUpdate(customer);
    }      

    @Override
    @Transactional
    public Customer registerCustomer(Account account) {
        Customer customer = new Customer();
        customer.setAccount(account);
        accountService.setLoginFromEmail(customer.getAccount());
        accountService.setRole(customer.getAccount());
        customer.setBonusCard(new BonusCard(0d));
        return saveOrUpdate(customer);
    }   

    @Override
    @Transactional
    public Customer findByAccount(Account account) {
        return customerRepository.findByAccount(account);
    }

}
