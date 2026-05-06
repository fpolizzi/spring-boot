package com.fpolizzi.person;

/**
 * Created by fpolizzi on 06.05.26
 */
public record Person(Integer id,
                     String name,
                     Integer age,
                     Gender gender
) {
}
