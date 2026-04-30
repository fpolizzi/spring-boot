package com.fpolizzi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAndSpringBootApplication {

    static void main(String[] args) {
        SpringApplication.run(
                SpringAndSpringBootApplication.class,
                args
        );
    }

    public enum Gender {MALE, FEMALE}
}
