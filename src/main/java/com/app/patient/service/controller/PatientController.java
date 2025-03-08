package com.app.patient.service.controller;

import com.app.patient.service.dto.PatientDTO;
import com.app.patient.service.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientDTO> addPatient(@RequestBody PatientDTO patientDTO){
        PatientDTO patient = patientService.addPatient(patientDTO);
        return ResponseEntity.ok().body(patient);
    }

    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAllPatient(){
        List<PatientDTO> patientList = patientService.getAllPatients();
        return ResponseEntity.ok().body(patientList);
    }
}
