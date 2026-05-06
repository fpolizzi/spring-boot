package com.fpolizzi.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;

import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@RestController
@SpringBootApplication
public class SpringAndSpringBootApplication {

    private static AtomicInteger idCounter = new AtomicInteger(0);

    public static List<Person> people = new ArrayList<>();

    static {
        people.add(new Person(idCounter.incrementAndGet(), "John", 20, Gender.MALE));
        people.add(new Person(idCounter.incrementAndGet(), "Mariam", 18, Gender.FEMALE));
        people.add(new Person(idCounter.incrementAndGet(), "Samba", 29, Gender.MALE));
    }

=======

@SpringBootApplication
public class SpringAndSpringBootApplication {

>>>>>>> 1c62e8b (refactor: reorganize book example properly)
    static void main(String[] args) {
        SpringApplication.run(
                SpringAndSpringBootApplication.class,
                args
        );
    }
<<<<<<< HEAD

    @GetMapping
    public List<Person> getPersons(
=======
<<<<<<< HEAD
<<<<<<< HEAD

    @Bean
    CommandLineRunner commandLineRunner(ObjectMapper objectMapper) {

        String personString = "{\"id\":1, \"name\":\"John Doe\", \"age\":37, \"gender\":\"MALE\"}";
        Person person = objectMapper.readValue(personString, Person.class);

        // Serialize and Deserialize Object to Json
        System.out.println(person);
        System.out.println(objectMapper.writeValueAsString(person));

        return args -> {

        };
    }
<<<<<<< HEAD

    @GetMapping
    public List<Person> getPersons(
            HttpMethod httpMethod,
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            @RequestHeader("Content-Type") String contentType,
>>>>>>> 1c62e8b (refactor: reorganize book example properly)
            @RequestParam(
                    value = "sort",
                    required = false,
                    defaultValue = "ASC"
            ) SortingOrder sort,

            @RequestParam(
                    value = "limit",
                    required = false,
                    defaultValue = "10"
            ) Integer limit) {

<<<<<<< HEAD
        if (sort == SortingOrder.ASC) {

            return people.stream().limit(limit)
                    .sorted(Comparator.comparing(Person::id))
=======
        System.out.println(httpMethod);
        System.out.println(servletRequest.getLocalAddr());
        System.out.println(servletResponse.isCommitted());
        System.out.println(contentType);

        if (sort == SortingOrder.ASC) {

            return people.stream().limit(limit)
                    .sorted(Comparator.comparing(Person::getId))
>>>>>>> 1c62e8b (refactor: reorganize book example properly)
                    .collect(Collectors.toList());
        }

        return people.stream().limit(limit)
<<<<<<< HEAD
                .sorted(Comparator.comparing(Person::id).reversed())
=======
                .sorted(Comparator.comparing(Person::getId).reversed())
>>>>>>> 1c62e8b (refactor: reorganize book example properly)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
<<<<<<< HEAD
    public Optional<Person> getPersonById(
            @PathVariable Integer id
    ) {

        return people.stream()
                .filter(person -> person.id == id)
                .findFirst();
=======
    public ResponseEntity<Optional<Person>> getPersonById(
            @PathVariable Integer id
    ) {

        Optional<Person> person = people.stream()
                .filter(p -> p.id == id)
                .findFirst();

        return ResponseEntity.ok().body(person);
>>>>>>> 1c62e8b (refactor: reorganize book example properly)
    }

    @DeleteMapping("{id}")
    public void deletePersonById(@PathVariable Integer id) {

        people.removeIf(person -> person.id == id);
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        people.add(
                new Person(
                        idCounter.incrementAndGet(),
                        person.name,
<<<<<<< HEAD
                        person.age(),
=======
                        person.getAge(),
>>>>>>> 1c62e8b (refactor: reorganize book example properly)
                        person.gender
                )
        );
    }

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
>>>>>>> 1c62e8b (refactor: reorganize book example properly)
    @PutMapping("{id}")
    public void updatePerson(
            @PathVariable Integer id,
            @RequestBody PersonUpdate request

    ) {
        people.stream()
                .filter(p -> p.id.equals(id))
                .findFirst()
                .ifPresent(p -> {
                    var index = people.indexOf(p);

                    if (request.name != null &&
                            !request.name.isEmpty() &&
                            !request.name.equals(p.name)) {
                        Person person = new Person(
                                p.id,
                                request.name,
<<<<<<< HEAD
                                p.age(),
                                p.gender()
=======
                                p.getAge(),
                                p.getGender()
>>>>>>> 1c62e8b (refactor: reorganize book example properly)
                        );
                        people.set(index, person);
                    }
                    if (request.age != null &&
                            !request.age.equals(p.age)) {
                        Person person = new Person(
                                p.id,
                                p.name, request.age,
                                p.gender
                        );
                        people.set(index, person);
                    }
                });
    }

<<<<<<< HEAD
=======
>>>>>>> caf5977 (feat: example of Json annotations on a class)
>>>>>>> 1c62e8b (refactor: reorganize book example properly)
    public enum Gender {MALE, FEMALE}

    public enum SortingOrder {ASC, DESC}

<<<<<<< HEAD
    public record Person(Integer id,
                         String name,
                         Integer age,
                         Gender gender) {
    }

    public record PersonUpdate(String name,
                               Integer age) {
    }
=======
//    public record Person(Integer id,
//                         @JsonGetter("foobar") String name,
//                         @JsonIgnore Integer age,
//                         Gender gender) {
//    }
<<<<<<< HEAD
=======

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

        @JsonIgnore
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
>>>>>>> c609a9b (Json (#6))

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

        @JsonIgnore
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
=======
>>>>>>> 6c6b94f (refactor: remove service logic from controller)
=======
>>>>>>> 6138dde (refactor: restrucure and introduce repository)
=======
>>>>>>> d26277b (organizing code (#7))
>>>>>>> 1c62e8b (refactor: reorganize book example properly)
}
