package io.pismo.test.domain.account.service;

import io.pismo.test.domain.account.model.Account;

public interface AccountService {

    Account createAccount(Account account);
    Account retrieveAccount(Long id);
}
