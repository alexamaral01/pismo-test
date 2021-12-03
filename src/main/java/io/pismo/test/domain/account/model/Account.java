package io.pismo.test.domain.account.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


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

    public Account(String documentNumber) {
        this.documentNumber = documentNumber;
    }
}
