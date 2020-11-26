package com.costipro.vaultservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties("costipro")
@Data
public class VaultDbConfig {

    private String username;

    private String password;

}