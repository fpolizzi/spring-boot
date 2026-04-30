package com.fpolizzi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
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

    public static List<Person> people = new ArrayList<>();

    static {
        people.add(new Person(1, "John", 20, Gender.MALE));
        people.add(new Person(2, "Mariam", 18, Gender.FEMALE));
        people.add(new Person(3, "Samba", 29, Gender.MALE));
    }

    public List<Person> getPersons() {

        return people;
    }
}
