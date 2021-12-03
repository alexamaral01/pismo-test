package io.pismo.test.domain.transaction.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.pismo.test.domain.account.model.Account;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static java.util.Objects.requireNonNull;

/**
 * The type Transaction.
 */
@Data
@Entity
@Table(name = "TRANSACTIONS")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactions_seq_gen")
    @SequenceGenerator(name = "transactions_seq_gen", sequenceName = "transactions_transaction_id_seq", allocationSize = 1)
    private Long transactionId;

    /**
     * Instantiates a new Transaction.
     *
     * @param account       the account
     * @param operationType the operation type
     * @param amount        the amount
     */
    public Transaction(Account account, OperationType operationType, BigDecimal amount) {
        this.account = requireNonNull(account);
        this.operationType = requireNonNull(operationType);
        this.amount = operationType.getTransationType().ajustSignal(requireNonNull(amount));
        this.eventDate = LocalDateTime.now();
    }

    @ManyToOne(optional = false )
    @JoinColumn(name="ACCOUNT_ID")
    private Account account;

    @ManyToOne(optional = false)
    @JoinColumn(name="OPERATION_TYPE_ID")
    private OperationType operationType;

    private BigDecimal amount;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime eventDate;

}
