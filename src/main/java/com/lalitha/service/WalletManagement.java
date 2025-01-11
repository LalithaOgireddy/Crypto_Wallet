package com.lalitha.service;

import com.lalitha.model.Wallet;

public interface WalletManagement {
    Wallet createWallet(String walletName);
    Wallet getById(String id);
}
