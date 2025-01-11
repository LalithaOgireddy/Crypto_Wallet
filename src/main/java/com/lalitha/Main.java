package com.lalitha;

import com.lalitha.config.AppConfig;
import com.lalitha.model.CryptoCurrency;
import com.lalitha.model.Transaction;
import com.lalitha.model.Wallet;
import com.lalitha.service.TxnManagement;
import com.lalitha.service.WalletManagement;
import com.lalitha.service.impl.TxnManagementImpl;
import com.lalitha.service.impl.WalletManagementImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        WalletManagement walletManagement = context.getBean(WalletManagementImpl.class);
        TxnManagement txnManagement = context.getBean(TxnManagementImpl.class);

        Wallet my_wallet = walletManagement.createWallet("My Wallet");
        Transaction myFirstTxn = txnManagement.createDepositTransaction(
                my_wallet.getId(),
                CryptoCurrency.ETH,
                new BigDecimal(100),
                "Sample");

        System.out.println(myFirstTxn.toString());


    }
}