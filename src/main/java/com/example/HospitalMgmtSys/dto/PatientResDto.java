package com.example.HospitalMgmtSys.dto;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PatientResDto {

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

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
