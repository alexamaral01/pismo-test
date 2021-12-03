package io.pismo.test.domain.transaction.service;

import io.pismo.test.domain.account.model.Account;
import io.pismo.test.domain.account.service.AccountService;
import io.pismo.test.domain.transaction.model.OperationType;
import io.pismo.test.domain.transaction.model.Transaction;
import io.pismo.test.domain.transaction.repository.TransactionRepository;
import io.pismo.test.dto.CreateTransactionCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * The type Default transaction service.
 */
@Service
@AllArgsConstructor
public class DefaultTransactionService implements TransactionService{

    private TransactionRepository transactionRepository;

    private AccountService accountService;
    private OperationTypeService operationTypeService;


    @Override
    public Transaction createTransaction(CreateTransactionCommand createTransactionCommand) {
        Account account = accountService.retrieveAccount(createTransactionCommand.getAccountId());
        OperationType operationType = operationTypeService.retrieve(createTransactionCommand.getOperationTypeId());
        Transaction transaction = new Transaction(account, operationType, createTransactionCommand.getAmount());

        return transactionRepository.save(transaction);
    }
}
