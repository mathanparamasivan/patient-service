package com.app.patient.service.controller;

import com.app.patient.service.dto.PatientDTO;
import com.app.patient.service.dto.PhysicianDTO;
import com.app.patient.service.entity.Physician;
import com.app.patient.service.services.PatientService;
import com.app.patient.service.services.PhysicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/physician")
public class PhysicianController {

    @Autowired
    PhysicianService physicianService;

    @PostMapping
    public ResponseEntity<PhysicianDTO> addPhysician(PhysicianDTO physicianDTO){
        PhysicianDTO physician = physicianService.addPhysician(physicianDTO);
        return ResponseEntity.ok().body(physician);
    }

    @GetMapping
    public ResponseEntity<List<PhysicianDTO>> getAllPhysician(){
        List<PhysicianDTO> physicianList = physicianService.getAllPhysician();
        return ResponseEntity.ok().body(physicianList);
    }
}
