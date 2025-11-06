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

import java.util.HashMap;
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

     @GetMapping("/fetchPatient/{id}")
    public ResponseEntity<PatientResDto> fetchPatientById(@PathVariable(name="id") Long id ){

         log.info("fetch patient by id request reached with this id - {}",id);

         log.info("Calling service to fetch the data of patient through  id");

         PatientResDto patientResult = patientService.fetchPatientById(id);

         log.info("Request id {} to fetch patient and  response is - {}",id, patientResult.toString());

         return ResponseEntity.ok(patientResult);

      }

     @PostMapping("/update/{id}")
     public ResponseEntity<PatientResDto>  updatePatient(@RequestBody PatientReqDto patientReqDto, Long id){

         log.info("Inside controller - updated patient Request dto is {} and id {}",patientReqDto.toString(),id);

         log.info("Calling service method to update patient of this  id is {}",id);

         //calling service method
          PatientResDto  updatePatientDetails= patientService.updatePatientDetails(patientReqDto,id);

         log.info("After calling service method the request is {} , id is {} and response is {}",patientReqDto.toString(),id);

         return ResponseEntity.ok(updatePatientDetails);

     }

}
