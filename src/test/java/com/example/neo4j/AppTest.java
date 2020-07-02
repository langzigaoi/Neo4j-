package com.example.neo4j;

import org.neo4j.driver.*;
import org.neo4j.driver.types.Node;
import org.neo4j.jdbc.Neo4jConnection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

public class AppTest
{
    public static void main(String[] args) throws Exception {
        try{
            testBolt();
            System.out.println("bolt is ok");
            testJdbc();
            System.out.println("jdbc is ok");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void testBolt() throws Exception {
        String boltUri = "bolt://localhost:7687";
        String user = "neo4j";
        String password = "aptx4869";
        Driver driver = GraphDatabase.driver(boltUri, AuthTokens.basic(user, password));
        Session session = driver.session();
        Transaction tx = session.beginTransaction();
        Result result = tx.run("MATCH (p:Person) RETURN p limit 3");
        List<Record> list=result.list();
        for(int i=0;i<list.size();i++){
            Record r = list.get(i);
            List<String> keys = r.keys();
            for(String key: keys){
                Value val = r.get(key);
                Node node = val.asNode();
                Iterator<String> it = node.keys().iterator();
                while(it.hasNext()){
                    String field = it.next();
                    System.out.print(",field=" + field + ",value=" + node.get(field));
                }
            }
        }
        tx.close();
        session.close();
        driver.close();
    }

    public static void testJdbc() throws Exception {

        Class.forName("org.neo4j.jdbc.Driver").newInstance();
        Neo4jConnection con = (Neo4jConnection) DriverManager.getConnection("jdbc:neo4j:http://localhost:7474", "neo4j",
                "aptx4869");
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery("match (p:Person) return p limit 10");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        }
        con.close();
    }

}