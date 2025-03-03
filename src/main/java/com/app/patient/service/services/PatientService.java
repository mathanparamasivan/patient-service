package com.app.patient.service.services;

import com.app.patient.service.dto.PatientDTO;
import com.app.patient.service.entity.Patient;
import com.app.patient.service.entity.Physician;
import com.app.patient.service.mapper.PatientMapper;
import com.app.patient.service.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {
    @Autowired
    PatientMapper patientMapper;

    @Autowired
    DiagnosesRepository diagnosesRepository;

    @Autowired
    ReferralInfoRepository referralInfoRepository;

    @Autowired
    InsuranceDetailsRepository insuranceDetailsRepository;

    @Autowired
    PhysicianRepository physicianRepository;

    @Autowired
    PatientRepository patientRepository;

    public PatientDTO addPatient(PatientDTO patientDTO) {
        Patient patient = patientMapper.toEntity(patientDTO);

        Physician physician = physicianRepository.findById(patientDTO.getPrimaryPhysician().getId())
                .orElse(null);
        patient.setPrimaryPhysician(physician);
        Patient savedPatient = patientRepository.save(patient);

        return patientMapper.toDTO(savedPatient);
    }

    public List<PatientDTO> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(patient -> patientMapper.toDTO(patient))
                .collect(Collectors.toList());
    }
}
