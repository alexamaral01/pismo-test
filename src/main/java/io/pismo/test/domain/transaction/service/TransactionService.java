package io.pismo.test.domain.transaction.service;

import io.pismo.test.domain.transaction.model.Transaction;
import io.pismo.test.dto.CreateTransactionCommand;

public interface TransactionService {

    Transaction createTransaction(CreateTransactionCommand createTransactionCommand);
}
