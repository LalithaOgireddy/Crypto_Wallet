package com.lalitha.dao.impl;

import com.lalitha.dao.TransactionDao;
import com.lalitha.model.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TransactionDaoImpl implements TransactionDao {

    List<Transaction> storage ;

    public TransactionDaoImpl() {
        this.storage = new ArrayList<>();
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        storage.add(transaction);
        return transaction;
    }

    @Override
    public Optional<Transaction> findById(String txnId) {
        return storage.stream()
                .filter(t -> t.getId().equals(txnId))
                .findFirst();
    }

    @Override
    public List<Transaction> findTransactionByWalletId(String walletId) {
        return storage.stream()
                .filter(transaction -> transaction.getWalletId().equals(walletId))
                .toList();
    }
}
