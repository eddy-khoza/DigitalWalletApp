package com.example.DigitalWalletApp.request;

public class GetTransactionHistoryRequest {
    private Long accountId;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}