package com.app.patient.service.controller;

import com.app.patient.service.dto.PatientDTO;
import com.app.patient.service.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final WebClient.Builder webClientBuilder;

    @Autowired
    PatientService patientService;

    public PatientController(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @PostMapping
    public ResponseEntity<PatientDTO> addPatient(@RequestBody PatientDTO patientDTO){
        PatientDTO patient = patientService.addPatient(patientDTO);
        return ResponseEntity.ok().body(patient);
    }

    @GetMapping("/fetch-vital-sign")
    public String fetchVitalSign() {
        return webClientBuilder.build()
                .get()
                .uri("http://vitalsign/vital-sign")  // Calls another microservice
                .retrieve()
                .bodyToMono(String.class)
                .block(); // Blocks the call (not recommended for reactive apps)
    }

    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAllPatient(){
        List<PatientDTO> patientList = patientService.getAllPatients();
        return ResponseEntity.ok().body(patientList);
    }
}
