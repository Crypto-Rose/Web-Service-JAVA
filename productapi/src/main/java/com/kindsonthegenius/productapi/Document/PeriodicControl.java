package com.kindsonthegenius.productapi.Document;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PeriodicControl {
    @Id
    private String id= new ObjectId().toString();
    private Date date = new Date();
    private String name;
    private Appointment appointment;
    private Patient patient;
    private Professional professional;
    private List<ClinicalExaminations> clinicalExaminations = new ArrayList<>();

    public PeriodicControl(){
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

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public List<ClinicalExaminations> getClinicalExaminations() {
        return clinicalExaminations;
    }

    public void setClinicalExaminations(List<ClinicalExaminations> clinicalExaminations) {
        this.clinicalExaminations = clinicalExaminations;
    }
}
