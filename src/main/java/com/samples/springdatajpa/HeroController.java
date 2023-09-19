package com.samples.springdatajpa;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/heroes")
public class HeroController {

    private final HeroRepository repo;

    /**
     * Creates a new hero, example:
     * <code>
     * curl -s -X POST "http://localhost:8080/heroes/BruceWayne/35" | jq .
     * curl -s -X POST "http://localhost:8080/heroes/ClarkKent/25" | jq .
     * curl -s -X POST "http://localhost:8080/heroes/BarryAllen/20" | jq .
     * </code>
     */
    @PostMapping("/{name}/{age}")
    public Hero create(@PathVariable("name") String name, @PathVariable("age") int age) {
        return repo.save(Hero.builder()
                .name(name)
                .age(age)
                .build());
    }

    /**
     * Gets a list of all heroes in the system, example:
     * <code>
     * curl -X GET "http://localhost:8080/heroes" --silent | jq .
     * </code>
     */
    @GetMapping
    public Iterable<Hero> all() {
        return repo.findAll();
    }

    /**
     * Gets a list of all heroes in the system younger than the given age, example:
     * <code>
     * curl -X GET "http://localhost:8080/heroes/lt/30" --silent | jq .
     * </code>
     */
    @GetMapping("/lt/{age}")
    public List<Hero> lessThan(@PathVariable("age") int age) {
        return repo.findByAgeLessThan(age);
    }

    /**
     * Gets a list of all heroes in the system older than the given age, example:
     * <code>
     * curl -X GET "http://localhost:8080/heroes/gt/30" --silent | jq .
     * </code>
     */
    @GetMapping("/gt/{age}")
    public List<Hero> greaterThan(@PathVariable("age") int age) {
        return repo.findByAgeGreaterThan(age);
    }

    /**
     * Gets a list of all heroes in the system with the given name, example:
     * <code>
     * curl -X GET "http://localhost:8080/heroes/ClarkKent" --silent | jq .
     * </code>
     */
    @GetMapping("/{name}")
    @Cacheable
    public List<Hero> name(@PathVariable("name") String name) {
        return repo.findByName(name);
    }
}
