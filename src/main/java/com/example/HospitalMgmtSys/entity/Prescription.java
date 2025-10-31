package com.example.HospitalMgmtSys.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="prescription")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescriptionId;

    //patient info
    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;

    //doctor info
    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    @OneToMany(mappedBy = "prescription",fetch = FetchType.LAZY)
    private List<Medicine> medicineList = new ArrayList<>();

    private String signature;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
