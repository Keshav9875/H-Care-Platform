package com.example.HospitalMgmtSys.repository;

import com.example.HospitalMgmtSys.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine,Long> {
}
