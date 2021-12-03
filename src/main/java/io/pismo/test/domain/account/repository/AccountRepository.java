package io.pismo.test.domain.account.repository;

import io.pismo.test.domain.account.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface AccountRepository extends CrudRepository<Account, Long> {


    Optional<Account> findByDocumentNumber(String documentNumber);
    Boolean existsByDocumentNumber(String documentNumber);
}
