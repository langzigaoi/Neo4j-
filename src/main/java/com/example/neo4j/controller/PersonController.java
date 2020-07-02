package com.example.neo4j.controller;

import com.example.neo4j.node.PersonNode;
import com.example.neo4j.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping("/queryPersonList")
    @ResponseBody
    public String queryPersonList(){
        Page<PersonNode> personNodes = personService.queryPersonList();
        return "success";
    }

    @RequestMapping("/createPerson")
    @ResponseBody
    public String createPerson(){

        PersonNode pn = new PersonNode();
        pn.setName("测试添加");
        pn.setBorn(1963l);
        pn.setNodeId(651l);
        personService.createPerson(pn);
        return "success";
    }


}
