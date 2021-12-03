package io.pismo.test.domain.account.service;

import io.pismo.test.domain.account.model.Account;

/**
 * The interface Account service.
 */
public interface AccountService {

    /**
     * Create account account.
     *
     * @param account the account
     * @return the account
     */
    Account createAccount(Account account);

    /**
     * Retrieve account account.
     *
     * @param id the id
     * @return the account
     */
    Account retrieveAccount(Long id);
}
