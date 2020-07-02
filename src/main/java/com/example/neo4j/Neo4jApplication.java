package com.example.neo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;


@SpringBootApplication(scanBasePackages="com.example.neo4j")
@EnableNeo4jRepositories(basePackages="com.example.neo4j.repository")
@EntityScan(basePackages="com.example.neo4j.node")
public class Neo4jApplication {

    public static void main(String[] args) {
        SpringApplication.run(Neo4jApplication.class, args);
    }

}
