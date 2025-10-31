package com.example.HospitalMgmtSys.service;

import com.example.HospitalMgmtSys.dto.DoctorDto;
import com.example.HospitalMgmtSys.dto.DoctorResponseDto;
import com.example.HospitalMgmtSys.entity.Doctor;

import java.util.List;

public interface DoctorService {

    public DoctorResponseDto createDoctor(DoctorDto doctorDto);

    //handle execption in this required.
    public DoctorResponseDto getDoctorInfo(Long id);

    public List<DoctorResponseDto> getAllDoctors();

    public DoctorResponseDto updateDoctorInfo(Long id,DoctorDto doctorDto);

}
