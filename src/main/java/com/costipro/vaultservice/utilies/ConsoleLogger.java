package com.costipro.vaultservice.utilies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsoleLogger {

    private static Logger logger = LoggerFactory.getLogger(ConsoleLogger.class);

    public void logInfo(String message, Object data){
        logger.info(message, data);
    }

    public void logWarn(String message){
        logger.warn(message);
    }

    public void logDebug(String message){
        logger.debug(message);
    }

    public void logError(String message){
        logger.error(message);
    }
    
}