package com.example.neo4j.repository;

import com.example.neo4j.node.PersonNode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PersonRepository extends Neo4jRepository<PersonNode,Long> {
    @Query(value = "MATCH (n:Person) RETURN n",
    countQuery = "MATCH (n:Person) RETURN count(n)")
    Page<PersonNode> getUserNodeList(Pageable pageable);
}
