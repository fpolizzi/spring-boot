package com.fpolizzi.person;

import com.fpolizzi.SortingOrder;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> d26277b (organizing code (#7))
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
<<<<<<< HEAD
=======
import com.fpolizzi.SpringAndSpringBootApplication;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.springframework.http.HttpMethod;
=======
>>>>>>> 6c6b94f (refactor: remove service logic from controller)
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
<<<<<<< HEAD
import java.util.stream.Collectors;
>>>>>>> 89a321b (refactor: put controller methods to PersonController)
=======
>>>>>>> 6c6b94f (refactor: remove service logic from controller)
=======
>>>>>>> d26277b (organizing code (#7))

/**
 * Created by fpolizzi on 06.05.26
 */
@RestController
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> d26277b (organizing code (#7))
@RequestMapping("api/v1/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getPeople(

<<<<<<< HEAD
=======
@RequestMapping("api/v1/person")
=======
@RequestMapping("api/v1/persons")
>>>>>>> 6c6b94f (refactor: remove service logic from controller)
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
<<<<<<< HEAD
    public List<SpringAndSpringBootApplication.Person> getPersons(
            HttpMethod httpMethod,
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            @RequestHeader("Content-Type") String contentType,
>>>>>>> 89a321b (refactor: put controller methods to PersonController)
=======
    public List<Person> getPeople(

>>>>>>> 6c6b94f (refactor: remove service logic from controller)
=======
>>>>>>> d26277b (organizing code (#7))
            @RequestParam(
                    value = "sort",
                    required = false,
                    defaultValue = "ASC"
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> d26277b (organizing code (#7))
            ) SortingOrder sort) {

        return personService.getPeople(sort);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Person>> getPersonById(
            @PathVariable Integer id
    ) {
        Optional<Person> person = personService.getPersonById(id);
<<<<<<< HEAD
=======
            ) SortingOrder sort,
=======
            ) SortingOrder sort) {
>>>>>>> 6c6b94f (refactor: remove service logic from controller)

        return personService.getPeople(sort);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Person>> getPersonById(
            @PathVariable Integer id
    ) {
<<<<<<< HEAD

        Optional<SpringAndSpringBootApplication.Person> person = people.stream()
                .filter(p -> p.id == id)
                .findFirst();
>>>>>>> 89a321b (refactor: put controller methods to PersonController)
=======
        Optional<Person> person = personService.getPersonById(id);
>>>>>>> 6c6b94f (refactor: remove service logic from controller)
=======
>>>>>>> d26277b (organizing code (#7))

        return ResponseEntity.ok().body(person);
    }

    @DeleteMapping("{id}")
    public void deletePersonById(@PathVariable Integer id) {

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> d26277b (organizing code (#7))
        personService.deletePersonById(id);
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {

        personService.addPerson(person);
<<<<<<< HEAD
=======
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
>>>>>>> 89a321b (refactor: put controller methods to PersonController)
=======
        personService.deletePersonById(id);
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {

        personService.addPerson(person);
>>>>>>> 6c6b94f (refactor: remove service logic from controller)
=======
>>>>>>> d26277b (organizing code (#7))
    }

    @PutMapping("{id}")
    public void updatePerson(
            @PathVariable Integer id,
            @RequestBody PersonUpdate request
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    ) {

        personService.updatePerson(id, request);
=======

=======
>>>>>>> 6c6b94f (refactor: remove service logic from controller)
    ) {

<<<<<<< HEAD
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
>>>>>>> 89a321b (refactor: put controller methods to PersonController)
=======
        personService.updatePerson(id, request);
>>>>>>> 6c6b94f (refactor: remove service logic from controller)
=======
    ) {

        personService.updatePerson(id, request);
>>>>>>> d26277b (organizing code (#7))
    }
}
