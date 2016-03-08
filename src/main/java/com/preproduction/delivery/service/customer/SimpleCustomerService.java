package com.preproduction.delivery.service.customer;

import com.preproduction.delivery.domain.Account;
import com.preproduction.delivery.domain.BonusCard;
import com.preproduction.delivery.domain.Customer;
import com.preproduction.delivery.domain.Role;
import com.preproduction.delivery.repository.customer.CustomerRepository;
import com.preproduction.delivery.repository.role.RoleRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Irbis
 */
@Service
public class SimpleCustomerService implements CustomerService {
    
    private static final String ROLE_USER = "USER";

    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public Customer saveOrUpdate(Customer customer) {
        return customerRepository.saveOrUpdate(customer);
    }

    @Override
    @Transactional
    public Customer findByMail(String mail) {
        return customerRepository.findByAccountMail(mail);
    }
    
    @Override
    @Transactional
    public Customer findByLogin(String login) {
        return customerRepository.findByAccountLogin(login);
    }

    @Override
    public void setLoginFromEmail(Account account) {        
        String email = account.getMail();
        String login = email.substring(0, email.lastIndexOf("@"));
        account.setLogin(login);        
    }
    
    @Override
    public void setRole(Account account) {
        Role role = roleRepository.findByName(ROLE_USER);
        account.getRoles().add(role);
    }
    
//    @Override
//    public void setCard(Customer customer) {         
//        customer.setBonusCard(new BonusCard());
//    }

    @Override
    @Transactional
    public Customer registerCustomer(Account account) {
        Customer customer = new Customer();
        customer.setAccount(account);
        setLoginFromEmail(account);
        setRole(account);
        customer.setBonusCard(new BonusCard(0d));
        return saveOrUpdate(customer);
    }

}
