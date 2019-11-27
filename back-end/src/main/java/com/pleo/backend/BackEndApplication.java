package com.pleo.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackEndApplication {

    private static final Logger logger = LoggerFactory.getLogger(BackEndApplication.class);

    public static void main(String[] args) {
        logger.info("BackEnd main thread");
        SpringApplication.run(BackEndApplication.class, args);
    }
}