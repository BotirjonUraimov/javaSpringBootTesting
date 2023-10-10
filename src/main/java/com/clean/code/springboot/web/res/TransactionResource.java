package com.clean.code.springboot.web.res;

import com.clean.code.springboot.model.Transaction;
import com.clean.code.springboot.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TransactionResource {

    private final TransactionService transactionService;


    public TransactionResource(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/getmsg82")
    public ResponseEntity getMsg() {
        return  ResponseEntity.ok(transactionService.getMessage());
    }

    @PostMapping("/savetransactionto82")
    public ResponseEntity createOnTransactionTo82(@RequestBody Transaction transaction) {
        return ResponseEntity.ok(transactionService.save(transaction).getBody());
    }

}
