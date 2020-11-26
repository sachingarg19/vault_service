package com.costipro.vaultservice.dao;

import com.costipro.vaultservice.models.request.VaultSecrets;

public interface VaultWriteSecretServiceDao {
    public void writeSecrets(VaultSecrets vaultSecrets);
}