package com.fpolizzi.person;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fpolizzi on 6/6/26
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
