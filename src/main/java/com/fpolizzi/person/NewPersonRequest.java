package com.fpolizzi.person;

public record NewPersonRequest(String name,
                               Integer age,
                               Gender gender) {
}