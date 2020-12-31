package com.kindsonthegenius.productapi.RestRepository;

import com.kindsonthegenius.productapi.Document.Patient;
import com.kindsonthegenius.productapi.Document.Professional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Patient> findAll(){
        return mongoTemplate.findAll(Patient.class);
    }

    public Object save(Patient patient){
        Query query = new Query(Criteria.where("identification").is( patient.getIdentification()));
        boolean result = mongoTemplate.exists(query, Professional.class);
        if(!result)
            return mongoTemplate.save(patient);
        else
            return "Existing identification";
    }
}
