package com.lalitha.model;

import com.lalitha.exception.InsufficientBalanceException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Wallet {

    private final String id;
    private final String walletName;
    private final Map<CryptoCurrency, BigDecimal>  cryptocurrencies;

    public Wallet(String walletName) {
        this.id = UUID.randomUUID().toString();
        this.walletName = walletName;
        this.cryptocurrencies = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public String getWalletName() {
        return walletName;
    }

    public Map<CryptoCurrency, BigDecimal> getCryptocurrencies() {
        return cryptocurrencies;
    }

    public BigDecimal getBalance(CryptoCurrency cryptoCurrency){
        return getCryptocurrencies().getOrDefault(cryptoCurrency, BigDecimal.ZERO);
    }

    public void deposit(CryptoCurrency cryptoCurrency, BigDecimal amount){
        if(amount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("Deposit amount must be greater than zero");
        BigDecimal balance = getBalance(cryptoCurrency);
        BigDecimal newBalance = balance.add(amount);

        cryptocurrencies.put(cryptoCurrency,newBalance);
    }

    public void withdrawal(CryptoCurrency cryptoCurrency, BigDecimal amount){
        if(amount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("Withdrawal amount must be greater than zero");
        BigDecimal balance = getBalance(cryptoCurrency);
        if(amount.compareTo(balance) < 0) throw new InsufficientBalanceException("Insufficient balance for withdrawal");
        BigDecimal newBalance = balance.subtract(amount);

        cryptocurrencies.put(cryptoCurrency,newBalance);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Wallet{");
        sb.append("id='").append(id).append('\'');
        sb.append(", walletName='").append(walletName).append('\'');
        sb.append(", cryptocurrencies=").append(cryptocurrencies);
        sb.append('}');
        return sb.toString();
    }
}
