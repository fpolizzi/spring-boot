package com.fpolizzi.person;

/**
 * Created by fpolizzi on 06.05.26
 */
public record PersonUpdateRequest(
        String name,
        Integer age
) {
}