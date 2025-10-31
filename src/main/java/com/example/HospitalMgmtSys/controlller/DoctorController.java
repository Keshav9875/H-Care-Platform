package com.example.HospitalMgmtSys.controlller;

import com.example.HospitalMgmtSys.dto.DoctorDto;
import com.example.HospitalMgmtSys.dto.DoctorResponseDto;
import com.example.HospitalMgmtSys.entity.Doctor;
import com.example.HospitalMgmtSys.service.DoctorService;
import com.example.HospitalMgmtSys.service.impl.DoctorServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@Slf4j
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/create")
    public ResponseEntity<DoctorResponseDto> createDoctor(@RequestBody DoctorDto doctorDto){

        log.info("Request to create new doctor is {}",doctorDto);

        log.info("calling service method to create doctor...");

        DoctorResponseDto doctorRes= doctorService.createDoctor(doctorDto);

        log.info("Doctor creation request: {}, Response after saving: {}", doctorDto, doctorRes);

        return  ResponseEntity.status(HttpStatus.CREATED).body(doctorRes);

    }

    @GetMapping("/getDoctorInfo/{id}")
    public ResponseEntity<DoctorResponseDto> getDoctorInfoById(@PathVariable(name="id") Long id){

        log.info("Requested doctor id is {}",id);

        log.info("calling service getDoctorInfo method for this id - {}",id);
        // create service method to fetch the detials of doctor by id.
        DoctorResponseDto doctorDetails=doctorService.getDoctorInfo(id);

        log.info("Request id is {} and Response from service method is {}",id,doctorDetails.toString());


        return ResponseEntity.ok(doctorDetails);
    }

    @GetMapping("/getAllDoctors")
    public ResponseEntity<List<DoctorResponseDto>> getAllDoctors(){

        log.info("In controller calling getAlldoctors service method");

        List<DoctorResponseDto> doctorDtoList=doctorService.getAllDoctors();

        return ResponseEntity.ok(doctorDtoList);

    }

    // used patch mapping to update the doctor profile that more feasible i have created  this for practice and future use.
    @PutMapping("/update/{id}")
    public DoctorResponseDto updateDoctorById(@PathVariable(name="id") Long id,@RequestBody DoctorDto doctorDto){

        log.info("calling service update Doctor for this id - {} and request body {}",id,doctorDto.toString());

        //call update doctor service method via id
        DoctorResponseDto updatedDoctor =doctorService.updateDoctorInfo(id,doctorDto);

        log.info("Request to update doctor is {} and response after " +
                "calling updateDoctorInfo service method is {}",
                doctorDto.toString(),updatedDoctor.toString());

        return updatedDoctor;
    }
}
