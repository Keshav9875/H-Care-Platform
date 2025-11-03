package com.example.HospitalMgmtSys.controlller;

import com.example.HospitalMgmtSys.dto.PatientReqDto;
import com.example.HospitalMgmtSys.dto.PatientResDto;
import com.example.HospitalMgmtSys.service.PatientService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
@Slf4j
public class PatientController {

    @Autowired
    PatientService patientService;

    // how to return two response dto accept from responseEntity
     @PostMapping(value = "/register",consumes = "application/json", produces = "application/json")
     public ResponseEntity<PatientResDto> registerPatient(@Valid @RequestBody PatientReqDto patientReqDto){

         log.info("Incoming patient Req dto is {}", patientReqDto.toString());

         log.info("calling service method to register or save user ");

         PatientResDto patientRes= patientService.registerPatient(patientReqDto);

         log.info("Incoming patient req dto is {} and response dto is {}",patientReqDto.toString(),patientRes.toString());

         return  ResponseEntity.status(HttpStatus.CREATED).body(patientRes);

      }

     @GetMapping("/fetchAllPatient")
     public ResponseEntity<List<PatientResDto>> fetchAllPatient(){
         // implement pagination here to find the patient and give to frontend in slot of size 10.
            log.info("In controller method , to fetch all the patient details.");

            log.info("Calling service method to fetch all patient list");

            List<PatientResDto> patientResDtoList = patientService.fetchAllPatient();

            log.info("The patient res list returning from service is {}",patientResDtoList.toString());

            return ResponseEntity.ok(patientResDtoList);

      }

//     @GetMapping("/fetchPatient/{id}")
//    public ResponseEntity<> fetchPatientById(){
//
//      }

//     @PatchMapping("/update/{id}")
//     public ResponseEntity<>  updatePatient(){
//
//     }

}
