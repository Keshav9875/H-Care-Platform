package com.example.HospitalMgmtSys.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="medicine")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicine_id;

    private String drugName;

    //like 3 tablets , 2 capsules
    private Long quantity;

    // like 50gm or 100gm
    private Long strength;

    //Like capsule,tablets, liquid or creamy foam.
    private String dosageForm;

    // This describe about intake medicine instruction  has  been given by doctor (for patient).
    // like take the medicine twice a day , before meal , after meal and once a day etc.
    private String medicationInfo;

    @ManyToOne
    @JoinColumn(name="prescriptionId")
    private Prescription prescription;

}
