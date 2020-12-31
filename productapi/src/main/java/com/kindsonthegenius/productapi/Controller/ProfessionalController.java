package com.kindsonthegenius.productapi.Controller;

import com.kindsonthegenius.productapi.Document.Professional;
import com.kindsonthegenius.productapi.RestRepository.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professional")
@CrossOrigin(origins = "http://localhost:4200")
public class ProfessionalController {
    @Autowired
    ProfessionalRepository professionalRepository;

    @GetMapping(value = "/consult/")
    public List<Professional> findAll(){
        return professionalRepository.findAll();
    }
    @PostMapping("/save")
    public Object save(@RequestBody Professional professional){
        return professionalRepository.save(professional);
    }
}
