package com.example.DigitalWalletApp.controller;

import com.example.DigitalWalletApp.model.Account;
import com.example.DigitalWalletApp.model.Transaction;
import com.example.DigitalWalletApp.model.User;
import com.example.DigitalWalletApp.repo.AccountRepository;
import com.example.DigitalWalletApp.repo.TransactionRepository;
import com.example.DigitalWalletApp.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class TransactionControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    public void testGetTransactionHistory() throws Exception {
        User user = new User();
        user.setUsername("testUser");
        userRepository.save(user);

        Account account = new Account();
        account.setUser(user);
        accountRepository.save(account);

        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setAmount(BigDecimal.valueOf(100.0));
        transaction.setType("Deposit");
        transaction.setDate(new Date());
        transactionRepository.save(transaction);

        mockMvc.perform(get("/api/transactions/" + account.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].amount").value(100.0))
                .andDo(print());
    }
}