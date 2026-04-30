package com.fpolizzi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@SpringBootApplication
public class SpringAndSpringBootApplication {

    public static List<Person> people = new ArrayList<>();

    static {
        people.add(new Person(1, "John", 20, Gender.MALE));
        people.add(new Person(2, "Mariam", 18, Gender.FEMALE));
        people.add(new Person(3, "Samba", 29, Gender.MALE));
    }

    static void main(String[] args) {
        SpringApplication.run(
                SpringAndSpringBootApplication.class,
                args
        );
    }

    @GetMapping
    public List<Person> getPersons(
            @RequestParam(
                    value = "sort",
                    required = false,
                    defaultValue = "ASC"
            ) SortingOrder sort) {
        if (sort == SortingOrder.ASC) {

            return people.stream()
                    .sorted(Comparator.comparing(Person::id))
                    .collect(Collectors.toList());
        }

        return people.stream()
                .sorted(Comparator.comparing(Person::id).reversed())
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public Optional<Person> getPersonById(
            @PathVariable Integer id
    ) {

        return people.stream()
                .filter(person -> person.id == id)
                .findFirst();
    }

    public enum Gender {MALE, FEMALE}

    public enum SortingOrder {ASC, DESC}

    public record Person(
            int id,
            String name,
            int age,
            Gender gender) {
    }
}
