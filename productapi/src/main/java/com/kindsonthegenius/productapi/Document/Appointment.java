package com.kindsonthegenius.productapi.Document;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Appointment {
    @Id
    private String id= new ObjectId().toString();
    private Date date = new Date();
    private String name;
    private Integer patient;
    private Integer professional;
    private ClinicalExaminations clinicalExaminations;

    public Appointment(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPatient() {
        return patient;
    }

    public void setPatient(Integer patient) {
        this.patient = patient;
    }

    public Integer getProfessional() {
        return professional;
    }

    public void setProfessional(Integer professional) {
        this.professional = professional;
    }

    public ClinicalExaminations getClinicalExaminations() {
        return clinicalExaminations;
    }

    public void setClinicalExaminations(ClinicalExaminations clinicalExaminations) {
        this.clinicalExaminations = clinicalExaminations;
    }
}
