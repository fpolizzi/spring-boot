package com.fpolizzi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by fpolizzi on 5/27/26
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class SpringAndSpringBootApplication {

    @Value("${user.my-name}")
    private String userName;

    static void main(String[] args) {
        SpringApplication.run(
                SpringAndSpringBootApplication.class,
                args
        );
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        System.out.println(userName);

        return args -> {};
    }
}

