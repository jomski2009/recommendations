package com.yookos.recommendations.neo4j.entities;

import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class Person {
	private long id; // For Node id representations

	private long userid;
	private String username;
	private String name;
	private String firstname;
	private String lastname;
	private String email;
	private boolean userenabled;
	private long creationdate;
	private int age;
	private long birthdate;
	private String gender;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isUserenabled() {
		return userenabled;
	}

	public void setUserenabled(boolean userenabled) {
		this.userenabled = userenabled;
	}

	public long getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(long creationdate) {
		this.creationdate = creationdate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(long birthdate) {
		this.birthdate = birthdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
