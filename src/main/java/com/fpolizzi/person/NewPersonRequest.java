package com.fpolizzi.person;

import com.fpolizzi.validation.Foo;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record NewPersonRequest(@NotEmpty @Foo String name,
                               @Min(16) Integer age,
                               @NotNull Gender gender) {
}