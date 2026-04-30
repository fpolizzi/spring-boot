package com.fpolizzi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringAndSpringBootApplication {

    static void main(String[] args) {
        SpringApplication.run(
                SpringAndSpringBootApplication.class,
                args
        );
    }

    public enum Gender {MALE, FEMALE}

    public record Person(
            int id,
            String name,
            int age,
            Gender gender) {
    }

    public List<Person> getPersons() {

        return null;
    }
}
