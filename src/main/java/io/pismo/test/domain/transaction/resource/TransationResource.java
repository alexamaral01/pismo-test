package io.pismo.test.domain.transaction.resource;

import io.pismo.test.domain.transaction.model.Transaction;
import io.pismo.test.domain.transaction.service.TransactionService;
import io.pismo.test.dto.CreateTransactionCommand;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("transactions")
public class TransationResource {

    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransation(@RequestBody @Valid CreateTransactionCommand createTransactionCommand){
        return ResponseEntity.ok(transactionService.createTransaction(createTransactionCommand));
    }
}
