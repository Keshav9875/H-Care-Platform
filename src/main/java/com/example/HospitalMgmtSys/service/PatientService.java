package com.example.HospitalMgmtSys.service;


import com.example.HospitalMgmtSys.dto.PatientReqDto;
import com.example.HospitalMgmtSys.dto.PatientResDto;

public interface PatientService {

    PatientResDto registerPatient(PatientReqDto patientReqDto);
}
