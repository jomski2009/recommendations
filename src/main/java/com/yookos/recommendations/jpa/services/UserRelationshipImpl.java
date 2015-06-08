package com.yookos.recommendations.jpa.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yookos.recommendations.jpa.entities.UserRelationship;
import com.yookos.recommendations.jpa.repositories.UserRelationshipRepository;

@Service
public class UserRelationshipImpl implements UserRelationshipService {
@Autowired
UserRelationshipRepository repository;
	
	@Override
	public UserRelationship saveOne() {

		UserRelationship relationship = new UserRelationship();
		relationship.setUserid(8432);
		relationship.setCreationdate(new Date().getTime());
		relationship.setRelateduserid(2017);
		
		relationship = repository.save(relationship);
		return relationship;
		
	}

	@Override
	public UserRelationship saveOne(UserRelationship relationship) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createRelationData(List<String> rows) {
		for (String r : rows) {
			System.out.println(r);
			String[] rs = r.split(";");
			
			UserRelationship rel = new UserRelationship();
			rel.setRelationshipid(Long.parseLong(rs[0]));
			rel.setUserid(Long.parseLong(rs[1]));
			rel.setRelateduserid(Long.parseLong(rs[2]));
			rel.setCreationdate(Long.parseLong(rs[5]));

			
			rel = repository.save(rel);
			System.out.println(rel);			
		}
		
	}

	@Override
	public List<UserRelationship> getOutgoingRelationshipsByUserid(long userid) {
		List<UserRelationship> relationships = repository.findByUserid(userid);
		return relationships;
	}

	@Override
	public List<UserRelationship> getIncomingRelationshipsByUserid(long relateduserid) {
		List<UserRelationship> relationships = repository.findByRelateduserid(relateduserid);
		return relationships;
	}

}
