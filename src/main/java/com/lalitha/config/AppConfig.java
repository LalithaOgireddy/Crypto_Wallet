package com.lalitha.config;

import com.lalitha.dao.impl.TransactionDaoImpl;
import com.lalitha.dao.impl.WalletDaoImpl;
import com.lalitha.service.impl.TxnManagementImpl;
import com.lalitha.service.impl.WalletManagementImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.lexicon")
public class AppConfig {


}
