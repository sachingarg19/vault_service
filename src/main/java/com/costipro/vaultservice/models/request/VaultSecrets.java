package com.costipro.vaultservice.models.request;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NonNull;

@Data
public class VaultSecrets {

	@NonNull
    private String secretPath;
    @NonNull
    private VaultSecretCredentails vaultSecretCredentails;
}