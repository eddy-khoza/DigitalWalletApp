package com.example.DigitalWalletApp.service;


import com.example.DigitalWalletApp.model.Transaction;
import com.example.DigitalWalletApp.repo.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionService transactionService;

    @Test
    public void testGetTransactionHistory() {
        Transaction transaction = new Transaction();
        transaction.setAmount(BigDecimal.valueOf(100.0));
        transaction.setType("Deposit");

        when(transactionRepository.findByAccountId(1L)).thenReturn(Collections.singletonList(transaction));

        List<Transaction> transactions = transactionService.getTransactionHistory(1L);

        assertEquals(1, transactions.size());
        assertEquals(100.0, transactions.get(0).getAmount());
        verify(transactionRepository, times(1)).findByAccountId(1L);
    }
}