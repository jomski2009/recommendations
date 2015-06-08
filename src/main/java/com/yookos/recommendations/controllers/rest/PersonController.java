package com.yookos.recommendations.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yookos.recommendations.neo4j.entities.Person;
import com.yookos.recommendations.neo4j.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonService personService;
	
	@RequestMapping("username/{username}")
	public ResponseEntity<Person> getPersonByUsername(@PathVariable("username") String username){
		Person person = personService.findByUsername(username);
		if(person !=null){
		return new ResponseEntity<>(person, HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
