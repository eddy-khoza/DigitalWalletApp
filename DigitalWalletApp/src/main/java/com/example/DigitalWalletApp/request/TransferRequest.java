package com.example.DigitalWalletApp.request;

public class TransferRequest {
    private String from;
    private String to;
    private String amount;
    private String sender;
    private String recipient;

    public TransferRequest(String from, String to, String amount, String sender, String recipient) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.sender = sender;
        this.recipient = recipient;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}
