package com.example.DigitalWalletApp.repo;

import com.example.DigitalWalletApp.model.Account;
import com.example.DigitalWalletApp.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccountId(Long accountId);
    List<Transaction> findByType(String type);
    List<Transaction> findByAccount(Account account);
}
