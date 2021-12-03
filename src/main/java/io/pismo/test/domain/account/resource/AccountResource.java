package io.pismo.test.domain.account.resource;

import io.pismo.test.domain.account.model.Account;
import io.pismo.test.domain.account.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("accounts")
public class AccountResource {

    private AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount( @RequestBody @Valid Account account ){
        return ResponseEntity.ok(accountService.createAccount(account));
    }

    @GetMapping("{accountId}")
    public ResponseEntity<Account> retrieveAccount( @PathVariable Long accountId){
        return ResponseEntity.ok(accountService.retrieveAccount(accountId));
    }
}
