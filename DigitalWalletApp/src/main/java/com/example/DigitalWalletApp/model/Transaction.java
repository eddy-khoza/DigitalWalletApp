package com.example.DigitalWalletApp.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "accountid", referencedColumnName = "id")
    private Account account;

    private Date date;

    private String type;

    private BigDecimal amount;

    private String status;

    public Transaction() {
    }

    public Transaction(Long id, Account account, Date date, String type, BigDecimal amount, String status) {
        this.id = id;
        this.account = account;
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.status = status;
    }

    public Transaction(Account account, Date date, String type, BigDecimal amount, String status) {
        this.account = account;
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", account=" + account +
                ", date=" + date +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}
