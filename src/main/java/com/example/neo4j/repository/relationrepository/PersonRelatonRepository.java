package com.example.neo4j.repository.relationrepository;

import com.example.neo4j.node.relation.PersonRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Component;

@Component
public interface PersonRelatonRepository extends Neo4jRepository<PersonRelation,Long> {
}
