package com.kindsonthegenius.productapi.RestRepository;

import com.kindsonthegenius.productapi.Document.Professional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProfessionalRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Professional> findAll(){
        return mongoTemplate.findAll(Professional.class);
    }

    public Object save(Professional professional){
        Query query = new Query(Criteria.where("identification").is( professional.getIdentification()));
        boolean result = mongoTemplate.exists(query,Professional.class);
        if(!result)
            return mongoTemplate.save(professional);
        else
            return "Existing identification";

    }
}
