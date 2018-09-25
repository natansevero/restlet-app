/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.natansevero.restlet.app.domains;

import com.mongodb.BasicDBObject;

/**
 *
 * @author natan
 */
public class Person {
    
    private String _id;
    private String name;
    private String imageUrl;
    
    
    public Person() {
        
    }

    public Person(String _id, String name, String imageUrl) {
        this._id = _id;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String get_Id() {
        return _id;
    }

    public void set_Id(String _id) {
        this._id = _id;
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
        return "Person{" + "_id=" + _id + ", name=" + name + ", imageUrl=" + imageUrl + '}';
    }
    
    
}
