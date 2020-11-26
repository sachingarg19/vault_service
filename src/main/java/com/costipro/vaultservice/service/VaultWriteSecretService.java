package com.costipro.vaultservice.service;

import com.costipro.vaultservice.models.request.VaultSecrets;

public interface VaultWriteSecretService {
    
    public void writeSecrets(VaultSecrets vaultSecrets);
    
}