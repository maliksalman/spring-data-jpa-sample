package com.smalik.sqldata;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository repository;

    @PostMapping("/person/{first}/{last}/{age}")
    public Person addUpdate(@PathVariable("first") String firstName,
                            @PathVariable("last") String lastName,
                            @PathVariable("age") int age) {

        return repository.save(Person.builder()
                .firstName(firstName)
                .lastName(lastName)
                .age(age)
                .build());
    }

    @GetMapping("/person")
    public Iterable<Person> listPeople() {
        return repository.findAll();
    }
}
