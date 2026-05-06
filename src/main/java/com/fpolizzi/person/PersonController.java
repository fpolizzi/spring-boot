package com.fpolizzi.person;

import com.fpolizzi.SortingOrder;
import com.fpolizzi.SpringAndSpringBootApplication;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by fpolizzi on 06.05.26
 */
@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    @GetMapping
    public List<SpringAndSpringBootApplication.Person> getPersons(
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
                    .sorted(Comparator.comparing(SpringAndSpringBootApplication.Person::getId))
                    .collect(Collectors.toList());
        }

        return people.stream().limit(limit)
                .sorted(Comparator.comparing(SpringAndSpringBootApplication.Person::getId).reversed())
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<SpringAndSpringBootApplication.Person>> getPersonById(
            @PathVariable Integer id
    ) {

        Optional<SpringAndSpringBootApplication.Person> person = people.stream()
                .filter(p -> p.id == id)
                .findFirst();

        return ResponseEntity.ok().body(person);
    }

    @DeleteMapping("{id}")
    public void deletePersonById(@PathVariable Integer id) {

        people.removeIf(person -> person.id == id);
    }

    @PostMapping
    public void addPerson(@RequestBody SpringAndSpringBootApplication.Person person) {
        people.add(
                new SpringAndSpringBootApplication.Person(
                        idCounter.incrementAndGet(),
                        person.name,
                        person.getAge(),
                        person.gender
                )
        );
    }

    @PutMapping("{id}")
    public void updatePerson(
            @PathVariable Integer id,
            @RequestBody PersonUpdate request

    ) {
        people.stream()
                .filter(p -> p.id.equals(id))
                .findFirst()
                .ifPresent(p -> {
                    var index = people.indexOf(p);

                    if (request.name != null &&
                            !request.name.isEmpty() &&
                            !request.name.equals(p.name)) {
                        SpringAndSpringBootApplication.Person person = new SpringAndSpringBootApplication.Person(
                                p.id,
                                request.name,
                                p.getAge(),
                                p.getGender()
                        );
                        people.set(index, person);
                    }
                    if (request.age != null &&
                            !request.age.equals(p.age)) {
                        SpringAndSpringBootApplication.Person person = new SpringAndSpringBootApplication.Person(
                                p.id,
                                p.name, request.age,
                                p.gender
                        );
                        people.set(index, person);
                    }
                });
    }
}
