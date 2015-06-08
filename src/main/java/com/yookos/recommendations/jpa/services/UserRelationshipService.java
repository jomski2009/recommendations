package com.yookos.recommendations.jpa.services;

import java.util.List;

import com.yookos.recommendations.jpa.entities.UserRelationship;

public interface UserRelationshipService {

	UserRelationship saveOne(UserRelationship relationship);

	UserRelationship saveOne();

	void createRelationData(List<String> rows); 

	List<UserRelationship> getOutgoingRelationshipsByUserid(long userid);

	List<UserRelationship> getIncomingRelationshipsByUserid(long userid);
}
