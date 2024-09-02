package com.example.DigitalWalletApp.service;

import com.example.DigitalWalletApp.model.Account;
import com.example.DigitalWalletApp.model.Transaction;
import com.example.DigitalWalletApp.repo.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getTransactionHistory(Long accountId) {
        return transactionRepository.findByAccountId(accountId);
    }
}
