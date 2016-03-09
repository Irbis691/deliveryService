/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery.service.account;

import com.preproduction.delivery.domain.Account;

/**
 *
 * @author Irbis
 */
public interface AccountService {

    Account saveOrUpdate(Account account);

    void setLoginFromEmail(Account account);

    void setRole(Account account);

    Account findByMail(String mail);

    Account findByLogin(String login);
}
