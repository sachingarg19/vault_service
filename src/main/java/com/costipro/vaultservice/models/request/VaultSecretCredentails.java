package com.costipro.vaultservice.models.request;

import lombok.Data;

@Data
public class VaultSecretCredentails {
    
    private String key;
    
    private String value;
    
}