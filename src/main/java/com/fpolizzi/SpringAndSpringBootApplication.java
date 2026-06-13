package com.fpolizzi;

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

    static void main(String[] args) {
        SpringApplication.run(
                SpringAndSpringBootApplication.class,
                args
        );

        System.out.println("Hello");
    }
}

