/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.natansevero.restlet.app.domains;

import org.bson.types.ObjectId;

/**
 *
 * @author natan
 */
public class Person {
    
    private ObjectId id;
    private String name;
    private String imageUrl;
    
    
    public Person() {
        
    }

    public Person(ObjectId id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", imageUrl=" + imageUrl + '}';
    }
    
    
}
