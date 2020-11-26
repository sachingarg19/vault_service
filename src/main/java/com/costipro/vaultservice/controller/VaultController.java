package com.costipro.vaultservice.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.costipro.vaultservice.service.impl.VaultWriteSecretServiceImpl;
import com.costipro.vaultservice.utilies.ConsoleLogger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.ipc.http.HttpSender.Response;
import lombok.NonNull;

import com.costipro.vaultservice.dao.VaultWriteSecretServiceDao;
import com.costipro.vaultservice.dao.impl.VaultWriteSecretServiceDaoImpl;
import com.costipro.vaultservice.models.request.VaultSecretCredentails;
import com.costipro.vaultservice.models.request.VaultSecrets;
import com.costipro.vaultservice.service.VaultWriteSecretService;

@RestController
@RequestMapping("/vaultservice")
public class VaultController {

    // private static Logger logger =
    // LoggerFactory.getLogger(VaultController.class);

    @Inject
    private ConsoleLogger logger;
    @Inject
    private VaultWriteSecretService vaultWriteSecretService;
   
    private static final String LOGGER_PREFIX = "VaultConroller:";

    @GetMapping(path = "/hello")
    public String home() {
        return "Hello World -- Sachin!";
    }

    @PostMapping(path = "/write-secrets")
    public String writeSecrets(@RequestBody VaultSecrets vaultSecrets) {
        logger.logInfo(LOGGER_PREFIX + " request object : ", vaultSecrets.toString());
        vaultWriteSecretService.writeSecrets(vaultSecrets);
        return "";
    }

    @PostMapping(path = "/write")
    public String write(@RequestBody Map<String, Object> values) {
        logger.logInfo(LOGGER_PREFIX + "Secret Path:{}", values.get("secretPath"));
        VaultSecrets vaultSecrets = new VaultSecrets("", new VaultSecretCredentails());
        vaultSecrets.setSecretPath((@NonNull String) values.get("secretPath"));

        Map secrets = (Map) values.get("vaultDbConfig");
        vaultSecrets.getVaultSecretCredentails().setKey((String) secrets.get("key"));
		vaultSecrets.getVaultSecretCredentails().setValue((String) secrets.get("value"));
        vaultWriteSecretService.writeSecrets(vaultSecrets);
        return Response.NO_RESPONSE_BODY;
    }

    /* private void writeSecrets(){
		VaultSecrets vaultSecrets = new VaultSecrets("", new VaultSecretCredentails());
        vaultSecrets.setSecretPath("costipro1/costipro-db");
		vaultSecrets.getVaultSecretCredentails().setKey("abc");
		vaultSecrets.getVaultSecretCredentails().setValue("password");
		vaultWriteSecretServiceDao.writeSecrets(vaultSecrets);
    }
    
    public static void main(String[] args) {
        new VaultController().writeSecrets();
    } */
}