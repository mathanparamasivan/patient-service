package com.app.patient.service.mapper;

import com.app.patient.service.dto.PhysicianDTO;
import com.app.patient.service.entity.Physician;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhysicianMapper {

        Physician toEntity(PhysicianDTO physicianDTO);

        PhysicianDTO toDTO(Physician physician);
}
