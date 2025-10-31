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
@Table(name="doctor")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;

    private String firstName;

    private String lastName;

    private String speciality;

    private String gender;

    //change to calendar one choose option to user. (see in frontend or backend ) where to change.
    private String dateOfBirth;

    private double yearOfExperience;

    private String highestQualification;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private List<Patient> patientList= new ArrayList<>();

    @OneToMany(mappedBy = "doctor",fetch = FetchType.LAZY)
    private List<Appointment> appointmentList= new ArrayList<>();


    @OneToMany(mappedBy = "doctor",fetch = FetchType.LAZY)
    private List<Slot>  slotList= new ArrayList<>();

    @OneToMany(mappedBy = "doctor",fetch = FetchType.LAZY)
    private List<Prescription>  prescriptionList= new ArrayList<>();

    @Override
    public String toString() {
        return "Doctor{" +
                "DoctorId=" + doctorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", speciality='" + speciality + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", yearOfExperience=" + yearOfExperience +
                ", highestQualification='" + highestQualification + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", patientList=" + patientList +
                ", appointmentList=" + appointmentList +
                ", slotList=" + slotList +
                ", prescriptionList=" + prescriptionList +
                '}';
    }
}
