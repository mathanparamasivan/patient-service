package com.app.patient.service.repository;

import com.app.patient.service.entity.Diagnoses;
import com.app.patient.service.entity.InsuranceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceDetailsRepository extends JpaRepository<InsuranceDetails, Long> {
}

