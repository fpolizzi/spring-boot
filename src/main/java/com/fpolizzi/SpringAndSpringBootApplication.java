package com.fpolizzi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;

/**
 * Created by fpolizzi on 5/27/26
 */
@SpringBootApplication
@EnableScheduling
public class SpringAndSpringBootApplication {

    static void main(String[] args) {
        SpringApplication.run(
                SpringAndSpringBootApplication.class,
                args
        );
    }

    @Scheduled(
            fixedRate = 5,
            timeUnit = TimeUnit.SECONDS
    )
    public void sendEmails() throws InterruptedException {

        System.out.println("start sending emails");

        Thread.sleep(2000);

        System.out.println("end sending emails");
    }

    @Scheduled(
            cron = "*/5 * * * * *"
    )
    public void generateSalesReport() throws InterruptedException {

        System.out.println("start sales report");

        Thread.sleep(5000);

        System.out.println("end sales report");
    }
}

