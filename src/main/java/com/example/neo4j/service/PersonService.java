package com.example.neo4j.service;

import com.example.neo4j.node.PersonNode;
import com.example.neo4j.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository PERSON_REPOSITORY;

    public Page<PersonNode> queryPersonList(){
        Pageable pageable = PageRequest.of(0, 6);
        Page<PersonNode> userNodeList = PERSON_REPOSITORY.getUserNodeList(pageable);

        return userNodeList;
    }

    public void createPerson(PersonNode personNode){
        PERSON_REPOSITORY.save(personNode);
    }
}
