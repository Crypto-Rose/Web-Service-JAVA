package com.kindsonthegenius.productapi.RestRepository;

import com.kindsonthegenius.productapi.Document.*;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class AppointmentRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Appointment> findAll(){
        return mongoTemplate.findAll(Appointment.class);
    }

    public UpdateResult addExam(String idDate, ClinicalExaminations clinicalExaminations){
        System.out.println(idDate);
        return mongoTemplate.updateFirst(
                new Query().addCriteria(Criteria.where("_id").is(idDate)),
                new Update().addToSet("clinicalExaminations",clinicalExaminations),
                Appointment.class);

    }

    public UpdateResult addControl(String idDate, PeriodicControl periodicControl){
        return mongoTemplate.updateFirst(
                new Query().addCriteria(Criteria.where("_id").is(idDate)),
                new Update().addToSet("periodicControl",periodicControl),
                Appointment.class
        );
    }

    public Appointment save(Appointment appointment){
        return mongoTemplate.save(appointment);
    }

    public List<Appointment> findByPatient(Integer patient){
        return mongoTemplate.find (new Query().addCriteria( Criteria.where("patient").is(patient)), Appointment.class);
    }

    public List<Appointment> findByProfessional(Integer professional){
        return mongoTemplate.find (new Query().addCriteria( Criteria.where("professional").is(professional)), Appointment.class);
    }

    public List<Appointment> findByProfessionalByDate(Integer professional, String dateInit,String dateEnd) {
        Date init = javax.xml.bind.DatatypeConverter.parseDateTime(dateInit).getTime();
        Date end = javax.xml.bind.DatatypeConverter.parseDateTime(dateEnd).getTime();

        return mongoTemplate.find (Query.query( new Criteria().andOperator(
                Criteria.where("professional").is(professional),
                Criteria.where("date").gte(init).andOperator(Criteria.where("date").lt(end))
        )),Appointment.class);
    }

    public List<Appointment> findByPatientByDate(Integer patient, String dateInit,String dateEnd) {
        Date init = javax.xml.bind.DatatypeConverter.parseDateTime(dateInit).getTime();
        Date end = javax.xml.bind.DatatypeConverter.parseDateTime(dateEnd).getTime();

        return mongoTemplate.find (Query.query( new Criteria().andOperator(
                Criteria.where("patient").is(patient),
                Criteria.where("date").gte(init).andOperator(Criteria.where("date").lt(end))
                )),
                Appointment.class);
    }


}
