package com.yookos.recommendations.config;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;


@Configuration
@EnableMongoRepositories(basePackages="com.yookos.recommendations.mongo")
public class MongoDbConfig {

    @Bean
    Mongo mongo(){
        MongoClient client=null;
        try {
            client = new MongoClient("localhost");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return client;
    }

    @Bean
    MongoDbFactory mongoDbFactory(){
        return new SimpleMongoDbFactory(mongo(), "yookosreco");
    }

    @Bean
    MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongoDbFactory());
    }
}
