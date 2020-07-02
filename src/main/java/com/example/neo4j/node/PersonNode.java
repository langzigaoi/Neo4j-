package com.example.neo4j.node;

import lombok.Data;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity(label="Person")
@Data
public class PersonNode {

    @Id
    private Long nodeId;
    @Property
    private String name;
    @Property
    private Long born;
}
