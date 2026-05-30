package com.fpolizzi.person;

public record Person(Integer id,
                     String name,
                     Integer age,
                     Gender gender,
                     String email) {
}