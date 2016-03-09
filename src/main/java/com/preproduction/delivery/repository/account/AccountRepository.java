/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery.repository.account;

import com.preproduction.delivery.domain.Account;
import com.preproduction.delivery.repository.GenericRepository;

/**
 *
 * @author Irbis
 */
public interface AccountRepository extends GenericRepository<Account> {

    Account findByMail(String mail);

    Account findByLogin(String login);
}
