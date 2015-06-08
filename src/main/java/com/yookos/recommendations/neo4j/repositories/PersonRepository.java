package com.yookos.recommendations.neo4j.repositories;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.yookos.recommendations.neo4j.entities.Person;

public interface PersonRepository extends GraphRepository<Person> {
	Person findByUsername(String username);

	Person findByUserid(String userid);

	Person findByEmail(String email);
}
