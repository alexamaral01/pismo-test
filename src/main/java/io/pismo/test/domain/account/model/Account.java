package io.pismo.test.domain.account.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


/**
 * The type Account.
 */
@Data
@Entity
@Table(name = "Accounts")
@NoArgsConstructor
@AllArgsConstructor
public class Account{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accounts_seq_gen")
    @SequenceGenerator(name = "accounts_seq_gen", sequenceName = "accounts_account_id_seq", allocationSize = 1)
    private Long accountId;

    @NotEmpty
    private String documentNumber;

    /**
     * Instantiates a new Account.
     *
     * @param documentNumber the document number
     */
    public Account(String documentNumber) {
        this.documentNumber = documentNumber;
    }
}
