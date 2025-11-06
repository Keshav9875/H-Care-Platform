package com.example.HospitalMgmtSys.service;


import com.example.HospitalMgmtSys.dto.PatientReqDto;
import com.example.HospitalMgmtSys.dto.PatientResDto;

import java.util.List;

public interface PatientService {

    PatientResDto registerPatient(PatientReqDto patientReqDto);

    List<PatientResDto> fetchAllPatient();

    PatientResDto fetchPatientById(Long id);

    PatientResDto  updatePatientDetails(PatientReqDto patientReqDto, Long id );
}
