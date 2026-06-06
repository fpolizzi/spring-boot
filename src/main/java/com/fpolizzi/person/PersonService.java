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

    private final FakePersonRepository fakePersonRepository;

    public PersonService(FakePersonRepository fakePersonRepository) {
        this.fakePersonRepository = fakePersonRepository;
    }

    public List<Person> getPeople(
            SortingOrder sort
    ) {
        if (sort == SortingOrder.ASC) {
            return fakePersonRepository.getPeople().stream()
                    .sorted(Comparator.comparing(Person::getId))
                    .collect(Collectors.toList());
        }
        return fakePersonRepository.getPeople().stream()
                .sorted(Comparator.comparing(Person::getId).reversed())
                .collect(Collectors.toList());
    }


    public Person getPersonById(Integer id) {
        return fakePersonRepository.getPeople().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Person with id: " + id + " does not exists"));
    }

    public void deletePersonById(Integer id) {
        Person person = fakePersonRepository.getPeople().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Person with id: " + id + " does not exists"));
        fakePersonRepository.getPeople().remove(person);
    }

    public void addPerson(NewPersonRequest person) {

        if (person.email() != null && !person.email().isEmpty()) {
            boolean exists = fakePersonRepository.getPeople().stream()
                    .anyMatch(p -> p.getEmail().equalsIgnoreCase(person.email()));
            if (exists) {
                throw new DuplicateResourceException("email taken");
            }
        }

        fakePersonRepository.getPeople().add(
                new Person(
                        fakePersonRepository.getIdCounter().incrementAndGet(),
                        person.name(),
                        person.age(),
                        person.gender(),
                        person.email()
                )
        );
    }

    public void updatePerson(Integer id,
                             PersonUpdateRequest request) {

        Person p = fakePersonRepository.getPeople().stream()
                .filter(person -> person.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Person with id: " + id + " does not exists")
                );

        var index = fakePersonRepository.getPeople().indexOf(p);

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
            fakePersonRepository.getPeople().set(index, person);
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

            fakePersonRepository.getPeople().set(index, person);
        }
    }
}