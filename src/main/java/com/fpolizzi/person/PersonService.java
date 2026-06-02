package com.fpolizzi.person;

import com.fpolizzi.SortingOrder;
import com.fpolizzi.exception.DuplicateResourceException;
import com.fpolizzi.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPeople(
            SortingOrder sort
    ) {
        if (sort == SortingOrder.ASC) {
            return personRepository.getPeople().stream()
                    .sorted(Comparator.comparing(Person::getId))
                    .collect(Collectors.toList());
        }
        return personRepository.getPeople().stream()
                .sorted(Comparator.comparing(Person::getId).reversed())
                .collect(Collectors.toList());
    }


    public Person getPersonById(Integer id) {
        return personRepository.getPeople().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Person with id: " + id + " does not exists"));
    }

    public void deletePersonById(Integer id) {
        Person person = personRepository.getPeople().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Person with id: " + id + " does not exists"));
        personRepository.getPeople().remove(person);
    }

    public void addPerson(NewPersonRequest person) {

        if (person.email() != null && !person.email().isEmpty()) {
            boolean exists = personRepository.getPeople().stream()
                    .anyMatch(p -> p.getEmail().equalsIgnoreCase(person.email()));
            if (exists) {
                throw new DuplicateResourceException("email taken");
            }
        }

        personRepository.getPeople().add(
                new Person(
                        personRepository.getIdCounter().incrementAndGet(),
                        person.name(),
                        person.age(),
                        person.gender(),
                        person.email()
                )
        );
    }

    public void updatePerson(Integer id,
                             PersonUpdateRequest request) {

        Person p = personRepository.getPeople().stream()
                .filter(person -> person.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Person with id: " + id + " does not exists")
                );

        var index = personRepository.getPeople().indexOf(p);

        if (request.name() != null &&
                !request.name().isEmpty() &&
                !request.name().equals(p.getName())) {
            Person person = new Person(
                    p.getId(),
                    request.name(),
                    p.getAge(),
                    p.getGender(),
                    p.getEmail()
            );
            personRepository.getPeople().set(index, person);
        }
        if (request.age() != null
                && !request.age().equals(p.getAge())) {
            Person person = new Person(
                    p.getId(),
                    p.getName(),
                    request.age(),
                    p.getGender(),
                    p.getName()
            );

            personRepository.getPeople().set(index, person);
        }
    }
}