package com.smalik.sqldata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class PersonController {

	@Autowired
	private PersonRepository repo;
	
	/**
	 * Creates a new person, example:
	 * <code>
	 * curl -X POST -H "Content-Type: application/json" "http://localhost:8080/person" -d '{"name":"BruceWayne", "age":35}' --silent | jq .
	 * curl -X POST -H "Content-Type: application/json" "http://localhost:8080/person" -d '{"name":"ClarkKent", "age":25}' --silent | jq .
	 * curl -X POST -H "Content-Type: application/json" "http://localhost:8080/person" -d '{"name":"BarryAllen", "age":20}' --silent | jq .
	 * </code>
	 */
	@RequestMapping(value="/person", method=RequestMethod.POST)
	@ResponseBody
	public Person create(@RequestBody @Valid Person bean) {
		return repo.save(bean);
	}
	
	/**
	 * Gets a list of all people in the system, example:
	 * <code>
	 * curl -X GET "http://localhost:8080/person" --silent | jq .
	 * </code>
	 */
	@RequestMapping(value="/person", method=RequestMethod.GET)
	@ResponseBody
	public Iterable<Person> all() {
		return repo.findAll();
	}
	
	/**
	 * Gets a list of all people in the system younger than the given age, example:
	 * <code>
	 * curl -X GET "http://localhost:8080/person/lt/30" --silent | jq .
	 * </code>
	 */
	@RequestMapping(value="/person/lt/{age}", method=RequestMethod.GET)
	@ResponseBody
	public Iterable<Person> lessThan(@PathVariable int age) {
		return repo.findByAgeLessThan(age);
	}

	/**
	 * Gets a list of all people in the system older than the given age, example:
	 * <code>
	 * curl -X GET "http://localhost:8080/person/gt/30" --silent | jq .
	 * </code>
	 */
	@RequestMapping(value="/person/gt/{age}", method=RequestMethod.GET)
	@ResponseBody
	public Iterable<Person> greaterThan(@PathVariable int age) {
		return repo.findByAgeGreaterThan(age);
	}

	/**
	 * Gets a list of all people in the system with the given name, example:
	 * <code>
		 * curl -X GET "http://localhost:8080/person/ClarkKent" --silent | jq .
	 * </code>
	 */
	@RequestMapping(value="/person/{name}", method=RequestMethod.GET)
	@ResponseBody
	public Iterable<Person> name(@PathVariable String name) {
		return repo.findByName(name);
	}
}
