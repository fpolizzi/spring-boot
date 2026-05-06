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

/*
public static class Person {

    private final Integer id;
    private final String name;
    private final Integer age;
    private final Gender gender;

    public Person(Integer id, String name, Integer age, Gender gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(name, person.name) && Objects.equals(age, person.age) && gender == person.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, gender);
    }
}
*/
