package com.example.HospitalMgmtSys.repository;

import com.example.HospitalMgmtSys.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotRepository extends JpaRepository<Slot,Long> {
}
