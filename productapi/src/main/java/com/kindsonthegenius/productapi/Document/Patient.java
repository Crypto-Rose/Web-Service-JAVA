package com.kindsonthegenius.productapi.Document;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Patient {
    @Id
    private String id= new ObjectId().toString();
    private Integer identification;
    private String name;

    public Patient(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getIdentification() {
        return identification;
    }

    public void setIdentification(Integer identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
