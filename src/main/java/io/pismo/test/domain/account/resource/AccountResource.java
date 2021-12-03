package io.pismo.test.domain.account.resource;

import io.pismo.test.domain.account.model.Account;
import io.pismo.test.domain.account.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * The type Account resource.
 */
@RestController
@AllArgsConstructor
@RequestMapping("accounts")
public class AccountResource {

    private AccountService accountService;

    /**
     * Create account.
     *
     * @param account the account
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<Account> createAccount( @RequestBody @Valid Account account ){
        return ResponseEntity.ok(accountService.createAccount(account));
    }

    /**
     * Retrieve account.
     *
     * @param accountId the account id
     * @return the response entity<Account>
     */
    @GetMapping("{accountId}")
    public ResponseEntity<Account> retrieveAccount( @PathVariable Long accountId){
        return ResponseEntity.ok(accountService.retrieveAccount(accountId));
    }
}
