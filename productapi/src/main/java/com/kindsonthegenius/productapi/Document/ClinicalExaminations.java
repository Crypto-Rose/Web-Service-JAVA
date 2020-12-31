package com.kindsonthegenius.productapi.Document;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class ClinicalExaminations {
    @Id
    private String id= new ObjectId().toString();
    private String problemDescription;
    private String observation;
    private String medications;

    public ClinicalExaminations(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getMedications() {
        return medications;
    }

    public void setMedications(String medications) {
        this.medications = medications;
    }
}
