package com.app.patient.service.repository;

import com.app.patient.service.entity.Diagnoses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosesRepository extends JpaRepository<Diagnoses, Long> {
}
