package com.lalitha.dao;

import com.lalitha.model.Wallet;
import java.util.Optional;

public interface WalletDao {

    Wallet createWallet(Wallet wallet);
    Optional<Wallet> findWallet(String id);
}
