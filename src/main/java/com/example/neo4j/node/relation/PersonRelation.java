package com.example.neo4j.node.relation;

import com.example.neo4j.node.PersonNode;
import lombok.Data;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type="UserRelation")
@Data
public class PersonRelation {

    @Id
    private Long id;

    @StartNode
    private PersonNode startNode;

    @EndNode
    private PersonNode endNode;
}
