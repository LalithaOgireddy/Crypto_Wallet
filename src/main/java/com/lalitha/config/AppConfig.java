package com.lalitha.config;

import com.lalitha.dao.impl.TransactionDaoImpl;
import com.lalitha.dao.impl.WalletDaoImpl;
import com.lalitha.service.impl.TxnManagementImpl;
import com.lalitha.service.impl.WalletManagementImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public WalletDaoImpl walletDao(){
        return new WalletDaoImpl();
    }

    @Bean
    public TransactionDaoImpl transactionDao(){
        return new TransactionDaoImpl();
    }

    @Bean
    public WalletManagementImpl walletManagement(){
        return new WalletManagementImpl(walletDao());
    }

    @Bean
    public TxnManagementImpl txnManagement(){
        return new TxnManagementImpl(walletDao(),transactionDao());
    }
}
