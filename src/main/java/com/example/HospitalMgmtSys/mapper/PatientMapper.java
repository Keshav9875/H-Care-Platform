package com.example.HospitalMgmtSys.mapper;

import com.example.HospitalMgmtSys.dto.PatientReqDto;
import com.example.HospitalMgmtSys.dto.PatientResDto;
import com.example.HospitalMgmtSys.entity.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {


    // understand why patientReqDto param name required why it is necessary in multiple parameter.
    Patient toEntity(PatientReqDto patientReqDto);

    PatientResDto toResDto(Patient patient);
}
