package com.costipro.vaultservice.dao.impl;

import javax.inject.Inject;

import com.costipro.vaultservice.dao.VaultWriteSecretServiceDao;
import com.costipro.vaultservice.models.request.VaultSecretCredentails;
import com.costipro.vaultservice.models.request.VaultSecrets;
import com.costipro.vaultservice.utilies.ConsoleLogger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.vault.core.VaultKeyValueOperations;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;

@Repository
public class VaultWriteSecretServiceDaoImpl implements VaultWriteSecretServiceDao {
  //Logger logger = LoggerFactory.getLogger(VaultWriteSecretServiceDaoImpl.class);
  @Inject
  private VaultTemplate vaultTemplate;

  @Inject 
  private VaultKeyValueOperations vaultKeyValueOperationsTemplate;

  @Inject
  private ConsoleLogger logger;
  private static final String LOGGER_PREFIX = "VaultWriteSecretServiceDaoImpl:";

  public void writeSecrets(VaultSecrets vaultSecrets) {
    //logger.logInfo("token : {} ", vaultTemplate.opsForToken().create().getToken().getToken());
    logger.logInfo(LOGGER_PREFIX + "Writing secrets:{} ", vaultSecrets.getSecretPath());
    // Writing the secrets
    vaultKeyValueOperationsTemplate.put(vaultSecrets.getSecretPath(), vaultSecrets.getVaultSecretCredentails());

    // Reading the secrets
    VaultResponseSupport<VaultSecretCredentails> response = vaultKeyValueOperationsTemplate.get(vaultSecrets.getSecretPath(),
        VaultSecretCredentails.class);
    logger.logInfo(LOGGER_PREFIX + "response:{}", response.getData().getKey());
  }
}