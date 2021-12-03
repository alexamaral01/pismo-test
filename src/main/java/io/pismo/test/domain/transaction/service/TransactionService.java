package io.pismo.test.domain.transaction.service;

import io.pismo.test.domain.transaction.model.Transaction;
import io.pismo.test.dto.CreateTransactionCommand;

/**
 * The interface Transaction service.
 */
public interface TransactionService {

    /**
     * Create transaction transaction.
     *
     * @param createTransactionCommand the create transaction command
     * @return the transaction
     */
    Transaction createTransaction(CreateTransactionCommand createTransactionCommand);
}
