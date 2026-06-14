package com.fpolizzi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by fpolizzi on 5/27/26
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync

public class SpringAndSpringBootApplication {

    private final static Logger LOGGER =
            LoggerFactory.getLogger(SpringAndSpringBootApplication.class);


    static void main(String[] args) {
        SpringApplication.run(
                SpringAndSpringBootApplication.class,
                args
        );

//        System.out.println("Hello");
//
//        LOGGER.info("Hello World");
//        LOGGER.debug("I am a debug message");
//        LOGGER.warn("I am a warn message");
//        LOGGER.error("I am a error message");
    }
}