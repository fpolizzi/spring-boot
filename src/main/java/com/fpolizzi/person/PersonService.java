package com.fpolizzi.person;

import com.fpolizzi.SortingOrder;
import com.fpolizzi.exception.DuplicateResourceException;
import com.fpolizzi.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final FakePersonRepository fakePersonRepository;
    private final PersonRepository personRepository;

    public PersonService(FakePersonRepository fakePersonRepository, PersonRepository personRepository) {
        this.fakePersonRepository = fakePersonRepository;
        this.personRepository = personRepository;
    }

    public List<Person> getPeople(
            SortingOrder sort
    ) {
        return personRepository.findAll();
    }


    public Person getPersonById(Integer id) {
        return personRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Person with id: " + id + " does not exists"));
    }

    public void deletePersonById(Integer id) {
        boolean existsById = personRepository.existsById(id);

        if (!existsById) {
            throw new ResourceNotFoundException(
                    "Person with id: " + id + " does not exists");
        }

        personRepository.deleteById(id);
    }

    public void addPerson(NewPersonRequest personRequest) {

        if (personRequest.email() != null && !personRequest.email().isEmpty()) {
            boolean exists = personRepository.existsByEmail(personRequest.email());

            if (exists) {
                throw new DuplicateResourceException("email taken");
            }
        }

        Person person = new Person(
                personRequest.name(),
                personRequest.age(),
                personRequest.gender(),
                personRequest.email()
        );

        personRepository.save(person);
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