package com.fpolizzi.person;

import com.fpolizzi.SortingOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by fpolizzi on 06.05.26
 */
@RestController
@RequestMapping("api/v1/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getPeople(

            @RequestParam(
                    value = "sort",
                    required = false,
                    defaultValue = "ASC"
            ) SortingOrder sort) {

        return personService.getPeople(sort);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Person>> getPersonById(
            @PathVariable Integer id
    ) {
        Optional<Person> person = personService.getPersonById(id);

        return ResponseEntity.ok().body(person);
    }

    @DeleteMapping("{id}")
    public void deletePersonById(@PathVariable Integer id) {

        personService.deletePersonById(id);
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {

        personService.addPerson(person);
    }

    @PutMapping("{id}")
    public void updatePerson(
            @PathVariable Integer id,
            @RequestBody PersonUpdate request
    ) {

        personService.updatePerson(id, request);
    }
}
