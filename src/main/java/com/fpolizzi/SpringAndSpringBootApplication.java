package com.fpolizzi;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/person")
@SpringBootApplication
public class SpringAndSpringBootApplication {

    public static List<Person> people = new ArrayList<>();
    private static AtomicInteger idCounter = new AtomicInteger(0);

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
            HttpMethod httpMethod,
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            @RequestHeader("Content-Type") String contentType,
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

        System.out.println(httpMethod);
        System.out.println(servletRequest.getLocalAddr());
        System.out.println(servletResponse.isCommitted());
        System.out.println(contentType);

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
    public ResponseEntity<Optional<Person>> getPersonById(
            @PathVariable Integer id
    ) {

        Optional<Person> person = people.stream()
                .filter(p -> p.id == id)
                .findFirst();

        return ResponseEntity.ok().body(person);
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
