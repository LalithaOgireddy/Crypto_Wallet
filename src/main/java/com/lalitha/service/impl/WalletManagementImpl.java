package com.lalitha.service.impl;

import com.lalitha.dao.WalletDao;
import com.lalitha.exception.WalletNotFoundException;
import com.lalitha.exception.WalletValidationException;
import com.lalitha.model.Wallet;
import com.lalitha.service.WalletManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WalletManagementImpl implements WalletManagement {

    private WalletDao walletDao;

    @Autowired
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
