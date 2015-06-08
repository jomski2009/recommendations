package com.yookos.recommendations.controllers.rest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yookos.recommendations.jpa.entities.UserRelationship;
import com.yookos.recommendations.jpa.services.UserRelationshipService;

@RestController
@RequestMapping("/relationship/")
public class UserRelationshipController {
	@Autowired
	UserRelationshipService relationshipService;

	@RequestMapping("create")
	public ResponseEntity<String> createSingleRelationship() {
		relationshipService.saveOne();
		return new ResponseEntity<String>("Relationship created", HttpStatus.OK);
	}
	
	@RequestMapping("user/{userid}")
	public ResponseEntity<List<UserRelationship>> getOutgoingRelationshipsByUserid(@PathVariable("userid") long userid){
		List<UserRelationship> rels = relationshipService.getOutgoingRelationshipsByUserid(userid);
		System.out.println(rels.size());
		return new ResponseEntity<List<UserRelationship>>(rels, HttpStatus.OK);
	}
	
	@RequestMapping("relateduser/{relateduserid}")
	public ResponseEntity<List<UserRelationship>> getIncomingRelationshipsByUserid(@PathVariable("relateduserid") long userid){
		List<UserRelationship> rels = relationshipService.getIncomingRelationshipsByUserid(userid);
		System.out.println(rels.size());
		return new ResponseEntity<List<UserRelationship>>(rels, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/csv/{start}/{end}", method = RequestMethod.POST)
	public ResponseEntity<Void> addRelationshipsFromCSV(
			@RequestParam("file") MultipartFile file, @PathVariable("start") int start, @PathVariable("end") int end) {
		try {
			System.out.println("Starting relationship csv processing...");
			List<String> rows = new ArrayList<String>();

			if (!file.isEmpty()) {
				String row = "";
				BufferedReader br = new BufferedReader(new InputStreamReader(
						file.getInputStream()));
				while ((row = br.readLine()) != null) {
					if(rows.size() <= (end - start)){
						rows.add(row);						
					}else{
						break;
					}
				}
				br.close();
				// System.out.println(rows.get(0));
				// rows.remove(0); // Just to get csv working... removing the
				// // header row...
				// System.out.println(rows.get(0));

				relationshipService.createRelationData(rows);

				return new ResponseEntity<Void>(HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);

	}
}
