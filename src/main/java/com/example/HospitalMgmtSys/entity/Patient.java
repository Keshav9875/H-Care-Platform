package com.example.HospitalMgmtSys.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="patient")
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    private String firstName;

    private String lastName;

    private String dateOfBirth;

    private String gender;

    private String phoneNo;

    private String email;

    private Long weight;

    @Lob
    private String Address;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY)
    private List<Appointment> appointmentList= new ArrayList<>();

    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY)
    private List<Prescription> prescriptionList= new ArrayList<>();

    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY)
    private List<Invoice>  invoiceList= new ArrayList<>();

    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY)
    private List<Slot> slotList  = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;


}
