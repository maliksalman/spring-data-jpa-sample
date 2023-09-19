package com.samples.springdatajpa;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HeroRepository extends CrudRepository<Hero, Long> {

    List<Hero> findByName(String name);

    List<Hero> findByAgeLessThan(int age);

    List<Hero> findByAgeGreaterThan(int age);

}
