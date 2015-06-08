package com.yookos.recommendations.neo4j.services;

import com.yookos.recommendations.neo4j.entities.Person;

public interface PersonService {
	Person findByUsername(String username);

	Person findByUserid(long userid);

	Person findByEmail(String email);
}
