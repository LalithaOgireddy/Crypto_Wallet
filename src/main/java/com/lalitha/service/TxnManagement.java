package com.lalitha.service;

import com.lalitha.model.CryptoCurrency;
import com.lalitha.model.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface TxnManagement {
    Transaction createDepositTransaction(String walletId, CryptoCurrency cryptoCurrency, BigDecimal amount, String description);
    Transaction createWithdrawalTransaction(String walletId, CryptoCurrency cryptoCurrency, BigDecimal amount, String description);
    List<Transaction> getTransactionsByWalletId(String WalletId);
}
