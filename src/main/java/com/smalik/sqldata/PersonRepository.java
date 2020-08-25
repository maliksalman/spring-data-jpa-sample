package com.smalik.sqldata;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {

	List<Person> findByName(String name);
	List<Person> findByAgeLessThan(int age);
	List<Person> findByAgeGreaterThan(int age);

}
