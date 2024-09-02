package com.example.DigitalWalletApp.controller;

import ch.qos.logback.core.model.Model;
import com.example.DigitalWalletApp.model.Account;
import com.example.DigitalWalletApp.model.User;
import com.example.DigitalWalletApp.request.DepositRequest;
import com.example.DigitalWalletApp.request.TransferRequest;
import com.example.DigitalWalletApp.request.WithdrawRequest;
import com.example.DigitalWalletApp.service.AccountService;
import com.example.DigitalWalletApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/deposit")
    public Account deposit(@RequestParam Long userId, @RequestParam Double amount) {
        return accountService.deposit(userId, amount);
    }

    @PostMapping("/withdraw")
    public Account withdraw(@RequestParam Long userId, @RequestParam Double amount) throws Exception {
        return accountService.withdraw(userId, amount);
    }
}