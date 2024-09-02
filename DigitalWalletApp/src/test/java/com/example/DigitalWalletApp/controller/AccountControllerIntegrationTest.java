package com.example.DigitalWalletApp.controller;

import com.example.DigitalWalletApp.model.Account;
import com.example.DigitalWalletApp.model.User;
import com.example.DigitalWalletApp.repo.AccountRepository;
import com.example.DigitalWalletApp.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void testDeposit() throws Exception {
        User user = new User();
        user.setUsername("testUser");
        userRepository.save(user);

        Account account = new Account();
        account.setUser(user);
        account.setBalance(BigDecimal.valueOf(100.0));
        accountRepository.save(account);

        mockMvc.perform(post("/api/accounts/deposit")
                        .param("userId", String.valueOf(user.getId()))
                        .param("amount", "50.0"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.balance").value(150.0))
                .andDo(print());
    }

    @Test
    public void testWithdraw() throws Exception {
        User user = new User();
        user.setUsername("testUser");
        userRepository.save(user);

        Account account = new Account();
        account.setUser(user);
        account.setBalance(100.0);
        accountRepository.save(account);

        mockMvc.perform(post("/api/accounts/withdraw")
                        .param("userId", String.valueOf(user.getId()))
                        .param("amount", "50.0"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.balance").value(50.0))
                .andDo(print());
    }
}