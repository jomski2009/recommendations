package com.yookos.recommendations.neo4j.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yookos.recommendations.neo4j.entities.Person;
import com.yookos.recommendations.neo4j.repositories.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired 
	PersonRepository personRepository;
	@Override
	public Person findByUsername(String username) {
		return personRepository.findByUsername(username);
	}

	@Override
	public Person findByUserid(long userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
