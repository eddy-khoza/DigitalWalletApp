package com.example.DigitalWalletApp.repo;


import com.example.DigitalWalletApp.model.Account;
import com.example.DigitalWalletApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUserId(Long userId);
    List<Account> findByBalanceGreaterThanEqual(BigDecimal balance);
    Optional<Account> findByUser(User user);

}

