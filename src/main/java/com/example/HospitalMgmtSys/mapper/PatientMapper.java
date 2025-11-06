package com.example.HospitalMgmtSys.mapper;

import com.example.HospitalMgmtSys.dto.DoctorDto;
import com.example.HospitalMgmtSys.dto.PatientReqDto;
import com.example.HospitalMgmtSys.dto.PatientResDto;
import com.example.HospitalMgmtSys.entity.Doctor;
import com.example.HospitalMgmtSys.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {


    // understand why patientReqDto param name required why it is necessary in multiple parameter.
    Patient toEntity(PatientReqDto patientReqDto);

    PatientResDto toResDto(Patient patient);

    List<PatientResDto> toPatientDtoList(List<Patient> patientList);

    @Mapping(target = "patientId", ignore = true)
    void updatePatientFromDto(PatientReqDto dto, @MappingTarget Patient entity);
}
