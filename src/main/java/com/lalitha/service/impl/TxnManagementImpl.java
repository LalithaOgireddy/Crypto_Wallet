package com.lalitha.service.impl;

import com.lalitha.dao.TransactionDao;
import com.lalitha.dao.WalletDao;
import com.lalitha.exception.WalletNotFoundException;
import com.lalitha.model.CryptoCurrency;
import com.lalitha.model.Transaction;
import com.lalitha.model.Wallet;
import com.lalitha.service.TxnManagement;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class TxnManagementImpl implements TxnManagement {
    private final WalletDao walletDao;
    private final TransactionDao transactionDao;

    public TxnManagementImpl(WalletDao walletDao, TransactionDao transactionDao) {
        this.walletDao = walletDao;
        this.transactionDao = transactionDao;
    }

    @Override
    public Transaction createDepositTransaction(String walletId, CryptoCurrency cryptoCurrency, BigDecimal amount, String description) {
        if (walletId == null || cryptoCurrency == null || amount == null || description == null)
            throw new IllegalArgumentException("Transaction params are not valid");

        Optional<Wallet> optionalWallet = walletDao.findWallet(walletId);
        if (optionalWallet.isEmpty()) throw new WalletNotFoundException("Wallet not Found");

        Wallet wallet = optionalWallet.get();
        wallet.deposit(cryptoCurrency, amount);

        Transaction transaction = new Transaction("DEPOSIT", amount, walletId, cryptoCurrency.getName(), description);

        return transactionDao.createTransaction(transaction);
    }

    @Override
    public Transaction createWithdrawalTransaction(String walletId, CryptoCurrency cryptoCurrency, BigDecimal amount, String description) {
        if (walletId == null || cryptoCurrency == null || amount == null || description == null)
            throw new IllegalArgumentException("Transaction params are not valid");

        Optional<Wallet> optionalWallet = walletDao.findWallet(walletId);
        if (optionalWallet.isEmpty()) throw new WalletNotFoundException("Wallet not Found");

        Wallet wallet = optionalWallet.get();
        wallet.deposit(cryptoCurrency, amount);

        Transaction transaction = new Transaction("WITHDRAWAL", amount, walletId, cryptoCurrency.getName(), description);

        return transactionDao.createTransaction(transaction);
    }

    @Override
    public List<Transaction> getTransactionsByWalletId(String WalletId) {
        return transactionDao.findTransactionByWalletId(WalletId);
    }
}
