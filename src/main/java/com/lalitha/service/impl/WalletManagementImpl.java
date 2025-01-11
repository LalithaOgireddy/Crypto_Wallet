package com.lalitha.service.impl;

import com.lalitha.dao.WalletDao;
import com.lalitha.exception.WalletNotFoundException;
import com.lalitha.exception.WalletValidationException;
import com.lalitha.model.Wallet;
import com.lalitha.service.WalletManagement;

import java.util.Optional;

public class WalletManagementImpl implements WalletManagement {

    private WalletDao walletDao;

    public WalletManagementImpl(WalletDao walletDao) {
        this.walletDao = walletDao;
    }

    @Override
    public Wallet createWallet(String walletName) {
        if(walletName == null) throw new WalletValidationException("Param is not valid","Wallet name");
        Wallet wallet = new Wallet(walletName);
        return walletDao.createWallet(wallet);
    }

    @Override
    public Wallet getById(String id) {
        Optional<Wallet> wallet = walletDao.findWallet(id);
        if(wallet.isEmpty()) throw new WalletNotFoundException("Wallet not found");
        return wallet.get();
    }
}
