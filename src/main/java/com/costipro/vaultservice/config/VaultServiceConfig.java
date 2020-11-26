package com.costipro.vaultservice.config;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.vault.config.EnvironmentVaultConfiguration;

@PropertySource("bootstap.yml")
@Import(EnvironmentVaultConfiguration.class)
public class VaultServiceConfig {

}