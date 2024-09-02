package com.example.DigitalWalletApp.service;

import com.example.DigitalWalletApp.model.Account;
import com.example.DigitalWalletApp.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.DigitalWalletApp.repo.AccountRepository;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @Test
    public void testDeposit() {
        User user = new User();
        user.setId(1L);
        Account account = new Account();
        account.setUser(user);
        account.setBalance(100.0);

        when(accountRepository.findByUserId(1L)).thenReturn(account);

        Account updatedAccount = accountService.deposit(1L, 50.0);

        assertEquals(150.0, updatedAccount.getBalance());
        verify(accountRepository, times(1)).save(account);
    }

    @Test
    public void testWithdraw() throws Exception {
        User user = new User();
        user.setId(1L);
        Account account = new Account();
        account.setUser(user);
        account.setBalance(BigDecimal.valueOf(100.0));

        when(accountRepository.findByUserId(1L)).thenReturn(account);

        Account updatedAccount = accountService.withdraw(1L, 50.0);

        assertEquals(50.0, updatedAccount.getBalance());
        verify(accountRepository, times(1)).save(account);
    }

    @Test
    public void testWithdrawInsufficientBalance() {
        User user = new User();
        user.setId(1L);
        Account account = new Account();
        account.setUser(user);
        account.setBalance(BigDecimal.valueOf(100.0));

        when(accountRepository.findByUserId(1L)).thenReturn(account);

        assertThrows(Exception.class, () -> accountService.withdraw(1L, 150.0));
        verify(accountRepository, times(0)).save(account);
    }
}
