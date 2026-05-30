package com.fpolizzi.person;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record NewPersonRequest(@NotEmpty(message = "Name must not be null or empty") String name,
                               @Min(value = 16, message = "Age must be equal or greater than 16") Integer age,
                               @NotNull(message = "Gender must not be null or empty") Gender gender) {
}