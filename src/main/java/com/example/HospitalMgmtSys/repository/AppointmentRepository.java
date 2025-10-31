package com.example.HospitalMgmtSys.repository;

import com.example.HospitalMgmtSys.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
