package com.example.HospitalMgmtSys.repository;

import com.example.HospitalMgmtSys.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
