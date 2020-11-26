package com.costipro.vaultservice.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.core.VaultKeyValueOperations;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.core.VaultKeyValueOperationsSupport.KeyValueBackend;

@Configuration
public class VaultBeanConfig {

    @Inject
    private VaultTemplate vaultTemplate;
  
    @Bean
    public VaultKeyValueOperations getVaultTemplate(){
      return vaultTemplate.opsForKeyValue("secret", KeyValueBackend.versioned());
    }
    
}