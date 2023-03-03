package com.smalik.sqldata;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Person.PersonId> { }
