package com.app.patient.service.repository;

import com.app.patient.service.entity.Diagnoses;
import com.app.patient.service.entity.ReferralInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferralInfoRepository extends JpaRepository<ReferralInfo, Long> {
}
