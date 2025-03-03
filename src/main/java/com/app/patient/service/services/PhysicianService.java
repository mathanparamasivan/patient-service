package com.app.patient.service.services;

import com.app.patient.service.dto.PhysicianDTO;
import com.app.patient.service.mapper.PhysicianMapper;
import com.app.patient.service.repository.PhysicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PhysicianService {
    @Autowired
    PhysicianRepository physicianRepository;

    @Autowired
    PhysicianMapper physicianMapper;

    public PhysicianDTO addPhysician(PhysicianDTO physicianDTO) {
        return physicianMapper.toDTO(physicianRepository.save(physicianMapper.toEntity(physicianDTO)));
    }

    public List<PhysicianDTO> getAllPhysician() {
        return physicianRepository.findAll().stream()
                .map(physician -> physicianMapper.toDTO(physician)).collect(Collectors.toList());
    }
}
