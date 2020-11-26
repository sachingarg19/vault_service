package com.costipro.vaultservice;

import javax.inject.Inject;

import com.costipro.vaultservice.config.VaultDbConfig;
import com.costipro.vaultservice.utilies.ConsoleLogger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Profile;

/*
To run local vault server --dev --dev-root-token-id="00000000-0000-0000-0000-000000000000"
*/
@SpringBootApplication
@EnableConfigurationProperties(VaultDbConfig.class)
@Profile({"dev"})
public class VaultApplication implements CommandLineRunner {
	//Logger logger = LoggerFactory.getLogger(VaultApplication.class);

	@Inject
	private VaultDbConfig vaultDbConfig;

	@Inject
	private ConsoleLogger logger;

	private static final String LOGGER_PREFIX = "VaultApplication:";
	
	public static void main(String[] args) {
		SpringApplication.run(VaultApplication.class, args);
	}

	@Override
	public void run(String... args) {
		logger.logInfo(LOGGER_PREFIX + "----------------------------------------","");
		logger.logInfo(LOGGER_PREFIX + "Configuration properties","");
		logger.logInfo(LOGGER_PREFIX + "example.username:{}", vaultDbConfig.getUsername());
		logger.logInfo(LOGGER_PREFIX + "example.password:{}", vaultDbConfig.getPassword());
		logger.logInfo(LOGGER_PREFIX+"----------------------------------------","");
	}

}
