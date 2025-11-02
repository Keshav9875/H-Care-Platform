package com.example.HospitalMgmtSys.service;

import com.example.HospitalMgmtSys.dto.DoctorDto;
import com.example.HospitalMgmtSys.dto.DoctorResponseDto;
import com.example.HospitalMgmtSys.entity.Doctor;

import java.util.List;

public interface DoctorService {

     DoctorResponseDto createDoctor(DoctorDto doctorDto);

    //handle execption in this required.
     DoctorResponseDto getDoctorInfo(Long id);

     List<DoctorResponseDto> getAllDoctors();

     DoctorResponseDto updateDoctorInfo(Long id,DoctorDto doctorDto);

}
