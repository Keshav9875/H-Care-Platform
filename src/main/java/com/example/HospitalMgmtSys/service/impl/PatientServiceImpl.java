package com.example.HospitalMgmtSys.service.impl;

import com.example.HospitalMgmtSys.dto.PatientReqDto;
import com.example.HospitalMgmtSys.dto.PatientResDto;
import com.example.HospitalMgmtSys.entity.Doctor;
import com.example.HospitalMgmtSys.entity.Patient;
import com.example.HospitalMgmtSys.mapper.PatientMapper;
import com.example.HospitalMgmtSys.repository.PatientRepository;
import com.example.HospitalMgmtSys.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<PatientResDto> fetchAllPatient() {
        log.info("In service fetchAllPatient method to find the detials of patient");

        log.info("calling Repository method to find the details of patient.");

        List<Patient> patientList=  patientRepository.findAll();

        log.info("List of all the patient from db - {}",patientList.toString());

        log.info("calling mapper  for patientlist -> patientResDtoList");

        List<PatientResDto> patientResDtoList = patientMapper.toPatientDtoList(patientList);

        log.info("patientResDtoList is - {}",patientResDtoList.toString());

        return patientResDtoList;


    }

    @Override
    public PatientResDto fetchPatientById(Long id) {

        log.info("inside service method with the request id is - {}",id);

        Optional<Patient> patientOptional= patientRepository.findById(id);

        log.info("patientOptional is {}",patientOptional.toString());

        Patient patient = patientOptional
                .orElseThrow(() -> new RuntimeException("patient not found with id: " + id));

        log.info("patient is {} and going to call mapper to convert it into patientResDto",patient.toString());

        PatientResDto patientRes = patientMapper.toResDto(patient);

        log.info("Mapper result patientResDto is {}",patientRes.toString());

        return patientRes;


    }

    @Override
    public PatientResDto updatePatientDetails(PatientReqDto patientReqDto, Long id) {

        log.info("Inside service method and the request is {} amd id is {}",patientReqDto.toString(),id);

        log.info("Calling PatientRepository to find the existing doctor detials");

         Optional<Patient> existingPatient =patientRepository.findById(id);

         log.info("After repo get optional patient with existing details {}",existingPatient.toString());

         Patient existingPatientDetails = existingPatient.
                                              orElseThrow(() ->
                                                      new RuntimeException("Patient not found with id "+id)
                                              );

         log.info("Existing patient Details is {}",existingPatientDetails.toString());

         log.info("Calling mapper updatePatient from Dto.");

         patientMapper.updatePatientFromDto(patientReqDto,existingPatientDetails);

         log.info("Calling patient repo save method to stored the updated patient detials");

         Patient patient= patientRepository.save(existingPatientDetails);

         log.info("Calling mapper again to convert patient to pateint Res dto ");

         PatientResDto patientResult= patientMapper.toResDto(patient);

         log.info("patientResult response after updating is {}", patientResult.toString());

         return patientResult;



    }
}
