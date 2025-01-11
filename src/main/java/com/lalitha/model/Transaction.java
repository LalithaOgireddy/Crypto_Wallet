package com.lalitha.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {

    private String id;
    private String type; // Deposit or withdrawal
    private BigDecimal amount;
    private String walletId;
    private String cryptoCurrencySymbol;
    private String description;
    private LocalDateTime timeStamp;

    public Transaction(String type, BigDecimal amount, String walletId, String cryptoCurrencySymbol, String description) {
        this.id = UUID.randomUUID().toString();
        this.type = type;
        this.amount = amount;
        this.walletId = walletId;
        this.cryptoCurrencySymbol = cryptoCurrencySymbol;
        this.description = description;
        this.timeStamp = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getWalletId() {
        return walletId;
    }

    public String getCryptoCurrencySymbol() {
        return cryptoCurrencySymbol;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Transaction{");
        sb.append("id='").append(id).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", amount=").append(amount);
        sb.append(", walletId='").append(walletId).append('\'');
        sb.append(", cryptoCurrencySymbol='").append(cryptoCurrencySymbol).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", timeStamp=").append(timeStamp);
        sb.append('}');
        return sb.toString();
    }
}
