package com.example.DigitalWalletApp.controller;


import com.example.DigitalWalletApp.model.Account;
import com.example.DigitalWalletApp.model.Transaction;
import com.example.DigitalWalletApp.request.TransactionRequest;
import com.example.DigitalWalletApp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/{accountId}")
    public List<Transaction> getTransactionHistory(@PathVariable Long accountId) {
        return transactionService.getTransactionHistory(accountId);
    }
}