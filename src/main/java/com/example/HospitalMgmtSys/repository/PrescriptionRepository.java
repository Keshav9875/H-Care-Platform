package com.example.HospitalMgmtSys.repository;

import com.example.HospitalMgmtSys.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {
}
