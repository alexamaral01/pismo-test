package io.pismo.test.domain.account.service;

import io.pismo.test.domain.account.model.Account;
import io.pismo.test.domain.account.repository.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class DefaultAccountService implements AccountService {

    private AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {
        if( accountRepository.existsByDocumentNumber(account.getDocumentNumber())) {
            throw new IllegalArgumentException("Account found with this document number.");
        }

        return accountRepository.save(account);
    }

    @Override
    public Account retrieveAccount(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found."));
    }
}
