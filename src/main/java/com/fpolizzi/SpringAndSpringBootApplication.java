package com.fpolizzi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@SpringBootApplication
public class SpringAndSpringBootApplication {

    public static List<Person> people = new ArrayList<>();

    static {
        people.add(new Person(idCounter.incrementAndGet(), "John", 20, Gender.MALE));
        people.add(new Person(idCounter.incrementAndGet(), "Mariam", 18, Gender.FEMALE));
        people.add(new Person(idCounter.incrementAndGet(), "Samba", 29, Gender.MALE));
    }

    static void main(String[] args) {
        SpringApplication.run(
                SpringAndSpringBootApplication.class,
                args
        );
    }

    @Bean
    CommandLineRunner commandLineRunner(ObjectMapper objectMapper) {

        String personString = "{\"id\":1, \"name\":\"John Doe\", \"age\":37, \"gender\":\"MALE\"}";
        Person person = objectMapper.readValue(personString, Person.class);

        // Serialize and Deserialize Object to Json
        System.out.println(person);
        System.out.println(objectMapper.writeValueAsString(person));

        return args -> {

        };
    }
}
