package com.fpolizzi.person;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by fpolizzi on 06.05.26
 */
@Repository
public class PersonRepository {

    private final AtomicInteger idCounter =
            new AtomicInteger(0);

    private final List<Person> people = new ArrayList<>();

    {
        people.add(new Person(idCounter.incrementAndGet(), "John", 20, Gender.MALE));
        people.add(new Person(idCounter.incrementAndGet(), "Mariam", 18, Gender.FEMALE));
        people.add(new Person(idCounter.incrementAndGet(), "Samba", 29, Gender.MALE));
    }

    public AtomicInteger getIdCounter() {

        return idCounter;
    }

    public List<Person> getPeople() {

        return people;
    }
}
