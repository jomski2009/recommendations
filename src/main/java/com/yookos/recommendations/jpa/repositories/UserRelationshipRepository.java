package com.yookos.recommendations.jpa.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.yookos.recommendations.jpa.entities.UserRelationship;

public interface UserRelationshipRepository extends
		CrudRepository<UserRelationship, Long> {
	List<UserRelationship> findByUserid(long userid);
	List<UserRelationship> findByRelateduserid(long relateduserid);
}
