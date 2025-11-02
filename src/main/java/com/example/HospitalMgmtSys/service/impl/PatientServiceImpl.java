package com.example.HospitalMgmtSys.service.impl;

import com.example.HospitalMgmtSys.dto.PatientReqDto;
import com.example.HospitalMgmtSys.dto.PatientResDto;
import com.example.HospitalMgmtSys.entity.Patient;
import com.example.HospitalMgmtSys.mapper.PatientMapper;
import com.example.HospitalMgmtSys.repository.PatientRepository;
import com.example.HospitalMgmtSys.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PatientServiceImpl  implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    PatientMapper patientMapper;


    @Override
    public PatientResDto registerPatient(PatientReqDto patientReqDto) {

        log.info("Inside service registerPatient method  request is - {}", patientReqDto.toString());

        log.info("convert request to patient entity  through patientMapper");
        Patient patient = patientMapper.toEntity(patientReqDto);

        log.info("Patient Entity from patientMapper is {}",patient.toString());

        log.info("calling parentRepo method to register patient");
         Patient savedPatient = patientRepository.save(patient);

         log.info("Regiser patient is {}",savedPatient.toString());

         log.info("calling mapper method to convert savedPatient into patientRes");

         PatientResDto savedPatientResponse = patientMapper.toResDto(savedPatient);

         log.info(" patientResponseDto after converting from patient is {} ",savedPatientResponse.toString());


         return savedPatientResponse;
    }
}
