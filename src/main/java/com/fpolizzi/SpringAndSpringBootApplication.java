package com.fpolizzi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAndSpringBootApplication {

    static void main(String[] args) {
        SpringApplication.run(
                SpringAndSpringBootApplication.class,
                args
        );
    }
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

        System.out.println(httpMethod);
        System.out.println(servletRequest.getLocalAddr());
        System.out.println(servletResponse.isCommitted());
        System.out.println(contentType);

        if (sort == SortingOrder.ASC) {

            return people.stream().limit(limit)
                    .sorted(Comparator.comparing(Person::getId))
                    .collect(Collectors.toList());
        }

        return people.stream().limit(limit)
                .sorted(Comparator.comparing(Person::getId).reversed())
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Person>> getPersonById(
            @PathVariable Integer id
    ) {

        Optional<Person> person = people.stream()
                .filter(p -> p.id == id)
                .findFirst();

        return ResponseEntity.ok().body(person);
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
                        person.getAge(),
                        person.gender
                )
        );
    }

<<<<<<< HEAD
=======
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
                                p.getAge(),
                                p.getGender()
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

>>>>>>> caf5977 (feat: example of Json annotations on a class)
    public enum Gender {MALE, FEMALE}

    public enum SortingOrder {ASC, DESC}

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
}
