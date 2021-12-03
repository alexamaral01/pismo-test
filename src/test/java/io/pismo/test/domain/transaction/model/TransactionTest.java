package io.pismo.test.domain.transaction.model;

import io.pismo.test.domain.account.model.Account;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class TransactionTest {

    @Test
    @DisplayName("Should create transation with entry operation")
    void shouldCreateTransacionWithEntryOperation(){
        Account account = new Account("123");
        OperationType operationType = new OperationType("PAGAMENTO", TransationType.ENTRY);

        Transaction transaction = new Transaction(account, operationType, BigDecimal.TEN.negate());

        assertThat(transaction.getAccount()).isNotNull();
        assertThat(transaction.getAccount().getDocumentNumber()).isEqualTo("123");
        assertThat(transaction.getOperationType()).isNotNull();
        assertThat(transaction.getOperationType().getDescription()).isEqualTo("PAGAMENTO");
        assertThat(transaction.getAmount()).isNotNull().isPositive();
        assertThat(transaction.getEventDate()).isNotNull();

        transaction = new Transaction(account, operationType, BigDecimal.TEN);

        assertThat(transaction.getAccount()).isNotNull();
        assertThat(transaction.getAccount().getDocumentNumber()).isEqualTo("123");
        assertThat(transaction.getOperationType()).isNotNull();
        assertThat(transaction.getOperationType().getDescription()).isEqualTo("PAGAMENTO");
        assertThat(transaction.getAmount()).isNotNull().isPositive();
        assertThat(transaction.getEventDate()).isNotNull();
    }

    @Test
    @DisplayName("Should create transation with exit operation")
    void shouldCreateTransacionWithExitOperation(){
        Account account = new Account("123");
        OperationType operationType = new OperationType("SAQUE", TransationType.EXIT);

        Transaction transaction = new Transaction(account, operationType, BigDecimal.TEN);

        assertThat(transaction.getAccount()).isNotNull();
        assertThat(transaction.getAccount().getDocumentNumber()).isEqualTo("123");
        assertThat(transaction.getOperationType()).isNotNull();
        assertThat(transaction.getOperationType().getDescription()).isEqualTo("SAQUE");
        assertThat(transaction.getAmount()).isNotNull().isNotPositive();
        assertThat(transaction.getEventDate()).isNotNull();
    }
}