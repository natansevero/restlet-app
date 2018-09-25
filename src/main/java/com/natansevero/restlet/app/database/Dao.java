/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.natansevero.restlet.app.database;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.natansevero.restlet.app.domains.Person;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author natan
 */
public class Dao {
    
    private final MongoCollection collection;
    
    public Dao() {
        collection = new Connection().getCollection("persons", Person.class);
    }
    
    public void save(Person person) {
        collection.insertOne(person);
    }
    
    public List<Person> listAll() {
        List<Person> persons = new ArrayList<>();
        MongoCursor cursor = collection.find().iterator();
        
        while(cursor.hasNext()) {
            persons.add((Person) cursor.next());
        }
        
        return persons;
    }
}
