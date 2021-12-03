package io.pismo.test.domain.account.repository;

import io.pismo.test.domain.account.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * The interface Account repository.
 */
@Component
public interface AccountRepository extends CrudRepository<Account, Long> {

    /**
     * Exists account by document number.
     *
     * @param documentNumber the document number
     * @return the boolean
     */
    Boolean existsByDocumentNumber(String documentNumber);
}
