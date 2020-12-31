package com.kindsonthegenius.productapi.Controller;

import com.kindsonthegenius.productapi.Document.Appointment;
import com.kindsonthegenius.productapi.Document.ClinicalExaminations;
import com.kindsonthegenius.productapi.Document.PeriodicControl;
import com.kindsonthegenius.productapi.RestRepository.AppointmentRepository;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appoinment/")
@CrossOrigin(origins = "http://localhost:4200")
public class AppoinmentController {
    @Autowired
    AppointmentRepository appointmentRepository;

    @GetMapping(value = "/consult/")
    public List<Appointment> findAll(){
        return appointmentRepository.findAll();
    }

    @GetMapping("/patient/{id}")
    public List<Appointment> findByPatient(@PathVariable("id") Integer id){
        return appointmentRepository.findByPatient(id);
    }

    @GetMapping("/professional/{id}")
    public List<Appointment> findByProfessional(@PathVariable("id") Integer id){
        return appointmentRepository.findByProfessional(id);
    }

    @GetMapping("/professionalDate/{id}/{dateInit}/{dateEnd}")
    public List<Appointment> findByProfessionalByDate(@PathVariable("id") Integer id, @PathVariable("dateInit") String dateInit, @PathVariable("dateEnd") String dateEnd) {
        return appointmentRepository.findByProfessionalByDate(id,dateInit,dateEnd);
    }

    @GetMapping("/patientDate/{id}/{dateInit}/{dateEnd}")
    public List<Appointment> findByPatientByDate(@PathVariable("id") Integer id, @PathVariable("dateInit") String dateInit, @PathVariable("dateEnd") String dateEnd){
        return appointmentRepository.findByPatientByDate(id,dateInit,dateEnd);
    }

    @PostMapping("/save")
    public Appointment save(@RequestBody Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    @PostMapping("/addExam/{idDate}")
    public UpdateResult addExam(@PathVariable("idDate") String idDate, @RequestBody ClinicalExaminations clinicalExaminations){
        return appointmentRepository.addExam(idDate,clinicalExaminations);
    }

    @PostMapping("/addControl/{idDate}")
    public UpdateResult addControl(@PathVariable("idDate") String idDate, @RequestBody PeriodicControl periodicControl){
        return appointmentRepository.addControl(idDate,periodicControl);
    }
}
