package com.fpolizzi.person;

import com.fpolizzi.SortingOrder;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
<<<<<<< HEAD
<<<<<<< HEAD
import java.util.Objects;
=======
>>>>>>> 6138dde (refactor: restrucure and introduce repository)
=======
import java.util.Objects;
>>>>>>> 9365a7e (refactor: replace == by equals)
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by fpolizzi on 06.05.26
 */
@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPeople(
            SortingOrder sort) {

        if (sort == SortingOrder.ASC) {

            return personRepository.getPeople().stream()
                    .sorted(Comparator.comparing(Person::id))
                    .collect(Collectors.toList());
        }

        return personRepository.getPeople().stream()
                .sorted(Comparator.comparing(Person::id).reversed())
                .collect(Collectors.toList());
    }


    public Optional<Person> getPersonById(
            Integer id
    ) {

        return personRepository.getPeople().stream()
<<<<<<< HEAD
<<<<<<< HEAD
                .filter(p -> Objects.equals(p.id(), id))
=======
                .filter(p -> p.id() == id)
>>>>>>> 6138dde (refactor: restrucure and introduce repository)
=======
                .filter(p -> Objects.equals(p.id(), id))
>>>>>>> 9365a7e (refactor: replace == by equals)
                .findFirst();
    }

    public void deletePersonById(Integer id) {

        personRepository.getPeople()
<<<<<<< HEAD
<<<<<<< HEAD
                .removeIf(person -> Objects.equals(person.id(), id));
=======
                .removeIf(person -> person.id() == id);
>>>>>>> 6138dde (refactor: restrucure and introduce repository)
=======
                .removeIf(person -> Objects.equals(person.id(), id));
>>>>>>> 9365a7e (refactor: replace == by equals)
    }

    public void addPerson(Person person) {
        personRepository.getPeople().add(
                new Person(
                        personRepository.getIdCounter().incrementAndGet(),
                        person.name(),
                        person.age(),
                        person.gender()
                )
        );
    }

    public void updatePerson(
            Integer id,
            PersonUpdate request

    ) {
        personRepository.getPeople().stream()
                .filter(p -> p.id().equals(id))
                .findFirst()
                .ifPresent(p -> {
                    var index = personRepository.getPeople().indexOf(p);

                    if (request.name() != null &&
                            !request.name().isEmpty() &&
                            !request.name().equals(p.name())) {
                        Person person = new Person(
                                p.id(),
                                request.name(),
                                p.getAge(),
                                p.getGender()
                        );
                        personRepository.getPeople().set(index, person);
                    }
                    if (request.age() != null &&
                            !request.age().equals(p.age())) {
                        Person person = new Person(
                                p.id(),
                                p.name(), request.age(),
                                p.gender()
                        );
                        personRepository.getPeople().set(index, person);
                    }
                });
    }
}

