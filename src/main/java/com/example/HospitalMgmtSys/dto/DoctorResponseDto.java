package com.example.HospitalMgmtSys.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DoctorResponseDto {

    private Long DoctorId;

    private String firstName;

    private String lastName;

    private String speciality;

    private String gender;

    //change to calendar one choose option to user. (see in frontend or backend ) where to change.
    private String dateOfBirth;

    private double yearOfExperience;

    private String highestQualification;


    private LocalDateTime createdAt;


    private LocalDateTime updatedAt;

}
