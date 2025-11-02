package com.example.HospitalMgmtSys.dto;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PatientReqDto {

    @NotNull
    private String firstName;

    private String lastName;

    @NotNull
    private String dateOfBirth;

    @NotNull
    private String gender;

    @NotNull
    private String phoneNo;


    private String email;

    private Long weight;

    @Lob
    private String Address;
}
