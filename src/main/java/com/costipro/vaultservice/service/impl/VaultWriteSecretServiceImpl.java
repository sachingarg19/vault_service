package com.costipro.vaultservice.service.impl;

import javax.inject.Inject;
import com.costipro.vaultservice.dao.VaultWriteSecretServiceDao;
import com.costipro.vaultservice.models.request.VaultSecrets;
import com.costipro.vaultservice.service.VaultWriteSecretService;
import com.costipro.vaultservice.utilies.ConsoleLogger;

import org.springframework.stereotype.Service;

@Service
public class VaultWriteSecretServiceImpl implements VaultWriteSecretService {

    @Inject
    private VaultWriteSecretServiceDao vaultWriteSecretServiceDao;

    @Inject
    ConsoleLogger logger;

    private static final String LOGGER_PREFIX = "VaultWriteSecretServiceImpl:";

    @Override
    public void writeSecrets(VaultSecrets vaultSecrets) {
        logger.logInfo(LOGGER_PREFIX + "secretPath:{}", vaultSecrets.getSecretPath());
        vaultWriteSecretServiceDao.writeSecrets(vaultSecrets);
    }
    
}