package io.pismo.test.domain.transaction.repository;

import io.pismo.test.domain.transaction.model.Transaction;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Transaction repository.
 */
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

}
