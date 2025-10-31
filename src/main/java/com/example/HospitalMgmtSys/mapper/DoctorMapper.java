package com.example.HospitalMgmtSys.mapper;


import com.example.HospitalMgmtSys.dto.DoctorDto;
import com.example.HospitalMgmtSys.dto.DoctorResponseDto;
import com.example.HospitalMgmtSys.entity.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    Doctor toEntity(DoctorDto doctorDto);

    DoctorResponseDto toDto(Doctor doctor);

    List<DoctorResponseDto> toDoctorDtoList(List<Doctor> doctorList);


    // this is the key method for updating an existing entity
    @Mapping(target = "doctorId", ignore = true) // keep the original ID
    void updateDoctorFromDto(DoctorDto dto, @MappingTarget Doctor entity);

}
