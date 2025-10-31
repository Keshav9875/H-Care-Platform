package com.example.HospitalMgmtSys.entity;


import com.example.HospitalMgmtSys.constants.DoctorConstant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    private static  Long totalSlots = DoctorConstant.totalSlots;

    private Long availableSlots;

    private String status;

    // booked by like patient appointment.
    // add this
    @ManyToOne
    @JoinColumn(name="patient_id")
    Patient patient;

    //added end


    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;




}
