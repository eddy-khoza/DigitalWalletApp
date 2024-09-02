package com.example.DigitalWalletApp.service;

import com.example.DigitalWalletApp.model.Account;
import com.example.DigitalWalletApp.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account deposit(Long userId, Double amount) {
        Account account = accountRepository.findByUserId(userId);
        account.setBalance(account.getBalance().add(BigDecimal.valueOf(amount)));
        return accountRepository.save(account);
    }

    public Account withdraw(Long userId, Double amount) throws Exception {
        Account account = accountRepository.findByUserId(userId);
        if (account.getBalance().compareTo(BigDecimal.valueOf(amount)) < 0) {
            throw new Exception("Insufficient balance");
        }
        account.setBalance(account.getBalance().subtract(BigDecimal.valueOf(amount)));
        return accountRepository.save(account);
    }
}
