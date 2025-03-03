package com.app.patient.service.mapper;

import com.app.patient.service.dto.PatientDTO;
import com.app.patient.service.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    @Mapping(source = "insuranceDetails.insuranceId", target = "insuranceDetails.id")  // Ensure ID is mapped
    Patient toEntity(PatientDTO patientDTO);

    @Mapping(source = "insuranceDetails.id", target = "insuranceDetails.insuranceId")  // Ensure ID is mapped
    PatientDTO toDTO(Patient patient);
}
