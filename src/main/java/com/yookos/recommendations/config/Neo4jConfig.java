package com.yookos.recommendations.config;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.rest.graphdb.RestAPIFacade;
import org.neo4j.rest.graphdb.RestGraphDatabase;
import org.neo4j.rest.graphdb.batch.BatchRestAPI;
import org.neo4j.rest.graphdb.query.RestCypherQueryEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.core.GraphDatabase;
import org.springframework.data.neo4j.support.Neo4jTemplate;



@Configuration
@EnableNeo4jRepositories(basePackages="com.yookos.recommendations.neo4j")
public class Neo4jConfig {
	@Autowired
	Environment env;

	@Bean
	GraphDatabaseService graphDatabase(){
		GraphDatabaseService db = new GraphDatabaseFactory().newEmbeddedDatabase("target/test/");
		return db;
	}
	
//	@Bean
//	@Autowired
//	RestGraphDatabase restGraphDatabase() {
//		return new RestGraphDatabase(env.getProperty("neo4j.db",
//				"http://localhost:7474/db/data/"));
//	}
//
//	@Bean
//	@Autowired
//	RestAPIFacade restAPIFacade() {
//		return new RestAPIFacade(env.getProperty("neo4j.db",
//				"http://localhost:7474/db/data/"));
//	}
//
//	@Bean
//	RestCypherQueryEngine restCypherQueryEngine() {
//		return new RestCypherQueryEngine(restAPIFacade());
//	}
//
//	@Bean
//	BatchRestAPI batchRestAPI() {
//		return new BatchRestAPI(env.getProperty("neo4j.db",
//				"http://localhost:7474/db/data/"), restAPIFacade());
//	}
	
	@Bean
	public Neo4jTemplate neo4jTemplate(){
		Neo4jTemplate template = new Neo4jTemplate(graphDatabase());
		return template;
	}
	
}
