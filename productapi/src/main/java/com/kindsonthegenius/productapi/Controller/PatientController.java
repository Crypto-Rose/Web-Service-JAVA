package com.kindsonthegenius.productapi.Controller;

import com.kindsonthegenius.productapi.Document.Patient;
import com.kindsonthegenius.productapi.RestRepository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient/")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {
    @Autowired
    PatientRepository patientRepository;

    @GetMapping(value = "/consult/")
    public List<Patient> findAll(){
        return patientRepository.findAll();
    }
    @PostMapping("/save")
    public Object save(@RequestBody Patient patient){
        return patientRepository.save(patient);
    }
}
