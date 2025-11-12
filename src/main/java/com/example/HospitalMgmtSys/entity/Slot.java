package com.example.HospitalMgmtSys.entity;


import com.example.HospitalMgmtSys.constants.DoctorConstant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="slot")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long slotId;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    private String status; // can only be cancelled, available, booked, expire.

    // booked by like patient appointment.
    // add this
    @ManyToOne
    @JoinColumn(name="patient_id")
    private  Patient patient;


    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;




}
