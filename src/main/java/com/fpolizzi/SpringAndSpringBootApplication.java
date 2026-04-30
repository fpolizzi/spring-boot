package com.fpolizzi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@RestController
@SpringBootApplication
public class SpringAndSpringBootApplication {

    private static AtomicInteger idCounter = new AtomicInteger(0);

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

    @GetMapping
    public List<Person> getPersons(
            @RequestParam(
                    value = "sort",
                    required = false,
                    defaultValue = "ASC"
            ) SortingOrder sort,

            @RequestParam(
                    value = "limit",
                    required = false,
                    defaultValue = "10"
            ) Integer limit) {

        if (sort == SortingOrder.ASC) {

            return people.stream().limit(limit)
                    .sorted(Comparator.comparing(Person::id))
                    .collect(Collectors.toList());
        }

        return people.stream().limit(limit)
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

    @DeleteMapping("{id}")
    public void deletePersonById(@PathVariable Integer id) {

        people.removeIf(person -> person.id == id);
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        people.add(
                new Person(
                        idCounter.incrementAndGet(),
                        person.name,
                        person.age(),
                        person.gender
                )
        );
    }

    public enum Gender {MALE, FEMALE}

    public enum SortingOrder {ASC, DESC}

    public record Person(Integer id,
                         String name,
                         Integer age,
                         Gender gender) {
    }
}
