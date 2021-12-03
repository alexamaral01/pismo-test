package io.pismo.test.domain.transaction.model;

import io.pismo.test.domain.account.model.Account;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

@Data
@Entity
@Table(name = "TRANSACTIONS")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactions_seq_gen")
    @SequenceGenerator(name = "transactions_seq_gen", sequenceName = "transactions_transaction_id_seq", allocationSize = 1)
    private Long transactionId;

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

    private LocalDateTime eventDate;

}
