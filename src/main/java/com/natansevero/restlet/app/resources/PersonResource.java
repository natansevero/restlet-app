/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.natansevero.restlet.app.resources;

import com.natansevero.restlet.app.database.Dao;
import com.natansevero.restlet.app.domains.Person;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.data.MediaType;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

/**
 *
 * @author natan
 */
public class PersonResource extends ServerResource {
    
    public final Dao dao = new Dao();
    
    @Post("json")
    public Representation createPerson(JsonRepresentation entity) throws IOException {
        try {
            JSONObject personJsonObj = entity.getJsonObject();
            
            Person person = new Person();
            person.setName(personJsonObj.getString("name"));            
            person.setImageUrl(personJsonObj.getString("imageUrl"));
            
            dao.save(person);

        } catch (JSONException ex) {
            Logger.getLogger(PersonResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new StringRepresentation("{\"message\":\"All is alright\"}", MediaType.APPLICATION_JSON);
    }
    
    @Get("json")
    public Representation getAllPersons() {
        List<Person> persons = dao.listAll();
        
        JSONArray response = new JSONArray();
        
        try {
            for(Person person: persons) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("_id", person.get_Id());
                jsonObject.put("name", person.getName());
                jsonObject.put("imageUrl", person.getImageUrl());

                response.put(jsonObject);
            }

        } catch (JSONException ex) {
            Logger.getLogger(PersonResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return new JsonRepresentation(response);
    }
}
