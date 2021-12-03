package io.pismo.test.domain.account.service;

import io.pismo.test.domain.account.model.Account;
import io.pismo.test.domain.account.repository.AccountRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
class DefaultAccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private DefaultAccountService accountService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

    }

    @Test
    @DisplayName("Should create account when don't find account with document number.")
    void shouldCreateWhenNotExistAccountWithDocumentNumberTest() {
        when(accountRepository.existsByDocumentNumber(any())).thenReturn(Boolean.FALSE);
        when(accountRepository.save(any()))
                .thenAnswer( call -> new Account(1l, ((Account)call.getArgument(0)).getDocumentNumber()));

        Account account = new Account("123");

        Account accountSaved = accountService.createAccount(account);

        assertThat(accountSaved.getAccountId()).isNotNull();
        assertThat(accountSaved.getDocumentNumber()).isEqualTo("123");
    }

    @Test
    @DisplayName("Should error when found account with document number.")
    void shouldErrorWhenExistAccountWithDocumentNumberTest() {

        when(accountRepository.existsByDocumentNumber(any())).thenReturn(Boolean.TRUE);
        when(accountRepository.save(any()))
                .thenAnswer( call -> new Account(1l, ((Account)call.getArgument(0)).getDocumentNumber()));

        Account account = new Account("123");

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    accountService.createAccount(account);
                }).withMessage("Account found with this document number.");
    }

    @Test
    @DisplayName("Should return account when found account with id.")
    void shouldReturnWhenFoundAccountWithId() {
        when(accountRepository.findById(any()))
                .thenReturn(Optional.of(new Account(250l, "123123")));

        Account accountFound = accountService.retrieveAccount(250l);

        assertThat(accountFound.getAccountId()).isNotNull();
        assertThat(accountFound.getDocumentNumber()).isEqualTo("123123");
    }

    @Test
    @DisplayName("Should return error when not found account with id.")
    void shouldReturnErrorWhenNotFoundAccountWithId() {
        when(accountRepository.findById(any())).thenReturn(Optional.empty());

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    accountService.retrieveAccount(200l);
                }).withMessage("Account not found.");
    }
}